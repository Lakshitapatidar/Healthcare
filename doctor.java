import java.sql.ResultSet;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.io.*;

public class doctor extends database{
  String email;
  String password;
  String name;
  String drname;
  String patname;
  String disease;
   String dremail;
  String specialist="";
    Scanner sc=new Scanner(System.in);
    doctor() throws Exception{
        System.out.println("enter your Id");
         email=sc.nextLine();
        System.out.println("enter the password");
         password=sc.nextLine();
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
    void apoint()throws Exception
    {
  
      String str2="select * from doctordetail where email=?";
      PreparedStatement p2 = con.prepareStatement(str2);
       p2.setString(1, email);
        ResultSet rr=p2.executeQuery();
             while(rr.next()) {
              name=rr.getString("name");
             }
             String str1="select * from patientappoint where drName=?";

             PreparedStatement p1 = con.prepareStatement(str1);
      p1.setString(1,name);
   ResultSet r=p1.executeQuery();
             while(r.next()) {
              String  name2=r.getString("name");
              String  address2=r.getString("address");
               String phoneno2=r.getString("phoneno");
               String  drname2=r.getString("drname");
               String  time2=r.getString("time");
               String date2=r.getString("date");
               String  BookAppointment2=r.getString("BookAppointment");
               System.out.println("----------------------------------------------");
               System.out.println(name2+" "+address2+ " "+phoneno2+" "+drname2+" "+time2+" "+date2+" "+BookAppointment2);
               System.out.println("----------------------------------------------");
             }
    }
    void drdetail(String email)throws Exception{
      int pa=0;
      do{
      System.out.println("press 1:view profile");
      System.out.println("press 2:view appointment");
      System.out.println("press 3:attend patient");
      System.out.println("press 4:view reports");
      System.out.println("enter the choice ");
      int m=sc.nextInt();
      switch(m)
      {
        case 1:
        String str="select * from doctordetail where email=?";
        PreparedStatement p = con.prepareStatement(str);
         p.setString(1, email);
          ResultSet rs=p.executeQuery();
               while(rs.next()) {
                System.out.println("query get");
          String  name=rs.getString("name");
          String  password=rs.getString("password");
           String specialist=rs.getString("specialist");
           String experience=rs.getString("experience");
           String fees=rs.getString("fees");
           String phoneno=rs.getString("phoneno");
           System.out.println("----------------------------------------------");
           System.out.println(name+" "+email+ " "+password+" "+specialist+" "+experience+" "+fees+" "+phoneno);
           System.out.println("----------------------------------------------");
               }
               pa=m;
        break;
        case 2:
       apoint();
       pa=m;
        break;
        case 3:
        apoint();
       
        System.out.println("select patient number for appointment");
        String num=sc.next();
        String str1="select * from patientdetail where phoneno=?";
        PreparedStatement p1 = con.prepareStatement(str1);
        p1.setString(1, num);
      ResultSet s= p1.executeQuery();
      while(s.next())
      {
          patname=s.getString("name");
          disease=s.getString("disease");
      }

        String str2="select * from doctordetail where email=?";
        PreparedStatement p2 = con.prepareStatement(str2);
         p2.setString(1, email);
          ResultSet rr=p2.executeQuery();
          while(rr.next()){
            drname=rr.getString("name");
            dremail=rr.getString("email");
          }
          System.out.println(" cure for patient");
          sc.nextLine();
          String cure =sc.nextLine();
          String str3="insert into reports values(?,?,?,?,?)";
          PreparedStatement p3 = con.prepareStatement(str3);
          p3.setString(1, drname);
          p3.setString(2, dremail);
          p3.setString(3, patname);
          p3.setString(4, disease);
          p3.setString(5, cure);
     p3.executeUpdate();
     String str4="delete from  patientAppoint where phoneno=?";
     PreparedStatement p4 = con.prepareStatement(str4);
     p4.setString(1, num);
   p4.executeUpdate();
  
  pa=m;
        break;
        case 4:
        PreparedStatement ps1 = con.prepareStatement("select * from reports where patname=?");
        ps1.setString(1, patname);
        ResultSet rss1 = ps1.executeQuery();
        while (rss1.next()) {
          String name2 = rss1.getString("drName");
          String address2 = rss1.getString("dremail");
          String phoneno2 = rss1.getString("patname");
          String drname2 = rss1.getString("disease");
          String time2 = rss1.getString("cure");
        
          System.out.println("----------------------------------------------");
          System.out.println(name2 + " " + address2 + " " + phoneno2 + " " + drname2 + " " + time2 + " " );
          System.out.println("----------------------------------------------");
        }
        pa=m;
        break;
     default :
     System.out.println("thanks to be with us");
     return;
      }
    }while(pa<5);

    }
}
