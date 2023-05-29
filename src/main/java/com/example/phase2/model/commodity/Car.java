package com.example.phase2.model.commodity;

public class Car extends Vehicle {
   private boolean isAutomatic;
   private int engineVolume;
   public Car(String name,int cost,String company,boolean isAutomatic,int engineVolume,int amountOfInventory){
       super(name,cost,company,amountOfInventory);
       this.engineVolume = engineVolume;
       this.isAutomatic = isAutomatic;
   }
    public boolean isAutomatic() {
        return isAutomatic;
    }

    public void setAutomatic(boolean automatic) {
        isAutomatic = automatic;
    }

    public int getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(int engineVolume) {
        this.engineVolume = engineVolume;
    }
    @Override
    public String toString()
    {
        return super.toString()+" engine volume "+engineVolume+" is Automatic"+isAutomatic;
    }
}
