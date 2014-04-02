package com.example.fragebogen_test;

import com.example.fragebogen_test.R;
import android.os.Bundle;
import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Zweiterfragebogen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zweiterfragebogen);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zweiterfragebogen, menu);
		return true;
	}

	public void showFragebogen(View view) {
		Intent intent = new Intent(this, Alle_Fragebogen.class);
		startActivity(intent);
	}

	public void createFragebogen(View view) {
		Intent intent = new Intent(this, Erstelle_Fragebogen.class);
		startActivity(intent);
	}

	public void datenauswerten(View view) {
		Intent intent = new Intent(this, Datenauswerten.class);
		startActivity(intent);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {

		switch (item.getItemId()) {
		case android.R.id.home:
			Intent intent = new Intent(this, MainActivity.class);
			intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
			startActivity(intent);

			break;

		default:
			break;
		}

		return super.onOptionsItemSelected(item);
	}

}
