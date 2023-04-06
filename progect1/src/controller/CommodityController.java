package controller;

import model.commodity.*;
import model.user.Admin;

import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.Callable;

public class CommodityController {
    public static int AverageCalculation(Commodity commodity){
        int sum =0, average;
        for(CommodityScore score : commodity.getCommodityScores())
            sum +=score.getPoint();
        average = sum/commodity.getCommodityScores().size();
        commodity.setAverageScore(average);
        return average;
    }
    public static ArrayList<Commodity> filterCategory(String category){
        ArrayList<Commodity>commodities = new ArrayList<>();
        for(Commodity commodity : Admin.getAdmin().getCommodities()){
            if(commodity.getCategory().name().compareTo(category)==0)
                commodities.add(commodity);
        }
        return commodities;
    }
    public static ArrayList<Commodity> filterCost(int costLimit) {
        ArrayList<Commodity> commodities = new ArrayList<>();
        for (Commodity find : Admin.getAdmin().getCommodities()) {
            if (find.getCost() <= costLimit)
                commodities.add(find);
        }
        return commodities;
    }
    public static ArrayList<Commodity> filterInventory() {
        ArrayList<Commodity> commodities = new ArrayList<>();
        for (Commodity find : Admin.getAdmin().getCommodities()) {
            if (find.getAmountOfInventory() != 0)
                commodities.add(find);
        }
        return commodities;
    }
    public static ArrayList<Commodity> filterScore(){
        ArrayList<Commodity>commodities=new ArrayList<>();
        for(Commodity commodity : Admin.getAdmin().getCommodities())
        {
            if(commodity.getAverageScore()>=8)
                commodities.add(commodity);
        }
        return commodities;
    }
    public static ArrayList<Commodity>filterStationaryCountry(String country){
        ArrayList<Commodity> commodities = new ArrayList<>();
        for (Commodity commodity : Admin.getAdmin().getCommodities())
        {
            if(commodity.getCategory().equals(CommodityCategory.STATIONERY)==true)
            {
                Stationery stationery = (Stationery) commodity;
                if(stationery.getManufacturingCountry().compareTo(country)==0)
                    commodities.add(commodity);
            }
        }
        return commodities;
    }
    public static ArrayList<Commodity>filterVehicleCompany(String company){
        ArrayList<Commodity> commodities = new ArrayList<>();
        for (Commodity commodity : Admin.getAdmin().getCommodities())
        {
            if(commodity.getCategory().equals(CommodityCategory.VEHICLE)==true)
            {
                Vehicle vehicle=(Vehicle) commodity;
                if(vehicle.getCompany().compareTo(company)==0)
                    commodities.add(commodity);
            }
        }
        return commodities;
    }

    public static ArrayList<Commodity>filterFreshFood()
    {
        ArrayList<Commodity>commodities =new ArrayList<>();
        for (Commodity commodity : commodities)
        {
            if(commodity.getCategory().equals(CommodityCategory.FOOD)==true)
            {
                Date date = new Date();
                Food food = (Food) commodity;
                if(food.getManufactureDate().compareTo(date.toString())==0)
                    commodities.add(commodity);
            }
        }
        return commodities;
    }
    public static ArrayList<Pen> filterPen(){
         ArrayList<Commodity>commodities =filterCategory("STATIONERY");
         ArrayList<Stationery>stationeries = new ArrayList<>();
         ArrayList<Pen>pens = new ArrayList<>();
        for(Commodity commodity : commodities)
            stationeries.add((Stationery)commodity);
        for (Stationery stationery : stationeries)
        {
            if(stationery instanceof Pen==true )
                pens.add((Pen)stationery);
        }
        return pens;
    }
    public static ArrayList<Pencil> filterPencil(){
        ArrayList<Commodity>commodities =filterCategory("STATIONERY");
        ArrayList<Stationery>stationeries = new ArrayList<>();
        ArrayList<Pencil>pencils = new ArrayList<>();
        for(Commodity commodity : commodities)
            stationeries.add((Stationery)commodity);
        for (Stationery stationery : stationeries)
        {
            if(stationery instanceof Pencil==true )
                pencils.add((Pencil)stationery);
        }
        return pencils;
    }
    public static ArrayList<NoteBook> filterNoteBook(){
        ArrayList<Commodity>commodities =filterCategory("STATIONERY");
        ArrayList<Stationery>stationeries = new ArrayList<>();
        ArrayList<NoteBook>noteBooks = new ArrayList<>();
        for(Commodity commodity : commodities)
            stationeries.add((Stationery)commodity);
        for (Stationery stationery : stationeries)
        {
            if(stationery instanceof NoteBook==true )
                noteBooks.add((NoteBook)stationery);
        }
        return noteBooks;
    }
    public static ArrayList<Car> filterCar(){
        ArrayList<Commodity>commodities =filterCategory("VEHICLE");
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Car> cars = new ArrayList<>();
        for(Commodity commodity : commodities)
            vehicles.add((Vehicle) commodity);
        for (Vehicle vehicle : vehicles)
        {
            if(vehicle instanceof Car==true )
                cars.add((Car)vehicle );
        }
        return cars;
    }
    public static ArrayList<Bicycle> filterBike(){
        ArrayList<Commodity>commodities =filterCategory("VEHICLE");
        ArrayList<Vehicle> vehicles = new ArrayList<>();
        ArrayList<Bicycle> bicycles = new ArrayList<>();
        for(Commodity commodity : commodities)
            vehicles.add((Vehicle) commodity);
        for (Vehicle vehicle : vehicles)
        {
            if(vehicle instanceof Bicycle==true )
                bicycles.add((Bicycle) vehicle );
        }
        return bicycles;
    }
    public static ArrayList<PC> filterPC(){
        ArrayList<Commodity>commodities =filterCategory("DIGITAL");
        ArrayList<DigitalCommodity> digitalCommodities = new ArrayList<>();
        ArrayList<PC> pcs = new ArrayList<>();
        for(Commodity commodity : commodities)
            digitalCommodities.add((DigitalCommodity) commodity);
        for (DigitalCommodity digitalCommodity : digitalCommodities)
        {
            if(digitalCommodity instanceof PC==true )
                pcs.add((PC) digitalCommodity);
        }
        return pcs;
    }
    public static ArrayList<StorageDevice> filterStorageDevice(){
        ArrayList<Commodity>commodities =filterCategory("DIGITAL");
        ArrayList<DigitalCommodity> digitalCommodities = new ArrayList<>();
        ArrayList<StorageDevice>storageDevices = new ArrayList<>();
        for(Commodity commodity : commodities)
            digitalCommodities.add((DigitalCommodity) commodity);
        for (DigitalCommodity digitalCommodity : digitalCommodities)
        {
            if(digitalCommodity instanceof StorageDevice==true )
                storageDevices.add((StorageDevice) digitalCommodity);
        }
        return storageDevices;
    }
    public static ArrayList<SSD> filterSSD(){
        ArrayList<StorageDevice> storageDevices=filterStorageDevice();
        ArrayList<SSD> ssds = new ArrayList<>();
        for(StorageDevice storageDevice :storageDevices)
            if(storageDevice instanceof SSD == true)
            ssds.add((SSD)storageDevice);
        return ssds;
    }
    public static ArrayList<FlashMemory> filterFlashMemory(){
        ArrayList<StorageDevice> storageDevices=filterStorageDevice();
        ArrayList<FlashMemory>flashMemories = new ArrayList<>();
        for(StorageDevice storageDevice :storageDevices)
            if(storageDevice instanceof FlashMemory == true)
            flashMemories.add((FlashMemory) storageDevice);
        return flashMemories;
    }
    public static ArrayList<PC>filterCPU(String CPU){
        ArrayList<PC>pcs=filterPC();
        ArrayList<PC>pcList=new ArrayList<>();
        for (PC pc : pcs)
            if(pc.getVersionOfCPU().compareTo(CPU)==0)
                pcList.add(pc);
        return pcList;
    }
    public static ArrayList<Bicycle>filterBikeType(String type){
        ArrayList<Bicycle>bicycles=filterBike();
        ArrayList<Bicycle>bikeList=new ArrayList<>();
        for (Bicycle bicycle : bicycles)
            if(bicycle.getBikeType().name().compareTo(type)==0)
                bikeList.add(bicycle);
        return bikeList;
    }

    public static Commodity searchCommodity(String name) {
        for (Commodity commodity : Admin.getAdmin().getCommodities()) {
            if (commodity.getName().compareTo(name)==0)
                return commodity;
        }
        return null;
    }


}
