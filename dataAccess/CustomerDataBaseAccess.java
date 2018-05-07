package dataAccess;

import exception.AddCustomerException;
import exception.GetCustomerException;
import exception.InvalidFormatException;
import exception.NullException;
import model.Customer;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDataBaseAccess {


    public ArrayList<Customer> getAllCustomers() throws GetCustomerException {
        ArrayList<Customer> customers = null;
        try {
            //TODO install drivers for JDBC
            Connection connection = SingletonConnection.getInstance();

            customers = new ArrayList<>();
            Customer customer;
            String requestSQL = "select * from Customer";
            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);
            ResultSet data = preparedStatement.executeQuery();
            while (data.next()) {
                customer = new Customer(data.getInt("CustomerNumber"),
                        data.getString("NationalResgistrationNumber"),
                        data.getString("LastName"),
                        data.getString("FirstName"),
                        data.getString("FirstName2"),
                        data.getString("FirstName3"),
                        data.getString("AccountNumber"),
                        data.getBoolean("VIP"),
                        data.getString("Street"),
                        data.getString("HouseNumber"),
                        data.getString("MobilePhone"),
                        data.getString("LandlinePhone"),
                        data.getDate("DateOfBirth"),
                        data.getInt("Code"));
                customers.add(customer);
            }

        } catch (SQLException exception) {
            throw new GetCustomerException(exception);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (NullException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }
        return customers;
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
