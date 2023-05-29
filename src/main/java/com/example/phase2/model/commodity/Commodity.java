package com.example.phase2.model.commodity;

import java.util.ArrayList;

public abstract class Commodity implements Comparable<Commodity>{
    private String commodityID;
    private String name;
    private int cost;
    private int averageScore;
    private CommodityCategory category;
    private int amountOfInventory;
    private static int count;      //for making ID
    private ArrayList<CommodityScore> commodityScores = new ArrayList<>();
    private ArrayList<Comment> comments = new ArrayList<>();
   public Commodity(String name, int cost, CommodityCategory category, int amountOfInventory)
    {
        this.category = category;
        this.cost = cost;
        this.name = name;
        this.amountOfInventory = amountOfInventory;
        count++;
        makeID();
    }
    @Override
    public int compareTo(Commodity commodity){
        if(name.compareTo(commodity.name)>0)
            return 1;
        if(name.compareTo(commodity.name)<0)
            return -1;
        if(name.compareTo(commodity.name)==0)
        {
            if(averageScore> commodity.getAverageScore())
                return 1;
            if(averageScore<commodity.getAverageScore())
                return -1;
            if(averageScore==commodity.getAverageScore())
            {
                if(cost>commodity.getCost())
                    return 1;
                if(cost<commodity.getCost())
                    return -1;
                if(cost==commodity.getCost())
                {
                    if(amountOfInventory>commodity.amountOfInventory)
                        return 1;
                    if(amountOfInventory<commodity.getAmountOfInventory())
                        return -1;
                }
            }
        }
        return 0;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public CommodityCategory getCategory() {
        return category;
    }

    public void setCategory(CommodityCategory category) {
        this.category = category;
    }
    void makeID()
    {
        StringBuilder iD = new StringBuilder();
        iD.append(category.getCode());
        iD.append("_");
        iD.append(name);
        iD.append("_");
        iD.append(count);
        commodityID = iD.toString();
    }
    @Override
    public String toString(){
       return " name "+name+" id "+commodityID+" cost "+cost+" amount of inventory "+amountOfInventory+" category "+category+" average score "+averageScore;
    }
    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }



    public int getAmountOfInventory() {
        return amountOfInventory;
    }

    public void setAmountOfInventory(int amountOfInventory) {
        this.amountOfInventory = amountOfInventory;
    }
    public int getCount(){return count;}

    public ArrayList<CommodityScore> getCommodityScores() {
        return commodityScores;
    }

    public void setCommodityScores(ArrayList<CommodityScore> commodityScores) {
        this.commodityScores = commodityScores;
    }

    public int getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(int averageScore) {
        this.averageScore = averageScore;
    }
}
