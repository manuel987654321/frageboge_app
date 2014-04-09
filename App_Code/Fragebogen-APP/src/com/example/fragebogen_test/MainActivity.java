package com.example.fragebogen_test;

import com.example.fragebogen_test.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main1);
		//Log.d("Fehlermeldung:", "mein Fehler");
		
	}
	
	  @Override
	public boolean onOptionsItemSelected(MenuItem item) {
		    switch (item.getItemId()) {
		    
		    case R.id.logout:
//		    	Toast.makeText(this, "Logout selected", Toast.LENGTH_SHORT)
//		          .show();
		    	Intent intent1 = new Intent(this, Fragebogen_login.class);
			      startActivity(intent1);
		    	break;
		    
		    case R.id.layout1:
//			      Intent intent = new Intent(this, SettingsActivity.class);
//			      startActivity(intent);
		    	setContentView(R.layout.activity_main1);
		    
		    	break;
		    	
		    case R.id.layout2:
//			      Intent intent = new Intent(this, SettingsActivity.class);
//			      startActivity(intent);
		    	setContentView(R.layout.activity_main2);
		    
		    	break;
	
		    case R.id.layout3:
//			      Intent intent = new Intent(this, SettingsActivity.class);
//			      startActivity(intent);
		    	setContentView(R.layout.activity_main3);
		    
		    	break;
		    	
		    case R.id.layout4:
//			      Intent intent = new Intent(this, SettingsActivity.class);
//			      startActivity(intent);
		    	setContentView(R.layout.activity_main4);
		    
		    	break;	
		    	
		    
		    default:
		      break;
		    }

		    return true;
		  } 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		 MenuInflater inflater = getMenuInflater();
		    inflater.inflate(R.menu.main, menu);
		    return true;
	}

	public void ersterFragebogen(View view) {
		Intent intent = new Intent(this, Ersterfragebogen.class);
		startActivity(intent);
	}

	public void zweiterFragebogen(View view) {
		Intent intent = new Intent(this, Zweiterfragebogen.class);
		startActivity(intent);
	}
}
