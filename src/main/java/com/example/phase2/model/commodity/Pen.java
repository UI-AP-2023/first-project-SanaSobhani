package com.example.phase2.model.commodity;

import com.example.phase2.model.discount.Idiscount;

public class Pen extends Stationery implements Idiscount {
   private String color;
   private double discountPercent;
   private int costBeforeDiscount;
   public Pen(String name,int cost,String manufacturingCountry,String color,int amountOfInventory){
       super(name,cost,manufacturingCountry,amountOfInventory);
       this.color = color;
       costBeforeDiscount = cost;
   }
    @Override
    public void addingDiscount(int discountPercent){
       this.discountPercent = discountPercent;
        this.setCost(this.getCost()-(this.getCost()*discountPercent/100));
    }
    @Override
    public void removingDiscount(){
        this.setCost(costBeforeDiscount);
        this.discountPercent = 0;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
    @Override
    public String toString()
    {
        //return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" Color: "+color+" Inventory: "+getAmountOfInventory();
        return super.toString()+" color "+color+" discount percent "+discountPercent;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }
}
