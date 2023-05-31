package model.user;

import model.commodity.*;
import model.discount.Discount;

import java.util.ArrayList;

public class Customer extends Account {
    private int credit;
    private ArrayList<Commodity> shoppingBasket = new ArrayList<>();
    private ArrayList<Bill> shoppingHistory = new ArrayList<>();
    private ArrayList <Discount> discounts = new ArrayList<>();
   public Customer(String email,String phoneNumber,String passWord,String userName)
    {
        super(email,phoneNumber,passWord,userName);
    }

    public ArrayList<Commodity> getShoppingBasket() {
        return shoppingBasket;
    }

    public void setShoppingBasket(ArrayList<Commodity> shoppingBasket) {
        this.shoppingBasket = shoppingBasket;
    }

    public ArrayList<Bill> getShoppingHistory() {
        return shoppingHistory;
    }

    public void setShoppingHistory(ArrayList<Bill> shoppingHistory) {
        this.shoppingHistory = shoppingHistory;
    }

    public int getCredit() {
        return credit;
    }

    public void setCredit(int credit) {
        this.credit = credit;
    }
    @Override
    public String toString()
    {
        StringBuilder info ;
        info = new StringBuilder("UserName: " + getUserName() + " PassWord: " + getPassWord() + " Credit: " + credit + " phoneNumber: " + getPhoneNumber() + " email: "+getEmail()+"\t"+" Basket: ");
        for (int i = 0;i<shoppingBasket.size();i++)
            info.append(shoppingBasket.get(i).getName()+"/");
        return info.toString();
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }
}
