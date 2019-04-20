package com.second.foodrocket;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mtoggle;
    final DatabaseRestaurantList db=new DatabaseRestaurantList(this);
    ArrayList<RestaurantListType> imageArry = new ArrayList<RestaurantListType>();
    ContactImageAdapter adapter;
    List<RestaurantListType> myContactList;
    String[] listItemsValue = new String[5] ;
    int p=0;


    Button logbutton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setNavigationViewListner();

        mdrawerlayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mtoggle = new ActionBarDrawerToggle(this, mdrawerlayout, R.string.open, R.string.close);

        mdrawerlayout.addDrawerListener(mtoggle);
        mtoggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        myContactList = db.getAllContact();
        for (RestaurantListType cn : myContactList) {
            String log = "ID:" + cn.get_id() + " Name: " + cn.getName()
                    + " ,Image: " + cn.getImage();
            // Writing Contacts to log
            String c=cn.getName();
            Log.d("Result: ", log);
            Log.d("Result: ", "check");
            //add contacts data in arrayList
            listItemsValue[p++] = c;
            imageArry.add(cn);

        }
        adapter = new ContactImageAdapter(this, R.layout.basic_reslist, imageArry);
        final ListView dataList = (ListView) findViewById(R.id.reslist);
        dataList.setAdapter(adapter);


        dataList.setOnItemClickListener(new OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // TODO Auto-generated method stub
                //Toast.makeText(MainActivity.this, listItemsValue[position], Toast.LENGTH_SHORT).show();
                Intent myIntent = new Intent(MainActivity.this, FoodListActivity1.class);
                myIntent.putExtra("RestaurantName",listItemsValue[position]);

                startActivity(myIntent);

            }
        });

    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Handle navigation view item clicks here.
        switch (item.getItemId()) {

            case R.id.nav_contact: {
                startActivity(new Intent(MainActivity.this,ContactUsActivity.class));
                break;
            }
            case R.id.nav_settings: {
                startActivity(new Intent(MainActivity.this,SettingActivity.class));
                break;
            }
        }
        //close navigation drawer
        mdrawerlayout.closeDrawer(GravityCompat.START);
        return true;
    }


    public void tologinwin(View v){
        Log.d("Food Rocket","check");
        mdrawerlayout.closeDrawer(GravityCompat.START);
        startActivity(new Intent(MainActivity.this,loginwin.class));
    }
    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view_id);
        navigationView.setNavigationItemSelectedListener(this);
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mtoggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }





}

