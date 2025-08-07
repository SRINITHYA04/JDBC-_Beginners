package Bus_Reservation_System.DB;

import java.util.Scanner;

public class UserLogin {

    private String cust_uname;
    private String cust_pwd;

    public UserLogin(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter UserName: ");
        cust_uname = sc.nextLine();

        System.out.println("Enter password: ");
        cust_pwd = sc.nextLine();
    }

    // accessor
    public String getCust_uname(){ return cust_uname; }
    public String getCust_pwd(){ return cust_pwd; }
}
