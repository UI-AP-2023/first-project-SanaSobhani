package com.example.phase2.view;

import com.example.phase2.controller.CustomerController;
import com.example.phase2.model.commodity.Bill;
import com.example.phase2.model.commodity.Commodity;
import com.example.phase2.model.discount.Discount;
import com.example.phase2.model.exception.*;

import java.util.Scanner;

public class CustomerView {
    private Scanner sc ;
    private CustomerController customerController;
    private CommodityView commodityView = new CommodityView();
    public CustomerView(){
        sc = new Scanner(System.in);
        customerController = new CustomerController();
    }
   public void signUpPage(){
       System.out.println("**SignUp Page**");
       System.out.println("Please Enter Your userName, passWord, phoneNumber, eMail");
       boolean signUp = false;
        while (signUp==false)
       {
           System.out.println("your password must have at least 8 character includes at least a number");  //nexline??
           try{
           if(customerController.signUp(sc.nextLine(),sc.nextLine(), sc.nextLine(), sc.nextLine())==false)
               System.out.println("sign up was not successful");
           else
           {
               signUp=true;
               System.out.println("a request is sent to admin");
           }
           }
           catch (InvalidInput invalidInput){}
       }
   }
   public void longInPageAsCustomer() throws WrongDiscount, UnsuccessfulBuying, InvalidPassword, InvalidEmail, InvalidPhoneNumber {
       System.out.println("**login Page**");
       System.out.println("Please Enter Your username, password ");
       sc.nextLine();
       for (int i =0;;i++){
           if(customerController.login(sc.nextLine(),sc.nextLine())==true) {
               userMenu();
              break;}
           else
           {System.out.println("you are not signed up!1. try again 0.go to main page");
            int choice = sc.nextInt();
            if(choice==0)
                break;
            if(choice==1)
                sc.nextLine();
           }

       }
   }
   public void userMenu() throws WrongDiscount, UnsuccessfulBuying, InvalidPassword, InvalidEmail, InvalidPhoneNumber {
       System.out.println("**user menu**");
       int option = 8;
       while (option!=8){
           System.out.println("1. Visit Account\n2. Show Commodity\n3. Visit Shopping Basket \n4. Increasing Credit\n5. Buy\n6. Shopping History\n7. visit discounts\n8. Exit");
           option = sc.nextInt();
           switch (option){
               case 1:
                   visitAccount();
                   break;
               case 2:
                  commodityView.commodityMainView();
                  break;
               case 3:
                   showShoppingBasket();
                   break;
               case 4:
                   bankPanel();
                   break;
               case 5:
                   buyingPanel();
                   break;
               case 6:
                   showCustomerHistory();
                   break;
               case 7:

           }
           System.out.println("**user menu**");
       }
   }
   public void visitAccount() throws InvalidPassword, InvalidEmail, InvalidPhoneNumber {
       System.out.println("**your account**");
       System.out.println(customerController.getCustomerPointer().toString());
       System.out.println("1. Email\n2. Password\n3. PhoneNumber\n4. Exit\n  Enter Feature Number Which You Want to Edit ");
       int option = 5;
       while (option!=4){
           option = sc.nextInt();
           sc.nextLine();
       switch (option){
           case(1):
               System.out.println("Enter new Email");
               String email = sc.nextLine();
               while (customerController.editEmail(email)==false){
                System.out.println("Wrong Email! enter again");
                email=sc.nextLine();
               }
               System.out.println("changes are saved");
                break;
           case(2):
               System.out.println("Enter new password");
               String passWord = sc.nextLine();
               while (customerController.editPassWord(passWord)==false){
               System.out.println("Wrong Password! your password must have at least 8 character includes at least a number enter again");
               passWord=sc.nextLine();
               }
               System.out.println("changes are saved");
               break;
           case(3):
               System.out.println("Enter new phoneNumber");
               String phoneNumber = sc.nextLine();
               while (customerController.editPhoneNumber(phoneNumber)==false){
               System.out.println("Wrong phone number! enter again");
               phoneNumber=sc.nextLine();
               }
               System.out.println("changes are saved");
       }
       }
   }
   public void bankPanel(){
       System.out.println("**bank panel**");
       System.out.println("please enter amount of credit increase and cvv2 and card password and card number");
       int credit = sc.nextInt();
       sc.nextLine();
      if(customerController.increasingCredit(credit,sc.nextLine(),sc.nextLine(),sc.nextLine())==true)
          System.out.println("SUCCESSFUL\nyour request sent to admin");
      else
          System.out.println("increasing credit was not successful!");

   }
    public void showCustomerHistory(){
        System.out.println("**your history**");
        for(Bill bill : customerController.getCustomerPointer().getShoppingHistory()){
            System.out.println(bill.toString());
        }
    }
    public void showShoppingBasket()
    {
        System.out.println("**your shopping basket**");
        for(Commodity commodity :customerController.getCustomerPointer().getShoppingBasket())
            System.out.println(commodity.getName());
    }
    public void buyingPanel() throws WrongDiscount, UnsuccessfulBuying {
        System.out.println("**buying**");
        try{
        if(!customerController.buy())
            System.out.println("your credit is not enough or your shopping basket is empty!");
        else
            System.out.println("buying was successful");}
        catch (UnsuccessfulBuying unsuccessfulBuying){}  //catch wrong discount
    }
    public void showDiscounts(){
        for(Discount discount : customerController.getCustomerPointer().getDiscounts())
            System.out.println(discount.getDiscountCode());
    }

}
