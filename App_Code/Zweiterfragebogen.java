package com.example.fragebogen_test;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class Zweiterfragebogen extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.zweiterfragebogen);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.zweiterfragebogen, menu);
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
	
}
