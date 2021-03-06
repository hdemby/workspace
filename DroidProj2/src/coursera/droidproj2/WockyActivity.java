package coursera.droidproj2;

import java.io.IOException;


import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.view.View;

public class WockyActivity extends ActionBarActivity {
    MediaPlayer wockyplay;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jabberwocky_main);
		WebView myWebView = (WebView) findViewById(R.id.webView1);
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setDomStorageEnabled(true);
		myWebView.loadUrl("file:///android_asset/jabberwocky.html");
		
		wockyplay = MediaPlayer.create(this,R.raw.serpentsteeth);		
		try {
			wockyplay.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wockyplay.start();
		wockyplay.setLooping(true);

	}
	
	@Override
	protected void onRestart() {
		// TODO Auto-generated method stub
		try {
			wockyplay.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wockyplay.start();
		super.onRestart();
	}
	
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		try {
			wockyplay.prepare();
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wockyplay.start();
		super.onResume();
	}
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		wockyplay.stop();
		super.onPause();
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		wockyplay.stop();
		wockyplay.release();
		super.onStop();
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		wockyplay.stop();
		wockyplay.release();
		super.onDestroy();
	}
	public void openInfo(View v) {
		// handler for 'openWiki' button
		String url = "http://wikipedia.com/wiki/Jabberwocky";
		Intent intent1 = new Intent(Intent.ACTION_VIEW);
		intent1.setData(Uri.parse(url));
		startActivity(intent1);
	}
	
	public void openImage(View v) {
		// handler for 'openWiki' button
		WebView myWebView = (WebView) findViewById(R.id.webView1);
		String url = "file:///android_asset/drawdragon.html";
		myWebView.getSettings().setBuiltInZoomControls(true);
		myWebView.getSettings().setJavaScriptEnabled(true);
		myWebView.getSettings().setDomStorageEnabled(true);
		myWebView.loadUrl(url);
		
		/*Intent intent2 = new Intent(Intent.ACTION_VIEW);
		intent2.setData(Uri.parse(url));
		startActivity(intent2);*/
	}
		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.wocky, menu);
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
