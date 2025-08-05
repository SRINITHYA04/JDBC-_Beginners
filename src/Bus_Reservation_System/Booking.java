package Bus_Reservation_System;

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

    public  boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
        int capacity=0;
        int booked =0;

        for(Bus b: buses){
            if(b.getBusNo() == busNo){
                capacity = b.getCapacity();
            }
        }

        for(Booking b : bookings){
            if(b.busNo == busNo && b.date.equals(date) ){
                booked++;
            }
        }
        return booked<capacity;
    }
}

