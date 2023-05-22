package model.commodity;

public abstract class Vehicle extends Commodity{
   private String company;
  public Vehicle(String name,int cost,String company,int amountOfInventory){
      super(name,cost,CommodityCategory.VEHICLE,amountOfInventory);
      this.company = company;
  }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
