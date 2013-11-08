package com.swegnchic.sampleshoppingcart.directory;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.swegnchic.sampleshoppingcart.users.user.User;

public class Directory {
	private static Directory directory;
	
	private DirectoryDAO directoryDAO;
	
	private List<User> users;
	
	private Directory(Context context) {
		directoryDAO = DirectoryDAO.getDirectoryDAO(context);
		users = new ArrayList<User>();
	}
	
	public static Directory getDirectory(Context context) {
		if(directory == null) {
			directory = new Directory(context);
		}
		
		return directory;
	}
	
	public User getUserByEmail(final String email) {
		if(users.size() == 0){
			users = directoryDAO.getUsers();
		}
		
		for(User user : users) {
			if(user.getEmail().equals(email)) {
				return user;
			}
		}
				
		//TODO: not good to return null
		return null;
		
	}
	
	public long saveUser(User user) {
		return directoryDAO.insertUser(user);
	}

}
