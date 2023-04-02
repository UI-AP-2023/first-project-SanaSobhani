package model.commodity;

public class Bicycle extends Vehicle{
    private BikeType type;
    public Bicycle(String name,int cost,String company,BikeType type,int amountOfInventory){
        super(name,cost,company,amountOfInventory);
        this.type = type;
    }

    public BikeType getType() {
        return type;
    }

    public void setType(BikeType type) {
        this.type = type;
    }
    @Override
   public String toString()
    {
        return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" Company: "+getCompany()+" BikeType: "+type+" Inventory: "+getAmountOfInventory();
    }
}
