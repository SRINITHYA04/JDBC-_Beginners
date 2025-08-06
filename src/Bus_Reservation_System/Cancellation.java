package Bus_Reservation_System;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Cancellation {

    String passengerName;
    int bookingID;

    Cancellation(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Passenger name: ");
        passengerName = sc.nextLine();

        System.out.println("Enter the Booking_ID: ");
        bookingID =sc.nextInt();

    }

    public boolean isDetailsAvailable() throws SQLException, IOException {
        BookingDAO bookingdao = new BookingDAO();
        return bookingdao.hasBooked(passengerName, bookingID);


    }
}
