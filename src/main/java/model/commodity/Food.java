package model.commodity;

public class Food extends Commodity{
    private String manufactureDate;
    private String expirationDate;
    public Food(String name,int cost,String manufactureDate,String expirationDate,int amountOfInventory){
        super(name,cost,CommodityCategory.FOOD,amountOfInventory);
        this.expirationDate = expirationDate;
        this.manufactureDate = manufactureDate;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
    @Override
    public String toString()
    {
        return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" ManufactureDate: "+ manufactureDate+" ExpirationDate: "+expirationDate+" Inventory: "+getAmountOfInventory();
    }
}
