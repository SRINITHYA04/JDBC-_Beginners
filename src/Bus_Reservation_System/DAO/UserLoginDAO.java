package Bus_Reservation_System.DAO;

import Bus_Reservation_System.DB.DbConnection;
import Bus_Reservation_System.DB.UserLogin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserLoginDAO {

    public boolean validateUser(UserLogin userlogin) throws SQLException, IOException {

        String query = "Select * from user_details where cust_uname=? and cust_pwd=?;";

        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1,userlogin.getCust_uname());
        pst.setString(2,userlogin.getCust_pwd());

        ResultSet rst = pst.executeQuery();
        return rst.next();

    }
}
