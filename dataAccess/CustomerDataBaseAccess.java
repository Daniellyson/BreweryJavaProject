package dataAccess;

import exception.AddCostumerException;
import exception.GetCostumerException;
import model.Customer;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;

public class CustomerDataBaseAccess {

    public ArrayList<String> getAllCustomers() throws GetCostumerException {
        try{
            Connection connection = SingletonConnetion.getInstance();
            ArrayList<String> customers = new ArrayList<>();
            String requestSQL = "select * from Costumer";
            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);
            ResultSet data = preparedStatement.executeQuery();
            while(data.next()){
                customers.add(data.getString("wording"));
            }
            return customers;
        }
        catch(NamingException | SQLException exception){
            throw new GetCostumerException(exception);
        }
    }

    public void addCustomer(Customer costumer) throws AddCostumerException {
        try{
            Connection connection = SingletonConnetion.getInstance();
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
