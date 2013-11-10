package com.swegnchic.sampleshoppingcart.directory;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

import com.swegnchic.sampleshoppingcart.constants.Constants;
import com.swegnchic.sampleshoppingcart.db.DatabaseDAO;
import com.swegnchic.sampleshoppingcart.users.user.User;
/**
 * DirectoryDAO builds list of users from query results.
 * @author swegnchic
 *
 */
public class DirectoryDAO {
	private DatabaseDAO dbDAO;
	
	public DirectoryDAO(Context context) {
		dbDAO = DatabaseDAO.getInstance(context);		
	}
	
	public long insertUser(final User user) {
		return dbDAO.insertUser(user.getEmail(), user.getPassword());
	}
	
	protected List<User> getUsers() {
		return getUsersFromDbResults();
	}
	
	private List<User> getUsersFromDbResults() {
		List<User> users = new ArrayList<User>();
		
		Cursor cursor = dbDAO.getUsers();
		if(cursor.moveToFirst()) {
			User user = new User();
			do {
				String email = cursor.getString(cursor.getColumnIndex(Constants.EMAIL_NAME));
				String password = cursor.getString(cursor.getColumnIndex(Constants.PASSWORD_NAME));
				
				user.setEmail(email);
				user.setPassword(password);				
				users.add(user);
			} while(cursor.moveToNext());
		}
		cursor.close();
		
		return users;
	}

}
