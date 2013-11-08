package com.example.battlesim;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.parse.GetCallback;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;
import com.parse.ParseException;

public class WelcomeActivity extends Activity {
	private ParseObject parseChar = new ParseObject("Character");

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Character");
		query.getInBackground("a4fCOTOka0", new GetCallback<ParseObject>() {
		  public void done(ParseObject parseCharBack, ParseException e) {
		    if (e == null) {
		    	if(parseCharBack.getString("username").equals(ParseUser.getCurrentUser().getUsername())){
		    		setContentView(R.layout.activity_welcomechar);
		    	}
		    	else{
		    		setContentView(R.layout.activity_welcome);
		    	}
		    } else {
		      Log.d("Error","Something really bad happened");// something went wrong
		    }
		  }
		});
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
		Character character = new Character("test", 5, 5, 5);
		parseChar.put("user",ParseUser.getCurrentUser());
		parseChar.put("name",character.getName());
		parseChar.put("str",character.getStr());
		parseChar.put("agi",character.getAgi());
		parseChar.put("def",character.getDef());
		parseChar.put("hp",character.getHp());
		parseChar.put("exp",character.getExp());
		parseChar.put("level",character.getLevel());
		parseChar.put("username",ParseUser.getCurrentUser().getUsername());
		parseChar.saveInBackground();
	}
	
	public void disp(View view){
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Character");
		query.getInBackground("a4fCOTOka0", new GetCallback<ParseObject>() {
		  public void done(ParseObject parseCharBack, ParseException e) {
		    if (e == null) {
		    	Toast.makeText(getApplicationContext(), parseCharBack.getString("username"), Toast.LENGTH_LONG).show();
		    	
		    } else {
		      Log.d("Error","Something really bad happened");// something went wrong
		    }
		  }
		});
		
		//Toast.makeText(getApplicationContext(), parseChar.getInt("str"), Toast.LENGTH_LONG);
	}
}
