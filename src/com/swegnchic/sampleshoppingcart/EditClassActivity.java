package com.swegnchic.sampleshoppingcart;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.swegnchic.sampleshoppingcart.catalogue.Catalogue;
import com.swegnchic.sampleshoppingcart.danceclass.DanceClass;

public class EditClassActivity extends Activity {
	public final static String DANCE_CLASS = "DANCECLASS";
	public final static String CLASS_ID = "CLASSID";
	
	private Catalogue catalogue;
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_class);
        
        catalogue = new Catalogue(this);

    }
    
    public void saveClass(View view) {
    	DanceClass danceClass = buildDanceClass();
    	long id = saveClassToDB(danceClass);
    	danceClass.setId(id);
    	Log.v ("Main", "id: " + id);
    	
    	Toast.makeText(this, "Class Saved!", Toast.LENGTH_SHORT).show();
    	
    	Intent intent = new Intent(this, DisplayClassActivity.class);
    	intent.putExtra(CLASS_ID, id);
    	//intent.putExtra(DANCE_CLASS, danceClass);
    	startActivity(intent);
    }
    
    private long saveClassToDB(DanceClass danceClass) {
    	return catalogue.saveDanceClass(danceClass);
    }
    
    private DanceClass buildDanceClass() {
    	DanceClass danceClass = new DanceClass();
    	danceClass.setName(getValueFromEditTextView(R.id.edit_class_name));
    	danceClass.setDescription(getValueFromEditTextView(R.id.edit_class_description));
    	
    	Log.v ("Main", "name: " + danceClass.getName());
    	Log.v ("Main", "description: " + danceClass.getDescription());
    	
 /*   	danceClass.setStartTime(getValueFromEditTextView(R.id.edit_class_time));
    	danceClass.setDuration(Integer.parseInt(getValueFromEditTextView(R.id.edit_class_duration)));
    	danceClass.setPrice(getValueFromEditTextView(R.id.edit_class_price));
    	danceClass.setSize(Integer.parseInt(getValueFromEditTextView(R.id.edit_class_size)));
    	danceClass.setOriginalInstructor(getValueFromSpinner(R.id.spinner_instructors));*/
    	
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
