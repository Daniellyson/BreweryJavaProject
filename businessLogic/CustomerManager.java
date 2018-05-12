package businessLogic;

import dao.DAO;
import dataAccess.CustomerDataBaseAccess;
import exception.AddCustomerException;
import exception.GetCustomerException;
import model.Customer;
import model.Order;
import model.Product;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CustomerManager {
    private DAO dao;

    public CustomerManager() {
        dao = new CustomerDataBaseAccess();
    }

    public ArrayList<Customer> getAllCustomers() throws GetCustomerException {
        return dao.getAllCustomers();
    }

    public void addCustomer(Customer customer) throws AddCustomerException {
        dao.addCustomer(customer);
    }

    public ArrayList<Product> getSearchOne(Integer id, GregorianCalendar first, GregorianCalendar last) throws GetCustomerException {

        return dao.getSearchOne(id, first, last);
    }

    public ArrayList<Customer> getSearchTwo(GregorianCalendar gregorianCalendar) throws GetCustomerException {
        return dao.getSearchTwo(gregorianCalendar);
    }

    public ArrayList<Customer> getSearchThree(String idProduct, GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetCustomerException, NamingException {
        return dao.getSearchThree(idProduct, firstDate, secondDate);
    }

    public ArrayList<Product> getAllProducts() throws GetCustomerException, NamingException {
        return dao.getAllProducts();
    }

    public boolean deleteCustomer(Integer id) {
        return dao.deleteCustomer(id);
    }
}
