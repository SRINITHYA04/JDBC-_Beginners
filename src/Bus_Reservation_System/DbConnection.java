package Bus_Reservation_System;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DbConnection {

    private static String url;
    private static String name;
    private static String pwd ;

    public DbConnection() throws IOException {
        FileInputStream fis = new FileInputStream("db.properties");
        Properties props = new Properties();
        props.load(fis);

        url = props.getProperty("url2");
        name = props.getProperty("userName");
        pwd = props.getProperty("pwd");
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,name,pwd);
    }
}
