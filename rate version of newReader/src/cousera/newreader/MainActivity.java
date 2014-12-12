package cousera.newreader;


import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
	private long msectime = 0L;		// time from system clock
	private long newtime = 0L;		// time delta
	private long reftime = 0L;		// time from start of application
	private long pausetime = 0L;	// store reading time here
	private long ratetime = 0L;		// reference time for wordrate in 10ths of a second
	private int count = 0;			// simple counter value
	private int wpmrate = 200;		// default words per sec ~= 200wpm
	private int mspword;			// miliseconds per count for word rate
	private int wordcount = 0;		// the number of words in the text source
	private boolean paused = false;	// paused state
	
	private TextView showtime;
	private Handler myhandler = new Handler();
	
	private TextView mdisplay;
	private TextView showprog;
	private EditText intext;
	private String outtext;
	private String nword;
	private String[] wordlist;
	
	private Button startBtn;
	private Button pauseBtn;
	private Button quitBtn;
	private Button saveBtn;
	private Button hideBtn;
	private Button rateBtn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Toast.makeText(getApplicationContext(), "Press start to begin reading", Toast.LENGTH_LONG).show();
		
		Log.e("onCreate","load text");
		mdisplay = (TextView) findViewById(R.id.textView1);
		intext = (EditText) findViewById(R.id.editText1);
		outtext = intext.getText().toString();
		wordlist = outtext.split(" ");
		wordcount = wordlist.length;
		Log.e("onCreate","length of wordlist: "+ wordcount);
		
		Log.e("onCreate","wpmrate :"+ wpmrate);
		mspword = (int) ((int) 1 / (wpmrate / (60 * 1000.0)));
		Log.e("onCreate","mspword :"+ mspword);
		
		Log.e("onCreate","set 'showtime' view...");
		showtime = (TextView) findViewById(R.id.textView4);
		showprog = (TextView) findViewById(R.id.textView7);
		
		Log.e("onCreate","make 'start' button...");
		startBtn = (Button) findViewById(R.id.button1);
		startBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Log.e("onStart","Start button pushed");
				reftime = SystemClock.uptimeMillis();
				count = 0;
				myhandler.postDelayed(updateCounterThread, 0);
				}
			});
		Log.e("onCreate","make 'pause' button...");
		pauseBtn = (Button) findViewById(R.id.button2);
		pauseBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View view) {
				Log.e("onPause","Pause button pushed");
				if (paused) {
					myhandler.postDelayed(updateCounterThread, 0);
					reftime += SystemClock.uptimeMillis() - pausetime;
					paused = false;
					pauseBtn.setText(R.string.pause_btn);
				}else {
					myhandler.removeCallbacks(updateCounterThread);
					pausetime = SystemClock.uptimeMillis();
					paused = true;
					pauseBtn.setText(R.string.unpause_btn);
					Toast.makeText(getApplicationContext(), "Press pause again to resume reading", Toast.LENGTH_SHORT).show();
					}
				}
			});
		
		Log.e("onCreate","make 'quit' button...");
		quitBtn = (Button) findViewById(R.id.button5);
		quitBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Log.e("onQuit","Quit button pushed");
				myhandler.removeCallbacks(updateCounterThread);
				//System.exit(0);
				Toast.makeText(getApplicationContext(), "Goodbye!", Toast.LENGTH_LONG).show();
				finish();
				}
			});
		
		hideBtn = (Button) findViewById(R.id.button4);
		hideBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Log.e("onHide","Hide button pushed");
				if (intext.getVisibility() == View.VISIBLE) {
					intext.setVisibility(View.INVISIBLE);
					hideBtn.setText(R.string.showtxt_btn);
					Toast.makeText(getApplicationContext(), "Click again to show source", Toast.LENGTH_SHORT).show();

					} else {
						intext.setVisibility(View.VISIBLE);
						hideBtn.setText(R.string.hidetxt_btn);
						Toast.makeText(getApplicationContext(), "Click again to hide source", Toast.LENGTH_SHORT).show();

					}
				}
			});
		
		saveBtn = (Button) findViewById(R.id.button3);
		saveBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Log.e("onSave","Hide button pushed");
				if (intext.getVisibility() == View.VISIBLE) {
					Toast.makeText(getApplicationContext(), "Sorry, Not Yet Implemented", Toast.LENGTH_SHORT).show();
					}
				}
			});
		
		rateBtn = (Button) findViewById(R.id.button3);
		rateBtn.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				Log.e("doRate","'Set Rate' button pushed");
				final String rate = (String) findViewById(R.id.editText2).toString();
				wpmrate = Integer.parseInt(rate);
				mspword = (int) ((int) 1 / (wpmrate / (60 * 1000.0)));
				}
			});
		
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
	
	private Runnable updateCounterThread = new Runnable() 
		{
		public void run() {
			final String timestr;
			msectime = SystemClock.uptimeMillis() - reftime;
			ratetime += msectime;
			// count is used as an index for the text list
			try {
				mdisplay.setText(wordlist[count]);
			} catch (Exception e) {
				mdisplay.setText("- fini -");
				Toast.makeText(getApplicationContext(), "End of text. Click start to replay", Toast.LENGTH_LONG).show();
				count = 0;
				myhandler.removeCallbacks(updateCounterThread);
				return;
				}
			;
			newtime = msectime/1000;
			Log.e("running","newtime: " + newtime);
			final int hrs = (int) newtime / 3600;
			final int minsecs = (int) (newtime % 3600);
			final int mins = 	(int) (minsecs / 60);
			final int secs =  (int) minsecs % 3600;
			
			timestr = String.format("%02d", hrs)
					         +":"+ String.format("%02d", mins)
					         +":"+ String.format("%02d", secs);
			showtime.setText(timestr);
			Log.e("running","time: " + timestr);
			
			Log.e("running","progress: "+ count + "/" + wordcount +"%");
			Log.e("running","progress: "+ ((int)count)/((int)wordcount) +"%");
			try {
				showprog.setText( ""+ count+ "/" + wordcount);
				//showprog.setText( ""+ count / wordcount + "%");
			} catch (Exception e) {
				// TODO: handle exception
				showprog.setText( ""+ count + "/" + wordcount +"%");
			}
			Log.e("runninge","words per minute: " + wpmrate);
			Log.e("runninge","milliseconds per count: " + mspword);
			Log.e("runninge","milliseconds: " + ratetime);
			Log.e("running","count: "+ count);
			if (ratetime > mspword ) {
				if ( ! paused) {
					count += 1;
					ratetime = 0L;
					}
			}
			Log.e("runninge","milliseconds: " + ratetime);

			myhandler.postDelayed(this,0);
			}
		};
}
