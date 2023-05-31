package com.example.phase2.model.exception;

public class UnsuccessfulBuying extends Exception{
    public UnsuccessfulBuying(){
        super("buying was not successful");
    }
    public UnsuccessfulBuying(String message){
        super("buying was not successful_"+message);
    }
}
