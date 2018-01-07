package app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class dbConnect {
	public static Connection openDatabase()
	{ 
 	   Connection myConn;
	   try {
		 Class.forName("com.mysql.jdbc.Driver");  
		 myConn = DriverManager.getConnection("jdbc:mysql://sql9.freemysqlhosting.net:3306/sql9213450?user=sql9213450&password=FhjHmiQqnR");
		 
	     return myConn;
	   } catch (SQLException | ClassNotFoundException e) {
		   
		  app.Message.sendMessage("Error", "Oops! An error has occurred."); 
		  e.printStackTrace();
	   }
	  
 	   return null;
	}
	/*
	 * Get session factory object
	 */
	public static SessionFactory getSessionFactory()
	{
	   //configure	
	   //Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	   
	   SessionFactory sf = new Configuration().configure().buildSessionFactory();
	   
	   
	   return sf;   
	   
	}
	/*
	 * save an object in the database
	 */
	public static boolean saveObject(Object object)
	{
	    try
	    {
		   SessionFactory sf = getSessionFactory(); 
		   
	       Session session = sf.openSession();
		   
		   session.beginTransaction();
		   
		   session.save(object);
		   
		   session.getTransaction().commit();
		   
		   session.close();
		   
		   sf.close();
			
		   return true;	
	    }
	    catch(Exception e)
	    {
	       e.printStackTrace();
	       app.Message.sendMessage("Error", "Could not create record");
	    }
	    return false;
	}
	
	/*
	 * Retrieve object from database
	 */
	public static boolean readObject(String query)
	{
	   try
	   {
	       SessionFactory sf = getSessionFactory();
	       
	       Session session = sf.openSession();
	       
	       @SuppressWarnings("unchecked")
		   List<User> result = (List<User>) session.createQuery(query).list();
	       
	       for(User user : result)
	       {
	           System.out.print(user.getUser());	   
	       }	   
	       
	       session.close();
	       
	       sf.close();
	       
	       return true;
	   }
	   catch(Exception e)
	   {
	      e.printStackTrace();
	      
	   }
	   
	   return false;
	}
}
