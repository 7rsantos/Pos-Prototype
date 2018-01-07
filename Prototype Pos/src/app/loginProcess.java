package app;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.io.*;

import org.jboss.logging.Logger;

public class loginProcess {	
	
	final static Logger logger = Logger.getLogger(loginProcess.class);
	
   /*
    * Login the user with given user name and password	
    */
   public static void login(String user, String pass)
   {

	   String query = "CALL Login(?,?, ?)";
	   CallableStatement cs = null;
	   Connection conn = null;
	   
	   boolean success = false;
       try
       {   	   
          conn = dbConnect.openDatabase();
          
          //prepared stmt
          cs = conn.prepareCall(query);
          
          //set parameters      
          cs.setString(1, user);
          cs.setString(2, pass);
          cs.registerOutParameter(3, java.sql.Types.TINYINT); 
          
          //execute
          cs.executeQuery();
          
          //get result
          success = cs.getBoolean(3);
    	  
          cs.close();
          conn.close();
          
          //process
          if(success)
          {
             app.Message.sendMessage("Nova Prototype", "Success");	  
             
             //log success
             logger.info("Login Successful");
             
          }	  
          else
          {
             app.Message.sendMessage("Nova Prototype", "Incorrect username or password");	  
          }	  
    	   	   
       }
       catch(Exception e)
       {
          e.printStackTrace();
          
          app.Message.sendMessage("Error", "Oops! An error has occurred. Please see log file");	 

          try
          {
             conn.close();
             
             cs.close();
          }
          catch(Exception ex)
          {
             ex.printStackTrace();
          }
        
       }
   }
}
