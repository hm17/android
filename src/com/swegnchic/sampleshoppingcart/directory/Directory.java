package com.swegnchic.sampleshoppingcart.directory;

import java.util.List;

import android.content.Context;

import com.swegnchic.sampleshoppingcart.users.user.User;

public class Directory {
	private static Directory directory;
	private DirectoryDAO directoryDAO;
	
	private List<User> users;
	
	private Directory(Context context) {
		directoryDAO = new DirectoryDAO(context);
		users = directoryDAO.getUsers();
	}
	
	public static Directory getInstance(Context context) {
		if(directory == null) {
			directory = new Directory(context);
		}		
		return directory;
	}
	
	public User getUserByEmail(final String email) {
		for(User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
				
		//TODO: not good to return null
		return null;		
	}
	
	public long saveUser(final User user) throws Exception {
		long id = directoryDAO.insertUser(user);		
		if(id == -1) 
			throw new Exception("User not saved!");

		users.add(user);
		return id;
	}

}
