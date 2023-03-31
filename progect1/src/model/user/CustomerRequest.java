package model.user;

public class CustomerRequest {
    private boolean isAccepted;
    private RequestType type;
    public CustomerRequest(RequestType type){
        this.type = type;
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
}
enum RequestType{SIGNUP,COMMENT,INCREASECREDIT}