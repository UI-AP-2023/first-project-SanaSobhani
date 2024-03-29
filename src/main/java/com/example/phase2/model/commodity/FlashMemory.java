package com.example.phase2.model.commodity;

public class FlashMemory extends StorageDevice {
   private String uSBVersion;
   public FlashMemory(String name,int cost,int weight,String dimension,int capacity,String version,int amountOfInventory)
   {
      super(name,cost,weight,dimension,capacity,amountOfInventory);
      this.uSBVersion = version;
   }

   public String getUSBVersion() {
      return uSBVersion;
   }

   public void setUSBVersion(String uSBVersion) {
      this.uSBVersion = uSBVersion;
   }
   public String toString()
   {
      //return "Name: "+getName()+" Cost: "+getCost()+" ID: "+getCommodityID()+" Capacity: "+ getCapacity()+" Version: "+uSBVersion+" Inventory: "+getAmountOfInventory();
      return super.toString()+" usb version "+uSBVersion;
   }
}
