import java.io.*;
import java.sql.*;
import java.util.Properties;


public class JDBCDemo {

    public static void readRecord() throws Exception{

        // get the hidden database details.
        Properties props = new Properties();
        FileInputStream fis= new FileInputStream("db.properties");
        // load it to props variable to access
        props.load(fis);


        String url = props.getProperty("url");
        String userName = props.getProperty("userName");
        String passWord = props.getProperty("pwd");

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

    public static void insertRecord() throws Exception{

        FileInputStream fis = new FileInputStream("db.properties");
        Properties props = new Properties();
        props.load(fis);

        String url = props.getProperty("url");
        String name = props.getProperty("userName");
        String pwd = props.getProperty("pwd");

        String query = "insert into employee value(5,'Dharshini',120000)";

        Connection con = DriverManager.getConnection(url,name,pwd);
        Statement st = con.createStatement();
        int row = st.executeUpdate(query);

        System.out.println("The number of rows affected : "+row);

        con.close();

    }

    public static void insertVar() throws Exception{

        FileInputStream fis = new FileInputStream("db.properties");
        Properties props = new Properties();
        props.load(fis);

        String url = props.getProperty("url");
        String name = props.getProperty("userName");
        String pwd = props.getProperty("pwd");

        int id = 6;
        String ename ="Vinaya";
        int salary = 90000;

//                     "insert into employee value(5,'Dharshini',120000)";
        String query ="insert into employee value ("+id+",'"+ename+"',"+salary+")";

        Connection con = DriverManager.getConnection(url,name,pwd);
        Statement st = con.createStatement();
        int row = st.executeUpdate(query);

        System.out.println("The number of rows affected : "+row);

        con.close();

    }

    public static void insertUsingPst() throws Exception{

        FileInputStream fis = new FileInputStream("db.properties");
        Properties props = new Properties();
        props.load(fis);

        String url = props.getProperty("url");
        String name = props.getProperty("userName");
        String pwd = props.getProperty("pwd");

        int id = 7;
        String ename ="Swetha";
        int salary = 95000;

//                     "insert into employee value(5,'Dharshini',120000)";
        String query ="insert into employee value (?,?,?);";

        Connection con = DriverManager.getConnection(url,name,pwd);
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, id);
        pst.setString(2, ename);
        pst.setInt(3,salary);

        int row = pst.executeUpdate();

        System.out.println("The number of rows affected : "+row);

        con.close();
    }

    public static void Delete() throws Exception{

        FileInputStream fis = new FileInputStream("db.properties");
        Properties props = new Properties();
        props.load(fis);

        String url = props.getProperty("url");
        String name = props.getProperty("userName");
        String pwd = props.getProperty("pwd");

        int id = 7;


//                     "insert into employee value(5,'Dharshini',120000)";
        String query ="delete from employee where emp_id="+id;

        Connection con = DriverManager.getConnection(url,name,pwd);
        Statement st = con.createStatement();
        int row = st.executeUpdate(query);

        System.out.println("The number of rows affected : "+row);

        con.close();
    }

    public static void Update() throws Exception{

        FileInputStream fis = new FileInputStream("db.properties");
        Properties props = new Properties();
        props.load(fis);

        String url = props.getProperty("url");
        String name = props.getProperty("userName");
        String pwd = props.getProperty("pwd");



//                     "insert into employee value(5,'Dharshini',120000)";
        String query ="update employee set salary = 123456 where emp_id = 1;";

        Connection con = DriverManager.getConnection(url,name,pwd);
        Statement st = con.createStatement();
        int row = st.executeUpdate(query);

        System.out.println("The number of rows affected : "+row);

        con.close();
    }

    public static void sp() throws Exception {

        FileInputStream fis = new FileInputStream("db.properties");
        Properties props = new Properties();
        props.load(fis);

        String url = props.getProperty("url");
        String name = props.getProperty("userName");
        String pwd = props.getProperty("pwd");

        Connection con = DriverManager.getConnection(url,name,pwd);

        CallableStatement cst = con.prepareCall("{call GetEmp()}");
        ResultSet rst = cst.executeQuery();

        while(rst.next()){
            System.out.println("The id is :" + rst.getInt(1));
            System.out.println("The Name is :" + rst.getString(2));
            System.out.println("The Salary is :" + rst.getInt(3));
        }

        con.close();
    }


    public static void main(String[] args) throws Exception {
//        insertRecord();
//        readRecord();
//        insertVar();
//        insertUsingPst();
//        Delete();
//        Update();
//        sp();
    }
}
