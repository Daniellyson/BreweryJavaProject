package controller;

import businessLogic.CustomerManager;
import exception.AddCustomerException;
import exception.GetCustomerException;
import model.City;
import model.Customer;
import model.Order;
import model.Product;

import javax.naming.NamingException;
import javax.swing.table.AbstractTableModel;
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

    public boolean addCustomer(Customer customer) throws AddCustomerException {
       return customerManager.addCustomer(customer);
    }

    public boolean upDateCustomer(Customer customer) throws AddCustomerException {
       return customerManager.upDateCustomer(customer);
    }

    public ArrayList<Product> getSearchOne(Integer id, GregorianCalendar first, GregorianCalendar last) throws GetCustomerException {
        return customerManager.getSearchOne(id, first, last);
    }

    public ArrayList<Customer> getSearchTwo(GregorianCalendar gregorianCalendar) throws GetCustomerException {
        return customerManager.getSearchTwo(gregorianCalendar);
    }

    public ArrayList<Customer> getSearchThree(String idProduct, GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetCustomerException, NamingException {
        return customerManager.getSearchThree(idProduct, firstDate, secondDate);
    }

    public ArrayList<Product> getAllProducts() throws GetCustomerException, NamingException {
        return customerManager.getAllProducts();
    }

    public boolean deleteCustomer(Integer id) {
        return customerManager.deleteCustomer(id);
    }

    public ArrayList<City> getAllCities(Integer postCode) throws GetCustomerException {
        return customerManager.getAllCities(postCode);
    }
}
