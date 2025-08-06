package Bus_Reservation_System.DAO;

import Bus_Reservation_System.DB.DbConnection;
import Bus_Reservation_System.Model.Bus;

import java.io.IOException;
import java.sql.*;

public class BusDAO {



    public void displayBusInfo() throws SQLException, IOException {

        final String query ="select * from bus;";

        Connection con = DbConnection.getConnection();
        Statement st  = con.createStatement();
        ResultSet rt = st.executeQuery(query);

        while(rt.next()){
            System.out.println("The Bus number is "+rt.getInt("id")+(rt.getBoolean("ac") ?" with   ":" without") + " AC and has a capacity of "+rt.getInt("capacity")+" seats. Driver Name: "+rt.getString("bus_driver"));
        }
        System.out.println("--------------------------------------------------------------------------------------------------------");
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

    public void addNewBus(Bus bus) throws SQLException, IOException {
        String query ="insert into bus values(?,?,?,?);";

        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1,bus.getBusNo());
        pst.setString(2,bus.getDriverName());
        pst.setBoolean(3,bus.getAc());
        pst.setInt(4,bus.getCapacity());

        pst.executeUpdate();

    }
}
