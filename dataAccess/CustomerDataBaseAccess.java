package dataAccess;

import exception.AddCustomerException;
import exception.GetCustomerException;
import model.Customer;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDataBaseAccess {


    public ArrayList<Customer> getAllCustomers() throws GetCustomerException {
        try{
            //TODO
            //exception.GetCustomerException: Error during query of customer data
            // (No suitable driver found for jdbc:mysql://localhost:3306/database_brewery?useSSL=false).
            Connection connection = SingletonConnection.getInstance();

            ArrayList<Customer> customers = new ArrayList<>();
            Customer customer;
            String requestSQL = "select * from Customer";
            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);
            ResultSet data = preparedStatement.executeQuery();
            while(data.next()){
                //TODO
                customer = new Customer(data.getInt("Customer Number"),
                                        data.getString("Last Name"),
                                        data.getString("First Name"));
                customers.add(customer);
            }
            return customers;
        }
        catch(NamingException | SQLException exception){
            throw new GetCustomerException(exception);
        }
    }

    public void addCustomer(Customer customer) throws AddCustomerException {
        try{
            Connection connection = SingletonConnection.getInstance();
            String sqlInstruction = "insert into Customer () values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            preparedStatement.setString(1, customer.getNationalRegistrationNumber());
            preparedStatement.setString(2, customer.getLastName());
            preparedStatement.setString(3, customer.getFirstNames()[0]);
            preparedStatement.setString(4, customer.getFirstNames()[1]);
            preparedStatement.setString(5, customer.getFirstNames()[2]);
            preparedStatement.setString(6, customer.getAccountNumber());
            preparedStatement.setString(7, customer.getStreetName());
            preparedStatement.setString(8, customer.getHouseNumber());
            preparedStatement.setInt(9, customer.getCity().getPostCode());
            preparedStatement.setString(10, customer.getCity().getName());
            preparedStatement.setString(11, customer.getMobilePhone());
            preparedStatement.setString(12, customer.getLandlinePhone());
            preparedStatement.setDate(13, new java.sql.Date(customer.getBirthDate().getTimeInMillis()));

            preparedStatement.executeUpdate();
        }
        catch(NamingException | SQLException exception){
            throw new AddCustomerException(exception);
        }
    }
}
