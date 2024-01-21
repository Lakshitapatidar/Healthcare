import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Patient extends database {
  String name, date, address, phoneno;
  Scanner s = new Scanner(System.in);
    String Drname;
    String name2;
    String address2;
    String phoneno2;
  void bookappoint(String num) throws Exception {
    String special = "";
    System.out.println("enter your disease");
    String disease = s.nextLine();
    if (disease.equals("heart")) {
      special = "Cardiologists  ";
    }
    if (disease.equals("cold") || disease.equals("cough")) {
      special = "Ear-Nose-Throat (ENT) ";
    }
    if (disease.equals("sugar")) {
      special = "Diabities Specialist ";
    }
    if (disease.equals("asthma")) {
      special = "Pulmonologists Specialist ";
    }
    System.out.println("---------------" + special);
    String str12 = "select * from doctordetail where specialist = ?";
    PreparedStatement p = con.prepareStatement(str12);
    p.setString(1, special);
    ResultSet rs = p.executeQuery();
    while (rs.next()) {
      // System.out.println("doctor");
      String name = rs.getString("name");
      String email = rs.getString("email");
      String password = rs.getString("password");
      String specialist = rs.getString("specialist");
      String experience = rs.getString("experience");
      String fees = rs.getString("fees");
      String phoneno = rs.getString("phoneno");
      System.out.println("----------------------------------------------");
      System.out.println(
          name + " " + email + " " + password + " " + specialist + " " + experience + " " + fees + " " + phoneno);
      System.out.println("----------------------------------------------");
    }
    System.out.println("select the doctor emailId for booking appointment");
    String email = s.nextLine();
    System.out.println("enter date");
    String date = s.nextLine();
    String str5 = "select * from doctordetail where email=?";
    PreparedStatement p5 = con.prepareStatement(str5);
    p5.setString(1, email);
    ResultSet re = p5.executeQuery();
    while (re.next()) {
      Drname = re.getString("name");
      // System.out.println("---------------- "+Drname); 
    }
    String str1 = "select * from patientdetail where phoneno=?";
   System.out.println(num+"tyu");
    PreparedStatement p1 = con.prepareStatement(str1);
    p1.setString(1, num);
    ResultSet r = p1.executeQuery();
    while (r.next()) {
      name2 = r.getString("name");
       address2 = r.getString("address");
      phoneno2 = r.getString("phoneno");

    }
    System.out.println(name2+" "+address2+" "+phoneno2+" ");
    String str6 = "insert into patientAppoint value(?,?,?,?,?,?,?)";
    java.sql.PreparedStatement p6 = con.prepareStatement(str6);
    int y = 2;
    String time = y + ":00 pm";
    p6.setString(1, name2);
    p6.setString(2, address2);
    p6.setString(3, phoneno2);
    p6.setString(4, Drname);
    p6.setString(5, time);
    p6.setString(6, date);
    p6.setString(7, "Done");
    y++;
   p6.executeUpdate();

  }

  void patientsignup() throws Exception {
    Scanner s = new Scanner(System.in);
    System.out.println("enter the patient name ");
    String name = s.nextLine();
    System.out.println("enter address ");
    String address = s.nextLine();
    System.out.println("enter the age ");
    String age = s.nextLine();
    System.out.println("enter the phoneno ");
    String phoneno = s.nextLine();
    System.out.println("enter blood group ");
    String bloodgroup = s.nextLine();
    System.out.println("enter diseases ");
    String disease = s.nextLine();
    System.out.println("enter todays date");
    String date = s.nextLine();

    String str = "insert into patientdetail (name,address,age,phoneno,bloodgroup,disease) values(?,?,?,?,?,?)";
    java.sql.PreparedStatement p = con.prepareStatement(str);
    p.setString(1, name);
    p.setString(2, address);
    p.setString(3, age);
    p.setString(4, phoneno);
    p.setString(5, bloodgroup);
    p.setString(6, disease);
    System.out.println("-----------------------------------------");
    int i = p.executeUpdate();
    if (i > 0) {
      System.out.println("***************profile ceated******************");
    } else {
      System.out.println("some errors");
    }

    System.out.println("Book your Appointment");
    // BookAppointment(name, date ,address,phoneno);
    bookappoint(phoneno);
  }

  void profile(String mob) throws Exception {

    String str = "select * from patientdetail where phoneno=?";
    PreparedStatement p = con.prepareStatement(str);
    p.setString(1, mob);
    ResultSet rs = p.executeQuery();
    while (rs.next()) {
      String name = rs.getString("name");
      String address = rs.getString("address");
      String age = rs.getString("age");
      String phoneno = rs.getString("phoneno");
      System.out.println("----------------------------------------------");
      System.out.println(name + " " + address + " " + age + " " + phoneno);
      System.out.println("----------------------------------------------");
    }

  }
  String name1 ;

  void patientlogin() throws Exception {
    System.out.println("enter the patientname");
     name1 = s.nextLine();
    System.out.println("enter your mobile no to enter in site:");
    // s.nextLine();
     phoneno = s.nextLine();
    int flag = 0;

    String str = "select * from patientdetail where phoneno=?";
    PreparedStatement p = con.prepareStatement(str);
    p.setString(1, phoneno);
    ResultSet rs = p.executeQuery();
    while (rs.next()) {
      flag = 1;
    }
    if (flag == 1) {
      Scanner s = new Scanner(System.in);
      int pr=0;
      do{
      System.out.println("press 1:view Profile");
      System.out.println("press 2:BookAppointment");
      System.out.println("press 3:view appointment");
      System.out.println("press 4:give feedback");
      System.out.println("press 5:view reports");
      System.out.println("enter choice:");
      int n1 = s.nextInt();
      switch (n1) {
        case 1: {
          profile(phoneno);
          pr=n1;
          break;
        }
        case 2: {
        
          bookappoint(phoneno);
          pr=n1;
          break;
        }
        case 3:
   System.out.println(phoneno);
          PreparedStatement ps = con.prepareStatement("select * from patientappoint where phoneno=?");
          ps.setString(1, phoneno);
          ResultSet r = ps.executeQuery();
          while (r.next()) {
            String name2 = r.getString("name");
            String address2 = r.getString("address");
            String phoneno2 = r.getString("phoneno");
            String drname2 = r.getString("drname");
            String time2 = r.getString("time");
            String date2 = r.getString("date");
            String BookAppointment2 = r.getString("BookAppointment");
            System.out.println("----------------------------------------------");
            System.out.println(name2 + " " + address2 + " " + phoneno2 + " " + drname2 + " " + time2 + " " + date2 + " "
                + BookAppointment2);
            System.out.println("----------------------------------------------");
          }
          pr=n1;

          break;
          case 4:
          System.out.println("give your feedback ");
          s.nextLine();
          String strs=s.nextLine();
          PreparedStatement psa = con.prepareStatement("insert into feedbacktable value(?,?,?)");
          psa.setString(1, name1);
          psa.setString(2, phoneno);
          psa.setString(3, strs);
          psa.executeUpdate();

          pr=n1;
          break;
          case 5:
          System.out.println(name1);
          PreparedStatement ps1 = con.prepareStatement("select * from reports where patname=?");
          ps1.setString(1, name1);
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
          pr=n1;
          break;
          default:
          System.out.println("---------------------------------------");
          System.out.println("thanks to login");
          System.out.println("---------------------------------------");
          return;
      }
    }while (pr<6) ;
      
    
    } else {
      System.out.println("enter the correct password");
      patientlogin();
    }
  }
}
