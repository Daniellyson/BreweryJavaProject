package controller;

import businessLogic.CustomerManager;
import exception.*;
import model.*;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public class ApplicationController {
    private CustomerManager customerManager;

    public ApplicationController() {
        customerManager = new CustomerManager();
    }

    public ArrayList<Customer> getAllCustomers() throws GetDataException, NullException, InvalidFormatException, NumberException {
        return customerManager.getAllCustomers();
    }

    public void addCustomer(Customer customer) throws AddCustomerException, NullException, InvalidFormatException {
       customerManager.addCustomer(customer);
    }

    public void upDateCustomer(Customer customer) throws AddCustomerException, NullException, InvalidFormatException {
       customerManager.upDateCustomer(customer);
    }

    public ArrayList<Product> getProductsOrdered(Integer idProduct, GregorianCalendar firstDate, GregorianCalendar lastDate) throws GetDataException, NullException {
        return customerManager.getProductsOrdered(idProduct, firstDate, lastDate);
    }

    public ArrayList<Customer> getOrderDestination(GregorianCalendar targetDate) throws GetDataException, NullException, InvalidFormatException, NumberException {
        return customerManager.getOrderDestination(targetDate);
    }

    public ArrayList<Customer> getPurchasesCustomer(String idProduct, GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetDataException, NullException, InvalidFormatException, LengthException, NumberException, PercentException {
        return customerManager.getPurchasesCustomer(idProduct, firstDate, secondDate);
    }

    public ArrayList<Product> getAllProducts() throws GetDataException {
        return customerManager.getAllProducts();
    }

    public void deleteCustomer(Integer idCustomer) throws DeleteCustomerException {
        customerManager.deleteCustomer(idCustomer);
    }

    public ArrayList<City> getCities(Integer postCode) throws GetDataException, NullException {
        return customerManager.getCities(postCode);
    }

    public ArrayList<PercentProduct> getPurchasePercentage(GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetDataException, PercentException, NullException {
        return customerManager.getPurchasePercentage(firstDate, secondDate);
    }
}
