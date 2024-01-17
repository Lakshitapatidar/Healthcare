
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;
import java.io.*;

class index {
    

    public static void main(String[] args) throws Exception {
        Patient p=new Patient();
        Scanner sc = new Scanner(System.in);
        database ob = new database();
        ob.ConnectionReady();
        System.out.println(
                "                                              Welcome to  E-HealthCare-Management-System                      ");
        System.out.println();
        int x = 0;
        do {
            System.out.println("Press 1 for Patient :");
            System.out.println("Press 2 for Doctor :");
            System.out.println("Press 3 for Admin :");
            System.out.println("enter choice: ");
            int n = sc.nextInt();
            x=n;
            switch (n) {
                case 1:
                    System.out.println("Press 1 for signup :");
                    System.out.println("Press 2 for login :");
                    int m = sc.nextInt();
                    switch (m) {
                        case 1:
                           p.patientsignup();
                            x=n;
                            break;

                        case 2:
                        
                            p.patientlogin();
                            x=n;
                            break;
                    }
                    break;
                case 2:
              doctor d=new doctor();
                x=n;
                    break;
                case 3:
                x=n;
                    break;
                default:
                System.out.println("thanks to visit our site");
                x=n;
                    break;
            }
        } while (x < 4);

    }
}