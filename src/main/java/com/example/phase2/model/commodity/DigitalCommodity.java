package com.example.phase2.model.commodity;

import com.example.phase2.model.discount.Idiscount;

public abstract class DigitalCommodity extends Commodity implements Idiscount {
   private int weight;
   private String dimension;
   private double discountPercent;
   private int costBeforeDiscount;
   public DigitalCommodity(String name,int cost,int weight,String dimension,int amountOfInventory){
       super(name,cost, CommodityCategory.DIGITAL,amountOfInventory);
       this.dimension = dimension;
       this.weight = weight;
       this.costBeforeDiscount = cost;
   }
    @Override
    public void addingDiscount(int discountPercent){
       this.discountPercent = discountPercent;
       this.setCost(this.getCost()+(this.getCost()*discountPercent/100));
    }
    @Override
    public void removingDiscount(){
        this.setCost((costBeforeDiscount));
        this.discountPercent = 0;

    }
    @Override
    public String toString(){
       return super.toString()+" weight "+weight+" dimension "+dimension;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getCostBeforeDiscount() {
        return costBeforeDiscount;
    }

    public void setCostBeforeDiscount(int costBeforeDiscount) {
        this.costBeforeDiscount = costBeforeDiscount;
    }
}
