package businessLogic;

import dataAccess.CustomerDataBaseAccess;
import exception.AddCustomerException;
import exception.GetCustomerException;
import model.Customer;

import java.util.ArrayList;

public class CustomerManager {
    private CustomerDataBaseAccess customerDataBaseAccess;

    public CustomerManager() {
        customerDataBaseAccess = new CustomerDataBaseAccess();
    }

    public ArrayList<Customer> getAllCustomers() throws GetCustomerException {
        return customerDataBaseAccess.getAllCustomers();
    }

    public void addCustomer(Customer customer) throws AddCustomerException {
        customerDataBaseAccess.addCustomer(customer);
    }
}
