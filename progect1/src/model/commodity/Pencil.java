package model.commodity;

public class Pencil extends Stationery{
   private PencilType type;
 public Pencil(String name,int cost,String manufacturingCountry,PencilType type,int amountOfInventory){
     super(name,cost,manufacturingCountry,amountOfInventory);
     this.type =type;
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
}
