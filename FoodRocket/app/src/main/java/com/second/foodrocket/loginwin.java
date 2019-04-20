package com.second.foodrocket;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static com.second.foodrocket.R.id.navigation_view_id;

public class loginwin extends AppCompatActivity {

    Button loginID ;
    EditText accessusername;
    EditText accesspassword;
    TextView Emailshow;
    Button logbutton;
    final DatabaseHandler db=new DatabaseHandler(this);;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginwin);
        loginID = (Button) findViewById(R.id.logbutton);
        accessusername = (EditText) findViewById(R.id.emailbox);
        accesspassword =(EditText) findViewById(R.id.passwordbox);

    }


    public void gotocreateID(View view){
        startActivity(new Intent(loginwin.this,createID.class));
    }
    public void checkDatabase(View view){
        String loginuserNameValue=(String) accessusername.getText().toString();
      //  Log.d("Namelog ",loginuserNameValue);
        String loginpasswordValue=(String) accesspassword.getText().toString();
        //Log.d("Passlog ",loginpasswordValue);




        //logbutton=(Button) mnav.getHeaderView(1).findViewById(R.id.loginbuttonnavigation);
        if(loginuserNameValue.equals("") || loginpasswordValue.equals(""))
        {
            Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
        }
        else{
            if(db.search(new Contact(loginuserNameValue,loginpasswordValue))==true) {
                Toast.makeText(getApplicationContext(), "You are logged in", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(loginwin.this,MainActivity.class));
            }
            else{
                accessusername.setText("");
                accesspassword.setText("");
                Toast.makeText(getApplicationContext(), "Email and Password did'nt match", Toast.LENGTH_SHORT).show();
            }
        }
    }
}
