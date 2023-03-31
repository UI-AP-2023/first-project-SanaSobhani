package model.commodity;

public abstract class DigitalCommodity extends Commodity {
   private int weight;
   private String dimension;
   public DigitalCommodity(String name,int cost,int weight,String dimension,int amountOfInventory){
       super(name,cost,CommodityCategory.DIGITAL,amountOfInventory);
       this.dimension = dimension;
       this.weight = weight;
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
}
