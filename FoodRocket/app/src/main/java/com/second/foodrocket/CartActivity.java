package com.second.foodrocket;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CartActivity extends AppCompatActivity {
    List<CartType> myContactList;
    final DatabaseCart db =new DatabaseCart(this);
    Button plusbutton;
    Button order;
    TextView totaltext;
    ArrayList<CartType> imageArry = new ArrayList<CartType>();
    CartListAdapter adapter;
    int k=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        order=(Button) findViewById(R.id.addorder);
        totaltext=(TextView) findViewById(R.id.totaltaka);
        Button timebutton=(Button)findViewById(R.id.timebutton);
        try{
        timebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TimePickerFragment newFragment = new TimePickerFragment();
                newFragment.show(getFragmentManager(),"TimePicker");
            }
        });
        }
        catch (Exception e){
            Log.d("Check","Problem in 1");
        }
        try{
        myContactList = db.getAllContact();
        for (CartType cn : myContactList) {

            // Writing Contacts to log
            k=k+cn.getPrice();
            imageArry.add(cn);

        }
        adapter = new CartListAdapter(this, R.layout.basic_cartlist, imageArry);
        final ListView dataList = (ListView) findViewById(R.id.cartlist);
        dataList.setAdapter(adapter);
        }
        catch (Exception e){
            Log.d("Check","Problem in ");
        }
        totaltext.setText("Tk "+String.valueOf(k));
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText (getApplicationContext(),"Order Confirmed",Toast.LENGTH_SHORT).show();
                db.deleteContact();
            }
        });

    }
}
