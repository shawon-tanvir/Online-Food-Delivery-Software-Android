package com.second.foodrocket;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;

public class FoodListActivity1 extends AppCompatActivity {
    //RestaurantListType RLS;

    // gets the previously created intent
    String RestaurantName;
    final DatabaseFoodList dbfood=new DatabaseFoodList(this);
    ArrayList<FoodListType> imageArry = new ArrayList<FoodListType>();
    FoodListAdapter adapter;
    List<FoodListType> myContactList;
    String[] listFoodValue = new String[8] ;
    int[] listprice=new int[8];
    int p=0;
    FloatingActionButton floatbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_list1);

        try {
            ImageView img = (ImageView) findViewById(R.id.imageIconFoodList);
            TextView txt= (TextView) findViewById(R.id.ResnameFoodList);
            final DatabaseRestaurantList db = new DatabaseRestaurantList(this);

            Intent myIntent = getIntent();
            //
            RestaurantName = myIntent.getStringExtra("RestaurantName");
            Log.d("checkfor",RestaurantName);
            RestaurantListType RLS = db.getSingleContact(RestaurantName);

            //Toast.makeText(FoodListActivity1.this, RestaurantName, Toast.LENGTH_SHORT).show();

            byte[] outImage = RLS.getImage();
            ByteArrayInputStream imageStream = new ByteArrayInputStream(outImage);
            Bitmap theImage = BitmapFactory.decodeStream(imageStream);
            img.setImageBitmap(theImage);
            txt.setText(RestaurantName);
        }
        catch(Exception e){
            //Toast.makeText(FoodListActivity.this, "Fuck", Toast.LENGTH_SHORT).show();
        }
        try{
            final DatabaseFoodList dbfood=new DatabaseFoodList(this);
            myContactList = dbfood.getAllContact(RestaurantName);
            for (FoodListType cn : myContactList) {

                String c=cn.getFoodname();
                listFoodValue[p] = c;
                listprice[p++]=cn.getPrice();
                imageArry.add(cn);

            }
            adapter = new FoodListAdapter(this, R.layout.basic_foodlist, imageArry);

            final ListView dataList = (ListView) findViewById(R.id.foodlist);

            dataList.setAdapter(adapter);
            Log.d("Check:   ","Hoise");
        }
        catch(Exception e){
            Log.d("Check:   ","Problem");
        }
        try {
            final DatabaseCart dbcart = new DatabaseCart(this);
            final ListView dataList = (ListView) findViewById(R.id.foodlist);
            dataList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                    // TODO Auto-generated method stub
                    //Toast.makeText(MainActivity.this, listItemsValue[position], Toast.LENGTH_SHORT).show();
                    //Intent myIntent = new Intent(FoodListActivity1.this, .class);
                    //myIntent.putExtra("RestaurantName",listItemsValue[position]);
                    dbcart.addContact(listFoodValue[position], listprice[position]);
                    Toast.makeText(FoodListActivity1.this, "Added to Your Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(FoodListActivity1.this, CartActivity.class));

                    //startActivity(myIntent);

                }
            });
        }
        catch(Exception e){
            Log.d("Check:   ","Problem");
        }
        try {
            floatbutton = (FloatingActionButton) findViewById(R.id.fab);
            floatbutton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    startActivity(new Intent(FoodListActivity1.this, CartActivity.class));

                    Log.d("Check", "Problem in 1ch ");
                }
            });
        }
        catch(Exception e){
            Log.d("Check:   ","Problem");
        }


    }




}
