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
}
enum BikeType{MOUNTAIN,HYBRID,CITY,ROAD;}