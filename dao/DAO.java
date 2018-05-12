package dao;

import exception.AddCustomerException;
import exception.GetCustomerException;
import model.City;
import model.Customer;
import model.Order;
import model.Product;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface DAO {

    ArrayList<Customer> getAllCustomers() throws GetCustomerException;
    ArrayList<Product> getSearchOne(Integer id, GregorianCalendar firstDate, GregorianCalendar lastDate) throws GetCustomerException;
    void addCustomer(Customer customer) throws AddCustomerException;
    ArrayList<Customer> getSearchTwo(GregorianCalendar gregorianCalendar) throws GetCustomerException;
    boolean deleteCustomer(Integer id);
    ArrayList<Customer> getSearchThree(String idProduct, GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetCustomerException, NamingException;
    ArrayList<Product> getAllProducts() throws GetCustomerException, NamingException;
    ArrayList<City> getAllCities(Integer postCode) throws GetCustomerException;
}
