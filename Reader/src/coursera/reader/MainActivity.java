package coursera.reader;


import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends Activity {
	EditText mdisplay;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mdisplay = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void doStart(View v) {

		Log.e("MainActity","doStart");
		Intent intent = new Intent(Intent.ACTION_VIEW);
	    
		intent.getData();
		String text1 = String.valueOf("Start");
		mdisplay.setText(text1);
		}	

	public void doStop(View v) {
		// TODO Auto-generated method stub
		Log.e("MainActity","doStop");
		Intent intent = new Intent(Intent.ACTION_VIEW);
	    
		intent.getData();
		String text1 = String.valueOf("Stop");
		mdisplay.setText(text1);

	}
	
	
	public void doLoad(View v) {
		// TODO Auto-generated method stub
		Log.e("MainActity","doLoad");
		Intent intent = new Intent(Intent.ACTION_VIEW);
	    
		intent.getData();
		String text1 = String.valueOf("Load");
		mdisplay.setText(text1);

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
