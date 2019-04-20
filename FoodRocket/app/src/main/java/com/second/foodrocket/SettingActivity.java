package com.second.foodrocket;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends AppCompatActivity {
    Button setting;
    EditText emialupdate;
    EditText passupdate;
    final DatabaseHandler db=new DatabaseHandler(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        setting=(Button) findViewById(R.id.updatebutton);
        emialupdate=(EditText) findViewById(R.id.emailboxupdate);
        passupdate=(EditText) findViewById(R.id.passwordboxupdate);

        setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(emialupdate.getText().toString().equals("") || passupdate.getText().toString().equals(""))
                {
                    Toast.makeText (getApplicationContext(),"Information Missing",Toast.LENGTH_SHORT).show();
                }
                else {
                    db.updateContact(new Contact(emialupdate.getText().toString(), passupdate.getText().toString()));
                    Toast.makeText(getApplicationContext(), "Password Updated", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
