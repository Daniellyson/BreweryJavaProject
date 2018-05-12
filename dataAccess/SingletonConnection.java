package dataAccess;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection uniqueConnection;

    private SingletonConnection() throws SQLException, NamingException {
        uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_brewery?useSSL=false",
                "root", "yourPassword");

    }

    public static Connection getInstance() throws SQLException, NamingException {

        if(uniqueConnection == null){
            new SingletonConnection();
        }
        return uniqueConnection;
    }
}
