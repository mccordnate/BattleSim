package com.example.battlesim;

import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseUser;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;

public class StatActivity extends Activity {

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_stat);
		
		
	    
	    
	    
		
		ParseQuery<ParseObject> query = ParseQuery.getQuery("Character");
		query.whereEqualTo("username", ParseUser.getCurrentUser().getUsername());
		query.getFirstInBackground(new GetCallback<ParseObject>() {
		  public void done(ParseObject object, ParseException e) {
		    if (object != null) {
		      TextView name = (TextView) findViewById(R.id.u_name);
		      TextView level = (TextView) findViewById(R.id.u_level);
		      TextView str = (TextView) findViewById(R.id.u_str);
		      TextView agi = (TextView) findViewById(R.id.u_agi);
		      TextView def = (TextView) findViewById(R.id.u_def);
		      TextView wins = (TextView) findViewById(R.id.u_wins);
		      TextView losses = (TextView) findViewById(R.id.u_losses);
		      
		      name.setText(object.getString("name").toString());
		      level.setText(Integer.toString(object.getInt("level")));
		      str.setText(Integer.toString(object.getInt("str")));
		      agi.setText(Integer.toString(object.getInt("agi")));
		      def.setText(Integer.toString(object.getInt("def")));
		      wins.setText(Integer.toString(object.getInt("wins")));
		      losses.setText(Integer.toString(object.getInt("losses")));
		    }
		  }
		});
		
		
	}
	
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.stat, menu);
		return true;
	}

}
