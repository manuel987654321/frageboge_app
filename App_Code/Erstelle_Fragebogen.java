package com.example.fragebogen_test;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Erstelle_Fragebogen extends Activity {

	private ProgressDialog pDialog;
	 
   JSONParser jsonParser = new JSONParser();
   EditText input1;
   EditText input2;
   EditText input3;

   // url 
   private static String url_erstelle_fragebogen = "http://172.20.10.3/Fragebogen_app/create_fragebogen.php";

   // JSON Node 
   private static final String TAG_SUCCESS = "success";

   protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.erstelle_fragebogen);
	 	 
       // Edit Text
       input1 = (EditText) findViewById(R.id.eing1_ant);
       input2 = (EditText) findViewById(R.id.eing2_ant);
       input3 = (EditText) findViewById(R.id.eing3_ant);

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
	         * Vor der Hintergrundprozess gestartet wird wird noch fortschrittsbar gezeigt
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
	            String ersteant = input1.getText().toString();
	            String zweiteant = input2.getText().toString();
	            String dritteant = input3.getText().toString();
	 
	            Log.d("1te antwort", ersteant);
	            Log.d("2te antwort", zweiteant);
	            Log.d("3te antwort", dritteant);
	            
	            // Building Parameters
	            List<NameValuePair> params = new ArrayList<NameValuePair>();
	            params.add(new BasicNameValuePair("1teantwort", ersteant));
	            params.add(new BasicNameValuePair("2teantwort", zweiteant));
	            params.add(new BasicNameValuePair("3teantwort", dritteant));
	 
	            // holt JSON Object
	            // Note das fragebogen_erstellen url beinhaletet gibt man POST Methode
	            JSONObject json = jsonParser.makeHttpRequest(url_erstelle_fragebogen,
	                    "POST", params);
	 
	            // Log Cat
	            Log.d("Antwort von php Seite", json.toString());
	 
	            // Kontrolle success tag
	            try {
	                int success = json.getInt(TAG_SUCCESS);
	 
	                if (success == 1) {
	                    // Erstellen des Fragebogens war erfolgreich
	                    Intent i = new Intent(getApplicationContext(), Alle_Fragebogen.class);
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
	         * Wenn der Hintergrundprozess fertig ist dialog -> wird geschlossen 
	         * **/
	        protected void onPostExecute(String file_url) {
	            // dismiss the dialog once done
	            pDialog.dismiss();
	        }
	 
	    }
	}	

// Fragebogen f = new Fragebogen();
// f.add();
// f.add();
// ListView view = (ListView) this.findViewById(R.id.fragebogen_list);
// FragenAdapter adapter = new FragenAdapter(this,
// R.id.fragebogen_list_item, f.getFragen());
// adapter.setNotifyOnChange(true);
// view.setAdapter(adapter);
// setContentView(R.layout.erstelle_fragebogen);
//
