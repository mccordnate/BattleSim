package com.example.battlesim;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
	    		TextView tv = (TextView) findViewById(R.id.textView2);
	    		tv.setText(object.getString("name").toString());
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
		try {
			parseChar.save();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		startActivity(new Intent(WelcomeActivity.this, WelcomeActivity.class));
		finish();
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
}
