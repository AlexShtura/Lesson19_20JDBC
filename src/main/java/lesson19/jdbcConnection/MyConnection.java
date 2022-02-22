package lesson19.jdbcConnection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MyConnection {
    private Connection connection;

    public Connection getConnection() {
        Properties properties = new Properties();
        Connection connection = null;

        try (InputStream in = MyConnection.class.getClassLoader().getResourceAsStream("db.properties")) {
            properties.load(in);
            String url = properties.getProperty("url");
            String user = properties.getProperty("user");
            String password = properties.getProperty("password");
            connection = DriverManager.getConnection(url, user, password);
        } catch (SQLException | IOException ex) {
            ex.printStackTrace();
        }
        return connection;
    }
}
