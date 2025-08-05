package Bus_Reservation_System;

import java.awt.print.Book;
import java.text.ParseException;
import java.util.*;

public class BusDemo {
    public static void main(String[] args) throws ParseException {

        ArrayList<Bus> buses = new ArrayList<>();
        ArrayList<Booking> bookings = new ArrayList<>();
        buses.add(new Bus(1,true,2));
        buses.add(new Bus(2,false,2));
        buses.add(new Bus(3,true,3));
        for(Bus b : buses){
            b.displayBusInfo();
        }

        int userOpt = 1;
        Scanner sc = new Scanner(System.in);

        while(userOpt == 1) {
            System.out.println("Enter 1 for Booking and Enter 2 for Exit.");
            userOpt = sc.nextInt();
            if(userOpt == 1){
                Booking booking = new Booking();
                if(booking.isAvailable(bookings, buses)){
                    bookings.add(booking);
                    System.out.println("Your Booking is successFull.");
                }
                else{
                    System.out.println("Sorry bus is Full. Try another Bus or Date.");
                }
            }
        }
    }
}
