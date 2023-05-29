package com.example.phase2.model.commodity;

public class PC extends DigitalCommodity {
   private String CPUModel;
    private int capacityOfRAM;
    public PC(String name,int cost,int weight,String dimension,String CPUModel,int capacityOfRAM,int amountOfInventory){
        super(name,cost,weight,dimension,amountOfInventory);
        this.capacityOfRAM = capacityOfRAM;
        this.CPUModel =CPUModel;
    }

    public String getVersionOfCPU() {
        return CPUModel;
    }

    public void setVersionOfCPU(String CPUModel) {
        this.CPUModel = CPUModel;
    }

    public int getCapacityOfRAM() {
        return capacityOfRAM;
    }

    public void setCapacityOfRAM(int capacityOfRAM) {
        this.capacityOfRAM = capacityOfRAM;
    }
    @Override
    public String toString()
    {
        //return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" CapacityOfRAM: "+ capacityOfRAM+" VersionOfCPU: "+CPUModel+" Inventory: "+getAmountOfInventory();
        return super.toString()+" capacity of Ram "+capacityOfRAM+" cpu model "+CPUModel;
    }
}
