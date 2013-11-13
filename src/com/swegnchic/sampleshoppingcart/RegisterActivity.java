package com.swegnchic.sampleshoppingcart;

import java.util.regex.Pattern;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.swegnchic.sampleshoppingcart.directory.Directory;
import com.swegnchic.sampleshoppingcart.users.user.User;

public class RegisterActivity extends Activity{
	private Directory directory;
	private static final String EMAIL_REGEX = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	private static final String PASSWORD_REGEX = "^(?=.*(\\d|\\W)).{8,20}$";
	private User user;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);  
        
        directory = Directory.getInstance(this); 
        user = new User();
    }
    
    public void cancel(View view) {
    	backToLoginScreen();
    }
    
    public void register(View view) { 	
    	if(validateForm()) {
    		try {
    			directory.saveUser(user);
				Toast.makeText(this, "You've been added!", Toast.LENGTH_SHORT).show();
				backToLoginScreen();
			} catch (Exception e) {
				Log.e("register", e.getMessage());
				Toast.makeText(this, "There was an error processing your request.", Toast.LENGTH_SHORT).show();
			}
    	} 
    }
    
    private boolean validateForm() {
    	String email = getValueFromEditTextAndValidate(R.id.register_email);
    	String password = getValueFromEditTextAndValidate(R.id.register_password);
    	String passwordConfirm = getValueFromEditTextAndValidate(R.id.register_password_confirm);
    	
    	if(email.length() == 0 || password.length() == 0 || passwordConfirm.length() == 0) {
    		return false;
    	} 
    	
    	if (checkEmailValidity(email) && checkPasswordValidity(password, passwordConfirm)) {
    		createUser(email, password);
    		return true;   		
    	}   	
    	return false;
    }
    
    private boolean checkEmailValidity(final String email) {
    	if(Pattern.matches(EMAIL_REGEX, email)) {
    		return true;
    	} else {
    		Toast.makeText(this, "Email not valid.", Toast.LENGTH_SHORT).show();
    	}
    	return false;
    }
    
    private boolean checkPasswordValidity(final String password, final String passwordConfirm) {
    	if(!password.equals(passwordConfirm)) {
    		Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
    		return false;
    	} else if(!Pattern.matches(PASSWORD_REGEX, password)) {
    		Toast.makeText(this, "Password must be at least 8 characters long with special characters and numbers.", Toast.LENGTH_SHORT).show();
    		return false;
    	} else {
    		return true;
    	}
    }
    
    private void createUser(final String email, final String password) {
		user.setEmail(email);
		user.setPassword(password);
    }
    
    private String getValueFromEditTextAndValidate (int viewId) {
    	EditText editText = (EditText) findViewById(viewId);
    	String value = editText.getText().toString();
    	if(value.length() == 0) 
    		editText.setError("This value is required!");
    	
    	return value;
    }
    
    private void backToLoginScreen(){
		Intent intent = new Intent(this, MainActivity.class);
    	startActivity(intent);
    }
}
