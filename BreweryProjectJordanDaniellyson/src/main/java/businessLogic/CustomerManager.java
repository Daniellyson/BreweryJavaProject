package businessLogic;

import dao.DAO;
import dataAccess.CustomerDataBaseAccess;
import exception.*;
import model.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class CustomerManager {
    private DAO dao;

    public CustomerManager() {
        dao = new CustomerDataBaseAccess();
    }

    public ArrayList<Customer> getAllCustomers() throws GetDataException, NullException, InvalidFormatException, NumberException {
        ArrayList<Customer> customers;

        customers = dao.getAllCustomers();

        return customers;
    }

    public void addCustomer(Customer customer) throws AddCustomerException, NullException, InvalidFormatException {

        commonTestingCustomer(customer);

        dao.addCustomer(customer);
    }

    public void upDateCustomer(Customer customer) throws AddCustomerException, NullException, InvalidFormatException {

        commonTestingCustomer(customer);
        dao.upDateCustomer(customer);
    }

    public ArrayList<Product> getProductsOrdered(Integer idProduct, GregorianCalendar firstDate, GregorianCalendar lastDate) throws GetDataException, NullException {

        ArrayList<Product> products;

        if(firstDate == null) {
            throw new NullException("first date");
        }
        if(lastDate == null) {
            throw new NullException("last date");
        }

        products = dao.getProductsOrdered(idProduct, firstDate, lastDate);

        return products;
    }

    public ArrayList<Customer> getOrderDestination(GregorianCalendar targetDate) throws GetDataException, NullException, InvalidFormatException, NumberException {

        ArrayList<Customer> customers;

        if(targetDate == null){
            throw  new NullException("target date");
        }

        customers = dao.getOrderDestination(targetDate);

        return customers;
    }

    public ArrayList<Customer> getPurchasesCustomer(String idProduct, GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetDataException, NullException, InvalidFormatException, LengthException, NumberException {

        ArrayList<Customer> customers;

        if (idProduct == null) {
            throw new NullPointerException("product id");
        }
        if(idProduct.length() > 7) {
            throw new LengthException("id product", 7);
        }
        if(firstDate == null){
            throw  new NullException("first date");
        }
        if(secondDate == null){
            throw  new NullException("second date");
        }

        customers = dao.getPurchasesCustomer(idProduct, firstDate, secondDate);

        return customers;
    }

    public ArrayList<Product> getAllProducts() throws GetDataException {

        ArrayList<Product> products;

        products = dao.getAllProducts();

        return products;
    }

    public void deleteCustomer(Integer id) throws DeleteCustomerException {
        dao.deleteCustomer(id);
    }

    public ArrayList<City> getCities(Integer postCode) throws GetDataException, NullException {
        ArrayList<City> cities;

        if (postCode == null)
            throw new NullException("post code");

        cities = dao.getCities(postCode);

        return cities;
    }

    public void commonTestingCustomer(Customer customer) throws NullException, InvalidFormatException {

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

    public ArrayList<PercentProduct> getPurchasePercentage(GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetDataException, PercentException, NullException {
        ArrayList<OrderLine> orderLines;
        ArrayList<String> productsNames = new ArrayList<>();
        HashMap<String, Integer> productsAmount = new HashMap<>();
        ArrayList<PercentProduct> percentProducts = new ArrayList<>();
        Integer sommeProducts = 0;
        Double percent;
        int i;
        Integer oldValue;

        if (firstDate == null)
            throw new NullException("first date");

        if (secondDate == null)
            throw new NullException("second date");

        orderLines = dao.getPurchasePercentage(firstDate, secondDate);

        for (OrderLine orderLine : orderLines) {
            i = 0;

            while (i < productsNames.size() && !(productsNames.get(i).equals(orderLine.getProduct().getName()))) {
                i++;
            }
            if (i >= productsNames.size()) {
                productsNames.add(orderLine.getProduct().getName());
                productsAmount.put(orderLine.getProduct().getName(), orderLine.getAmount());

            } else {
                oldValue = productsAmount.get(productsNames.get(i));
                productsAmount.put(productsNames.get(i),oldValue+orderLine.getAmount());
            }

            sommeProducts += orderLine.getAmount();
        }


        for (String name : productsNames) {

            percent = percent(sommeProducts, productsAmount.get(name));
            percentProducts.add(new PercentProduct(name, percent));
        }
        return percentProducts;
    }

    public Double percent(Integer totalAmount, Integer amount) throws PercentException {


        if (totalAmount == null) {
            throw new PercentException(totalAmount, amount);
        }
        if(amount == null) {
            throw new PercentException(totalAmount, amount);
        }
        if (totalAmount <= 0 || amount < 0 || amount > totalAmount)
            throw new PercentException(totalAmount, amount);

        return ((double) amount/totalAmount)*100;
    }
}
