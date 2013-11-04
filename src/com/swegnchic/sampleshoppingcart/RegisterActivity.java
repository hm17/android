package com.swegnchic.sampleshoppingcart;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends Activity{
	private static final int PASSWORD_LIMIT = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);     
    }
    
    public void register(View view) { 	
    	String email = getValueFromEditTextAndValidate(R.id.register_email);
    	String password = getValueFromEditTextAndValidate(R.id.register_password);
    	String passwordConfirm = getValueFromEditTextAndValidate(R.id.register_password_confirm);
    	if(checkPasswordValidity(password, passwordConfirm)){
    		
    		//TODO: Save user to DB
    	}
    }
    
    private boolean checkPasswordValidity(final String password, final String passwordConfirm) {
    	if(!password.equals(passwordConfirm)) {
    		Toast.makeText(this, "Passwords do not match!", Toast.LENGTH_SHORT).show();
    		return false;
    	} else if(password.length() < PASSWORD_LIMIT || passwordConfirm.length() < PASSWORD_LIMIT) {
    		Toast.makeText(this, "Password must be " + PASSWORD_LIMIT + "or more characters", Toast.LENGTH_SHORT).show();
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
}
