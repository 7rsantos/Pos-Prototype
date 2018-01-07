package app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class main extends Application {

	public static void main(String[] args) {	
		
	   //launch app	
       launch(args);
	}
	
	@Override
	public void start(Stage window) throws Exception {
	
	   //build the login screen
	   gui.login.displayLogin();	

	}
	
	public static void sceneChanger(Scene scene)
	{
	   // create new stage	
	   Stage stage = new Stage();
	   
	   //configure stage
	   stage.setTitle("Nova Prototype");
	   stage.setMinWidth(300);
	   stage.centerOnScreen();
	   
	   //set scene
	   stage.setScene(scene);
	   
	   //display
	   stage.show();
	}

}
