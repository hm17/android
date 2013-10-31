package com.swegnchic.sampleshoppingcart.db;


import com.swegnchic.sampleshoppingcart.constants.Constants;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Creates and updates DB
 * 
 * @author swegnchic
 *
 */
public class MyDBHelper extends SQLiteOpenHelper{

	private static final String CREATE_TABLE_QUERY="create table " + 
			Constants.TABLE_NAME + " (" + 
			Constants.KEY_ID +" integer primary key autoincrement, " +
			Constants.CLASS_NAME + " text not null, " +
			Constants.DESCRIPTION_NAME + " text not null);";//, " +
			//Constants.START_NAME + " long);";
	
	public MyDBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		System.out.println ("MyDBHelper onCreate: Creating all the tables");
		try {
			db.execSQL(CREATE_TABLE_QUERY);
		} catch(SQLiteException e) {
			System.out.println ("Create table exception: " + e.getMessage());
		}
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		System.out.println  ("TaskDBAdapter: Upgrading from version " 
				+ oldVersion + " to " + newVersion + " , which will destroy all old data");
		
		db.execSQL("drop table if exists " + Constants.TABLE_NAME);
		onCreate(db);		
	}
}
