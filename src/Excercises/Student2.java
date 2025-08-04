package Excercises;

import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

public class Student2 {

    public static void readRecord() throws Exception{

        Properties props = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        props.load(fis);

        String url = props.getProperty("url");
        String name = props.getProperty("userName");
        String pwd = props.getProperty("pwd");

        String query = "Select * FROM student";

        Connection con = DriverManager.getConnection(url, name, pwd);
        Statement st = con.createStatement();
        ResultSet rst = st.executeQuery(query);

        while(rst.next()){
            System.out.println("The student: "+rst.getString(2)+" of ID:"+rst.getInt(1)+" has got "+rst.getFloat(3)+" GPA.");
        }

        con.close();
    }

    // Insertion - Hardcoding
    public static void insertRecord() throws Exception {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        prop.load(fis);

        String url = prop.getProperty("url");
        String name = prop.getProperty("userName");
        String pwd = prop.getProperty("pwd");

        String query = "insert into student value(6,'Vanni', 6.5);";

        Connection con = DriverManager.getConnection(url,name,pwd);
        Statement st = con.createStatement();
        int row = st.executeUpdate(query);

        System.out.println("number of rows affected : "+row);
        con.close();
    }

    public static void insertVar() throws Exception {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        prop.load(fis);

        String url = prop.getProperty("url");
        String name = prop.getProperty("userName");
        String pwd = prop.getProperty("pwd");

        int id = 7;
        String sname = "Vinaya";
        float gpa = 8.9f;


        String query = "insert into student value("+id+",'"+sname+"',"+gpa+");";

        Connection con = DriverManager.getConnection(url,name,pwd);
        Statement st = con.createStatement();
        int row = st.executeUpdate(query);

        System.out.println("number of rows affected : "+row);
        con.close();
    }

    public static void insertUsingPst() throws Exception {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("db.properties");
        prop.load(fis);

        String url = prop.getProperty("url");
        String name = prop.getProperty("userName");
        String pwd = prop.getProperty("pwd");

        int id = 8;
        String sname = "Varun";
        float gpa = 8.8f;


        String query = "insert into student value(?,?,?);";

        Connection con = DriverManager.getConnection(url,name,pwd);
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1,id);
        pst.setString(2,sname);
        pst.setFloat(3,gpa);

        int row = pst.executeUpdate();

        System.out.println("number of rows affected : "+row);
        con.close();
    }

    public static void main(String[] args) throws Exception {
//        readRecord();
//        insertRecord();
//        insertVar();
//        insertUsingPst();
    }
}
