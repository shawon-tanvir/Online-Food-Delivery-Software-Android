package com.second.foodrocket;

/**
 * Created by User on 2/3/2018.
 */

public class RestaurantListType {

        int _id;
        String Name;
        byte[] Image;

        public RestaurantListType()
        {

        }
        public RestaurantListType(int Id, String name , byte[] image)
        {

            this._id=Id;
            this.Name=name;
            this.Image=image;

        }

        public RestaurantListType(String Name, byte[] image)
        {
            this.Name=Name;
            this.Image=image;

        }

        public byte[] getImage() {
            return Image;
        }

        public int get_id() {
            return _id;
        }

        public String getName() {
            return Name;
        }

        public void set_id(int _id) {
            this._id = _id;
        }

        public void setImage(byte[] image) {
            Image = image;
        }

        public void setName(String name) {
            Name = name;
        }


}
