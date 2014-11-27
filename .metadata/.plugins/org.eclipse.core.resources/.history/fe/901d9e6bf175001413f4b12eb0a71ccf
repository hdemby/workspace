package coursera.cointoss;

import android.support.v7.app.ActionBarActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	
	ImageView imageView1;
	Button button1;
	EditText headText;
	EditText tailText;
	
	public int heads = 0;
	public int tails = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	    imageView1=(ImageView)findViewById(R.id.imageView1);
	    button1=(Button)findViewById(R.id.button1);
	    headText=(EditText)findViewById(R.id.editText2);
	    tailText=(EditText)findViewById(R.id.editText3);
		String text1 = String.valueOf(heads);
        String text2 = String.valueOf(tails);
        headText.setText(text1);
        tailText.setText(text2);

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
	
	public void flipCoin(View v) {

	    Intent intent = new Intent(Intent.ACTION_VIEW);
	    
		if(Math.random() > .5){
			imageView1.setImageResource(R.drawable.quarter_front);
			heads++;
		    } else {
		    	imageView1.setImageResource(R.drawable.quarter_back);
		    	tails++;
		    	}
		intent.getData();
		String text1 = String.valueOf(heads);
        String text2 = String.valueOf(tails);
        headText.setText(text1);
        tailText.setText(text2);
		}
}



/*public class MainActivity extends Activity {
	ImageView imageView1;
	Button button1;
	int len=images.length-1;
	static int curr=0;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
    	super.onCreate(savedInstanceState);
    	setContentView(R.layout.activity_main);
    	imageView1=(ImageView)findViewById(R.id.imageView1);
    	button1=(Button)findViewById(R.id.button1);
}

	private static final int[] 
	images=new int[]     {R.drawable.i1,R.drawable.i2,R.drawable.i3,R.drawable.i4,R.drawable.i5,R.drawable.i6};
	public void onClick(View view) {   
    	if(curr<6){
    	imageView1.setImageResource(images[curr]);
    	} else {
        	curr=-1;
    	}
    	curr++;
    	}
	}
*/
