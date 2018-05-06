package controller;

import businessLogic.CustomerManager;
import exception.AddCustomerException;
import exception.GetCustomerException;
import model.Customer;

import java.util.ArrayList;

public class ApplicationController {
    private CustomerManager customerManager;

    public ApplicationController() {
        customerManager = new CustomerManager();
    }

    public ArrayList<Customer> getAllCustomers() throws GetCustomerException {
        return customerManager.getAllCustomers();
    }

    public void addCustomer(Customer customer) throws AddCustomerException {
        customerManager.addCustomer(customer);
    }
}
