package com.example.phase2.model.exception;

public class WrongDiscount extends Exception{
    public WrongDiscount(){
        super("wrong code or expired");
    }
}
