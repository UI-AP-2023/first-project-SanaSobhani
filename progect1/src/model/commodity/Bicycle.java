package model.commodity;

public class Bicycle extends Vehicle{
    private BikeType bikeType;
    public Bicycle(String name,int cost,String company,BikeType type,int amountOfInventory){
        super(name,cost,company,amountOfInventory);
        this.bikeType = type;
    }

    public BikeType getBikeType() {
        return bikeType;
    }

    public void setBikeType(BikeType type) {
        this.bikeType = type;
    }
    @Override
   public String toString()
    {
        return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" Company: "+getCompany()+" BikeType: "+bikeType+" Inventory: "+getAmountOfInventory();
    }
}
