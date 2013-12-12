package com.example.battlesim;

import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ListView;

public class LeaderboardActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaderboard);
		// LeaderboardAdapter adapter = new LeaderboardAdapter(this);
		 //adapter.loadObjects();

		// ParseQueryAdapter adapter = new
		// ParseQueryAdapter<ParseObject>(this,"Character");
		ParseQueryAdapter<ParseObject> adapter = new ParseQueryAdapter<ParseObject>(
				this, new ParseQueryAdapter.QueryFactory<ParseObject>() {
					public ParseQuery<ParseObject> create() {
						// Here we can configure a ParseQuery to our heart's
						// desire.
						ParseQuery query = new ParseQuery("Character");
						query.whereNotEqualTo("name","");
						query.orderByDescending("wins");
						query.setLimit(-1);
						return query;
					}
				});
		adapter.setTextKey("name");

		ListView lv = (ListView) findViewById(R.id.listView1);
		lv.setAdapter(adapter);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.leaderboard, menu);
		return true;
	}

}
