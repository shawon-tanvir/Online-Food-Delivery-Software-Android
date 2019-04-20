package com.second.foodrocket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class createID extends AppCompatActivity {
    Button createID ;
    EditText createusername;
    EditText createpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_id);

        createID = (Button) findViewById(R.id.createbutton);
        createusername =(EditText) findViewById(R.id.createemailbox);
        createpassword= (EditText) findViewById(R.id.createpasswordbox);
        final DatabaseHandler db=new DatabaseHandler(this);

        createID.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userNameValue= createusername.getText().toString();
                String passwordValue= createpassword.getText().toString();
                if(userNameValue.equals("") || passwordValue.equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addContact(new Contact(userNameValue,passwordValue));
                    Toast.makeText (getApplicationContext(),"You are Added.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void onClickbutton(View view){
        startActivity(new Intent(createID.this,AddRestaurantList.class));
    }
}

