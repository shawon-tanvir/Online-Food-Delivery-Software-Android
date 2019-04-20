package com.second.foodrocket;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class DatabaseCart extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="CARTDATABASE";
    private static final String TABLE_NAME="Cart";
    private static final String KEY_ID="id";
    private static final String KEY_AMOUNT="Amount";
    private static final String KEY_FOOD="FoodName";
    private static final String KEY_Price="Price";


    public DatabaseCart(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Log.v("db created", "yes");
        String CREATE_CONTACT_TABLE="CREATE TABLE "+ TABLE_NAME +"("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_FOOD +" TEXT,"
                + KEY_AMOUNT +" INTEGER,"
                + KEY_Price +" INTEGER"+")";


        db.execSQL(CREATE_CONTACT_TABLE);
        //Log.v("db created", "yes");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addContact(String foodname,int price)
    {
        SQLiteDatabase db = this.getWritableDatabase();



        //String qry = "INSERT INTO CONTACT(NAME,PHONENO)VALUES('XYZ','016')";
        //db.execSQL(query);

        ContentValues value=new ContentValues();

        value.put(KEY_FOOD,foodname);
        value.put(KEY_AMOUNT,1);
        value.put(KEY_Price,price);

        db.insert(TABLE_NAME, null,value);

        db.close();

    }

    public boolean search(CartType contact){

        String selectquery="SELECT * FROM "+ TABLE_NAME;// where  LIKE '017%'";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);
        FoodListType contact1 = null;
        if(cursor.moveToFirst())
        {

            do
            {

                // contact1 = new FoodListType(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));


                // Contact contact= new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));

            }while(cursor.moveToNext());
        }
        db.close();
        return false;
    }



    public List<CartType> getAllContact()
    {
        List<CartType> mycontactList=new ArrayList<CartType>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                CartType contact= new CartType(Integer.parseInt(cursor.getString(0)),cursor.getString(1),Integer.parseInt(cursor.getString(2)),Integer.parseInt(cursor.getString(3)));
                mycontactList.add(contact);
            }while(cursor.moveToNext());
        }

        return mycontactList;
    }
    public void deleteContact()
    {
        SQLiteDatabase db=this.getWritableDatabase();
        String query = "DELETE From "+TABLE_NAME;
        db.execSQL(query);

        //db.delete(TABLE_NAME, KEY_ID+"=?", new String[]{String.valueOf(id)});
        db.close();
    }





}
