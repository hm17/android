package com.swegnchic.sampleshoppingcart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

import com.swegnchic.sampleshoppingcart.danceclasses.DanceClass;

public class MainActivity extends Activity {
	public final static String DANCE_CLASS = "DANCECLASS";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void saveClass(View view) {
    	DanceClass danceClass = buildDanceClass();
    	
    	Intent intent = new Intent(this, DisplayClassActivity.class);
    	intent.putExtra(DANCE_CLASS, danceClass);
    	startActivity(intent);
    }
    
    private DanceClass buildDanceClass() {
    	DanceClass danceClass = new DanceClass();
    	danceClass.setName(getValueFromEditTextView(R.id.edit_class_name));
    	danceClass.setDescription(getValueFromEditTextView(R.id.edit_class_description));
    	danceClass.setStartTime(getValueFromEditTextView(R.id.edit_class_time));
    	danceClass.setDuration(Integer.parseInt(getValueFromEditTextView(R.id.edit_class_duration)));
    	danceClass.setPrice(getValueFromEditTextView(R.id.edit_class_price));
    	danceClass.setSize(Integer.parseInt(getValueFromEditTextView(R.id.edit_class_size)));
    	danceClass.setOriginalInstructor(getValueFromSpinner(R.id.spinner_instructors));
    	
    	return danceClass;
    }
    
    private String getValueFromEditTextView (int viewId) {
    	EditText editText = (EditText) findViewById(viewId);
    	String value = editText.getText().toString();
    	return value;
    }
    
    private String getValueFromSpinner(int viewId) {
    	Spinner instructors = (Spinner) findViewById(viewId);  
    	String value = instructors.getSelectedItem().toString();     	
    	return value;

    }
}
