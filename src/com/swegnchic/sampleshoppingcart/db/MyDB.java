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
public class MyDB {
	private static MyDB myDBInstance;	
	private final Context context;
	private SQLiteDatabase db;
	private final MyDBHelper dbHelper;
	
	private MyDB(Context c) {
		context = c;

		dbHelper = new MyDBHelper(context, Constants.DATABASE_NAME, null, Constants.DATABASE_VERSION);		
		open();
	}
	
	public static MyDB getDB(Context c) {
		if(myDBInstance == null) {
			myDBInstance = new MyDB(c);
		}
		return myDBInstance;
	}
	
	private void close() {
		db.close();
	}
	
	private void open() throws SQLiteException {
		try {
			db = dbHelper.getWritableDatabase();
			
		} catch (SQLiteException e) {
			System.out.println ("Open database exception caught: " + e.getMessage());
			db = dbHelper.getReadableDatabase();
		}
	}
	
	public long insertUser(final String email, final String password) {
		try {
			ContentValues newTaskValue = new ContentValues();
			newTaskValue.put(Constants.EMAIL_NAME, email);
			newTaskValue.put(Constants.PASSWORD_NAME, password);
			
			return db.insert(Constants.USER_TABLE_NAME, null, newTaskValue);
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
