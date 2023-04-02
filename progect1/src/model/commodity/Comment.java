package model.commodity;

import model.user.Admin;
import model.user.Customer;

public class Comment {
    private String text;
  private   String commodityID;
  private   Customer customer;
  private boolean isBought;
  private CommentStatus status;
  public Comment(String text,String commodityID,Customer customer)
  {
      this.commodityID = commodityID;
      this.text = text;
      this.customer = customer;
      for (int i =0;i< Admin.getAdmin().getCommodities().size();i++){
          if(Admin.getAdmin().getCommodities().get(i).getCommodityID().compareTo(commodityID)==0)
              Admin.getAdmin().getCommodities().get(i).getComments().add(this);}
  }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCommodityID() {
        return commodityID;
    }

    public void setCommodityID(String commodityID) {
        this.commodityID = commodityID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public boolean isBought() {
        return isBought;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public CommentStatus getStatus() {
        return status;
    }

    public void setStatus(CommentStatus status) {
        this.status = status;
    }
    @Override
    public String toString()
    {
        return "Writer: "+customer.getUserName()+" txt: "+text;
    }
}
