package Bus_Reservation_System;

public class Bus {
    private int busNo;
    private int capacity;
    private Boolean ac;
    private String driverName;

    public Bus(int num, boolean ac, int cap) {
        this.busNo = num;
        this.capacity = cap;
        this.ac =ac;

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
