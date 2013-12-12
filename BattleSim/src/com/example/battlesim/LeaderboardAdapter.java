package com.example.battlesim;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.ParseException;
import com.parse.ParseQuery;
import com.parse.ParseQueryAdapter;
import com.parse.ParseObject;

public class LeaderboardAdapter extends ParseQueryAdapter<ParseObject> {
	public Context context;

	public LeaderboardAdapter(Context c) {
		super(c, new ParseQueryAdapter.QueryFactory<ParseObject>(){
			
			
			public ParseQuery<ParseObject> create(){
			ParseQuery<ParseObject> queryL = ParseQuery.getQuery("Character");
			queryL = queryL.whereNotEqualTo("name", "a");
			queryL = queryL.orderByDescending("level");
			queryL.setLimit(-1);
			try {
				queryL.find();
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return queryL;
			
			}
		});
		this.context = c;
	}
	
	
	@Override
	public View getItemView(ParseObject o, View convertView, ViewGroup parent){
		View vi = convertView;
		if(convertView == null) vi = View.inflate(getContext(),  R.layout.board, null);
		TextView name = (TextView) vi.findViewById(R.id.name);
		TextView level = (TextView) vi.findViewById(R.id.level);
		
		name.setText(o.getString("name"));
		level.setText(o.getInt("level"));
		
		return vi;
	}
	
	
	
}