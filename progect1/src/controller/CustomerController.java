package controller;

import model.commodity.*;
import model.discount.Discount;
import model.discount.WrongDiscount;
import model.user.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.regex.*;

public class CustomerController {
    private static ArrayList<Customer> customers =new ArrayList<>();
    private static Customer customerPointer;
    public CustomerController() {

    }

    public static Customer getCustomerPointer() {
        return customerPointer;
    }

    public  void setCustomerPointer(Customer customerPointer) {
        CustomerController.customerPointer = customerPointer;
    }

    public static ArrayList<Customer> getCustomers() {
        return customers;
    }

    public static void setCustomers(ArrayList<Customer> customers) {
        customers = customers;
    }


    boolean emailValidation(String email) {
        Pattern valid = Pattern.compile("^[A-Za-z0-9._%+-]+@[a-z]+\\.[a-z]{2,6}$");
        return valid.matcher(email).find();
    }

    boolean phoneValidation(String phoneNumber) {
        Pattern valid = Pattern.compile("^09\\d{9}");
        return valid.matcher(phoneNumber).find();
    }

    boolean passWordValidation(String passWord) {
        Pattern valid1 = Pattern.compile("(\\S){8,}");
        Pattern valid2 = Pattern.compile(".[0-9]+.");
        return valid2.matcher(passWord).find() && valid1.matcher(passWord).find();
    }

    public boolean signUp(String userName, String passWord, String phoneNumber, String eMail) {
        for (Customer value : customers) {
            if (userName.compareTo(value.getUserName()) == 0)
                return false;
            if (passWord.compareTo(value.getPassWord()) == 0)
                return false;
            if (phoneNumber.compareTo(value.getPhoneNumber()) == 0)
                return false;
            if (eMail.compareTo(value.getEmail()) == 0)
                return false;
        }
        if (!emailValidation(eMail))
            return false;
        if (!passWordValidation(passWord))
            return false;
        if (!phoneValidation(phoneNumber))
            return false;
        Customer customer = new Customer(eMail, phoneNumber, passWord, userName);
        CustomerRequest customerRequest = new CustomerRequest(RequestType.SIGNUP, customer);
        Admin.getAdmin().getRequests().add(customerRequest);
        return true;
    }

    public boolean login(String userName, String passWord) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPassWord().compareTo(passWord) == 0) {
                if (customers.get(i).getUserName().compareTo(userName) == 0) {
                    customerPointer = customers.get(i);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean editPassWord(String newPassWord) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPassWord().compareTo(newPassWord) == 0) {
                return false;
            }
        }
        if (passWordValidation(newPassWord)) {
            customerPointer.setPassWord(newPassWord);
            return true;
        }
        return false;
    }

    public boolean editPhoneNumber(String newPhoneNumber) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPhoneNumber().compareTo(newPhoneNumber) == 0)
                return false;
        }
        if (phoneValidation(newPhoneNumber)) {
            customerPointer.setPhoneNumber(newPhoneNumber);
            return true;
        } else
            return false;
    }

    public boolean editEmail(String newEmail) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getEmail().compareTo(newEmail) == 0)
                return false;
        }
        if (emailValidation(newEmail)) {
            customerPointer.setEmail(newEmail);
            return true;
        } else
            return false;
    }

    public boolean grading(int score, String name) {
        CommodityScore commodityScore = new CommodityScore(customerPointer, score);
        for (int i = 0; i < customerPointer.getShoppingHistory().size(); i++) {
            for (int j = 0; j < customerPointer.getShoppingHistory().get(i).getCommodities().size(); i++) {
                if (customerPointer.getShoppingHistory().get(i).getCommodities().get(j).getName().compareTo(name) == 0) {
                    customerPointer.getShoppingHistory().get(i).getCommodities().get(j).getCommodityScores().add(commodityScore);
                    CommodityController.AverageCalculation(customerPointer.getShoppingHistory().get(i).getCommodities().get(j));
                    return true;
                }
            }
        }
        Collections.sort(Admin.getAdmin().getCommodities(),Commodity::compareTo);
        return false;
    }

    public static void sendingComment(String txt, Commodity commodity) {
        Comment comment = new Comment(txt, commodity.getCommodityID(), customerPointer);
        for (int i = 0; i < customerPointer.getShoppingHistory().size(); i++) {
            for (int j = 0; j < customerPointer.getShoppingHistory().get(i).getCommodities().size(); j++) {
                if (customerPointer.getShoppingHistory().get(i).getCommodities().get(j).equals(commodity))
                    comment.setBought(true);
            }
        }
        Admin.getAdmin().getRequests().add(new CustomerRequest(RequestType.COMMENT, customerPointer, comment));
    }

    public static boolean cvv2Validation(String cvv2) {
        Pattern pattern = Pattern.compile("[0-9]{3}");
        return pattern.matcher(cvv2).find();
    }

    public static boolean cardNumberValidation(String cardNumber) {
        Pattern pattern = Pattern.compile("[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}\\s[0-9]{4}");
        return pattern.matcher(cardNumber).find();
    }

    public static boolean cardPasswordValidation(String cardPassword) {
        Pattern pattern = Pattern.compile("[0-9]{6}");
        return pattern.matcher(cardPassword).find();
    }

    public boolean increasingCredit(int credit, String cvv2, String cardPassword, String cardNumber) {
        int validation = 0;
        if (cardPasswordValidation(cardPassword))
            validation++;
        if (cardNumberValidation(cardNumber))
            validation++;
        if (cvv2Validation(cvv2))
            validation++;
        if (validation == 3) {
            Admin.getAdmin().getRequests().add(new CustomerRequest(RequestType.INCREASECREDIT, customerPointer, credit));
            return true;
        } else
            return false;
    }
    public boolean makingShoppingBasket(String name, int count) {

        for (Commodity find : Admin.getAdmin().getCommodities()) {
            if (find.getName().compareTo(name) == 0 && find.getAmountOfInventory() >= count) {
                for (int i = 0; i < count; i++) {
                    customerPointer.getShoppingBasket().add(find);
                }
                return true;
            }

        }
        return false;
    }
    public void removeCommodity(String name) {
        for (Commodity find : customerPointer.getShoppingBasket()) {
            if (find.getName().compareTo(name) == 0 && find.getAmountOfInventory()!=0)
                customerPointer.getShoppingBasket().remove(find);
        }
    }

    public boolean buy(String discountCode) throws WrongDiscount {
        int cost =0;
        LocalDate date = LocalDate.now();
        ArrayList<Commodity> bought = new ArrayList<>();
        Discount discount = null;
        if(discountCode!=null){
            for(Discount pointer : customerPointer.getDiscounts())
                {
                     if(pointer.getDiscountCode().equals(discountCode))
                        discount = pointer;
                }
            if(discount==null)
                throw new  WrongDiscount();
            if(discount.getDate().isBefore(date)&&discount.getCapacity()==0)
                throw new WrongDiscount();
        }
        for (Commodity commodity : customerPointer.getShoppingBasket())
        {
            if(commodity.getCount()==0)
                customerPointer.getShoppingBasket().remove(commodity);
        }
        if(customerPointer.getShoppingBasket().size()==0)
            return false;
        for (Commodity commodity : customerPointer.getShoppingBasket())
        {
            cost+=commodity.getCost();
            bought.add(commodity);
        }
        if(discount!=null){
            cost-=(cost*(discount.getDiscountPercent())/100);
        }

        if(customerPointer.getCredit()>=cost)
        {
            for (Commodity find : customerPointer.getShoppingBasket())
            {
                find.setAmountOfInventory(find.getAmountOfInventory()-1);
                Collections.sort(Admin.getAdmin().getCommodities(),Commodity::compareTo);
            }
            customerPointer.setCredit(customerPointer.getCredit()-cost);
            customerPointer.getShoppingHistory().add(new Bill(bought,date.toString(),cost));
            customerPointer.getShoppingBasket().clear();
            discount.setCapacity(discount.getCapacity()-1);
            return true;
        }
        return false;
    }
    public boolean buy() throws WrongDiscount {
        return buy(null);
    }

}


