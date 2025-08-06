package Bus_Reservation_System;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    String passengerName;
    int busNo;
    Date date;

    Booking() throws ParseException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the passenger name: ");
        passengerName = sc.nextLine();

        System.out.println("Enter the Bus Number: ");
        busNo = sc.nextInt();

        System.out.println("Enter the Date as (dd-mm-yyy): ");
        String dateInput = sc.next();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        try{
            date = dateFormat.parse(dateInput);
        }
        catch(ParseException e){
            e.printStackTrace();
        }

    }

    public  boolean isAvailable() throws SQLException, IOException {

        BusDAO busdao = new BusDAO();
        int capacity = busdao.getCapacity(busNo);

        BookingDAO bookingdao = new BookingDAO();
        int booked = bookingdao.getBookedCapacity(busNo, date);


        return booked<capacity;
    }
}

