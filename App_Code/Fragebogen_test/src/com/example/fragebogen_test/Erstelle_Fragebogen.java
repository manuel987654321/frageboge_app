package com.example.fragebogen_test;

import java.io.File;
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
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
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

	// url
	private static String url_erstelle_fragebogen = "http://192.168.25.222/Fragebogen_app/create_fragebogen.php";

	// JSON Node
	private static final String TAG_SUCCESS = "success";

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		this.setContentView(R.layout.erstelle_fragebogen);

		Serializer serializer = new Persister();
		File source = new File("Fragebogen_1.xml");

		Fragebogen example = serializer.read(Fragebogen.class, source);

//		serializer.write(example, System.out);
//		System.out.println(example.get(0).getFrage());
//		System.out.println(example.get(0).getHint());
//		System.out.println(example.get(1).getFrage());
//		System.out.println(example.get(1).getHint());
//		System.out.println(example.get(2).getFrage());
//		System.out.println(example.get(2).getHint());

		fragen = new Fragebogen();
		fragen.createFrage(example.get(0).getFrage(), example.get(0).getHint());
		fragen.createFrage(example.get(1).getFrage(), example.get(1).getHint());
		fragen.createFrage(example.get(2).getFrage(), example.get(2).getHint());

		ListView list = (ListView) this.findViewById(R.id.fragen_list);
		FragenAdapter adapter = new FragenAdapter(this,
				R.layout.fragebogen_item, fragen.getFragen());
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
		protected String doInBackground(String... args) {
			String ersteant = fragen.get(0).getAntwort();
			String zweiteant = fragen.get(1).getAntwort();
			String dritteant = fragen.get(2).getAntwort();

			Log.d("1te Antwort", ersteant);
			Log.d("2te Antwort", zweiteant);
			Log.d("3te Antwort", dritteant);

			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("1teantwort", ersteant));
			params.add(new BasicNameValuePair("2teantwort", zweiteant));
			params.add(new BasicNameValuePair("3teantwort", dritteant));

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
					// Erfolgreich, �ffnet Klasse in der angezeigt wird wie
					// viele Fragebogen ausgef�llt wurden
					Intent i = new Intent(getApplicationContext(),
							Alle_Fragebogen.class);
					startActivity(i);

					// Schlie�t Fenster
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
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once done
			pDialog.dismiss();
		}

	}
}
