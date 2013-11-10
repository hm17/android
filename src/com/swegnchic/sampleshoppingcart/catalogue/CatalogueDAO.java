package com.swegnchic.sampleshoppingcart.catalogue;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

import com.swegnchic.sampleshoppingcart.constants.Constants;
import com.swegnchic.sampleshoppingcart.danceclass.DanceClass;
import com.swegnchic.sampleshoppingcart.db.DatabaseDAO;

/**
 * CatalogueDAO builds list of dance classes from query results.
 * 
 * @author swegnchic
 *
 */
public class CatalogueDAO {
	private DatabaseDAO db;
	
	public CatalogueDAO(Context context) {
		db = DatabaseDAO.getInstance(context);
	}

	public long insertClass(DanceClass danceClass) {
    	return db.insertClass(danceClass.getName(), danceClass.getDescription());
	}
	
	public List<DanceClass> getDanceClasses() {				
		return extractDanceClassesFromDbResults(db.getClasses());
	}	
	
	private List<DanceClass> extractDanceClassesFromDbResults(Cursor cursor) {
		List<DanceClass> danceClasses = new ArrayList<DanceClass>();
		
		if(cursor.moveToFirst()) {
			do {
				String className = cursor.getString(cursor.getColumnIndex(Constants.CLASS_NAME));
				String description = cursor.getString(cursor.getColumnIndex(Constants.DESCRIPTION_NAME));
				long id = cursor.getLong(cursor.getColumnIndex(Constants.KEY_ID));
				
				DanceClass danceClass = new DanceClass();
				danceClass.setName(className);
				danceClass.setDescription(description);
				danceClass.setId(id);
				
				danceClasses.add(danceClass);
				
			} while(cursor.moveToNext());
		}		
		cursor.close();
		
		return danceClasses;
	}
	
}
