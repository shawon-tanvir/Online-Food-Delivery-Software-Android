package com.second.foodrocket;

public class CartType {
    int _id;
    int Amount;
    String Foodname;
    int price;

    public CartType()
    {

    }
    public CartType(int Id, String ContactNumber, int amount, int price)
    {

        this._id=Id;
        this.Amount=amount;
        this.Foodname=ContactNumber;
        this.price=price;

    }

    public CartType( String ContactNumber,int amount,int price)
    {
        this.Amount=Amount;
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

    public int getAmount() {
        return Amount;
    }

    public void setAmount(int amount) {
        Amount = amount;
    }
}
