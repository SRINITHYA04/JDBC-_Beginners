package Bus_Reservation_System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class BusDAO {



    public void displayBusInfo() throws SQLException, IOException {

        final String query ="select * from bus;";

        Connection con = DbConnection.getConnection();
        Statement st  = con.createStatement();
        ResultSet rt = st.executeQuery(query);

        while(rt.next()){
            System.out.println("The Bus number is "+rt.getInt("id")+(rt.getBoolean("ac") ?" with":" without") + " AC and has a capacity of "+rt.getInt("capacity")+" seats.");
        }
        con.close();
    }

    public int getCapacity(int Bus_id) throws SQLException, IOException {

        String query = "select capacity from bus where id ="+Bus_id;

        Connection con = DbConnection.getConnection();
        Statement st = con.createStatement();
        ResultSet rst = st.executeQuery(query);
        rst.next();


        return rst.getInt(1);
    }
}
