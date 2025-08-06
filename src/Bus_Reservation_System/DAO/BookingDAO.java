package Bus_Reservation_System.DAO;

import Bus_Reservation_System.DB.DbConnection;
import Bus_Reservation_System.Model.DeleteBus;
import Bus_Reservation_System.Model.Booking;

import java.io.IOException;
import java.sql.*;
import java.util.Date;

public class BookingDAO {

    public int getBookedCapacity(int busNo, Date date) throws SQLException, IOException {
        String query = "select count(passenger_Name) from booking where bus_no = ? and travel_date=?";
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setInt(1, busNo);
        pst.setDate(2,sqlDate);

        ResultSet rst = pst.executeQuery();
        rst.next();

        return rst.getInt(1);
    }

    public void addBooking(Booking booking) throws SQLException, IOException {
        String query = "insert into booking (passenger_Name, bus_no, travel_date, from_add, to_add) values(?,?,?,?,?);";
        java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());

        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1,booking.passengerName);
        pst.setInt(2,booking.busNo);
        pst.setDate(3,sqlDate);
        pst.setString(4, booking.from);
        pst.setString(5, booking.to);

        pst.executeUpdate();
    }

    public boolean hasBooked(String passengerName, int bookingID) throws SQLException, IOException {

        String query = " select * from booking where passenger_Name = ? and booking_number = ?;";

        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1,passengerName);
        pst.setInt(2,bookingID);

        ResultSet rst = pst.executeQuery();
        return rst.next();



    }

    public boolean isthereBus(DeleteBus deleteBus) throws SQLException, IOException {

        String query ="select * from bus where id ="+ deleteBus.busNo;
        Connection con = DbConnection.getConnection();

        Statement st = con.createStatement();
        ResultSet rst = st.executeQuery(query);

        return rst.next();

    }

    public void deleteBus(DeleteBus deletebus) throws SQLException, IOException {

        String query = " delete from bus where id ="+deletebus.busNo;

        Connection con = DbConnection.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate(query);

    }
}
