package businessLogic;

import dataAccess.CustomerDataBaseAccess;
import exception.AddCostumerException;
import exception.GetCostumerException;
import model.Customer;

import java.util.ArrayList;

public class CustomerManager {
    private CustomerDataBaseAccess customerDataBaseAccess;

    public CustomerManager() {
        customerDataBaseAccess = new CustomerDataBaseAccess();
    }

    public ArrayList<Customer> getAllCustomers() throws GetCostumerException {
        return customerDataBaseAccess.getAllCustomers();
    }

    public void addCustomer(Customer customer) throws AddCostumerException {
        customerDataBaseAccess.addCustomer(customer);
    }
}
