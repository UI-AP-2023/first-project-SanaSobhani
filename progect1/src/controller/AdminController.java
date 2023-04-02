package controller;

import model.commodity.*;
import model.user.*;

public class AdminController {
  public AdminController()
  {
      Admin.getAdmin("sanaacc26@gmail.com","09023133159","admin","admin");
  }
 public static void addFlashMemory(String name,int cost,int weight,String dimension,int capacity,String version,int amountOfInventory)
 {
    FlashMemory flash = new FlashMemory(name,cost,weight,dimension,capacity,version,amountOfInventory);
    Admin.getAdmin().getCommodities().add(flash);
 }
 public static void addSSD(String name,int cost,int weight,String dimension,int capacity,int writeSpeed,int readSpeed,int amountOfInventory)
 {
     SSD ssd = new SSD (name,cost,weight,dimension,capacity,writeSpeed,readSpeed,amountOfInventory);
     Admin.getAdmin().getCommodities().add(ssd);
 }
 public static void addPC(String name,int cost,int weight,String dimension,String versionOfCPU,int capacityOfRAM,int amountOfInventory)
 {
     PC pc = new PC(name,cost,weight,dimension,versionOfCPU,capacityOfRAM,amountOfInventory);
     Admin.getAdmin().getCommodities().add(pc);
 }
 public static void addPencil(String name, int cost, String manufacturingCountry, PencilType type, int amountOfInventory)
 {
     Pencil pencil = new Pencil(name,cost,manufacturingCountry,type,amountOfInventory);
     Admin.getAdmin().getCommodities().add(pencil);
 }
 public static void addPen(String name,int cost,String manufacturingCountry,String color,int amountOfInventory){
     Pen pen = new Pen(name,cost,manufacturingCountry,color,amountOfInventory);
     Admin.getAdmin().getCommodities().add(pen);
 }
 public static void addNoteBook(String name,int cost,String manufacturingCountry,PaperType type,int pageCount,int amountOfInventory){
     NoteBook noteBook = new NoteBook(name,cost,manufacturingCountry,type,pageCount,amountOfInventory);
     Admin.getAdmin().getCommodities().add(noteBook);
 }
 public static void addFood(String name,int cost,String manufactureDate,String expirationDate,int amountOfInventory){
     Food food = new Food(name,cost,manufactureDate,expirationDate,amountOfInventory);
     Admin.getAdmin().getCommodities().add(food);
 }
 public static void addCar(String name,int cost,String company,boolean isAutomatic,int engineVolume,int amountOfInventory){
    Car car = new Car(name,cost,company,isAutomatic,engineVolume,amountOfInventory);
    Admin.getAdmin().getCommodities().add(car);
 }
 public static void addBicycle(String name,int cost,String company,BikeType type,int amountOfInventory){
     Bicycle bicycle = new Bicycle(name,cost,company,type,amountOfInventory);
     Admin.getAdmin().getCommodities().add(bicycle);
 }
 public static void editCommodityName(String iD,String newName){
     for (int i =0;i<Admin.getAdmin().getCommodities().size();i++){
         if(Admin.getAdmin().getCommodities().get(i).getCommodityID().compareTo(iD)==0)
             Admin.getAdmin().getCommodities().get(i).setName(newName);
     }
 }
 public static void editCommodityInventory(String iD,int newInventory){
     for (int i =0;i<Admin.getAdmin().getCommodities().size();i++){
         if(Admin.getAdmin().getCommodities().get(i).getCommodityID().compareTo(iD)==0)
             Admin.getAdmin().getCommodities().get(i).setAmountOfInventory(newInventory);
     }
 }
   public static void editCommodityCost(String iD,int cost) {
         for (int i = 0; i < Admin.getAdmin().getCommodities().size(); i++) {
             if (Admin.getAdmin().getCommodities().get(i).getCommodityID().compareTo(iD) == 0)
                 Admin.getAdmin().getCommodities().get(i).setCost(cost);
         }
     }
        public static void removeCommodity(String iD){
            for (int i = 0;i<Admin.getAdmin().getCommodities().size();i++)
            {
                if(Admin.getAdmin().getCommodities().get(i).getCommodityID().compareTo(iD)==0)
                    Admin.getAdmin().getCommodities().remove(Admin.getAdmin().getCommodities().get(i));
            }
         }

 }







