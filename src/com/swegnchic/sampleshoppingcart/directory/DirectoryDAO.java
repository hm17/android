package com.swegnchic.sampleshoppingcart.directory;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

import com.swegnchic.sampleshoppingcart.constants.Constants;
import com.swegnchic.sampleshoppingcart.db.MyDB;
import com.swegnchic.sampleshoppingcart.users.user.User;

public class DirectoryDAO {
	private static DirectoryDAO directoryDAO;
	private MyDB db;
	private List<User> users;
	
	private DirectoryDAO(Context context) {
		db = MyDB.getDB(context);
		
	}
	
	protected static DirectoryDAO getDirectoryDAO(Context context) {
		if(directoryDAO == null) {
			directoryDAO = new DirectoryDAO(context);
		}
		
		return directoryDAO;
	}
	
	public long insertUser(User user) {
		long id = db.insertUser(user.getEmail(), user.getPassword());
		
		return id;
	}
	
	protected List<User> getUsers() {
		if(users == null) {
			users = new ArrayList<User>();
		} else {
			Cursor c = db.getUsers();
			manageCursor(c);
		}
		
		return users;
	}
	
	private void manageCursor(Cursor c) {
		if(c.moveToFirst()) {
			User tempUser = new User();
			do {
				String email = c.getString(c.getColumnIndex(Constants.EMAIL_NAME));
				String password = c.getString(c.getColumnIndex(Constants.PASSWORD_NAME));
				
				tempUser.setEmail(email);
				tempUser.setPassword(password);
				
				users.add(tempUser);
			} while(c.moveToNext());
		}
	}
	
	
	

}
