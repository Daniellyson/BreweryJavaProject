package controller;

import businessLogic.CustomerManager;
import exception.AddCustomerException;
import exception.GetCustomerException;
import model.Customer;
import model.Order;
import model.Product;
import java.util.ArrayList;
import java.util.GregorianCalendar;

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

    public ArrayList<Product> getSearchOne(Integer id, GregorianCalendar first, GregorianCalendar last) throws GetCustomerException {
        return customerManager.getSearchOne(id, first, last);
    }

    public ArrayList<Customer> getSearchTwo(GregorianCalendar gregorianCalendar) throws GetCustomerException {
        return customerManager.getSearchTwo(gregorianCalendar);
    }

    public boolean deleteCustomer(Integer id) {
        return customerManager.deleteCustomer(id);
    }
}
