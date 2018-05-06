package dataAccess;

import exception.AddCostumerException;
import exception.GetCostumerException;
import model.Customer;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDataBaseAccess {


    public ArrayList<Customer> getAllCustomers() throws GetCostumerException {
        try{
            //TODO
            //exception.GetCostumerException: Error during query of customer data
            // (No suitable driver found for jdbc:mysql://localhost:3306/database_brewery?useSSL=false).
            Connection connection = SingletonConnection.getInstance();

            ArrayList<Customer> customers = new ArrayList<>();
            Customer customer;
            String requestSQL = "select * from Costumer";
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
            throw new GetCostumerException(exception);
        }
    }

    public void addCustomer(Customer costumer) throws AddCostumerException {
        try{
            Connection connection = SingletonConnection.getInstance();
            String sqlInstruction = "insert into Costumer () values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            preparedStatement.setString(1, costumer.getNationalRegistrationNumber());
            preparedStatement.setString(2, costumer.getLastName());
            preparedStatement.setString(3, costumer.getFirstNames()[0]);
            preparedStatement.setString(4, costumer.getFirstNames()[1]);
            preparedStatement.setString(5, costumer.getFirstNames()[2]);
            preparedStatement.setString(6, costumer.getAccountNumber());
            preparedStatement.setString(7, costumer.getStreetName());
            preparedStatement.setString(8, costumer.getHouseNumber());
            preparedStatement.setInt(9, costumer.getCity().getPostCode());
            preparedStatement.setString(10, costumer.getCity().getName());
            preparedStatement.setString(11, costumer.getMobilePhone());
            preparedStatement.setString(12, costumer.getLandlinePhone());
            preparedStatement.setDate(13, new java.sql.Date(costumer.getBirthDate().getTimeInMillis()));

            preparedStatement.executeUpdate();
        }
        catch(NamingException | SQLException exception){
            throw new AddCostumerException(exception);
        }
    }
}
