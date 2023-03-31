package model.commodity;

import java.util.ArrayList;

public class Bill {
   private String billID;
   private int cost;
   private String date;
   private ArrayList<Commodity>commodities=new ArrayList<>() ;
    private static int billCount;            //for making unique id
    public Bill(ArrayList<Commodity> commodities,String date,int cost){
        this.commodities =commodities;
        this.date = date;
        this.cost = cost;
        billCount++;
        makeID();
    }
    public String getBillID() {
        return billID;
    }

    public void setBillID(String billID) {
        this.billID = billID;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Commodity> getCommodities() {
        return commodities;
    }

    public void setCommodities(ArrayList<Commodity> commodities) {
        this.commodities = commodities;
    }
    public void makeID(){
        StringBuilder iD = new StringBuilder();
        iD.append(commodities.size());
        iD.append("_");
        iD.append(date);
        iD.append("_");
        iD.append("cost:");
        iD.append(cost);
        this.billID = iD.toString();
    }
}
