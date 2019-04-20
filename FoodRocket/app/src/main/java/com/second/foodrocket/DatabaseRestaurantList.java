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

import static android.R.attr.id;

/**
 * Created by User on 2/3/2018.
 */

public class DatabaseRestaurantList extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="ProjectDatabaseRestaurantList";
    private static final String TABLE_NAME="RESTAURANTLIST";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_IMAGE="image";

    public DatabaseRestaurantList(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Log.v("db created", "yes");
        String CREATE_CONTACT_TABLE="CREATE TABLE "+ TABLE_NAME +"("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_NAME +" TEXT,"
                + KEY_IMAGE +" BLOB" +")";

        /*String sql= "CREATE TABLE CONTACT (ID INTEGER PRIMARY KEY" +
                ", NAME TEXT" +
                ", PASSWORD TEXT)";*/
        db.execSQL(CREATE_CONTACT_TABLE);
        //Log.v("db created", "yes");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addContact(RestaurantListType rlt)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        /*String query = "INSERT INTO USERLIST(NAME,PASSWORD)" +
                "VALUES('"+contact.getName()+"','"+contact.getPassword()+"')";
*/
        //String qry = "INSERT INTO CONTACT(NAME,PHONENO)VALUES('XYZ','016')";
        //db.execSQL(query);
        //RestaurantListType RLT;
        ContentValues value=new ContentValues();
        value.put(KEY_NAME, rlt.getName());
        value.put(KEY_IMAGE,rlt.getImage());

        db.insert(TABLE_NAME, null,value);
        Log.d("Check","Done");

        db.close();

    }

   /* public boolean search(RestaurantListType rlt){

        String selectquery="SELECT * FROM "+ TABLE_NAME;// where phoneno LIKE '017%'";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);
        Contact contact1 = null;
        if(cursor.moveToFirst())
        {

            do
            {

                contact1 = new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));

                if(contact1.getName().equals(rlt.getName()) && contact1.getPassword().equals(rlt.getPassword())){
                    db.close();
                    return true;
                }
                // Contact contact= new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));

            }while(cursor.moveToNext());
        }
        db.close();
        return false;
    }*/

    public RestaurantListType getSingleContact(String Resname)
    {
        SQLiteDatabase db = this.getReadableDatabase();
        //Toast.makeText(DatabaseRestaurantList.this, Resname.toString(), Toast.LENGTH_SHORT).show();
        String query = "SELECT id,name,image FROM RESTAURANTLIST WHERE name ='"+Resname+"'";
        //String query = "SELECT ID,NAME,PHONENO FROM CONTACT WHERE ID = "+id+" OR NAME ='A'";

        Cursor cursor=db.rawQuery(query, null);
        Log.d("checkin",Resname);
        //Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_ID,KEY_NAME,KEY_CONTACTNO}, "Id=?",new String[]{String.valueOf(id)} ,null, null,null, null);
        RestaurantListType myContact = null;

        if(cursor.moveToFirst())
        {
            myContact=new RestaurantListType(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getBlob(2));
            //Toast.makeText(DatabaseRestaurantList.this, cursor.getString(1), Toast.LENGTH_SHORT).show();

        }

        return myContact;
    }

    public List<RestaurantListType> getAllContact()
    {
        List<RestaurantListType> mycontactList=new ArrayList<RestaurantListType>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;// +" ORDER BY DESC";// where phoneno LIKE '017%'";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                RestaurantListType RlT= new RestaurantListType(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getBlob(2));
                mycontactList.add(RlT);

            }while(cursor.moveToNext());
        }
        db.close();
        return mycontactList;
    }




}
