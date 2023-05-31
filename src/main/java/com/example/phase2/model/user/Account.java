package com.example.phase2.model.user;
public abstract class Account {
    private String email;
    private String userName;
    private String passWord;
    private String phoneNumber;

    public Account(String email,String phoneNumber,String passWord,String userName)
    {
        this.email = email;
        this.userName = userName;
        this.passWord = passWord;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return " userName " + userName + " passWord " + passWord + " email " + email + " phoneNumber " + phoneNumber;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
