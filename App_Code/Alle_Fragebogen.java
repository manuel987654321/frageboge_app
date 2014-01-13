package com.example.fragebogen_test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.ListActivity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

public class Alle_Fragebogen extends ListActivity {

	// Fortschritts Dialog
	private ProgressDialog pDialog;

	// Erstelle JSON Parser object
	JSONParser jParser = new JSONParser();

	ArrayList<HashMap<String, String>> fragebogenList;

	// url zur php Seite welche die Fragebogenliste enthält
	private static String url_all_fragebogen = "http://172.20.10.3/Fragebogen_app/read_allfragebogen.php";

	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_FRAGEBOGEN = "fragebogen";
	private static final String TAG_FID = "f1id";
	//private static final String TAG_FID = "fid";

	
	// fragebogen JSONArray
	JSONArray fragebogen = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.alle_fragebogen);

		// Hashmap für die ListView
		fragebogenList = new ArrayList<HashMap<String, String>>();

		// Alle Fragebogen im Hintergrund laden
		new LoadAllFragebogen().execute();

		// Get listview
		ListView lv = getListView();
//		lv.setOnClickListener(null);

	}

	/**
	 * Im Hintergrund per HTTP Request alle fragebogen laden
	 * */
	class LoadAllFragebogen extends AsyncTask<String, String, String> {

		/**
		 * Bevor der Hintergrund Thread gestartet wird ein Fortschritts Dialog
		 * gestartet
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Alle_Fragebogen.this);
			pDialog.setMessage("Fragebogen werden geladen. Bitte warten ...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * alle fragebogen von url beziehen
		 * */
		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// holt sich JSON string von der URL
			JSONObject json = jParser.makeHttpRequest(url_all_fragebogen,
					"GET", params);

			// Die erhaltenen Daten in logcat anzeigen
			Log.d("Alle Fragebogen: ", json.toString());

			try {
				// holt man sich die success tag
				int success = json.getInt(TAG_SUCCESS);

				// wenn success 1 heißt das das ein/mehrerer Fragebogen
				// gefunden wurden

				if (success == 1) {

					// in die Variable fragebogen ein Array mit den ganzen
					// Fragebogen schreiben
					fragebogen = json.getJSONArray(TAG_FRAGEBOGEN);

					// Alle Fragebogen durchlaufen
					for (int i = 0; i < fragebogen.length(); i++) {
						JSONObject c = fragebogen.getJSONObject(i);

						// holt sich aus dem JSON Object alle id´s
						String id = c.getString(TAG_FID);

						HashMap<String, String> map = new HashMap<String, String>();

						map.put(TAG_FID, id);

						// adding HashList to ArrayList
						fragebogenList.add(map);

					}
				} else {

				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		protected void onPostExecute(String file_url) {
			// wenn alle Fragebogen gefunden wird der Dialog verworfen
			pDialog.dismiss();
			// updating UI from Background Thread
			runOnUiThread(new Runnable() {
				public void run() {
					/**
					 * JSON Daten in ListView
					 * */
					ListAdapter adapter = new SimpleAdapter(
							Alle_Fragebogen.this, fragebogenList,
							R.layout.list_item, new String[] { TAG_FID },
							new int[] { R.id.fid });

					// updating listview
					setListAdapter(adapter);
				}
			});

		}

	}
}