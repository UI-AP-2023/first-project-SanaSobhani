package view;

import controller.CommodityController;
import controller.CustomerController;
import model.commodity.Commodity;
import model.user.Admin;

import java.util.Scanner;

public class CommodityView {
   private CustomerController customerController= new CustomerController();
   private CommodityController commodityController =new CommodityController();
    Scanner sc = new Scanner(System.in);
    public void showAllCommodities()
    {
        int pages;
        if(Admin.getAdmin().getCommodities().size()%3==0)
            pages = Admin.getAdmin().getCommodities().size()/3;
        else
            pages = (Admin.getAdmin().getCommodities().size()/3)+1;
        int pageNumber = 1;
        while (pageNumber!=0)
        {
            System.out.println("\n"+"page count: "+pages+" enter a page number (enter zero if you dont want to watch a page)");
            for (int i = (pageNumber * 3) - 3; i < (pageNumber * 3); i++)
            {
                if(i<Admin.getAdmin().getCommodities().size())
                System.out.println(Admin.getAdmin().getCommodities().get(i).getName());
            }
            pageNumber=sc.nextInt();
        }

    }
    public void showCommodity(Commodity commodity){
        System.out.println("**"+commodity.getName()+"**");
        System.out.println(commodity.toString());
        System.out.println("1. add it to shopping basket\n2. comment\n3. grade\n4. Exit");
        int option =0;
        while (option!=4)
        {
            System.out.println("choose your option");
            option = sc.nextInt();
            switch (option)
            {
                case(1):
                    System.out.println("Enter count");
                    int count = sc.nextInt();
                    if(customerController.makingShoppingBasket(commodity.getName(),count)==false)
                        System.out.println("this commodity is not available");
                    else
                        System.out.println("SUCCESSFUL");
                    break;
                case(2):
                    System.out.println("Enter you comment");
                    sc.nextLine();
                    CustomerController.sendingComment(sc.nextLine(),commodity);
                    System.out.println("a request sent to admin");
                    break;
                case(3):
                    System.out.println("Enter grade");
                    if(customerController.grading(sc.nextInt(),commodity.getName())==false)
                        System.out.println("you did not buy it!");
                    else
                        System.out.println("SUCCESSFUL");
            }
        }
    }
    public  void commodityMainView()
    {
        System.out.println("**Commodity menu**");
        showAllCommodities();
        filter();
        /*System.out.println("Enter name of the commodity if you want search and  go to commodity page(if you dont want enter Exit)");
        boolean search = true;
        while (search==true)
        {
            sc.nextLine();
            String option = sc.nextLine();
            if(option.compareTo("Exit")==0)
                search=false;
            else
            showCommodity(commodityController.searchCommodity(option));
        }*/
    }
    public  void filterView()
    {
        System.out.println("**filter**");
        System.out.println("1. Category(DIGITAL,STATIONERY,VEHICLE,FOOD)\n2. Cost\n3. Inventory\n4. CommoditiesWithHighScore\n5. StationaryCountry\n6. VehicleCompany");
        System.out.println("7. FreshFood\n8. ShowPens\n9. ShowPencils\n10. ShowNoteBook\n11. ShowCars\n12. ShowBicycles\n13. ShowPCs\n14. ShowStorageDevices\n15. ShowSSDs");
        System.out.println("16. ShowFlashMemories\n17. ShowCPUs\n18. BikeType\n19. show all commodities\n20. Search\n 21. goto each commodity page (for members)\n0. toExit");

        int option = 22;
        while (option!=21&&option!=0)
        {
            System.out.println("Choose a number if you want to filter enter 21 to go to search page");
            option=sc.nextInt();
            switch (option)
            {
                case 1:
                    System.out.println("which category (enter name)");
                    sc.nextLine();
                    System.out.println(CommodityController.filterCategory(sc.nextLine()).toString());
                    break;
                case 2:
                    System.out.println("enter a cost limit");
                    System.out.println(CommodityController.filterCost(sc.nextInt()).toString());
                    break;
                case 3:
                    System.out.println(CommodityController.filterInventory().toString());
                    break;
                case 4:
                    System.out.println(CommodityController.filterScore());
                    break;
                case 5:
                    System.out.println("enter name of a country");
                    sc.nextLine();
                    System.out.println(CommodityController.filterStationaryCountry(sc.nextLine()).toString());
                    break;
                case 6:
                    System.out.println("enter name of a company");
                    sc.nextLine();
                    System.out.println(CommodityController.filterVehicleCompany(sc.nextLine()));
                    break;
                case 7:
                    System.out.println(CommodityController.filterFreshFood());
                    break;
                case 8:
                    System.out.println(CommodityController.filterPen());
                    break;
                case 9:
                    System.out.println(CommodityController.filterPencil());
                    break;
                case 10:
                    System.out.println(CommodityController.filterNoteBook());
                    break;
                case 11:
                    System.out.println(CommodityController.filterCar());
                    break;
                case 12:
                    System.out.println(CommodityController.filterBike());
                    break;
                case 13:
                    System.out.println(CommodityController.filterPC());
                    break;
                case 14:
                    System.out.println(CommodityController.filterStorageDevice());
                    break;
                case 15:
                    System.out.println(CommodityController.filterSSD());
                    break;
                case 16:
                    System.out.println(CommodityController.filterFlashMemory());
                    break;
                case 17:
                    System.out.println("enter model of cpu");
                    sc.nextLine();
                    System.out.println(CommodityController.filterCPU(sc.nextLine()));
                    break;
                case 18:
                    System.out.println("enter bike type");
                    sc.nextLine();
                    System.out.println(CommodityController.filterBikeType(sc.nextLine()));
                    break;
                case 19:
                    System.out.println(Admin.getAdmin().getCommodities());

                case 20:
                    System.out.println("enter name of commodity");
                    sc.nextLine();
                    showCommodity(CommodityController.searchCommodity(sc.nextLine()));
            }
        }
    }
    public void filter(){
        boolean search = true;
        filterView();
        sc.nextLine();
        while(search==true){
        System.out.println("enter name of commodity to go to page if you want to exit from search panel enter Exit ");
        sc.nextLine();
        String commodity = sc.nextLine();
        if(commodity.compareTo("Exit")==0)
            break;
        else
        showCommodity(CommodityController.searchCommodity(commodity));
    }
    }
}
