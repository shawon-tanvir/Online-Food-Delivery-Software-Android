package com.second.foodrocket;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;


public class CartListAdapter extends ArrayAdapter<CartType>{
    Context context;
    int layoutResourceId;
    // BcardImage data[] = null;
    ArrayList<CartType> data=new ArrayList<CartType>();
    public CartListAdapter(Context context, int layoutResourceId, ArrayList<CartType> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ImageHolder holder = null;
        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);
            holder = new ImageHolder();
            holder.foodtitle = (TextView)row.findViewById(R.id.cartfoodname);
            holder.pricetitle = (TextView)row.findViewById(R.id.cartfoodprice);
            row.setTag(holder);
        }
        else
        {
            holder = (ImageHolder)row.getTag();
        }

        CartType picture = data.get(position);
        holder.foodtitle.setText(picture.Foodname);
        //convert byte to bitmap take from contact class


        Log.d("Price: ", (Integer.toString( picture.price)));


        holder.pricetitle.setText("Tk "+Integer.toString( picture.price));
        Log.d("Food name: ",picture.Foodname);
        return row;

    }
    static class ImageHolder
    {
        TextView foodtitle;
        TextView pricetitle;

    }
}
