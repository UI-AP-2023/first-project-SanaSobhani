package com.example.phase2.model.exception;

public class InvalidInput extends Exception{
    public InvalidInput(){
        super("invalid input");
    }
    public InvalidInput(String message){
        super("invalid input_"+message);
    }
}
