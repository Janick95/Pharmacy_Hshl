package application;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Pattern;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegistrationController {

	@FXML
	private ComboBox cbAnrede;

	@FXML
	private TextField txtSurname;

	@FXML
	private TextField txtName;

	@FXML
	private TextField txtEmail1;

	@FXML
	private TextField txtEmail2;

	@FXML
	private PasswordField pfPassword1;

	@FXML
	private PasswordField pfPassword2;

	@FXML
	private Button btnRegistration;


	@FXML
	public void initialize() {
		cbAnrede.getItems().removeAll(cbAnrede.getItems());
		cbAnrede.getItems().addAll("Herr", "Frau", "Divers");
		cbAnrede.getSelectionModel().select("Herr");
	}


	@FXML
	private void handleButtonRegistrationAction(ActionEvent event) {
		
		
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.txt", true)))) {
			out.println(cbAnrede.getValue() + "," + txtSurname.getText() + "," + txtName.getText() + ","
					+ txtEmail1.getText() + "," + pfPassword1.getText());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	
	/**
	 * 
	 * Validiate Textfields and  User Input
	 * 
	 */
	
}
