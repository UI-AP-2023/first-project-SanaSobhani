package view;

import controller.CustomerController;
import model.discount.WrongDiscount;

import java.util.Scanner;

public class MainView {
    Scanner sc = new Scanner(System.in);
    CommodityView commodityView = new CommodityView();
    CustomerView customerView = new CustomerView();
    AdminView adminView = new AdminView();
   private void mainMenu()
   {
       System.out.println("**MAIN PAGE**");
       System.out.println("[1] SignUp");
       System.out.println("[2] Log in as customer");
       System.out.println("[3] log in as admin");
       System.out.println("[4] Product Page");
       System.out.println("[5] Exit");
       System.out.println("Choose your option");
   }
   public void mainView() throws WrongDiscount {
       int option = 6;
       while (option != 5) {
           mainMenu();
           option=sc.nextInt();
           switch (option){
               case 1:
                 customerView.signUpPage();
                 break;
               case 2:
                   customerView.longInPageAsCustomer();
                   break;
               case 3:
                 adminView.mainView();
                 break;
               case 4:
                 commodityView.filterView();
           }

       }
   }
}
