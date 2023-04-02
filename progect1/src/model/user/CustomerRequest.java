package model.user;

public class CustomerRequest {
    private boolean isAccepted;
    private RequestType type;
    Customer customer;
    public CustomerRequest(RequestType type,Customer customer){
        this.type = type;
        this.customer = customer;
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
}
