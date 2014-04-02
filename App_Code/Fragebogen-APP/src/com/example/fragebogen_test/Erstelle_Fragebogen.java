package com.example.fragebogen_test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fragebogen_test.R;
import android.widget.ListView;

public class Erstelle_Fragebogen extends Activity {

	private ProgressDialog pDialog;

	JSONParser jsonParser = new JSONParser();
	EditText input1;
	EditText input2;
	EditText input3;
	Fragebogen fragen;
	Fragebogen example;

	// url
	private static String url_erstelle_fragebogen = "http://172.20.10.3/PHP_Fragebogen_app/create_fragebogen.php";

	// JSON Node
	private static final String TAG_SUCCESS = "success";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.erstelle_fragebogen);
		getActionBar().setDisplayHomeAsUpEnabled(true);
		
		try {
			Serializer serializer = new Persister();
			AssetManager mgr = getAssets();
			example = serializer.read(Fragebogen.class, mgr.open("Fragebogen_1.xml"));
		} catch (Exception e) {
			example = new Fragebogen();
			Log.d("Fragebogen", example.anzFragen() + "");
		}

		ListView list = (ListView) this.findViewById(R.id.fragen_list);
		FragenAdapter adapter = new FragenAdapter(this,
				R.layout.fragebogen_item, example.getFragen());
		adapter.setNotifyOnChange(true);
		list.setAdapter(adapter);

		// Button erstellen
		Button btnCreateProduct = (Button) findViewById(R.id.erstelle_fragebogen);

		// Button event geben
		btnCreateProduct.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// neuen Fragebogen im Hintergrund erstellen
				new ErstelleNeuenFragebogen().execute();
			}
		});
	}

	/**
	 * Klasse bei der im Hintergrund Fragebogen erstellt werden
	 * */
	class ErstelleNeuenFragebogen extends AsyncTask<String, String, String> {

		/**
		 * Vor der Hintergrundprozess gestartet wird wird noch fortschrittsbar
		 * gezeigt
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(Erstelle_Fragebogen.this);
			pDialog.setMessage("Erstelle Fragebogen .....");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		/**
		 * Erstelle Fragebogen
		 * */
		@Override
		protected String doInBackground(String... args) {
			String ersteant = example.get(0).getAntwort();
			String zweiteant = example.get(1).getAntwort();
			String dritteant = example.get(2).getAntwort();
			String vierteant = example.get(3).getAntwort();
			String fuenfteant = example.get(4).getAntwort();
			String sechsteant = example.get(5).getAntwort();
			
			Log.d("1te Antwort", ersteant);
			Log.d("2te Antwort", zweiteant);
			Log.d("3te Antwort", dritteant);
			Log.d("4te Antwort", vierteant);
			Log.d("5te Antwort", fuenfteant);
			Log.d("6te Antwort", sechsteant);
						
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("1teantwort", ersteant));
			params.add(new BasicNameValuePair("2teantwort", zweiteant));
			params.add(new BasicNameValuePair("3teantwort", dritteant));
			params.add(new BasicNameValuePair("4teantwort", vierteant));
			params.add(new BasicNameValuePair("5teantwort", fuenfteant));
			params.add(new BasicNameValuePair("6teantwort", sechsteant));
			

			// holt JSON Object
			// Note das fragebogen_erstellen url beinhaletet gibt man POST
			// Methode
			JSONObject json = jsonParser.makeHttpRequest(
					url_erstelle_fragebogen, "POST", params);

			Log.d("Antwort von php Seite", json.toString());

			// Kontrolle ob Erfolg
			try {
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// Erfolgreich, öffnet Klasse in der angezeigt wird wie
					// viele Fragebogen ausgefüllt wurden
					Intent i = new Intent(getApplicationContext(),
							Alle_Fragebogen.class);
					startActivity(i);

					// Schließt Fenster
					finish();
				} else {
					// Fehler aufgetreten
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

			return null;
		}

		/**
		 * Wenn der Hintergrundprozess fertig ist, dialog -> wird geschlossen
		 * **/
		@Override
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once done
			pDialog.dismiss();
		}

	}
}
