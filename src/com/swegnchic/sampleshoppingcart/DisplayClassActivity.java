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
	private DanceClass danceClass;
	
	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstance) {
		super.onCreate(savedInstance);
		setContentView(R.layout.activity_display_class);
		
		// Get the DanceClass object that was passed from the form.
		Intent intent = getIntent();
		danceClass = (DanceClass) intent.getSerializableExtra(MainActivity.DANCE_CLASS);	
		buildClassDisplay();

		// Make sure we're running on Honeycomb or higher to use ActionBar APIs
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            // Show the Up button in the action bar.
            getActionBar().setDisplayHomeAsUpEnabled(true);
        }
	}
	
	private void buildClassDisplay() {
		setClassDisplayText(R.id.class_display_name, danceClass.getName());
		setClassDisplayText(R.id.class_display_description, danceClass.getDescription());
		setClassDisplayText(R.id.class_display_time, danceClass.getStartTime());
		setClassDisplayText(R.id.class_display_duration, Integer.toString(danceClass.getDuration()));
		setClassDisplayText(R.id.class_display_price, danceClass.getPrice());
		setClassDisplayText(R.id.class_display_size, Integer.toString(danceClass.getSize()));
		setClassDisplayText(R.id.class_display_instructor, danceClass.getOriginalInstructor());		
	}
	
	private void setClassDisplayText(int viewId, String text) {
		TextView tv = (TextView) findViewById(viewId);
		tv.setText(text);
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
