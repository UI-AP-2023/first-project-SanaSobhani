package com.example.phase2.model.user;

import com.example.phase2.model.commodity.Commodity;

import java.util.ArrayList;

public class Admin extends Account {
    private static Admin admin;
    private ArrayList<Commodity>commodities ;
    private ArrayList<CustomerRequest> requests = new ArrayList<>();
    private Admin(String email,String phoneNumber,String password,String userName)
    {
        super(email,phoneNumber,password,userName);
        commodities =new ArrayList<>();
    }
    public static Admin getAdmin(String email,String phoneNumber,String password,String userName)
    {
        if(admin==null)
            admin=new Admin(email,phoneNumber,password,userName);
        return admin;
    }
    public static Admin getAdmin(){return admin;}

    public ArrayList<CustomerRequest> getRequests() {
        return requests;
    }

    public void setRequests(ArrayList<CustomerRequest> requests) {
        this.requests = requests;
    }

    public ArrayList<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(ArrayList<Commodity> commodities) {
        this.commodities = commodities;
    }

}
