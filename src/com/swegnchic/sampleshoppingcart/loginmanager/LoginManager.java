package com.swegnchic.sampleshoppingcart.loginmanager;


public class LoginManager {
	
	public LoginManager() {
		
	}
	
	public int login(final String username, final String password) {
		if(verifyCredentials(username, password)) {
			transferPage();
		}
		
		return 0;
	}
	
	private Boolean verifyCredentials(final String username, final String password) {
		
		return true;
	}
	
	private int transferPage() {
		
		return 0;
		
	}
}
