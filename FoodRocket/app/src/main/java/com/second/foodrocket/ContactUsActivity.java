package com.second.foodrocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactUsActivity extends AppCompatActivity {
    Button cn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_us);
        cn=(Button) findViewById(R.id.cont);
        cn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Toast.makeText (getApplicationContext(),"Messege Sent",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
