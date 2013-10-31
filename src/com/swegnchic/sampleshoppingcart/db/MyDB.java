package com.swegnchic.sampleshoppingcart.db;

import com.swegnchic.sampleshoppingcart.constants.Constants;
import com.swegnchic.sampleshoppingcart.constants.Constants.*;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

/**
 * Class handles DB interactions
 * 
 * @author swegnchic
 *
 */
public class MyDB {
	
	private final Context context;
	
	private SQLiteDatabase db;
	
	private final MyDBHelper dbHelper;
	
	public MyDB(Context c) {
		context = c;

		dbHelper = new MyDBHelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);		
	}
	
	public void close() {
		db.close();
	}
	
	public void open() throws SQLiteException {
		try {
			db = dbHelper.getWritableDatabase();
			
		} catch (SQLiteException e) {
			System.out.println ("Open database exception caught: " + e.getMessage());
			db = dbHelper.getReadableDatabase();
		}
	}
	
	public long insertClass(String name, String description) {
		try {
			ContentValues newTaskValue = new ContentValues();
			newTaskValue.put(Constants.CLASS_NAME, name);
			newTaskValue.put(Constants.DESCRIPTION_NAME, description);
			return db.insert(Constants.TABLE_NAME, null, newTaskValue);
		} catch (SQLiteException e) {
			System.out.println ("Insert into database exception caught: " + e.getMessage());
			return -1;
		}
	}
	
	public Cursor getClasses() {
		Cursor c = db.query(com.swegnchic.sampleshoppingcart.constants.Constants.TABLE_NAME, null, null, null, null, null, null);
		
		return c;
	}

}
