package com.swegnchic.sampleshoppingcart;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.view.MenuItem;
import android.widget.TextView;

import com.swegnchic.sampleshoppingcart.danceclasses.DanceClass;

public class DisplayClassActivity extends Activity {
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		
		// Get the message
		Intent intent = getIntent();
		DanceClass danceClass = (DanceClass) intent.getSerializableExtra("danceClass");
		
		// Create the TextView
		TextView textView = new TextView(this);
		textView.setTextSize(40);
		textView.setText(danceClass.getName());
		
		setContentView(textView);
		
		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
	}
	
	   @Override
	    public boolean onOptionsItemSelected(MenuItem item) {
	        switch (item.getItemId()) {
	        case android.R.id.home:
	            NavUtils.navigateUpFromSameTask(this);
	            return true;
	        }
	        return super.onOptionsItemSelected(item);
	   }

}
