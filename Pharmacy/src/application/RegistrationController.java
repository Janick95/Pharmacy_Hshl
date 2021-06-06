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

	StringProperty email = new SimpleStringProperty("");
	StringProperty pass = new SimpleStringProperty("");

	@FXML
	public void initialize() {
		cbAnrede.getItems().removeAll(cbAnrede.getItems());
		cbAnrede.getItems().addAll("Herr", "Frau", "Divers");
		cbAnrede.getSelectionModel().select("Herr");
	}

	/**
	 * Validate the input fields
	 * 
	 * @return Result of validation
	 */
	private boolean validateRegistration() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Login");
		alert.setHeaderText(null);
		boolean result = true;

		// Check if email is empty
		if (getEmail().trim().equals("")) {
			result = false;
			alert.setContentText("Sie haben keine E-Mail Adresse angegeben!");
		} else {
			// Check email match email pattern
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
					+ "A-Z]{2,7}$";
			Pattern pat = Pattern.compile(emailRegex);
			if (!pat.matcher(getEmail()).matches()) {
				result = false;
				alert.setContentText("Sie haben eine ungültige E-Mail Adresse angegeben!");
			}
		}

		// Check if password is not empty
		if (getPass().trim().equals("")) {
			result = false;
			alert.setContentText("Sie haben kein Passwort angegeben!");
		}
		// If errors show alert
		if (!result) {
			alert.showAndWait();
		}

		return result;
	}

	@FXML
	private void handleButtonRegistrationAction(ActionEvent event) {
		validateRegistration();
		
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.txt", true)))) {
			out.println(cbAnrede.getValue() + "," + txtSurname.getText() + "," + txtName.getText() + ","
					+ txtEmail1.getText() + "," + pfPassword1.getText());

		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

	}

	public String getEmail() {
		return email.get();
	}

	public StringProperty emailProperty() {
		return email;
	}

	public void setEmail(StringProperty email) {
		this.email = email;
	}

	public String getPass() {
		return pass.get();
	}

	public StringProperty passProperty() {
		return pass;
	}

	public void setPass(StringProperty pass) {
		this.pass = pass;
	}

}
