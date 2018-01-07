package gui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

public class login {
   public static Scene buildLogin()
   {
	  //root
	  BorderPane root = new BorderPane();
	  
	  //setup
	  root.setPadding(new Insets(20,20,20,20));
	  root.setId("body");
	  
	  //top
	  Label title = new Label("Nova Prototype");
	  FlowPane top = new FlowPane();
	  top.setAlignment(Pos.CENTER);
	  top.setId("top");
	  title.setId("title");
	  
	  //add nodes to top
	  top.getChildren().add(title);
	  
	  //center
	  GridPane center = new GridPane();
	  center.setId("center");
	  
	  //nodes center
	  Label userlbl = new Label("Username");
	  Label passlbl = new Label("Password");
	  TextField user = new TextField();
	  PasswordField pass = new PasswordField();
	  
	  //add nodes
	  center.add(userlbl, 0, 0);
	  center.add(user, 1, 0);
	  center.add(passlbl, 0, 1);
	  center.add(pass, 1, 1);
	  
	  //setup
	  center.setAlignment(Pos.CENTER);
	  center.setHgap(5);
	  center.setVgap(5);
	  
	  //left
	  ImageView img = new ImageView(new Image(login.class.getResourceAsStream("/res/image2.jpg")));
	  img.setFitWidth(100);
	  img.setFitHeight(100);
	  
	  //bottom
	  Button login = new Button("Login");
	  Button clear = new Button("Clear");
	  
	  //set action
	  login.setOnAction(e -> app.loginProcess.login(user.getText(), pass.getText()));
	  clear.setOnAction(new EventHandler<ActionEvent>()
	  {

		@Override
		public void handle(ActionEvent arg0) {
			
			//set fields to blank
			user.setText("");
			pass.setText("");
			
		}
		  
	  });
	  
	  //set ids
	  login.setId("login");
	  clear.setId("clear");
	  userlbl.setId("user");
	  passlbl.setId("pass");
	  
	  //add nodes to bottom
	  HBox bottom = new HBox();
	  bottom.setAlignment(Pos.CENTER);
	  bottom.setSpacing(5);
	  bottom.setId("bottom");
	  
	  bottom.getChildren().addAll(login, clear);
	  
	  //build display
	  root.setTop(top);
	  root.setCenter(center);
	  root.setBottom(bottom);
	  root.setLeft(img);
	  
	  //build a scene
      Scene scene = new Scene(root);	
      
      //set style
      root.getStylesheets().add(login.class.getResource("loginStyle.css").toExternalForm());
      
      return scene;
   }
   
   /*
    * Display the login screen
    */
   public static void displayLogin()
   {
      Scene scene = buildLogin();
      
      app.main.sceneChanger(scene);
   }
   
}
