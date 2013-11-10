package com.swegnchic.sampleshoppingcart.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.swegnchic.sampleshoppingcart.constants.Constants;

/**
 * Class handles DB interactions
 * 
 * @author swegnchic
 *
 */
public class DatabaseDAO {
	private static DatabaseDAO dbDAO;	
	private final DatabaseBuilder dbBuilder;
	private static SQLiteDatabase db;
	private final Context context;
	
	private DatabaseDAO(final Context c) {
		context = c;
		dbBuilder = new DatabaseBuilder(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);		
		openDB();
	}
	
	public static synchronized DatabaseDAO getInstance(final Context c) {
		if(dbDAO == null) 
			dbDAO = new DatabaseDAO(c);
				
		return dbDAO;
	}
	
	private void close() {
		db.close();
	}
	
	private void openDB() throws SQLiteException {
		try {
			db = dbBuilder.getWritableDatabase();
			
		} catch (SQLiteException e) {
			Log.v("openDB", "Open database exception caught: " + e.getMessage());
			db = dbBuilder.getReadableDatabase();
		}
	}
	
	public long insertUser(final String email, final String password) {
		try {
			ContentValues newTaskValue = new ContentValues();
			newTaskValue.put(Constants.EMAIL_NAME, email);
			newTaskValue.put(Constants.PASSWORD_NAME, password);			
			long id = db.insert(Constants.USER_TABLE_NAME, null, newTaskValue);
			Log.v("insertUser", "User with id:" + id + " has been saved!");
			return id;
		} catch (SQLiteException e) {
			Log.v("insertUser", "Insert into database exception caught: " + e.getMessage());
			return -1;
		}		
	}
	
	public Cursor getUsers() {
		Cursor c = db.query(Constants.USER_TABLE_NAME, null, null, null, null, null, null);
		return c;
	}
	
	public long insertClass(String name, String description) {
		try {
			ContentValues newTaskValue = new ContentValues();
			newTaskValue.put(Constants.CLASS_NAME, name);
			newTaskValue.put(Constants.DESCRIPTION_NAME, description);
			return db.insert(Constants.DANCE_CLASSES_TABLE_NAME, null, newTaskValue);
		} catch (SQLiteException e) {
			Log.v("insertClass", "Insert into database exception caught: " + e.getMessage());
			return -1;
		}
	}
	
	public Cursor getClasses() {
		Cursor c = db.query(com.swegnchic.sampleshoppingcart.constants.Constants.DANCE_CLASSES_TABLE_NAME, null, null, null, null, null, null);		
		return c;
	}

}
