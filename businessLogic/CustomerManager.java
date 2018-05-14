package businessLogic;

import dao.DAO;
import dataAccess.CustomerDataBaseAccess;
import exception.*;
import model.City;
import model.Customer;
import model.Product;
import model.RegularExpression;

import javax.naming.NamingException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;

public class CustomerManager {
    private DAO dao;

    public CustomerManager() {
        dao = new CustomerDataBaseAccess();
    }

    public ArrayList<Customer> getAllCustomers() throws GetCustomerException, NullException, InvalidFormatException {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer;

        customers = dao.getAllCustomers();

        Iterator<Customer> listingCustomers = customers.iterator();


        while(listingCustomers.hasNext()) {
            customer = listingCustomers.next();

            communTestingCustomer(customer);
        }
        return customers;
    }

    public boolean addCustomer(Customer customer) throws AddCustomerException, NullException, InvalidFormatException {

        communTestingCustomer(customer);

        return dao.addCustomer(customer);
    }

    public boolean upDateCustomer(Customer customer) throws AddCustomerException, NullException, InvalidFormatException {

        communTestingCustomer(customer);
        return dao.upDateCustomer(customer);
    }

    public ArrayList<Product> getSearchOne(Integer id, GregorianCalendar first, GregorianCalendar last) throws GetCustomerException, NumberException, InvalidFormatException, NullException {

        ArrayList<Product> products = new ArrayList<>();
        Product product;

        if(first == null) {
            throw new NullException(first.toString());
        }
        if(last == null) {
            throw new NullException(last.toString());
        }

        products = dao.getSearchOne(id, first, last);

        Iterator<Product> listingProducts = products.iterator();


        while(listingProducts.hasNext()) {
            product = listingProducts.next();

            communtTestingProduct(product);
        }


        return products;
    }

    public ArrayList<Customer> getSearchTwo(GregorianCalendar gregorianCalendar) throws GetCustomerException, NullException, InvalidFormatException {

        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer;

        if(gregorianCalendar == null){
            throw  new NullException(gregorianCalendar.toString());
        }

        customers = dao.getSearchTwo(gregorianCalendar);

        Iterator<Customer> listingCustomers = customers.iterator();


        while(listingCustomers.hasNext()) {
            customer = listingCustomers.next();

            communTestingCustomer(customer);
        }


        return customers;
    }

    public ArrayList<Customer> getSearchThree(String idProduct, GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetCustomerException, NamingException, NullException, InvalidFormatException, NumberException {

        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer;

        if(idProduct.toString().length() > 7) {
            throw new NumberException(idProduct.toString());
        }
        if(firstDate == null){
            throw  new NullException(firstDate.toString());
        }
        if(secondDate == null){
            throw  new NullException(secondDate.toString());
        }

        customers = dao.getSearchThree(idProduct, firstDate, secondDate);

        Iterator<Customer> listingCustomers = customers.iterator();


        while(listingCustomers.hasNext()) {
            customer = listingCustomers.next();

            communTestingCustomer(customer);
        }

        return customers;
    }

    public ArrayList<Product> getAllProducts() throws GetCustomerException, NamingException, InvalidFormatException, NumberException, NullException {

        ArrayList<Product> products = new ArrayList<>();
        Product product;

        products =  dao.getAllProducts();

        Iterator<Product> listingProducts = products.iterator();


        while(listingProducts.hasNext()) {
            product = listingProducts.next();

            communtTestingProduct(product);
        }

        return products;
    }

    public boolean deleteCustomer(Integer id) {
        return dao.deleteCustomer(id);
    }

    public ArrayList<City> getAllCities(Integer postCode) throws GetCustomerException, NullException, InvalidFormatException {


        ArrayList<City> cities = new ArrayList<>();
        City city;

        cities = dao.getAllCities(postCode);

        Iterator<City> listingCity = cities.iterator();


        while(listingCity.hasNext()) {
            city = listingCity.next();


            if(city.getPostCode() == null)
                throw new NullException(city.getPostCode().toString() + " (PostCode)");

            if(city.getName().isEmpty())
                throw new NullException(city.getName() + " (ProductName) empity or not ");

            if (RegularExpression.test(city.getName(), "\\d+"))
                throw new InvalidFormatException("City name", city.getName());

        }
        return cities;
    }

    public void communTestingCustomer(Customer customer) throws NullException, InvalidFormatException {

        if (customer.getLastName().isEmpty())
            throw new NullException("last name");
        if (customer.getNationalRegistrationNumber().isEmpty())
            throw new NullException("register number");
        if (customer.getLastName().isEmpty())
            throw new NullException("last name");
        if (RegularExpression.test(customer.getLastName(), "\\d+"))
            throw new InvalidFormatException("last name", customer.getLastName());
        if(customer.getFirstName(1) != null)
            if (RegularExpression.test(customer.getFirstName(1), "\\d+"))
                throw new InvalidFormatException("first name", customer.getFirstName(1));
        if(customer.getFirstName(2) != null)
            if (RegularExpression.test(customer.getFirstName(2), "\\d+"))
                throw new InvalidFormatException("first name", customer.getFirstName(2));
        if (customer.getAccountNumber().isEmpty())
            throw new NullException("account number");
        if (customer.getStreetName().isEmpty())
            throw new NullException("street name");
        if (customer.getHouseNumber().isEmpty())
            throw new NullException("house number");
        if (customer.getBirthDate() == null)
            throw new NullException("date of birth");
    }

    public void communtTestingProduct(Product product) throws NumberException, NullException, InvalidFormatException {
        if(product.getPrice().isNaN())
            throw new NumberException(product.getPrice().toString());
        if(product.getReductionPercentage().isNaN())
            throw new NumberException(product.getReductionPercentage().toString());
        if(product.getName().isEmpty())
            throw new NullException(product.getName() + " (ProductName) empity or not ");
        if (RegularExpression.test(product.getName(), "\\d+"))
            throw new InvalidFormatException("product name", product.getName());
    }
}
