package com.swegnchic.sampleshoppingcart;

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
	private static final int PASSWORD_LIMIT = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);  
        
        directory = Directory.getInstance(this); 
    }
    
    public void register(View view) { 	
    	String email = getValueFromEditTextAndValidate(R.id.register_email);
    	String password = getValueFromEditTextAndValidate(R.id.register_password);
    	String passwordConfirm = getValueFromEditTextAndValidate(R.id.register_password_confirm);
    	if(checkPasswordValidity(password, passwordConfirm)){
    		User user = new User();
    		user.setEmail(email);
    		user.setPassword(password);
    		
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
    
    private boolean checkPasswordValidity(final String password, final String passwordConfirm) {
    	if(!password.equals(passwordConfirm)) {
    		Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
    		return false;
    	} else if(password.length() < PASSWORD_LIMIT || passwordConfirm.length() < PASSWORD_LIMIT) {
    		Toast.makeText(this, "Password must be " + PASSWORD_LIMIT + " or more characters", Toast.LENGTH_SHORT).show();
    		return false;
    	} else {
    		return true;
    	}
    	
    	//TODO: Check alphanumeric value of password
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
