package model.exception;

public class WrongDiscount extends Exception{
    public WrongDiscount(){
        super("wrong code or expired");
    }
}
