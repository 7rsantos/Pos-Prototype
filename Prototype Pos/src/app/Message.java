package app;

public class Message {

   public static void sendMessage(String title, String message)
   {
	  //send alert to the screen 
      gui.message.alert(title, message);	   
   }
}
