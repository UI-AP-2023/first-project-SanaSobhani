package com.example.phase2.model.discount;

import java.time.LocalDate;

public class Discount {
    private double discountPercent;
    private LocalDate date;
    private int capacity;
    private static int count =0;
    private String discountCode;
    public Discount(double discountPercent,int capacity,LocalDate date)
    {
        this.discountPercent = discountPercent;
        this.date = date;
        this.capacity = capacity;
        count++;
        this.discountCode = makingCode();
    }
    public double getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(double discountPercent) {
        this.discountPercent = discountPercent;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    public String getDiscountCode() {
        return discountCode;
    }

    public void setDiscountCode(String discountCode) {
        this.discountCode = discountCode;
    }
    private String makingCode(){
        StringBuilder code = new StringBuilder();
        String alphabets = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        code.append(alphabets.charAt((char)(Math.random()*alphabets.length())));
        code.append(alphabets.charAt((char)(Math.random()*alphabets.length())));
        code.append("_"+this.count+"_"+discountPercent+"%"+"_"+capacity);
        return code.toString();
    }
    @Override
    public String toString(){
        return discountCode;
    }
}
