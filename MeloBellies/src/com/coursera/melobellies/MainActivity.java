package com.coursera.melobellies;

import java.io.IOException;


import android.support.v7.app.ActionBarActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.R;


@SuppressWarnings({ "unused" })
public class MainActivity extends ActionBarActivity {
	
	MediaPlayer meteorplay = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_item);
		/*meteorplay = MediaPlayer.create(this, R.raw.meteor);
		try {
			meteorplay.prepare();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		meteorplay.start();*/
	}
	
    @Override
	protected void onResume() {
		//.start();
		super.onResume();
	}	

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

	@Override
    public boolean onOptionsItemSelected(MenuItem item) {
	    // TODO Auto-generated method stub
	    return super.onOptionsItemSelected(item);
}
	
}
