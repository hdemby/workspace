package coursera.mywebapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;

import android.view.MenuItem;

public class RandomActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Intent intent = new Intent();
		if (Math.random() > .5) {
		intent.setClass(this, Web2Activity.class);
		} else { intent.setClass(this, MainActivity.class);
		}
		startActivity(intent);
		
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
