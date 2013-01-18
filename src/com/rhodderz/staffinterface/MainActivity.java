package com.rhodderz.staffinterface;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	Context context = null;
	int toastDuration = Toast.LENGTH_SHORT;
	
	String userID;
	String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        context = getApplicationContext(); // had to do it like this as it crashes other wise (silly SDK)
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
    
    public void login()
    {
    	
    }
    
    //Debug stuff, leave here could be useful.......maybe
    
    public void dispUserID(View view)
    {
    	EditText usernameET = (EditText)findViewById(R.id.usrNameInput);
    	userID = usernameET.getText().toString();
    	Toast backToast = Toast.makeText(context, userID, toastDuration);
    	backToast.show();
    }
    
    public void dispPassword(View view)
    {
    	EditText passwordET = (EditText)findViewById(R.id.psswdInput);
    	password = passwordET.getText().toString();
    	Toast backToast = Toast.makeText(context, password, toastDuration);
    	backToast.show();
    }
}
