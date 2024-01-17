import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.sql.PreparedStatement;

public class Patient extends database{
  String name,date,address,phoneno;
  Scanner s=new Scanner(System.in);
  
  void BookAppointment(String name,String date ,String address,String phoneno) throws ClassNotFoundException, SQLException{
      System.out.println("enter the disease");
      String disease=s.nextLine();
      String drName="";
      System.out.println("Book your Appointment from  among this doctors");
      if(disease.contains("heart")|| disease.contains("blood")){
    System.out.println("1.DR.Arnav Sharma ");
    System.out.println("Cardiologists              Experience:30years");
    System.out.println("MBBS (1971), MD (1979), Dip. Card. (1976), FCCP");
    System.out.println();
    System.out.println("Book your Appointment from  among this doctors");
    System.out.println("2.DR.Rohit Arora ");
    System.out.println("Cardiologists              Experience:20years");
    System.out.println("MBBS (1981), MD (1990), Dip. Card. (1986)");
    System.out.println();
    System.out.println("select the doctor by pressing the no");
    int num=s.nextInt();
    if(num==1)
    {
      drName="Dr.Arnav sharma";
    }
    else{
      drName="Dr.Rohit Arora";
    }

  }
   if(disease.contains("cough")|| disease.contains("cold"))
   {
      System.out.println("1.DR.Arush patidar ");
      System.out.println("Ear-Nose-Throat (ENT) Specialist              Experience:10years");
      System.out.println("MBBS, MS - ENT");
      System.out.println();
System.out.println();
      System.out.println("2.DR.Rohit vyas ");
      System.out.println("Ear-Nose-Throat (ENT) Specialist              Experience:10years");
      System.out.println("MBBS, MS - ENT");
      System.out.println();
      System.out.println("select the doctor by pressing the no");
      int num=s.nextInt();
      if(num==1)
      {
        drName="Dr.Arush patidar";
      }
      else{
        drName="Dr.Rohit vyas";
      }
   }
   if(disease.contains("sugar"))
   {
      System.out.println("1.DR.Ram patidar ");
      System.out.println("Diabities Specialist           Experience:5years");
      System.out.println("M.D");
      System.out.println();
System.out.println();
      System.out.println("2.DR.priya singh ");
      System.out.println("Diabities Specialist              Experience:10years");
      System.out.println("MBBS, M.D");
      System.out.println();
      System.out.println("select the doctor by pressing the no");
      int num=s.nextInt();
      if(num==1)
      {
        drName="Dr.Ram patidar";
      }
      else{
        drName="Dr.priya singh";
      }
   }
   if(disease.contains("asthma"))
   {
      System.out.println("1.DR.Sanaa khanna");
      System.out.println(" Pulmonologists Specialist           Experience:5years");
      System.out.println("MBBS ");
      System.out.println();
System.out.println();
      System.out.println("2.DR.urmesh singh ");
      System.out.println("Pulmonologists Specialist            Experience:10years");
      System.out.println("MBBS, MS - ENT");
      System.out.println();
      System.out.println("select the doctor by pressing the no");
      int num=s.nextInt();
      if(num==1)
      {
        drName="Dr.sanna khanna";
      }
      else{
        drName="Dr.urmesh singh";
      }
      
   }                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                

   System.out.println("Pay 500 rs for registration : ");
   int n=s.nextInt();
   
    if(n==500)
    {
      System.out.println("**********your appointment is fixed**********");
      System.out.println();

    }
    
    String str1="insert into patientAppoint(name,address,phoneno,drName,time,date,BookAppointment) values(?,?,?,?,?,?,?)";
    java.sql.PreparedStatement p1 = con.prepareStatement(str1);
    int y=2;
    String time=y+":00 pm";
    p1.setString(1,name);
    p1.setString(2,address);
    p1.setString(3,phoneno);
    p1.setString(4,drName);
    p1.setString(5,time);
    p1.setString(6,date);
    p1.setString(7,"Done");
     y++;
    int j = p1.executeUpdate();
    if (j > 0) {
        System.out.println("visit again");
        System.out.println();
    } else {
        System.out.println("some errors");
    }
     }





       
     void patientsignup() throws SQLException, ClassNotFoundException {
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
      String date=s.nextLine();

   
        String str="insert into patientdetail (name,address,age,phoneno,bloodgroup,disease) values(?,?,?,?,?,?)";
        java.sql.PreparedStatement p = con.prepareStatement(str);
        p.setString(1,name);
        p.setString(2,address);
        p.setString(3,age);
        p.setString(4, phoneno);
        p.setString(5,bloodgroup);
        p.setString(6,disease);
System.out.println("-----------------------------------------");
        int i = p.executeUpdate();
        if (i > 0) {
            System.out.println("***************profile ceated******************");
        } else {
            System.out.println("some errors");
        }
     
        System.out.println("Book your Appointment");
        BookAppointment(name, date ,address,phoneno);
    }

  







 void profile(String mob) throws Exception
    {
     
   
      String str="select * from patientdetail where phoneno=?";
     PreparedStatement p = con.prepareStatement(str);
      p.setString(1, mob);
       ResultSet rs=p.executeQuery();
            while(rs.next()) {
       String  name=rs.getString("name");
       String  address=rs.getString("address");
       String  age=rs.getString("age");
        String phoneno=rs.getString("phoneno");
        System.out.println("----------------------------------------------");
        System.out.println(name+" "+address+ " "+age+" "+phoneno);
        System.out.println("----------------------------------------------");
      }

    }



     void patientlogin() throws Exception{
      System.out.println("enter the patientname");
      String name1=s.nextLine();
      System.out.println("enter your mobile no to enter in site:"); 
        // s.nextLine();   
              String mob=s.nextLine();
           int flag=0;
             
      String str="select * from patientdetail where phoneno=?";
      PreparedStatement p = con.prepareStatement(str);
      p.setString(1, mob);
      ResultSet rs=p.executeQuery();
      while(rs.next()) {
         flag =1;
      }
      if(flag ==1){
      Scanner s=new Scanner(System.in);
          System.out.println("press 1:view Profile");
          System.out.println("press 2:BookAppointment");
          System.out.println("press 3:view appointment");
           System.out.println("press 3:give feedback");
           System.out.println("press 4:view reports");
           System.out.println("enter choice:");
           int n1=s.nextInt();
           switch(n1)
           {
            case 1:
            {
               profile(mob);
               break;
            }
            case 2:
            {
              System.out.println("enter date");
              s.nextLine();
              String date=s.nextLine();
              java.sql.PreparedStatement p2 = con.prepareStatement("select * from patientdetail where phoneno=?");
              p2.setString(1, mob);
              ResultSet rs1=p2.executeQuery();
              while(rs1.next())
              {
                name=rs1.getString("name");
                // date=rs1.getString("date");
                address=rs1.getString("address");
                phoneno=rs1.getString("phoneno");
              }
              BookAppointment(name, date ,address,phoneno);
              break;
            }
            case 3:
            System.out.println("enter the patientname");
            
            String n=s.next();
            System.out.println("enter your mobile no to enter in site:"); 
           
                    String m=s.next();
              
                  PreparedStatement ps = con.prepareStatement( "select * from patientappoint where phoneno=?");
            ps.setString(1, m);
            ResultSet r=ps.executeQuery();
            while(r.next())
            {
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
             break;
           }
          }
          else{
            System.out.println("enter the correct password");
            patientlogin();
          }
        }
}
