package Bus_Reservation_System;

import java.awt.print.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class BusDemo {
    public static void main(String[] args)  {

        try{
            BusDAO busdao = new BusDAO();
            busdao.displayBusInfo();

            int userOpt = 1;
            Scanner sc = new Scanner(System.in);

            while(userOpt == 1|| userOpt == 2) {
                System.out.println("Enter 1 for Booking, 2 for cancellation and 3 for Exit.");
                userOpt = sc.nextInt();
                // takes New booking
                if(userOpt == 1){
                    Booking booking = new Booking();
                    if(booking.isAvailable()){
                        BookingDAO bookingdao = new BookingDAO();
                        bookingdao.addBooking(booking);
                        System.out.println("Your Booking is successFull.");
                    }
                    else{
                        System.out.println("Sorry bus is Full. Try another Bus or Date.");
                    }
                }

                // Takes Cancellations
                if(userOpt == 2){
                    Cancellation cancel = new Cancellation();
                    if(cancel.isthere()){
                        CancellationDAO canceldao = new CancellationDAO();
                        canceldao.deleteBooking(cancel);
                        System.out.println("Your booking cancelled successfully.");
                    }
                    else {
                        System.out.println("No such booking found.");
                    }
                }
            }
            sc.close();

        } catch (Exception e){
            System.out.println(e);
        }

    }
}
