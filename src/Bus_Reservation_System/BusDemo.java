package Bus_Reservation_System;

import java.awt.print.Book;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.*;

public class BusDemo {
    public static void main(String[] args) throws ParseException, SQLException, IOException {

        BusDAO busdao = new BusDAO();
        busdao.displayBusInfo();

//        int userOpt = 1;
//        Scanner sc = new Scanner(System.in);
//
//        while(userOpt == 1) {
//            System.out.println("Enter 1 for Booking and Enter 2 for Exit.");
//            userOpt = sc.nextInt();
//            if(userOpt == 1){
//                Booking booking = new Booking();
//                if(booking.isAvailable(bookings, buses)){
//                    bookings.add(booking);
//                    System.out.println("Your Booking is successFull.");
//                }
//                else{
//                    System.out.println("Sorry bus is Full. Try another Bus or Date.");
//                }
//            }
//        }
//        sc.close();

    }
}
