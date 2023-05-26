package model.commodity;

import model.discount.Idiscount;

public class Pencil extends Stationery implements Idiscount{
    private PencilType type;
    private int discountPercent;
    private int costBeforeDiscount;
    public Pencil(String name,int cost,String manufacturingCountry,PencilType type,int amountOfInventory){
     super(name,cost,manufacturingCountry,amountOfInventory);
     this.type =type;
     this.costBeforeDiscount = cost;
 }
    @Override
    public void addingDiscount(int discountPercent){
        this.discountPercent = discountPercent;
        this.setCost(this.getCost()-(this.getCost()*discountPercent/100));
    }
    @Override
    public void removingDiscount(){
         this.setCost((this.costBeforeDiscount));
        this.discountPercent=0;
    }
 public PencilType getType() {
        return type;
    }

    public void setType(PencilType type) {
        this.type = type;
    }
    @Override
    public String toString()
    {
        return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" ManufacturingCountry: "+getManufacturingCountry()+" Type: "+type.name()+" Inventory: "+getAmountOfInventory();
    }
    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

    public int getCostBeforeDiscount() {
        return costBeforeDiscount;
    }

    public void setCostBeforeDiscount(int costBeforeDiscount) {
        this.costBeforeDiscount = costBeforeDiscount;
    }
}
