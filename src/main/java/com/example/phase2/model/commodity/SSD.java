package com.example.phase2.model.commodity;

public class SSD extends StorageDevice {
    private int writeSpeed;
    private int readSpeed;
    public SSD(String name,int cost,int weight,String dimension,int capacity,int writeSpeed,int readSpeed,int amountOfInventory)
    {
        super(name,cost,weight,dimension,capacity,amountOfInventory);
        this.readSpeed=readSpeed;
        this.writeSpeed = writeSpeed;
    }

    public int getWriteSpeed() {
        return writeSpeed;
    }

    public void setWriteSpeed(int writeSpeed) {
        this.writeSpeed = writeSpeed;
    }

    public int getReadSpeed() {
        return readSpeed;
    }

    public void setReadSpeed(int readSpeed) {
        this.readSpeed = readSpeed;
    }
    @Override
    public String toString()
    {
        return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" Capacity: "+ getCapacity()+" WriteSpeed: "+writeSpeed+" ReadSpeed: "+readSpeed+" Inventory: "+getAmountOfInventory();
    }
}
