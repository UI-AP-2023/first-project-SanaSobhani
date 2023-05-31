package com.example.phase2.model.commodity;

import com.example.phase2.model.user.Customer;

public class CommodityScore {
   private Customer customer;
   private int point;
   //private Commodity commodity;

   public CommodityScore(Customer customer, int point)
   {
       this.customer = customer;
       this.point = point;
   }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }
    @Override
    public String toString()
    {
        return "Customer: "+customer+" Point: "+point;
    }

}
