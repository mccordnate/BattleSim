package com.example.battlesim;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class CharacterCreate extends Activity {
	private int statInit = 15;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_character_create);
		statSet();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.character_create, menu);
		return true;
	}
	
	public void statSet(){
		TextView stats = (TextView) this.findViewById(R.id.stats);
		stats.setText(statInit);
	}
	
	public void strMinus(View view){
		EditText strBox = (EditText) this.findViewById(R.id.strbox);
		int strInt = Integer.parseInt((strBox.getText().toString()));
		if(strInt>0){
		strBox.setText(strInt - 1);
		statInit++;
		statSet();
		}
	}
	
	public void strPlus(View view){
		EditText strBox = (EditText) this.findViewById(R.id.strbox);
		int strInt = Integer.parseInt((strBox.getText().toString()));
		if(statInit>0){
		strBox.setText(strInt + 1);
		statInit--;
		statSet();
		}
	}
	
	public void agiMinus(View view){
		EditText agiBox = (EditText) this.findViewById(R.id.agibox);
		int agiInt = Integer.parseInt((agiBox.getText().toString()));
		if(agiInt>0){
		agiBox.setText(agiInt - 1);
		statInit++;
		statSet();
		}
	}
	
	public void agiPlus(View view){
		EditText agiBox = (EditText) this.findViewById(R.id.agibox);
		int agiInt = Integer.parseInt((agiBox.getText().toString()));
		if(statInit>0){
		agiBox.setText(agiInt + 1);
		statInit--;
		statSet();
		}
	}
	
	public void defMinus(View view){
		EditText defBox = (EditText) this.findViewById(R.id.defbox);
		int defInt = Integer.parseInt((defBox.getText().toString()));
		if(defInt>0){
		defBox.setText(defInt - 1);
		statInit++;
		statSet();
		}
	}
	
	public void defPlus(View view){
		EditText defBox = (EditText) this.findViewById(R.id.defbox);
		int defInt = Integer.parseInt((defBox.getText().toString()));
		if(defInt>0){
		defBox.setText(defInt + 1);
		statInit--;
		statSet();
		}
	}
	
	public void submitChar(View view){
		EditText nameBox = (EditText) this.findViewById(R.id.name);
		EditText strBox = (EditText) this.findViewById(R.id.strbox);
		EditText agiBox = (EditText) this.findViewById(R.id.agibox);
		EditText defBox = (EditText) this.findViewById(R.id.defbox);
		
		Character character = new Character(nameBox.getText().toString(), Integer.parseInt((strBox.getText().toString())), Integer.parseInt((agiBox.getText().toString())), Integer.parseInt((defBox.getText().toString())));
			
	}

}
