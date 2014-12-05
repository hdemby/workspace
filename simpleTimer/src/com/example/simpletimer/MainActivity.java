package com.example.simpletimer;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.MenuItem;
import android.os.Handler;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
	 Button btnstart;
	 Button btnpause;
	 Button btnstop;
	 TextView timer;
	 Handler handler;

	 long ticktime, milisec, newtime;
	 
	 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = (TextView) findViewById(R.id.textView1);
        btnstart = (Button) findViewById(R.id.button1);
        btnstart.setOnClickListener(new View.OnClickListener(){

			@Override
			public void onClick(View view) {
				// TODO Auto-generated method stub
        		ticktime = SystemClock.uptimeMillis();
        		handler.postDelayed(updateTimerThread,  0);
			}
			});
			btnpause =(Button) findViewById(R.id.button2);
			btnpause.setOnClickListener(new View.OnClickListener(){
				public void onClick(View view) {
					newtime += millisec;
					handler.removeCallbacks(updateTimerThread);
					
				}
        });
        
    }

private Runnable updateTimerThread = newRunnable(){
    public void run() {
    	millisec = SystemClock.uptimeMillis();
    	newtime = millisec;
    	int secs = (int) (updatesTime / 1000);
    	int mins = secs/60;
    	
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
