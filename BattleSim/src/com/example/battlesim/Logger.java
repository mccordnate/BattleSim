package com.example.battlesim;

import java.util.Arrays;
import java.util.List;

import android.util.Log;
import android.view.Menu;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseFacebookUtils;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class Logger extends Activity {
	private EditText username;
	private EditText pass;
	private String utxt;
	private String ptxt;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logger);

		username = (EditText) findViewById(R.id.username);
		pass = (EditText) findViewById(R.id.pass);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.logger, menu);
		return true;
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	  super.onActivityResult(requestCode, resultCode, data);
	  ParseFacebookUtils.finishAuthentication(requestCode, resultCode, data);
	}

	public void login(View view) {
		utxt = username.getText().toString();
		ptxt = pass.getText().toString();

		ParseUser.logInInBackground(utxt, ptxt, new LogInCallback() {
			public void done(ParseUser user, ParseException e) {
				if (user != null) {
					startActivity(new Intent(Logger.this, WelcomeActivity.class));
					Toast.makeText(getApplicationContext(),
							"Login Successful!", Toast.LENGTH_LONG).show();
					finish();
				} else {
					Toast.makeText(
							getApplicationContext(),
							"Password/Username incorrect. Try again or Sign up",
							Toast.LENGTH_LONG).show();
				}
			}
		});
	}

	public void signUp(View view) {
		utxt = username.getText().toString();
		ptxt = pass.getText().toString();

		ParseUser user = new ParseUser();
		user.setUsername(utxt);
		user.setPassword(ptxt);
		user.setEmail(utxt);

		user.signUpInBackground(new SignUpCallback() {
			public void done(ParseException e) {
				if (e == null) {
					Toast.makeText(getApplicationContext(),
							"Sign up successful! Please login",
							Toast.LENGTH_LONG).show();
				} else {
					Toast.makeText(getApplicationContext(),
							"E-mail taken. Please try again", Toast.LENGTH_LONG)
							.show();
				}
			}
		});
	}
	
	public void fbook(View view){
		List<String> permissions = Arrays.asList("basic_info", "user_about_me",
	            "user_relationships", "user_birthday", "user_location");
		ParseFacebookUtils.logIn(permissions, this, new LogInCallback() {
			  @Override
			  public void done(ParseUser user, ParseException err) {
			    if (user == null) {
			      Log.d("MyApp", "Uh oh. The user cancelled the Facebook login.");
			    } else if (user.isNew()) {
			      Log.d("MyApp", "User signed up and logged in through Facebook!");
			      startActivity(new Intent(Logger.this, WelcomeActivity.class));
			    } else {
			      Log.d("MyApp", "User logged in through Facebook!");
			      startActivity(new Intent(Logger.this, WelcomeActivity.class));
			    }
			  }
			});
	}
}
