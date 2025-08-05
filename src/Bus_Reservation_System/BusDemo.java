package Bus_Reservation_System;

import java.util.*;

public class BusDemo {
    public static void main(String[] args) {

        ArrayList<Bus> buses = new ArrayList<>();
        buses.add(new Bus(1,true,45));
        buses.add(new Bus(2,false,50));
        buses.add(new Bus(3,true,48));
        for(Bus b : buses){
            b.displayBusInfo();
        }

        int userOpt = 1;
        Scanner sc = new Scanner(System.in);

        while(userOpt == 1) {
            System.out.println("Enter 1 for Booking and Enter 2 for Exit.");
            userOpt = sc.nextInt();
            if(userOpt == 1){
                System.out.println("Bookings");
            }
        }
    }
}
