package view;

import controller.CustomerController;
import model.commodity.Bill;
import model.commodity.Commodity;

import java.util.Scanner;

public class CustomerView {
    private Scanner sc ;
    private CustomerController customerController;
    public CustomerView(){
        sc = new Scanner(System.in);
        customerController = new CustomerController();
    }
   public void signUpPage(){
       System.out.println("**SignUp Page**");
       System.out.println("Please Enter Your userName, passWord, phoneNumber, eMail");
       sc.nextLine();
       for (int i = 0;;i++)
       {
           System.out.println("your password must have at least 8 character includes at least a number");
           if(customerController.signUp(sc.nextLine(),sc.nextLine(), sc.next(), sc.nextLine())==true)
               break;
       }
   }
   public void longInPageAsCustomer()
   {
       System.out.println("**login Page**");
       System.out.println("Please Enter Your username, password ");
       sc.nextLine();
       for (int i =0;;i++){
           if(customerController.login(sc.nextLine(),sc.nextLine())==true)
                break;
       }
   }
   public void userMenu(){
       System.out.println("1. Visit Account\n2. Show Commodity\n3. Visit Shopping Basket \n4. Increasing Credit\n6. Buy\n5. Shopping History\n6. Exit");
   }
   public boolean visitAccount()
   {
       System.out.println("**your account**");
       System.out.println(customerController.getCustomerPointer().toString());
       System.out.println("1. Email\n2. Password\n3. PhoneNumber\n4. Exit\n  Enter Feature Number Which You Want to Edit ");
       int option = sc.nextInt();
       sc.nextLine();
       switch (option){
           case(1):
               System.out.println("Enter new Email");
               String Email = sc.nextLine();
               if(customerController.editEmail(Email)==false)
               {
                    System.out.println("Wrong Email! ");
                    return false;
               }
                break;
           case(2):
               System.out.println("Enter new password");
               String passWord = sc.nextLine();
               if(customerController.editPassWord(passWord)==false)
               {
                    System.out.println("Wrong Password! your password must have at least 8 character includes at least a number");
                    return false;
               }
               break;
           case(3):
               System.out.println("Enter new phoneNumber");
               String phoneNumber = sc.nextLine();
               if(customerController.editPhoneNumber(phoneNumber)==false);
               {
                   System.out.println("Wrong phone number!");
                   return false;
               }
           case(4):
               return true;
       }
      return false;
   }
   public void bankPanel(){
       System.out.println("**bank panel**");
       System.out.println("please enter amount of credit increase and cvv2 and card password and card number");
      if(customerController.increasingCredit(sc.nextInt(),sc.nextLine(),sc.nextLine(),sc.nextLine())==true)
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
    public void buyingPanel(){
        System.out.println("**buying**");
        if(customerController.buy()==false)
            System.out.println("your credit is not enough or your shopping basket is empty!");
        else
            System.out.println("buying was successful");
    }


}
