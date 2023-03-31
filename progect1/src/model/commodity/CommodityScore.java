package model.commodity;

import model.user.Customer;

public class CommodityScore {
   private Customer customer;
   private int point;
   private Commodity commodity;

   public CommodityScore(Customer customer,int point,Commodity commodity)
   {
       this.commodity = commodity;
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

    public Commodity getCommodity() {
        return commodity;
    }

    public void setCommodity(Commodity commodity) {
        this.commodity = commodity;
    }

}
