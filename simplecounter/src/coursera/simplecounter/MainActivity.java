package coursera.simplecounter;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	private long msectime = 0L;
	private long newtime = 0L;
	private long reftime = 0L;
	private int count = 0; 
	private TextView showcount;
	

	
	private Handler myhandler = new Handler();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Log.e("onCreate","set view");
		showcount = (TextView) findViewById(R.id.textView1);
		reftime = SystemClock.uptimeMillis();
		Log.e("onCreate","set reftime: "+reftime);
		
		Log.e("onCreate","start thread");
		myhandler.postDelayed(updateCounterThread, 0);
	    } // end onCreate

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

	private Runnable updateCounterThread = new Runnable() {
		public void run() {
			Log.e("running","incrementing counter");
			newtime = SystemClock.uptimeMillis() - reftime;
			Log.e("running","newtime: " + newtime);
			msectime = newtime;
			count = (int) msectime/1000;
			Log.e("onCreate","showcount: " + count);
			showcount.setText(""+count);
			myhandler.postDelayed(updateCounterThread,0);
			} // end run()
		}; // end Runnable
	
} //end MainActivity


