package dao;

import exception.*;
import model.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public interface DAO {

    ArrayList<Customer> getAllCustomers() throws GetDataException, NullException, InvalidFormatException, NumberException;
    ArrayList<Product> getProductsOrdered(Integer idProduct, GregorianCalendar firstDate, GregorianCalendar lastDate) throws GetDataException;
    void addCustomer(Customer customer) throws AddCustomerException;
    void upDateCustomer(Customer customer) throws AddCustomerException;
    ArrayList<Customer> getOrderDestination(GregorianCalendar targetDate) throws GetDataException, NullException, InvalidFormatException, NumberException;
    void deleteCustomer(Integer id) throws DeleteCustomerException;
    ArrayList<Customer> getPurchasesCustomer(String idProduct, GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetDataException, NullException, InvalidFormatException, NumberException;
    ArrayList<Product> getAllProducts() throws GetDataException;
    ArrayList<City> getCities(Integer postCode) throws GetDataException;
    ArrayList<OrderLine> getPurchasePercentage(GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetDataException;
}
