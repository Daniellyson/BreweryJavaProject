package dataAccess;

import dao.DAO;
import exception.AddCustomerException;
import exception.GetCustomerException;
import exception.InvalidFormatException;
import exception.NullException;
import model.City;
import model.Customer;
import model.Product;

import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CustomerDataBaseAccess implements DAO {


    public ArrayList<Customer> getAllCustomers() throws GetCustomerException {

        ArrayList<Customer> customers = new ArrayList<>();

        try {
            Connection connection = SingletonConnection.getInstance();

            String requestSQL = "SELECT Customer.*, City.PostCode, City.Name " +
                    "FROM Customer, City " +
                    "WHERE Customer.Code in (City.Code);";
            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);
            ResultSet data = preparedStatement.executeQuery();

            customers = communCustomer(data);

        } catch (SQLException exception) {
            throw new GetCustomerException(exception);
        }  catch (NamingException e) {
            e.printStackTrace();
        }
        return customers;
    }


    public boolean addCustomer(Customer customer) throws AddCustomerException {
        boolean updated = true;
        try{
            Connection connection = SingletonConnection.getInstance();
            String sqlInstruction = "insert into Customer () values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            preparedStatement.setNull(1, Types.INTEGER);

            preparedStatement.setString(2, customer.getLastName());

            preparedStatement.setString(3, customer.getFirstName(0));

            preparedStatement.setString(4, customer.getFirstName(1));

            preparedStatement.setString(5, customer.getFirstName(2));

            preparedStatement.setBoolean(6, customer.getVip());

            preparedStatement.setString(7, customer.getNationalRegistrationNumber());

            preparedStatement.setString(8, customer.getAccountNumber());

            preparedStatement.setString(9, customer.getStreetName());

            preparedStatement.setString(10, customer.getHouseNumber());

            preparedStatement.setString(11, customer.getMobilePhone());

            preparedStatement.setString(12, customer.getLandlinePhone());

            preparedStatement.setDate(13, new java.sql.Date(customer.getBirthDate().getTimeInMillis()));

            preparedStatement.setInt(14, customer.getCity().getCode());

            preparedStatement.executeUpdate();


        }
        catch(NamingException | SQLException exception){
            updated = false;
            throw new AddCustomerException(exception);
        }
        return updated;
    }

    public ArrayList<Product> getSearchOne(Integer id, GregorianCalendar firstDate, GregorianCalendar lastDate) throws GetCustomerException {
        ArrayList<Product> products = new ArrayList<>();
        java.sql.Date dateBeginningSQL = new java.sql.Date(firstDate.getTimeInMillis());
        java.sql.Date dateEndSQL = new java.sql.Date(lastDate.getTimeInMillis());

        try {
            Connection connection = SingletonConnection.getInstance();
            Product product;

            String requestSQL = "SELECT DISTINCT product.Name, product.ReductionPercentage, product.Price " +
                    "FROM Product, Customer cust, ProductOrder, OrderLine " +
                    "WHERE orderline.ProductCode = product.ProductCode AND " +
                    "orderline.OrderCode = productorder.OrderCode AND " +
                    "? = productorder.CustomerNumber AND " +
                    "productorder.CreationDate >= (?) AND productorder.TargetDate <= (?) ";


            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);

            preparedStatement.setInt(1, id);
            preparedStatement.setDate(2, dateBeginningSQL);
            preparedStatement.setDate(3, dateEndSQL);

            ResultSet data = preparedStatement.executeQuery();
            while (data.next()) {
                product = new Product(data.getString("Name"),
                        data.getDouble("ReductionPercentage"),
                        data.getDouble("Price"));

                products.add(product);
            }

        } catch (SQLException exception) {
            throw new GetCustomerException(exception);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return products;
    }

    public ArrayList<Customer> getSearchTwo(GregorianCalendar gregorianCalendar) {
        ArrayList<Customer> customers = new ArrayList<>();
        java.sql.Date targetDateSQL = new java.sql.Date(gregorianCalendar.getTimeInMillis());
        ResultSet data;
        try {
            Connection connection = SingletonConnection.getInstance();

            String requestSQL = "SELECT Customer.*, City.Name, City.PostCode " +
                    "FROM Customer, City, ProductOrder " +
                    "WHERE Customer.Code = City.Code AND ProductOrder.CustomerNumber = Customer.CustomerNumber AND " +
                    "ProductOrder.TargetDate <= (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);

            preparedStatement.setDate(1, targetDateSQL);

            data = preparedStatement.executeQuery();

            customers = communCustomer(data);

        } catch (NamingException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public ArrayList<Customer> getSearchThree(String id, GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetCustomerException, NamingException {
        ArrayList<Customer> customers;
        ResultSet data;

        try {
            Connection connection = SingletonConnection.getInstance();
            String requestSQL = "select customer.*, city.*"+
                    "FROM product, customer, city, orderLine, sale " +
                    "WHERE customer.code = city.code " +
                    "AND sale.customerNumber = customer.customerNumber " +
                    "AND orderLine.saleCode = sale.saleCode "+
                    "AND orderLine.productCode = product.productCode "+
                    "AND product.productCode = ? " +
                    "AND sale.targetDate >= ?" +
                    "AND sale.targetDate <= ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);

            preparedStatement.setString(1, id);

            preparedStatement.setDate(2,  new java.sql.Date(firstDate.getTimeInMillis()));

            preparedStatement.setDate(3, new java.sql.Date(secondDate.getTimeInMillis()));

            data = preparedStatement.executeQuery();

            customers = communCustomer(data);

        } catch(SQLException exception) {
            throw new GetCustomerException(exception);
        }
        return customers;
    }


    public ArrayList<Customer> communCustomer(ResultSet data) throws SQLException {
        GregorianCalendar birthDate = new GregorianCalendar();
        java.sql.Date sqlDate;
        ArrayList<Customer> customers = new ArrayList<>();
        String firstName2;
        String firstName3;
        String mobilePhone;
        String landlinePhone;
        Customer customer;

        try {
            while (data.next()) {
                sqlDate = data.getDate("DateOfBirth");
                birthDate.setTime(sqlDate);
                customer = new Customer(data.getInt("CustomerNumber"),
                        data.getString("NationalResgistrationNumber"),
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
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (NullException e) {
            e.printStackTrace();
        }

        return customers;
    }

    public boolean deleteCustomer(Integer id) {
        boolean confirmation = true;

        try {
            Connection connection = SingletonConnection.getInstance();
            String requestSQL;
            PreparedStatement preparedStatement;

            requestSQL = "DELETE  " +
                    "FROM OrderLine " +
                    "WHERE OrderCode IN " +
                    "(SELECT OrderCode FROM ProductOrder WHERE CustomerNumber = ?)";

            preparedStatement = connection.prepareStatement(requestSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            requestSQL = "DELETE  " +
                    "FROM OrderLine " +
                    "WHERE SaleCode IN " +
                    "(SELECT SaleCode FROM Sale WHERE CustomerNumber = ?)";

            preparedStatement = connection.prepareStatement(requestSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();



            requestSQL = "DELETE  " +
                    "FROM ProductOrder " +
                    "WHERE CustomerNumber IN " +
                    "(SELECT CustomerNumber FROM Customer WHERE CustomerNumber = ?)";

            preparedStatement = connection.prepareStatement(requestSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();



            requestSQL = "DELETE  " +
                    "FROM Sale " +
                    "WHERE CustomerNumber IN " +
                    "(SELECT CustomerNumber FROM Customer WHERE CustomerNumber = ?)";

            preparedStatement = connection.prepareStatement(requestSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();



            requestSQL = "DELETE  " +
                    "FROM Customer " +
                    "WHERE CustomerNumber = ?";

            preparedStatement = connection.prepareStatement(requestSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
            confirmation = false;
        } catch (NamingException e) {
            confirmation = false;
            e.printStackTrace();
        }

        return confirmation;
    }

    @Override
    public ArrayList<Product> getAllProducts() throws GetCustomerException, NamingException {
        ArrayList<Product> products = new ArrayList<>();
        Product product;

        try {
            Connection connection = SingletonConnection.getInstance();
            PreparedStatement preparedStatement;
            ResultSet data;
            String requestSQL = "select *"+
                    "from product;";
            preparedStatement = connection.prepareStatement(requestSQL);
            data = preparedStatement.executeQuery();
            while (data.next()) {
                product = new Product(data.getString("productCode"), data.getString("Name"));
                products.add(product);
            }
        } catch (SQLException exception) {
            throw new GetCustomerException(exception);
        }
        return products;
    }


    @Override
    public ArrayList<City> getAllCities(Integer postCode) throws GetCustomerException {
        ArrayList<City> cities = new ArrayList<>();

        try {
            Connection connection = SingletonConnection.getInstance();
            City city;

            String requestSQL = "SELECT * " +
                    "FROM City " +
                    "WHERE City.PostCode = (?)";

            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);

            preparedStatement.setInt(1, postCode);

            ResultSet data = preparedStatement.executeQuery();
            while (data.next()) {
                city = new City(data.getInt("Code"),
                        data.getInt("PostCode"),
                        data.getString("Name"));

                cities.add(city);
            }

        } catch (SQLException exception) {
            throw new GetCustomerException(exception);
        } catch (NamingException e) {
            e.printStackTrace();
        }

        return cities;
    }
}