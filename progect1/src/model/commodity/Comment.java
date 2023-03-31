package model.commodity;

import model.user.Customer;

public class Comment {
    private String text;
  private   String commodityID;
  private   Customer customer;
  private boolean isBought;
  private CommentStatus status;
  public Comment(String text,String commodityID)
  {
      this.commodityID = commodityID;
      this.text = text;
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
}
enum CommentStatus{
    INDETERMINATE,CONFIRMED,NOTCONFIRMED;
}