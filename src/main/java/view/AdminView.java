package view;

import controller.AdminController;
import controller.CustomerController;
import model.commodity.BikeType;
import model.commodity.PaperType;
import model.commodity.PencilType;
import model.user.Admin;
import model.user.Customer;
import model.user.CustomerRequest;

import java.util.Scanner;

import static java.lang.Boolean.parseBoolean;

public class AdminView {
    private AdminController adminController = new AdminController();
    Scanner sc = new Scanner(System.in);
    public void logInAdminView()
    {
        System.out.printf("Enter your username and password\n");
        //sc.nextLine();
        boolean logIn = false;
        while (logIn==false) {
            if (adminController.logInAsAdmin(sc.nextLine(), sc.nextLine()) == false)
                System.out.println("Wrong!");
            else
                logIn = true;
        }
    }
    public void help()
    {
        System.out.println("AddFlashMemory string:name int:cost int:weight string:dimension int:capacity string:version int:amountOfInventory");
        System.out.println("AddSSD String:name int:cost int:weight String:dimension int:capacity int:writeSpeed int:readSpeed int:amountOfInventory");
        System.out.println("AddPC String:name int:cost int:weight String:dimension String:versionOfCPU int:capacityOfRAM int:amountOfInventory");
        System.out.println("AddPencil String:name int:cost String:manufacturingCountry PencilType:type int:amountOfInventory");
        System.out.println("AddPen String:name int:cost String:manufacturingCountry String:color int:amountOfInventory");
        System.out.println("AddNoteBook String:name int:cost String:manufacturingCountry PaperType:type int:pageCount int:amountOfInventory");
        System.out.println("AddFood String:name int:cost String:manufactureDate String:expirationDate int:amountOfInventory");
        System.out.println("AddCar(String:name int:cost String:company boolean:isAutomatic int:engineVolume int:amountOfInventory");
        System.out.println("AddBicycle(String:name int:cost String:company BikeType:type int:amountOfInventory");
        System.out.println("EditCommodityNameString:iD String:newName");
        System.out.println("EditCommodityInventory String:iD int:newInventory");
        System.out.println("EditCommodityCost String:iD int:cost");
        System.out.println("RemoveCommodity String:iD");
        System.out.println("CommentDetermination boolean:isAccepted int:requestNumber");
        System.out.println("SignUpDetermination boolean:isAccepted int:requestNumber");
        System.out.println("SignUpDetermination boolean:isAccepted int:requestNumber");
        System.out.println("IncreaseCreditDetermination boolean:isAccepted int:requestNumber");
        System.out.println("LogInAsAdmin String:userName String:passWord");
        System.out.println("Allocating Discount To Good Customers");
        System.out.println("addDiscount String:code int:percent");
        System.out.println("removeDiscount String:code");
        System.out.println("CustomerList");
        System.out.println("RequestList");
        System.out.println("Exit");
    }
    public void adminCommands(){
        sc.nextLine();
        String command = sc.nextLine();
        while (command.compareTo("Exit")!=0)
        {
            String[] words=command.split("\\s");
            if (words[0].compareTo("AddFlashMemory")==0)
                AdminController.addFlashMemory(words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]),words[4],Integer.parseInt(words[5]),words[6],Integer.parseInt(words[7]));
            if(words[0].compareTo("AddSSD")==0)
                AdminController.addSSD(words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]),words[4],Integer.parseInt(words[5]),Integer.parseInt(words[6]),Integer.parseInt(words[7]),Integer.parseInt(words[8]));
            if(words[0].compareTo("AddPC")==0)
                AdminController.addPC(words[1],Integer.parseInt(words[2]),Integer.parseInt(words[3]),words[4],words[5],Integer.parseInt(words[6]),Integer.parseInt(words[7]));
            if(words[0].compareTo("AddFood")==0)
                AdminController.addFood(words[1],Integer.parseInt(words[2]),words[3],words[4],Integer.parseInt(words[5]));
            if(words[0].compareTo("AddPencil")==0)
                AdminController.addPencil(words[1],Integer.parseInt(words[2]),words[3],PencilType.valueOf(words[4]),Integer.parseInt(words[5]));
            if(words[0].compareTo("AddNoteBook")==0)
                AdminController.addNoteBook(words[1],Integer.parseInt(words[2]),words[3],PaperType.valueOf(words[4]),Integer.parseInt(words[5]),Integer.parseInt(words[6]));
            if(words[0].compareTo("AddPen")==0)
                AdminController.addPen(words[1],Integer.parseInt(words[2]),words[3],words[4],Integer.parseInt(words[5]));
            if(words[0].compareTo("AddCar")==0)
                AdminController.addCar(words[1],Integer.parseInt(words[2]),words[3],parseBoolean(words[4]),Integer.parseInt(words[5]),Integer.parseInt(words[6]));
            if(words[0].compareTo("AddBicycle")==0)
                AdminController.addBicycle(words[1],Integer.parseInt(words[2]),words[3],BikeType.valueOf(words[4]),Integer.parseInt(words[5]));
            if(words[0].compareTo("EditCommodityName")==0)
                AdminController.editCommodityName(words[1],words[2]);
            if(words[0].compareTo("EditCommodityInventory")==0)
                AdminController.editCommodityInventory(words[1],Integer.parseInt(words[2]));
            if(words[0].compareTo("EditCommodityCost")==0)
                AdminController.editCommodityCost(words[1],Integer.parseInt(words[2]));
            if(words[0].compareTo("RemoveCommodity")==0)
                AdminController.removeCommodity(words[1]);
            if(words[0].compareTo("CommentDetermination")==0)
                AdminController.commentDetermination(parseBoolean(words[1]),Integer.parseInt(words[2]));
            if(words[0].compareTo("SignUpDetermination")==0)
                AdminController.signUpDetermination(parseBoolean(words[1]),Integer.parseInt(words[2]));
            if(words[0].compareTo("IncreaseCreditDetermination")==0)
                AdminController.increaseCreditDetermination(parseBoolean(words[1]),Integer.parseInt(words[2]));
            if(words[0].compareTo("RequestList")==0)
                visitAllRequests();
            if(words[0].compareTo("CustomerList")==0)
                visitAllCustomers();
            if(words[0].compareTo("Allocating")==0)
                AdminController.allocatingDiscount();
            command = sc.nextLine();
            if(words[0].compareTo("addDiscount")==0)
                AdminController.addDiscount(words[1],Integer.parseInt(words[2]));
            if(words[0].compareTo("removeDiscount")==0)
                AdminController.removeDiscount(words[1]);
         }

    }
   public void visitAllCustomers()
   {
       for (Customer customer : CustomerController.getCustomers())
           System.out.println(customer.toString());
       System.out.println("customers count "+CustomerController.getCustomers().size());
   }
   public void visitAllRequests()
   {
       int count = 0;
       for (CustomerRequest request : Admin.getAdmin().getRequests())
           System.out.println(count+++" "+request.toString());
   }
    public void mainView(){
        logInAdminView();
        System.out.println("if you want to watch help enter 1 else enter 0 to continue");
        int option = sc.nextInt();
        if(option==1)
            help();
        adminCommands();
    }
}
