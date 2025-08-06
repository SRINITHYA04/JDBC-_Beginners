package Bus_Reservation_System.Model;

import java.util.Scanner;

public class Bus {
    private int busNo;
    private int capacity;
    private Boolean ac;
    private String driverName;

    public Bus() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the Bus Number: ");
        this.busNo = sc.nextInt();

        System.out.println("Enter the No. of seats (Capacity): ");
        this.capacity = sc.nextInt();

        System.out.println("Is the bus has Air conditioner: ");
        this.ac = sc.next() != "no" ;
        sc.nextLine();

        System.out.println("Enter the Driver Name: ");
        this.driverName = sc.nextLine();

    }


    //Accessors
    public int getBusNo() {
        return busNo;
    }

    public int getCapacity(){
        return capacity;
    }

    public boolean getAc(){
        return ac;
    }

    public String getDriverName() {
        return driverName;
    }

    //Mutator
    public void setCapacity(int new_Capacity){
        capacity = new_Capacity;
    }

    public void setAc(boolean newAc){ ac = newAc; }

    public void setDriverName(String name){ driverName = name; }
}
