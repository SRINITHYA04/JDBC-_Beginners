package Bus_Reservation_System;

import java.util.Scanner;

public class DeleteBus {
    int busNo;

    DeleteBus(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Bus Number: ");
        busNo = sc.nextInt();

    }
}
