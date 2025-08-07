package Bus_Reservation_System.DAO;

import Bus_Reservation_System.DB.UserLogin;
import Bus_Reservation_System.Model.DeleteBus;
import Bus_Reservation_System.Model.Booking;
import Bus_Reservation_System.Model.Bus;
import Bus_Reservation_System.Model.Cancellation;


import java.util.*;

public class BusDemo {
    public static void main(String[] args)  {
        try{

            Scanner sc = new Scanner(System.in);

            System.out.println("Login as :");
            System.out.println("1. User");
            System.out.println("2. Admin");

            int role = sc.nextInt();
            if(role == 1) {

                UserLogin userlogin = new UserLogin();
                UserLoginDAO userlogindao = new UserLoginDAO();

                if (userlogindao.validateUser(userlogin)) {

                    System.out.println("Bus Details");
                    BusDAO busdao = new BusDAO();
                    busdao.displayBusInfo();

                    int userOpt = 1;

                    while (userOpt != 3) {
                        System.out.println("Enter 1 for Booking, 2 for cancellation and 3 for Exit.");
                        userOpt = sc.nextInt();
                        // takes New booking
                        if (userOpt == 1) {
                            Booking booking = new Booking();
                            if (booking.isAvailable()) {
                                BookingDAO bookingdao = new BookingDAO();
                                bookingdao.addBooking(booking);
                                System.out.println("Your Booking is successFull.");
                            } else {
                                System.out.println("Sorry bus is Full. Try another Bus or Date.");
                            }
                        }


                        // Takes Cancellations
                        if (userOpt == 2) {
                            Cancellation cancel = new Cancellation();
                            if (cancel.isDetailsAvailable()) {
                                CancellationDAO canceldao = new CancellationDAO();
                                canceldao.deleteBooking(cancel);
                                System.out.println("Your booking cancelled successfully.");
                            } else {
                                System.out.println("No such booking found.");
                            }
                        }
                    }
                }
            }
            else {
                System.out.println("Welcome to Admin Page");

                int userOpt =1;
                while(userOpt != 3){

                    System.out.println("Enter 1 for AddNewBus, 2 for DeleteBus and 3 for exit ");
                    userOpt = sc.nextInt();

                    if(userOpt == 1){
                        Bus bus = new Bus();

                        BusDAO busdao = new BusDAO();
                        busdao.addNewBus(bus);

                        System.out.println("New Bus Details Added Successfully.");
                    }

                    if(userOpt == 2){

                        DeleteBus deletebus = new DeleteBus();
                        BookingDAO bookingDAO = new BookingDAO();
                        if(bookingDAO.isthereBus(deletebus)){
                            bookingDAO.deleteBus(deletebus);
                            System.out.println("Bus deleted successfully");
                        }
                        else{
                            System.out.println("No such Bus number exists.");
                        }

                    }
                }
            }
            sc.close();
        } catch (Exception e){
            System.out.println(e);
        }

    }
}
