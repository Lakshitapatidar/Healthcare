import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class admin extends database {
    Scanner sc = new Scanner(System.in);
    String Drname;
    String Dremail;
    String password;
    String specialist;
    String experience;
    String fees;
    String phoneno;

    admin() throws Exception {
        int y=0;
        do{
        System.out.println("press 1: Add doctor");
        System.out.println("press 2:Remove doctor");
        System.out.println("press 3:view patientList");
        System.out.println("press 4:view drList");
        System.out.println("press 5:see feedback");
        System.out.println("enter choice :");
        int n = sc.nextInt();
        switch (n) {
            case 1:
                System.out.println("enter the Drname");
                sc.nextLine();
                Drname=sc.nextLine();
                System.out.println("enter email id");
                Dremail=sc.nextLine();
                System.out.println("enter the password");
                password=sc.nextLine();
                System.out.println("enter specialization");
                specialist=sc.nextLine();
                System.out.println("enter experience");
                experience=sc.nextLine();
                System.out.println("enter fees");
                fees=sc.nextLine();
                System.out.println("enter phoneno");
                phoneno=sc.nextLine();
                 String str3="insert into doctordetail values(?,?,?,?,?,?,?)";
          PreparedStatement p3 = con.prepareStatement(str3);
          p3.setString(1, Drname);
          p3.setString(2, Dremail);
          p3.setString(3, password);
          p3.setString(4, specialist);
          p3.setString(5, experience);
          p3.setString(6, fees);
          p3.setString(7,phoneno);
     p3.executeUpdate();
 y=n;
 System.out.println("______________Dr. added successfully ____________");
                break;

            case 2:
            System.out.println("enter the emailId");
            sc.nextLine();
            String s=sc.nextLine();

            String str2="delete  from doctordetail where email=?  ";
            PreparedStatement p2 = con.prepareStatement(str2);
            p2.setString(1, s);
           p2.executeUpdate();
                  System.out.println("_____________________________________________");
                    System.out.println("doctor removed");
                    System.out.println("____________________________________________");
                   y=n;
                break;
            case 3:
            String str1="select * from patientdetail ";
     PreparedStatement p1 = con.prepareStatement(str1);
       ResultSet rs1=p1.executeQuery();
            while(rs1.next()) {
       String  name=rs1.getString("name");
       String  address=rs1.getString("address");
       String  age=rs1.getString("age");
        String phoneno=rs1.getString("phoneno");
        String bloodgroup=rs1.getString("bloodgroup");
        String disease=rs1.getString("disease");
        System.out.println("----------------------------------------------");
        System.out.println(name+" "+address+ " "+age+" "+phoneno+" "+bloodgroup+" "+disease);
        System.out.println("----------------------------------------------");
      }
      y=n;
                break;
            case 4:
              String str="select * from doctordetail ";
        PreparedStatement p = con.prepareStatement(str);
          ResultSet rs=p.executeQuery();
               while(rs.next()) {
          String  name=rs.getString("name");
          String email=rs.getString("email");
          String  password=rs.getString("password");
           String specialist=rs.getString("specialist");
           String experience=rs.getString("experience");
           String fees=rs.getString("fees");
           String phoneno=rs.getString("phoneno");
           System.out.println("----------------------------------------------");
           System.out.println(name+" "+email+ " "+password+" "+specialist+" "+experience+" "+fees+" "+phoneno);
           System.out.println("----------------------------------------------");
               }
               y=n;
                break;
            case 5:
            String strr="select * from feedbacktable";
            PreparedStatement paa = con.prepareStatement(strr);
              ResultSet rsa=paa.executeQuery();
                   while(rsa.next()) {
              String  name=rsa.getString("name");
              String email=rsa.getString("phoneno");
              String  password=rsa.getString("feedback");
              
               System.out.println("----------------------------------------------");
               System.out.println(name+" "+email+ " "+password+" ");
               System.out.println("----------------------------------------------");
                   }
            y=n;
                break;
                default:
                System.out.println("__________________________--");
                System.out.println("thanks to admin ");
                System.out.println("_______________________________");
                return;
        
        }
    }while(y<6);

    }
}
