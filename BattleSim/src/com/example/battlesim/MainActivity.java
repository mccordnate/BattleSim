package com.example.battlesim;

import android.os.Bundle;
import android.view.View;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseFacebookUtils;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Parse.initialize(this, "R3nUsxvMwmHkVVljPSnvcMUP3fe3HkbDPIb4zvSa", "qi4iIY2rgn3bdEIP6lnvZm9r3DbH8mCCo4We7z7l");
		ParseFacebookUtils.initialize("1420131584883154");
		ParseAnalytics.trackAppOpened(getIntent());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	
	
	public void openLogin(View view){
		startActivity(new Intent(this, Logger.class));
	}
	
	public void exit(View view){
		finish();
		System.exit(0);
	}
}
