package model.user;

import model.commodity.*;

import java.util.ArrayList;

public class Customer extends Account {
    private int credit;
    private ArrayList<Commodity> shoppingBasket = new ArrayList<>();
    private ArrayList<Bill> shoppingHistory = new ArrayList<>();
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
}