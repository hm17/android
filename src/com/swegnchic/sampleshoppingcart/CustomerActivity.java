package com.swegnchic.sampleshoppingcart;

import android.app.ListActivity;
import android.widget.ArrayAdapter;

public class CustomerActivity extends ListActivity {
	// Show list of classes for the day
	// Show menu
	
    private void buildMenu() {
        String[] values = {"Sign up for a new class", 
        		"Pay Bill", 
        		"View Preferences"};
        
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, values);

        // Assign adapter to List
        setListAdapter(adapter); 
    }

}
