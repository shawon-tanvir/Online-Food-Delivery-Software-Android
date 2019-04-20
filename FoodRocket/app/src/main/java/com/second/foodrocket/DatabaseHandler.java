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

public class DatabaseHandler extends SQLiteOpenHelper{

    private static final int DATABASE_VERSION=1;
    private static final String DATABASE_NAME="ProjectDatabase";
    private static final String TABLE_NAME="USERLIST";
    private static final String KEY_ID="id";
    private static final String KEY_NAME="name";
    private static final String KEY_PASSWORD="password";
    private static final String KEY_CHECK="check";

    public DatabaseHandler(Context context) {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        //Log.v("db created", "yes");
        String CREATE_CONTACT_TABLE="CREATE TABLE "+ TABLE_NAME +" ("
                + KEY_ID +" INTEGER PRIMARY KEY,"
                + KEY_NAME +" TEXT,"
                + KEY_PASSWORD +" TEXT" +")";



        Log.v("db created", "yes");
        String sql= "CREATE TABLE USERLIST (ID INTEGER PRIMARY KEY" +
                ", NAME TEXT" +
                ", PASSWORD TEXT" +
                ", CHECK INTEGER)";

        db.execSQL(CREATE_CONTACT_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public void addContact(Contact contact)
    {
        SQLiteDatabase db = this.getWritableDatabase();

        String query = "INSERT INTO USERLIST(NAME,PASSWORD)" +
                "VALUES('"+contact.getName()+"','"+contact.getPassword()+"')";

        //String qry = "INSERT INTO CONTACT(NAME,PHONENO)VALUES('XYZ','016')";
        //db.execSQL(query);

        ContentValues value=new ContentValues();
        value.put(KEY_NAME, contact.getName());
        value.put(KEY_PASSWORD,contact.getPassword());


        db.insert(TABLE_NAME, null,value);

        db.close();

    }
    public void updateContact(Contact contact)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        //String query = "UPDATE USERLIST SET password='"+contact.getPassword() +"' WHERE name = "+contact.getName();
        //db.execSQL(query);

		ContentValues value=new ContentValues();
		value.put(KEY_NAME, contact.getName());
		value.put(KEY_PASSWORD,contact.getPassword());

		db.update(TABLE_NAME, value, KEY_NAME+"=?",new String[] {String.valueOf(contact.getName())});


        db.close();
    }


    public boolean search(Contact contact){

        String selectquery="SELECT * FROM "+ TABLE_NAME;// where phoneno LIKE '017%'";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);
        Contact contact1 = null;
        if(cursor.moveToFirst())
        {

            do
            {

                contact1 = new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1), cursor.getString(2));

                if(contact1.getName().equals(contact.getName()) && contact1.getPassword().equals(contact.getPassword())){
                    db.close();
                    return true;
                }
               // Contact contact= new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));

            }while(cursor.moveToNext());
        }
        db.close();
        return false;
    }



    public List<Contact> getAllContact()
    {
        List<Contact> mycontactList=new ArrayList<Contact>();

        String selectquery="SELECT * FROM "+ TABLE_NAME;// where phoneno LIKE '017%'";

        SQLiteDatabase db=this.getReadableDatabase();

        Cursor cursor=db.rawQuery(selectquery, null);

        if(cursor.moveToFirst())
        {
            do
            {
                Contact contact= new Contact(Integer.parseInt(cursor.getString(0)),cursor.getString(1),cursor.getString(2));
                mycontactList.add(contact);
            }while(cursor.moveToNext());
        }

        return mycontactList;
    }





}
