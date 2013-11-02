package com.swegnchic.sampleshoppingcart.loginmanager;

import com.swegnchic.sampleshoppingcart.constants.Constants.Screens;


public class LoginManager {
	
	public LoginManager() {
		
	}
	
	public Screens login(final String username, final String password) {
		if(verifyCredentials(username, password)) {
			transferPage();
		}
		
		return Screens.STUDIO;
	}
	
	private Boolean verifyCredentials(final String username, final String password) {
		
		return true;
	}
	
	private Screens transferPage() {
		
		return Screens.STUDIO;
		
	}
}
