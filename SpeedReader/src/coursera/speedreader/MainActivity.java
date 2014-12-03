package coursera.speedreader;

import android.R;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {
	private String filetext;
	private String intext;
	private String outtext;
	private String[] textlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list_item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// Phase I
	// - get the text file
	public void onStart(View v) {
		// TODO Auto-generated method stub
	// - read in a text source	
	// - prep the text for conversion to list
	//     String intext = (String){text_from_file}.replace("\n\n","\t");
	//     String outtext= intext.replace("\n"," ");
	// - convert it into a list of words
	//   String[] textlist = intext.split(" ");
		// - display each word in a 'textview' in sequence at a specified interval
		//   - "." get's an extra pause length
		// - provide controls to stop and start the word stream
		
		// Phase II
		// - display the reading window as words written on a Canvas object
		//   - create a canvas as background or use it as the display window
		//   - convert words to graphic
		//   - display word on canvas
		//     (this should be enough to pass the rubric)
		
		//   Extra
		// Phase III
		// - provide controls to rewind to last the sentence
		// - provide controls to save current text and position
		// - provide controls to quit the app

		// Phase IV
		// - provide feedback for word rate, percent completed and reading time

		// Phase V
		// - provide 'file chooser' to load new document for reading
		// - provide document info page with option to display the original text
	
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.button1) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
