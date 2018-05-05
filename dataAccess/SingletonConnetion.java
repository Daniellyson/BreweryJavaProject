package dataAccess;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnetion {
    private static Connection uniqueConnection;

    private SingletonConnetion() throws SQLException, NamingException {

        uniqueConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/database_brewery?useSSL=false",
                "root", "Dany.32290");
    }

    public static Connection getInstance() throws SQLException, NamingException {
        if(uniqueConnection == null){
            new SingletonConnetion();
        }
        return uniqueConnection;
    }
}
