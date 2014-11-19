package com.coursera.melobellies;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends ActionBarActivity {
	MediaPlayer meteorplay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		meteorplay = MediaPlayer.create(this, R.raw.meteor);
		try {
			meteorplay.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meteorplay.start();
	}
	
	 @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		meteorplay.pause();
		super.onPause();
	}
	 
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		try {
			meteorplay.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meteorplay.start();
		super.onResume();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		meteorplay.stop();
		meteorplay.release();
		super.onStop();
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		try {
			meteorplay.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meteorplay.start();
		super.onStart();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
}
