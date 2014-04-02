package com.example.fragebogen_test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.fragebogen_test.R;
import com.example.fragebogen_test.R.id;
import com.example.fragebogen_test.R.layout;
import com.example.fragebogen_test.R.menu;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Fragebogen_login extends Activity {

	private static String url_Passwort = "http://172.20.10.3/PHP_Fragebogen_app/Passwortkontrolle.php";
	private static String Tag_Success = "success";
	private ProgressDialog pDialog;
	JSONParser jsonParser = new JSONParser();
	JSONArray log = null;

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {

		case R.id.logout:
			// Toast.makeText(this, "Logout selected", Toast.LENGTH_SHORT)
			// .show();
			Intent intent1 = new Intent(this, Fragebogen_login.class);
			startActivity(intent1);
			break;

		case R.id.action_settings:
			Intent intent = new Intent(this, SettingsActivity.class);
			startActivity(intent);
			break;
		default:
			break;
		}

		return true;
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragebogen_login);

		findViewById(R.id.signin).setOnClickListener(
				new View.OnClickListener() {
					@Override
					public void onClick(View view) {
						new attemptLogin().execute();
					}
				});
	}


	class attemptLogin extends AsyncTask<String, String, String> {
		

//		HttpClient httpclient = new DefaultHttpClient();
//		HttpPost httppost = new HttpPost(url_Passwort);
//
//		try {
//			// Add your data
//			List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
//			nameValuePairs.add(new BasicNameValuePair("passw", Passwort));
//			
//			httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));
//
//			// Execute HTTP Post Request
//			HttpResponse response = httpclient.execute(httppost);
//			
//			Intent intent = new Intent(getApplicationContext(),MainActivity.class);
//			startActivity(intent);
//
//		} catch (ClientProtocolException e) {
//			// TODO Auto-generated catch block
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//		}

	
		
		@Override
		protected String doInBackground(String... arg0) {
			
			EditText inputpassw = (EditText) findViewById(R.id.pwd_id);
			String Passwort = inputpassw.getText().toString();
			Log.d("Eingegebenes Passwort: ", Passwort);
			
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			params.add(new BasicNameValuePair("passw", Passwort));
			JSONObject js = jsonParser.makeHttpRequest(url_Passwort, "POST",
					params);
			Log.d("Antwort von PHP-Seite", js.toString());
			try {
				if (js.getBoolean("success")) {
					Intent intent = new Intent(getApplicationContext(),
							MainActivity.class);
					
					startActivity(intent);
					
				} else {
					Log.d("Fehler", js.toString());
				}
			} catch (JSONException e) {
				Log.d("Fehler", js.toString());
			}
		
			
			return null;
		}
		
		protected void onPreExecute() {
			super.onPreExecute();
		}

	}
	
}
