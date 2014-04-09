package com.example.fragebogen_test;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class Ersterfragebogen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ersterfragebogen);
		
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	  @Override
		public boolean onOptionsItemSelected(MenuItem item) {
			    switch (item.getItemId()) {
			    
			    case R.id.logout:
			    	
			    	Intent intent1 = new Intent(this, Fragebogen_login.class);
				      startActivity(intent1);
			    	break;
			    
			    case R.id.action_settings:
//				      Intent intent = new Intent(this, SettingsActivity.class);
//				      startActivity(intent);
			    	setContentView(R.layout.activity_main2);
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
	public void showFragebogen(View view){
		Intent intent = new Intent(this, Alle_Fragebogen.class);
		startActivity(intent);
	}

	public void createFragebogen(View view){
		Intent intent = new Intent(this, Erstelle_Fragebogen.class);
		startActivity(intent);
	}
	
	public void datenauswerten(View view){
		Intent intent = new Intent(this, Datenauswerten.class);
		startActivity(intent);
	}


	
}
