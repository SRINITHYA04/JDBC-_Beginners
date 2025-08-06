package Bus_Reservation_System;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CancellationDAO {



    public void deleteBooking(Cancellation cancel) throws SQLException, IOException {

        String query = "delete from booking where passenger_Name = ? and booking_number = ?;";

        Connection con = DbConnection.getConnection();
        PreparedStatement pst = con.prepareStatement(query);

        pst.setString(1,cancel.passengerName);
        pst.setInt(2,cancel.bookingID);

        pst.executeUpdate();
    }
}
