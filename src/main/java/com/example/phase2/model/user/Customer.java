package com.example.phase2.model.user;

import com.example.phase2.model.commodity.Bill;
import com.example.phase2.model.commodity.Commodity;
import com.example.phase2.model.discount.Discount;

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
        return super.toString()+" credit "+ credit;
    }

    public ArrayList<Discount> getDiscounts() {
        return discounts;
    }

    public void setDiscounts(ArrayList<Discount> discounts) {
        this.discounts = discounts;
    }
}
