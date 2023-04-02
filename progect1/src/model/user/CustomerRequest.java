package model.user;

import model.commodity.Comment;

public class CustomerRequest {
    private boolean isAccepted;
    private RequestType type;
    Customer customer;
   private Comment comment;
    public CustomerRequest(RequestType type,Customer customer){
        this.type = type;
        this.customer = customer;
    }
    public CustomerRequest(RequestType type,Customer customer,Comment comment){
        this.customer = customer;
        this.type = type;
        this.comment = comment;
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
        return "Customer: "+customer+" RequestType: "+type.name();
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }
}
