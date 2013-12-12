package com.example.battlesim;

import android.os.Bundle;
import com.google.android.gms.ads.*;
import android.app.Activity;
import android.view.Menu;
import android.widget.LinearLayout;

public class AdActivity extends Activity {
	private AdView adView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_ad);
		
		// Create the adView.
	    adView = new AdView(this);
	    adView.setAdUnitId("ca-app-pub-6919385704931086/8563190853");
	    adView.setAdSize(AdSize.BANNER);

	    // Lookup your LinearLayout assuming it's been given
	    // the attribute android:id="@+id/mainLayout".
	    LinearLayout layout = (LinearLayout)findViewById(R.id.linlay);

	    // Add the adView to it.
	    layout.addView(adView);

	    // Initiate a generic request.
	    AdRequest adRequest = new AdRequest.Builder()
	    .addTestDevice("95F2814F50DDBA35CAD96C7F6EB67074")
	    .build();

	    // Load the adView with the ad request.
	    adView.loadAd(adRequest);		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.ad, menu);
		return true;
	}

}
