package dao;

import exception.AddCustomerException;
import exception.GetCustomerException;
import model.Customer;
import model.Order;
import model.Product;

import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface DAO {

    public ArrayList<Customer> getAllCustomers() throws GetCustomerException;
    public ArrayList<Product> getSearchOne(Integer id, GregorianCalendar firstDate, GregorianCalendar lastDate) throws GetCustomerException;
    public void addCustomer(Customer customer) throws AddCustomerException;
    public  ArrayList<Customer> getSearchTwo(GregorianCalendar gregorianCalendar) throws GetCustomerException;
    public boolean deleteCustomer(Integer id);
}
