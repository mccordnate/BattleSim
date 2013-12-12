package com.example.battlesim;

import java.util.List;
import com.google.android.gms.ads.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.ParseException;

public class WelcomeActivity extends Activity {
	private ParseObject parseChar = new ParseObject("Character");
	private AdView adView;
	private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Character");
		query.whereEqualTo("username", ParseUser.getCurrentUser().getUsername());
		query.getFirstInBackground(new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (object == null) {
		      setContentView(R.layout.activity_welcome);
		    } else {
		    	setContentView(R.layout.activity_welcomechar);
	    		TextView tv = (TextView) findViewById(R.id.charName);
	    		tv.setText(object.getString("name").toString());
		    }
		  }
		});
		
		interstitial = new InterstitialAd(this);
	    interstitial.setAdUnitId("ca-app-pub-6919385704931086/2200429654");

	    // Create ad request.
	    AdRequest adRequest = new AdRequest.Builder().addTestDevice("95F2814F50DDBA35CAD96C7F6EB67074").build();

	    // Begin loading your interstitial.
	    interstitial.loadAd(adRequest);
		
//		adView = new AdView(this);
//	    adView.setAdUnitId("ca-app-pub-6919385704931086/8563190853");
//	    adView.setAdSize(AdSize.BANNER);
//
//	    // Lookup your LinearLayout assuming it's been given
//	    // the attribute android:id="@+id/mainLayout".
//	    LinearLayout layout = (LinearLayout)findViewById(R.id.rellay);
//
//	    // Add the adView to it.
//	    layout.addView(adView);
//
//	    // Initiate a generic request.
//	    AdRequest adRequest = new AdRequest.Builder()
//	    .addTestDevice("95F2814F50DDBA35CAD96C7F6EB67074")
//	    .build();
//
//	    // Load the adView with the ad request.
//	    adView.loadAd(adRequest);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.welcome, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId()) {
        case R.id.logout:
            logout();
            return true;
        default:
            return super.onOptionsItemSelected(item);
    }
	}
	
	public void logout(){
		ParseUser.logOut();
		finish();
	}
	
	public void createChar(View view) {
		startActivity(new Intent(this, CharacterCreate.class));
		finish();
	}
	
	public void train(View view){
		startActivity(new Intent(this, TrainingActivity.class));
	}
	
	public void stats(View view){
		startActivity(new Intent(this, StatActivity.class));
	}
	
	public void deleteChar(View view){
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Character");
		query.whereEqualTo("username", ParseUser.getCurrentUser().getUsername());
		query.getFirstInBackground(new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (object == null) {
		      Log.d("deleteChar", "The getFirst request failed.");
		    } else {
		      try {
				object.delete();
			} catch (ParseException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		      startActivity(new Intent(WelcomeActivity.this, WelcomeActivity.class));
		      finish();
		    }
		  }
		});
	}
	
	public void leaderboard(View view){
		startActivity(new Intent(this, LeaderboardActivity.class));
	}
	
	public void ads(View view){
		displayInterstitial();
		startActivity(new Intent(this, AdActivity.class));
	}
	
	public void displayInterstitial() {
	    if (interstitial.isLoaded()) {
	      interstitial.show();
	    }
	}
}
