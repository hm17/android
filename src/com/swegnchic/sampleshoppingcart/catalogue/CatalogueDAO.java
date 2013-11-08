package com.swegnchic.sampleshoppingcart.catalogue;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

import com.swegnchic.sampleshoppingcart.danceclass.DanceClass;
import com.swegnchic.sampleshoppingcart.db.MyDB;

/**
 * CatalogueDAO works with DB
 * 
 * @author swegnchic
 *
 */
public class CatalogueDAO {
	private MyDB db;
	
	public CatalogueDAO(Context context) {
		db = MyDB.getDB(context);
	}

	public long insertClass(DanceClass danceClass) {
    	long id = db.insertClass(danceClass.getName(), danceClass.getDescription());
    	
    	Log.v ("catalogue", "name: " + danceClass.getName());
    	Log.v ("catalogue", "description: " + danceClass.getDescription());
    	
    	return id;
	}
	
	public Cursor getDanceClassesCursor() {
		return db.getClasses();
	}	
	
}
