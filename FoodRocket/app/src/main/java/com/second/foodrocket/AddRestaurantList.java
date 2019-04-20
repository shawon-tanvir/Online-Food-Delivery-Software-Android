package com.second.foodrocket;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

import static android.R.attr.bitmap;

public class AddRestaurantList extends AppCompatActivity {

    ImageView Imv;
    Button addimage;
    String Resname;

    EditText ResInput;
    EditText FoodInput;
    EditText PriceInput;
    Button addFoodItem;


    byte[] image;
    byte[] img;
    final DatabaseRestaurantList db=new DatabaseRestaurantList(this);
    final DatabaseFoodList dbFood=new DatabaseFoodList(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurant_list);

        addimage=(Button) findViewById(R.id.adRestaurant);
        Imv=(ImageView) findViewById(R.id.ResTaurantImage);
        ResInput=(EditText) findViewById(R.id.ResInput);
        FoodInput=(EditText) findViewById(R.id.FoodInput);
        PriceInput=(EditText) findViewById(R.id.PriceInput);
        addFoodItem=(Button) findViewById(R.id.adFooditem);

       /* Bitmap bmp = null;
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        byte[] byteArray = stream.toByteArray();*/
        Bitmap bitmap=BitmapFactory.decodeResource(getResources(), R.drawable.f);

        ByteArrayOutputStream bos=new ByteArrayOutputStream();

        bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);

        img=bos.toByteArray();

        //image = getBitmapAsByteArray(Imv.getDrawingCache());
        Resname="Cyclist Cafe";

        addimage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    db.addContact(new RestaurantListType(Resname,img));
                    Toast.makeText (getApplicationContext(),"New Contact Is Added.",Toast.LENGTH_SHORT).show();

            }
        });
        addFoodItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dbFood.addContact(new FoodListType(ResInput.getText().toString(),FoodInput.getText().toString(),Integer.parseInt(PriceInput.getText().toString()) ));
                Toast.makeText (getApplicationContext(),"New Food Is Added.",Toast.LENGTH_SHORT).show();
            }
        }

        );

    }


    public static byte[] getBitmapAsByteArray(Bitmap bitmap) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, outputStream);
        return outputStream.toByteArray();
    }
}
