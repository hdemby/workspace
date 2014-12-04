package coursera.reader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends Activity {
	TextView mdisplay;
	EditText intext;
	String outtext;
	String mword;
	String[] wordlist;
	Integer count = 0;
	String word1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mdisplay = (TextView) findViewById(R.id.textView2);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void doStart(View v) {
		// display text in the word view window
		Log.e("MainActity","doStart");
		Intent intent = new Intent(Intent.ACTION_ANSWER);
		intent.getData();
		
		Log.e("MainActity","get the string");
		//outtext = String.valueOf("This is a string");
		EditText mtext = (EditText) findViewById(R.id.editText2);
		outtext = mtext.getText().toString();
				
		Log.e("MainActity","convert to list");
		wordlist = (String[]) outtext.split(" ");
		Log.e("MainActity","get word:"+count);
		word1 = (String) wordlist[count];
		Log.e("MainActity",word1);
		mdisplay.setText(word1);
		Log.e("MainActity","increment the counter");
		count = count + 1;
		}	

	public void doStop(View v) {
		// TODO Auto-generated method stub
		Log.e("MainActity","doStop");
		Intent intent = new Intent(Intent.ACTION_VIEW);
	    
		intent.getData();
		String text1 = String.valueOf("Stop");
		count = 0;
		mdisplay.setText(text1);

	}
	
	public String getListFromText(){
		// convert text into a list of words
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.getData();
		Log.e("MainActity","getListFromText");
		//EditText intext = (EditText) findViewById(R.id.editText2);
		//String outtext = (TextView) intext.getText();
		//String[] wordlist = outtext.split(" ");
		return "display"; // should be 'displayed'
	}
	
	
	public void doLoad(View v) {
		// TODO Auto-generated method stub
		Log.e("MainActity","doLoad");
		Intent intent = new Intent(Intent.ACTION_VIEW);
	    
		intent.getData();
		String text1 = String.valueOf("Load");
		mdisplay.setText(text1);
		count = 0;

	}

	public void doSave(View v) {
		// TODO Auto-generated method stub
		Log.e("MainActity","doSave");
		Intent intent = new Intent(Intent.ACTION_VIEW);
	    
		intent.getData();
		String text1 = String.valueOf("Save");
		mdisplay.setText(text1);

	}

	public void doQuit(View v) {
		// TODO Auto-generated method stub
		Log.e("MainActity","doQuit");
		Intent intent = new Intent(Intent.ACTION_VIEW);
	    
		intent.getData();
		String text1 = String.valueOf("Quit");
		mdisplay.setText(text1);

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
