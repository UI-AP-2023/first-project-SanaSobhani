package controller;

import model.user.Customer;
import model.user.CustomerRequest;
import model.user.RequestType;

import java.util.ArrayList;
import java.util.regex.*;

public class CustomerController {
    private ArrayList<Customer> customers;
    private ArrayList<CustomerRequest> customerRequests;
    private Customer customerPointer;

    public CustomerController() {
        customers = new ArrayList<>();
        customerRequests = new ArrayList<>();
    }

    public Customer getCustomerPointer() {
        return customerPointer;
    }

    public void setCustomerPointer(Customer customerPointer) {
        this.customerPointer = customerPointer;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customers = customers;
    }

    public ArrayList<CustomerRequest> getCustomerRequests() {
        return customerRequests;
    }

    public void setCustomerRequests(ArrayList<CustomerRequest> customerRequests) {
        this.customerRequests = customerRequests;
    }

    boolean emailValidation(String email) {
        Pattern valid = Pattern.compile("^[A-Za-z0-9._%+-]+@[a-z]+\\.[a-z]{2,6}$");
        return valid.matcher(email).find();
    }

    boolean phoneValidation(String phoneNumber) {
        Pattern valid = Pattern.compile("^09\\d{9}");
        return valid.matcher(phoneNumber).find();
    }

    boolean passWordValidation(String passWord) {
        Pattern valid1 = Pattern.compile("(\\S){8,}");
        Pattern valid2 = Pattern.compile(".[0-9]+.");
        if (valid2.matcher(passWord).find() == true && valid1.matcher(passWord).find() == true)
            return true;
        return false;
    }

    public boolean signUp(String userName, String passWord, String phoneNumber, String eMail) {
        for (int i = 0; i < customers.size(); i++) {
            if (userName.compareTo(customers.get(i).getUserName()) == 0)
                return false;
            if (passWord.compareTo(customers.get(i).getPassWord()) == 0)
                return false;
            if (phoneNumber.compareTo(customers.get(i).getPhoneNumber()) == 0)
                return false;
            if (eMail.compareTo(customers.get(i).getEmail()) == 0)
                return false;
        }
        if (emailValidation(eMail) == false)
            return false;
        if (passWordValidation(passWord) == false)
            return false;
        if (phoneValidation(phoneNumber) == false)
            return false;
        Customer customer = new Customer(eMail, phoneNumber, passWord, userName);
        CustomerRequest customerRequest = new CustomerRequest(RequestType.SIGNUP, customer);
        customerRequests.add(customerRequest);
        return true;
    }

    public boolean login(String userName, String passWord) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getPassWord().compareTo(passWord) == 0) {
                if (customers.get(i).getUserName().compareTo(userName) == 0) {
                    customerPointer = customers.get(i);
                    return true;
                }
            }
        }
        return false;
    }
    public  boolean editPassWord(String newPassWord)
    {
        for(int i = 0;i<customers.size();i++){
            if (customers.get(i).getPassWord().compareTo(newPassWord)==0){
                return false;
            }
        }
        if(passWordValidation(newPassWord)==true)
        {
            customerPointer.setPassWord(newPassWord);
            return true;
        }
        return false;
    }
    public boolean editPhoneNumber(String newPhoneNumber)
    {
        for (int i = 0;i<customers.size();i++)
        {
            if(customers.get(i).getPhoneNumber().compareTo(newPhoneNumber)==0)
                return false;
        }
        if(phoneValidation(newPhoneNumber)==true) {
            customerPointer.setPhoneNumber(newPhoneNumber);
            return true;
        }
        else
            return false;
    }
    public  boolean editEmail(String newEmail)
    {
        for (int i = 0;i<customers.size();i++)
        {
            if(customers.get(i).getEmail().compareTo(newEmail)==0)
                return false;
        }
        if(emailValidation(newEmail)==true)
        {
            customerPointer.setEmail(newEmail);
            return true;
        }
        else
            return false;
    }
}

