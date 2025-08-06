package Bus_Reservation_System.Model;

import Bus_Reservation_System.DAO.BookingDAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.*;

public class Cancellation {

    public String passengerName;
    public int bookingID;

    public Cancellation(){
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
