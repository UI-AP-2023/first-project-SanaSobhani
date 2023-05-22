package model.commodity;

public abstract class StorageDevice extends DigitalCommodity{
    private int capacity;
   public StorageDevice(String name,int cost,int weight,String dimension,int capacity,int amountOfInventory){
       super(name,cost,weight,dimension,amountOfInventory);
       this.capacity = capacity;
   }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
}
