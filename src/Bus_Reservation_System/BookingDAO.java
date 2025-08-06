package Bus_Reservation_System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        String query = "insert into booking values(?,?,?);";
        java.sql.Date sqlDate = new java.sql.Date(booking.date.getTime());

        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1,booking.passengerName);
        pst.setInt(2,booking.busNo);
        pst.setDate(3,sqlDate);

        pst.executeUpdate();
    }
}
