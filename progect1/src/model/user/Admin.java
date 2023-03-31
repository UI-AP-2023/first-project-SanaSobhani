package model.user;

import model.commodity.Commodity;

import java.util.ArrayList;

public class Admin extends Account {
    private static Admin admin;
    private ArrayList<Commodity>commodities = new ArrayList<>();
    private ArrayList<CustomerRequest> requests = new ArrayList<>();
    private Admin(String email,String phoneNumber,String passWord,String userName)
    {
        super(email,phoneNumber,passWord,userName);
    }
    public Admin getAdmin(String email,String phoneNumber,String passWord,String userName){
        if (admin == null)
            admin = new Admin(email,phoneNumber,passWord,userName);
        return admin;
    }
    public Admin getAdmin(){return admin;}

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
