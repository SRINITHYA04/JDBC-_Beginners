package Excercises;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class Student1 {

    public static void main(String[] args) throws Exception {

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        props.load(fis);

        String url = props.getProperty("url");
        String name = props.getProperty("userName");
        String pwd = props.getProperty("Pwd");

        String query = "Select * FROM student";

        Connection con = DriverManager.getConnection(url, name, pwd);
        Statement st = con.createStatement();
        ResultSet rst = st.executeQuery(query);

        while(rst.next()){
            System.out.println("The student: "+rst.getString(2)+" of ID:"+rst.getInt(1)+" has got "+rst.getFloat(3)+" GPA.");
        }

        con.close();

    }
}
