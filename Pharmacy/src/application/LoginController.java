package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;


public class LoginController {
	
	@FXML
	private TextField txtEmail;
	
	@FXML
	private PasswordField pfPassword;
	
	@FXML
	private Button btnLogin;
	
	@FXML
	private Label lblRegistration;
	
	@FXML
	private void handleButtonLoginAction(ActionEvent event) {
		System.out.println(txtEmail.getText() + " " + pfPassword.getText());
	}
	@FXML
	private void handleOnClickEvent(MouseEvent event){
		 try {
			 FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Registration.fxml"));
			 	Parent root = (Parent) fxmlLoader.load();
	            Stage stage = new Stage();
	            stage.setScene(new Scene(root));  
	            stage.show();
	            Main.stg.close();
	      } catch(Exception e) {
	    	  e.printStackTrace();
	      }
	}
}
