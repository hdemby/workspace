package com.coursera.melobellies;

import java.io.IOException;

import android.support.v7.app.ActionBarActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

@SuppressWarnings({ "unused" })
public class MainActivity extends ActionBarActivity {
<<<<<<< HEAD
	
	MediaPlayer meteorplay = null;
=======
	MediaPlayer meteorplay;
>>>>>>> b0fadad16abd33152d34e3baf08865c47ca3dae8

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
<<<<<<< HEAD
		setContentView(R.layout.activity_list_item);
		/*meteorplay = MediaPlayer.create(this, R.raw.meteor);
=======
		setContentView(R.layout.activity_main);
		meteorplay = MediaPlayer.create(this, R.raw.meteor);
>>>>>>> b0fadad16abd33152d34e3baf08865c47ca3dae8
		try {
			meteorplay.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meteorplay.start();*/
	}
	
	 @Override
	protected void onPause() {
		// TODO Auto-generated method stub
		meteorplay.pause();
		super.onPause();
	}
	 
	@Override
	protected void onResume() {
<<<<<<< HEAD
		//.start();
=======
		// TODO Auto-generated method stub
		try {
			meteorplay.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meteorplay.start();
>>>>>>> b0fadad16abd33152d34e3baf08865c47ca3dae8
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

<<<<<<< HEAD
    @Override
    protected void onPause() {
		//meteorplay.pause();
	    super.onPause();
}
    
    @Override
    protected void onStop() {
    	// TODO Auto-generated method stub
    	//meteorplay.stop();
    	super.onStop();
    }
=======
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
>>>>>>> b0fadad16abd33152d34e3baf08865c47ca3dae8

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
