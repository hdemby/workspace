package com.example.simpletimer;

import android.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity {
	 Button btnstart;
	 Button btnpause;
	 Button btnstop;
	 TextView viewtime;
	 Handler handler;

	 long milisec = 0L;
	 long tmptime = 0L;
	 long newtime = 0L;
	 
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_item);
        
        viewtime = (TextView) findViewById(R.id.text1);
        
        btnstart = (Button) findViewById(R.id.button1);
        btnstart.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
        		tmptime = SystemClock.uptimeMillis();
        		handler.postDelayed(updateTimerThread,  0);
				}
			});
        
		btnpause = (Button) findViewById(R.id.button2);
		btnpause.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View view) {
					tmptime += milisec;
					handler.removeCallbacks(updateTimerThread);
					
			}
        });
        
    }

    private Runnable updateTimerThread = new Runnable(){
    	@Override
		public void run() {
    		milisec = SystemClock.uptimeMillis();
    		newtime = milisec;
    		int secs = (int) (newtime / 1000);
    		int mins = secs/60;
    		secs = secs % 60;
    		int msec = (int) (newtime % 1000);
    		viewtime.setText(""+mins+":"+String.format("%02d",secs)+":"+String.format("%03d",msec));
    		handler.postDelayed(this, 0);
    	}
    };
    
	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //if (id == R.id.action_settings) {
        //    return true;
        //}
        return super.onOptionsItemSelected(item);
    }
}
