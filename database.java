import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    public  static Connection con ;
   void ConnectionReady(){

       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           
           con = DriverManager.getConnection("jdbc:mysql://localhost:3306/patient", "root", "Lakshita@123");
           
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    // Connection getdat(){
    //     return con;
    // }

}
