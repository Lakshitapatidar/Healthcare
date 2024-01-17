import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class doctor extends database {
    Scanner sc=new Scanner(System.in);
    doctor() throws SQLException{
        System.out.println("enter your Id");
        String email=sc.nextLine();
        System.out.println("enter the password");
        String password=sc.nextLine();
         PreparedStatement p2 = con.prepareStatement("select * from doctordetail where email=?");
              p2.setString(1, email);
              ResultSet rs1=p2.executeQuery();
              int flage=0;
              while(rs1.next())
              {
                flage=1;
              }
              if(flage ==1)
              {
                drdetail(email);
              }
              else{
                System.out.println("enter your correct information");
                doctor d=new doctor();
              }

    }
    void drdetail(String email){
      System.out.println("press 1:view profile");
      System.out.println("press 2:view appointment");
      System.out.println("press 3:view reports");
    }
}
