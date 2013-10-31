package com.swegnchic.sampleshoppingcart;

import com.swegnchic.sampleshoppingcart.R;
import com.swegnchic.sampleshoppingcart.R.layout;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class StudioOwnerMainActivity extends ListActivity {
	private final static int CREATE_NEW_CLASS = 0;
	private final static int DISPLAY_ALL_CLASSES = 1;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_studio_owner_main);
    	
        buildMenu();
    }
    
    private void buildMenu() {
        String[] values = {"Create a new class", 
        		"Display all classes", 
        		"View Customer Stats"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);

        // Assign adapter to List
        setListAdapter(adapter); 
    }
    
    private void createNewClass() {  	
    	Intent intent = new Intent(this, EditClassActivity.class);
    	startActivity(intent);
    }
    
    private void displayAllClasses() {
    	Intent intent = new Intent(this, DisplayAllClassesActivity.class);
    	startActivity(intent);
    }
    
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
		 
		 if(position == CREATE_NEW_CLASS) {
			 createNewClass();
		 } else {
			 displayAllClasses();
		 }
             
    }
}
