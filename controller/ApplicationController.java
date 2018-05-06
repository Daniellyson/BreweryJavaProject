package controller;

import businessLogic.CustomerManager;
import exception.AddCostumerException;
import exception.GetCostumerException;
import model.Customer;

import java.util.ArrayList;

public class ApplicationController {
    private CustomerManager customerManager;

    public ApplicationController() {
        customerManager = new CustomerManager();
    }

    public ArrayList<String> getAllCustomers() throws GetCostumerException {
        return customerManager.getAllCustomers();
    }

    public void addCustomer(Customer customer) throws AddCostumerException {
        customerManager.addCustomer(customer);
    }
}
