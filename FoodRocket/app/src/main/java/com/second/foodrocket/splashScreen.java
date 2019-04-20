package com.second.foodrocket;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;


public class splashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        Thread splashtrread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    //Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(new Intent(getApplicationContext(),MainActivity.class));
                    finish();
                }
                catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        splashtrread.start();

    }
}

