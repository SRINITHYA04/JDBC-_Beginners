package Bus_Reservation_System.Model;

import java.util.Scanner;

public class DeleteBus {
    public int busNo;

    public DeleteBus(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Bus Number: ");
        busNo = sc.nextInt();

    }
}
