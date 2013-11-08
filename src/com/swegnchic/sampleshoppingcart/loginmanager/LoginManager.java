package com.swegnchic.sampleshoppingcart.loginmanager;

import android.content.Context;

import com.swegnchic.sampleshoppingcart.constants.Constants.Screens;
import com.swegnchic.sampleshoppingcart.directory.Directory;
import com.swegnchic.sampleshoppingcart.users.user.User;


public class LoginManager {
	private Directory directory;
	
	public LoginManager(Context context) {
		directory = Directory.getDirectory(context);
		
	}
	
	public Screens login(final String username, final String password) {
		if(verifyCredentials(username, password)) {
			transferPage();
		}
		
		return Screens.STUDIO;
	}
	
	private Boolean verifyCredentials(final String username, final String password) {
		User user = directory.getUserByEmail(username);
		if(user != null){
			user.getPassword().equals(password);
			return true;
		}
		
		return false;
	}
	
	private Screens transferPage() {
		
		return Screens.STUDIO;
		
	}
}
