package model.commodity;

public abstract class Stationery extends Commodity{
   private String manufacturingCountry;
  public Stationery(String name,int cost,String manufacturingCountry,int amountOfInventory){
      super(name,cost,CommodityCategory.STATIONERY,amountOfInventory);
      this.manufacturingCountry =manufacturingCountry;
  }

    public String getManufacturingCountry() {
        return manufacturingCountry;
    }

    public void setManufacturingCountry(String manufacturingCountry) {
        this.manufacturingCountry = manufacturingCountry;
    }
}
