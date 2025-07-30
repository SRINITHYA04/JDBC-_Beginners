import java.io.*;
import java.sql.*;
import java.util.Properties;


public class JDBCDemo {
    public static void main(String[] args) throws Exception {

        // get the hidden database details.
        Properties props = new Properties();
        FileInputStream fis= new FileInputStream("db.properties");
        // load it to props variable to access
        props.load(fis);


        String url = props.getProperty("url");
        String userName = props.getProperty("userName");
        String passWord = props.getProperty("Pwd");

        String query = "select * from employee";

        Connection con = DriverManager.getConnection(url, userName, passWord);
        Statement st = con.createStatement();
        ResultSet rt= st.executeQuery(query);

//        //initially it will be pointed to heading row so move to next row
//        rt.next();
//        System.out.println("The id is :"+ rt.getInt(1));
//        System.out.println("The Name is :"+ rt.getString(2));
//        System.out.println("The Salary is :"+ rt.getInt(3));

        // print all the rows in the db
        while(rt.next()) {
            System.out.println("The id is :" + rt.getInt(1));
            System.out.println("The Name is :" + rt.getString(2));
            System.out.println("The Salary is :" + rt.getInt(3));
        }

        con.close();

    }
}
