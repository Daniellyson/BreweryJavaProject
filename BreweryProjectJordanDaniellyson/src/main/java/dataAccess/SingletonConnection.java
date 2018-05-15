package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnection {
    private static Connection uniqueConnection;

    private SingletonConnection() throws SQLException {
        uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_brewery?useSSL=false",
                "root", "Dany.32290");

    }

    public static Connection getInstance() throws SQLException {

        if(uniqueConnection == null){
            new SingletonConnection();
        }
        return uniqueConnection;
    }
}
