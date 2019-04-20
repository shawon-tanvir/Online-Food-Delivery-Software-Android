package com.second.foodrocket;

public class Contact {
    int _id;
    String username;
    String password;

    public Contact()
    {

    }
    public Contact(int Id, String Name , String ContactNumber)
    {
        this._id=Id;
        this.username=Name;
        this.password=ContactNumber;

    }

    public Contact(String Name, String ContactNumber)
    {
        this.username=Name;
        this.password=ContactNumber;

    }

    public int getId()
    {
        return this._id;
    }
    public void setId(int Id)
    {
        this._id=Id;
    }

    public String getName()
    {
        return this.username;
    }
    public void setName(String Name)
    {
        this.username=Name;
    }

    public String getPassword()
    {
        return this.password;
    }
    public void setPassword(String ContactNumber)
    {
        this.password=ContactNumber;
    }



}
