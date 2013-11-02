package com.swegnchic.sampleshoppingcart;



import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.swegnchic.sampleshoppingcart.constants.Constants;
import com.swegnchic.sampleshoppingcart.constants.Constants.Screens;
import com.swegnchic.sampleshoppingcart.loginmanager.LoginManager;

public class MainActivity extends Activity {
	private LoginManager loginManager;

	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        loginManager = new LoginManager();          
    }
    
    public void login(View view) {
    	String email = getValueFromEditTextView(R.id.email);
    	String password = getValueFromEditTextView(R.id.password);
    	Screens screen = loginManager.login(email, password);
    	changeScreens(screen);
    }
    
    public void register(View view) {
    	changeScreens(Constants.Screens.REGISTER);
    }
    
    private void changeScreens(final Screens register) {
    	switch(register) {
    	case REGISTER:
    		startActivityForScreen(RegisterActivity.class);
    		break;
    	case STUDIO:
    		startActivityForScreen(StudioOwnerMainActivity.class);
    		break;
    	};
    	
    }
    
    private void startActivityForScreen(Class<?> cls) {
		Intent intent = new Intent(this, cls);
    	startActivity(intent);
    }
    
    private String getValueFromEditTextView (int viewId) {
    	EditText editText = (EditText) findViewById(viewId);
    	String value = editText.getText().toString();
    	return value;
    }


}
