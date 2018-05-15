package dataAccess;

import dao.DAO;
import exception.*;
import model.City;
import model.Customer;
import model.OrderLine;
import model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class CustomerDataBaseAccess implements DAO {


    public ArrayList<Customer> getAllCustomers() throws GetDataException, NullException, InvalidFormatException, NumberException {

        ArrayList<Customer> customers;

        try {
            Connection connection = SingletonConnection.getInstance();

            String requestSQL = "SELECT Customer.*, City.PostCode, City.Name " +
                    "FROM Customer, City " +
                    "WHERE Customer.Code in (City.Code);";
            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);
            ResultSet data = preparedStatement.executeQuery();

            customers = commonCustomer(data);

        } catch (SQLException exception) {
            throw new GetDataException(exception);
        }
        return customers;
    }


    public void addCustomer(Customer customer) throws AddCustomerException {
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
        catch (SQLException exception){
            throw new AddCustomerException(exception);
        }
    }



    public void upDateCustomer(Customer customer) throws AddCustomerException {

        try{
            Connection connection = SingletonConnection.getInstance();
            String sqlInstruction = "UPDATE Customer SET " +
                                                        "LastName = ?, " +
                                                        "FirstName = ?, " +
                                                        "FirstName2 = ?, " +
                                                        "FirstName3 = ?, " +
                                                        "VIP = ?, " +
                                                        "NationalResgistrationNumber = ?, " +
                                                        "AccountNumber = ?, " +
                                                        "Street = ?, " +
                                                        "HouseNumber = ?, " +
                                                        "MobilePhone = ?, " +
                                                        "LandlinePhone = ?, " +
                                                        "Code = ?, " +
                                                        "DateOfBirth = ? " +
                                    "WHERE CustomerNumber = ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(sqlInstruction);

            preparedStatement.setString(1, customer.getLastName());

            preparedStatement.setString(2, customer.getFirstName(0));

            preparedStatement.setString(3, customer.getFirstName(1));

            preparedStatement.setString(4, customer.getFirstName(2));

            preparedStatement.setBoolean(5, customer.getVip());

            preparedStatement.setString(6, customer.getNationalRegistrationNumber());

            preparedStatement.setString(7, customer.getAccountNumber());

            preparedStatement.setString(8, customer.getStreetName());

            preparedStatement.setString(9, customer.getHouseNumber());

            preparedStatement.setString(10, customer.getMobilePhone());

            preparedStatement.setString(11, customer.getLandlinePhone());

            preparedStatement.setInt(12, customer.getCity().getCode());

            preparedStatement.setDate(13, new java.sql.Date(customer.getBirthDate().getTimeInMillis()));

            preparedStatement.setInt(14, customer.getCustomerNumber());

            preparedStatement.executeUpdate();
        }
        catch(SQLException exception){
            throw new AddCustomerException(exception);
        }
    }

    public ArrayList<Product> getProductsOrdered(Integer idProduct, GregorianCalendar firstDate, GregorianCalendar lastDate) throws GetDataException {
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

            preparedStatement.setInt(1, idProduct);
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
            throw new GetDataException(exception);
        }

        return products;
    }

    public ArrayList<Customer> getOrderDestination(GregorianCalendar targetDate) throws GetDataException, NullException, InvalidFormatException, NumberException {
        ArrayList<Customer> customers;
        java.sql.Date targetDateSQL = new java.sql.Date(targetDate.getTimeInMillis());
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

            customers = commonCustomer(data);

        } catch (SQLException exception) {
            throw new GetDataException(exception);
        }

        return customers;
    }

    public ArrayList<Customer> getPurchasesCustomer(String idProduct, GregorianCalendar firstDate, GregorianCalendar secondDate)
            throws GetDataException, NullException, InvalidFormatException, NumberException {
        ArrayList<Customer> customers;
        ResultSet data;

        try {
            Connection connection = SingletonConnection.getInstance();
            String requestSQL = "select *, city.*"+
                    "FROM product, customer, city, orderLine, sale " +
                    "WHERE customer.code = city.code " +
                    "AND sale.customerNumber = customer.customerNumber " +
                    "AND orderLine.saleCode = sale.saleCode "+
                    "AND orderLine.productCode = product.productCode "+
                    "AND product.productCode = ? " +
                    "AND sale.targetDate >= ?" +
                    "AND sale.targetDate <= ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);

            preparedStatement.setString(1, idProduct);

            preparedStatement.setDate(2,  new java.sql.Date(firstDate.getTimeInMillis()));

            preparedStatement.setDate(3, new java.sql.Date(secondDate.getTimeInMillis()));

            data = preparedStatement.executeQuery();

            customers = commonCustomer(data);

        } catch(SQLException exception) {
            throw new GetDataException(exception);
        }
        return customers;
    }


    public ArrayList<Customer> commonCustomer(ResultSet data) throws SQLException, NullException, InvalidFormatException, NumberException {
        GregorianCalendar birthDate = new GregorianCalendar();
        java.sql.Date sqlDate;
        ArrayList<Customer> customers = new ArrayList<>();
        String firstName2;
        String firstName3;
        String mobilePhone;
        String landlinePhone;
        Customer customer;
        
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

        return customers;
    }

    public void deleteCustomer(Integer id) throws DeleteCustomerException {
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


        } catch (SQLException exception) {
            throw new DeleteCustomerException(exception);
        }
    }

    @Override
    public ArrayList<Product> getAllProducts() throws GetDataException {
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
            throw new GetDataException(exception);
        }
        return products;
    }


    @Override
    public ArrayList<City> getCities(Integer postCode) throws GetDataException {
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
            throw new GetDataException(exception);
        }
        return cities;
    }

    @Override
    public ArrayList<OrderLine> getPurchasePercentage(GregorianCalendar firstDate, GregorianCalendar secondDate) throws GetDataException {
        ArrayList<OrderLine> orderLines = new ArrayList<>();
        Product product;
        OrderLine orderLine;

        try {
            Connection connection = SingletonConnection.getInstance();

            String requestSQL = "select orderLine.*, product.name " +
                    "FROM sale, orderLine, product "+
                    "WHERE orderLine.saleCode = sale.saleCode " +
                    "AND orderLine.productCode = product.productCode " +
                    "AND sale.targetDate >= ? " +
                    "AND sale.targetDate <= ? ";

            PreparedStatement preparedStatement = connection.prepareStatement(requestSQL);

            preparedStatement.setDate(1 , new java.sql.Date(firstDate.getTimeInMillis()));

            preparedStatement.setDate(2, new java.sql.Date(secondDate.getTimeInMillis()));

            ResultSet data = preparedStatement.executeQuery();



            while (data.next()) {
                product = new Product(data.getString("name"));

                orderLine = new OrderLine(data.getInt("amount"), product);

                orderLines.add(orderLine);
            }

        } catch (SQLException exception) {
            throw new GetDataException(exception);
        }

        return orderLines;
    }
}