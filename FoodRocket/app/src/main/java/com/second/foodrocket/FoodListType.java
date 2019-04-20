package com.second.foodrocket;

public class FoodListType {
    int _id;
    String Resname;
    String Foodname;
    int price;

    public FoodListType()
    {

    }
    public FoodListType(int Id, String Name , String ContactNumber,int price)
    {

        this._id=Id;
        this.Resname=Name;
        this.Foodname=ContactNumber;
        this.price=price;

    }

    public FoodListType(String Name, String ContactNumber,int price)
    {
        this.Resname=Name;
        this.Foodname=ContactNumber;
        this.price=price;

    }

    public int getId()
    {
        return this._id;
    }
    public void setId(int Id)
    {
        this._id=Id;
    }

    public String getResname()
    {
        return this.Resname;
    }
    public void setResname(String Name)
    {
        this.Resname=Name;
    }

    public String getFoodname()
    {
        return this.Foodname;
    }
    public void setFoodname(String ContactNumber)
    {
        this.Foodname=ContactNumber;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
}
