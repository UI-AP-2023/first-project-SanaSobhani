package model.commodity;

public class Pen extends Stationery{
   private String color;
   public Pen(String name,int cost,String manufacturingCountry,String color,int amountOfInventory){
       super(name,cost,manufacturingCountry,amountOfInventory);
       this.color = color;
   }


    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
