package model.discount;

public class WrongDiscount extends Exception{
    public WrongDiscount(){
        super("wrong code or expired");
    }
}
