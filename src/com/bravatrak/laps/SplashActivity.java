package com.bravatrak.laps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends Activity {
	private static final int SPLASH_TIME_OUT = 1000 * 3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		
		new Handler().postDelayed(new Runnable(){
			@Override
			public void run(){
				//Code to start main Activity is executed once timer is finished.
				Intent i = new Intent(SplashActivity.this, MainFragmentActivity.class);
				startActivity(i);
				
				finish(); //close this activity
			}
		}, SPLASH_TIME_OUT);
	}


}
