package dataAccess;

import exception.AddCustomerException;
import exception.GetCustomerException;
import exception.InvalidFormatException;
import exception.NullException;
import model.Customer;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CustomerDataBaseAccess {


    public ArrayList<Customer> getAllCustomers() throws GetCustomerException {
        GregorianCalendar birthDate = new GregorianCalendar();
        java.sql.Date sqlDate;
        ArrayList<Customer> customers = null;
        String firstName2;
        String firstName3;
        String mobilePhone;
        String landlinePhone;

        try {
            //TODO install drivers for JDBC
            Connection connection = SingletonConnection.getInstance();

            customers = new ArrayList<>();
            Customer customer;
            String requestSQL = "select Customer.*, City.PostCode, City.Name\n" +
                                "from Customer, City\n" +
                                "where Customer.Code in (City.Code);";
            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);
            ResultSet data = preparedStatement.executeQuery();
            while (data.next()) {
                sqlDate = data.getDate("DateOfBirth");
                birthDate.setTime(sqlDate);
                customer = new Customer(data.getInt("CustomerNumber"),
                        data.getString("NationalRegistrationNumber"),
                        data.getString("LastName"),
                        data.getString("FirstName"),
                        data.getString("AccountNumber"),
                        data.getBoolean("VIP"),
                        data.getString("Street"),
                        data.getString("HouseNumber"),
                        birthDate,
                        data.getInt("Code"),
                        data.getInt("PostCode"),
                        data.getString("Name"));
                firstName2 = data.getString("firstName2");
                if (!data.wasNull()) {
                        customer.addFirstName(firstName2);
                }
                firstName3 = data.getString("firstName3");
                if (!data.wasNull()) {
                    customer.addFirstName(firstName3);
                }
                mobilePhone = data.getString("mobilePhone");
                if (!data.wasNull()) {
                    customer.setMobilePhone(mobilePhone);
                }
                landlinePhone = data.getString("landlinePhone");
                if (!data.wasNull()) {
                    customer.setLandlinePhone(landlinePhone);
                }
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
            preparedStatement.setString(3, customer.getFirstName(0));
            preparedStatement.setString(4, customer.getFirstName(1));
            preparedStatement.setString(5, customer.getFirstName(2));
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
