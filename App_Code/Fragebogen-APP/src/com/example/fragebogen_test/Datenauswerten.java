package com.example.fragebogen_test;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class Datenauswerten extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.datenauswerten);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.datenauswerten, menu);
		return true;
	}

}
