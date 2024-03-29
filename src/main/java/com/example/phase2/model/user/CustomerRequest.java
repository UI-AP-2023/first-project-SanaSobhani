package com.example.phase2.model.user;

import com.example.phase2.model.commodity.Comment;

public class CustomerRequest {
    private boolean isAccepted;
    private RequestType type;
    Customer customer;
   private Comment comment;
  private int increaseCredit;
    public CustomerRequest(RequestType type, Customer customer){
        this.type = type;
        this.customer = customer;
    }
    public CustomerRequest(RequestType type, Customer customer, Comment comment){
        this.customer = customer;
        this.type = type;
        this.comment = comment;
    }
    public CustomerRequest(RequestType type, Customer customer, int increaseCredit){
        this.increaseCredit = increaseCredit;
        this.type = type;
        this.customer = customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }

    public RequestType getType() {
        return type;
    }

    public void setType(RequestType type) {
        this.type = type;
    }
    @Override
    public String toString()
    {
        StringBuilder string = new StringBuilder();
        if(comment!=null)
            return comment.toString()+" RequestType: "+type.name();
        if(increaseCredit!=0)
            return "Customer: "+customer+" RequestType: "+type.name()+" Amount Of Increase: "+increaseCredit;
        return "Customer: "+customer+" RequestType: "+type.name();
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public int getIncreaseCredit() {
        return increaseCredit;
    }

    public void setIncreaseCredit(int increaseCredit) {
        this.increaseCredit = increaseCredit;
    }
}
