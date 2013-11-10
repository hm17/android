package com.swegnchic.sampleshoppingcart;

import java.util.List;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.swegnchic.sampleshoppingcart.catalogue.Catalogue;

public class DisplayAllClassesActivity extends ListActivity{
	private TextView content;
	
	private Catalogue catalogue;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {				       
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_all_classes);
                
        content = (TextView)findViewById(R.id.output);
		
        catalogue = Catalogue.getInstance(this);

        //listView = (ListView) findViewById(R.id.list);
        List<String> names = catalogue.getDanceClassNames();
        
        // Define a new Adapter
        // First parameter - Context
        // Second parameter - Layout for the row
        // Third - the Array of data
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);

        // Assign adapter to List
        setListAdapter(adapter); 
   	}

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
    	super.onListItemClick(l, v, position, id);
  
		 // ListView Clicked item index
		 int itemPosition     = position;
		 
		 // ListView Clicked item value
		 String  itemValue    = (String) l.getItemAtPosition(position);
		    
		 content.setText("Click : \n  Position :"+itemPosition+"  \n  ListItem : " +itemValue);
             
    }

	
}