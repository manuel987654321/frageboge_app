package com.example.fragebogen_test;

import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class SettingsActivity extends PreferenceActivity {

//	 int mylayout = R.layout.main;
//	 if (preferenceIsTrue)
//	 mylayout = R.layout.activity_main1mg;
//	 setContentView(mylayout);
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_settings);
		addPreferencesFromResource(R.xml.preferences);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.settings, menu);
		return true;
	}

}
