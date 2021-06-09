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
	private void handleButtonRegistrationAction(ActionEvent event) throws IOException {
		if (validateData()) {
			try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("users.txt", true)))) {
				out.println(cbAnrede.getValue() + "," + txtSurname.getText() + "," + txtName.getText() + ","
						+ txtEmail1.getText() + "," + pfPassword1.getText());

			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		/*
		txtSurname.clear();
		txtName.clear();
		txtEmail1.clear();
		txtEmail2.clear();
		pfPassword1.clear();
		pfPassword2.clear();
		*/
	}

	/**
	 * 
	 * Validiate Textfields and User Input
	 * 
	 * @return Result of validation
	 */

	private boolean validateData() {
		Alert msg = new Alert(AlertType.ERROR);
		boolean result = true;
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z"
				+ "A-Z]{2,7}$";
		Pattern pat = Pattern.compile(emailRegex);
		if (txtSurname.getText().equals("")) {
			msg.setContentText("Bitte füllen Sie das Vornamen Feld aus!");
			msg.showAndWait();
			result = false;
		} else {
			if (txtName.getText().equals("")) {
				msg.setContentText("Bitte füllen Sie das Nachnamen Feld aus!");
				msg.showAndWait();
				result = false;
			} else {
				if (txtEmail1.getText().equals("")) {
					msg.setContentText("Bitte füllen Sie das erste E-Mail Feld aus!");
					msg.showAndWait();
					result = false;
				} else {
					if (txtEmail2.getText().equals("")) {
						msg.setContentText("Bitte füllen Sie das zweite E Feld aus!");
						msg.showAndWait();
						result = false;
					} else {
						if (pfPassword1.getText().equals("")) {
							msg.setContentText("Bitte füllen Sie das erste Passwort aus!");
							msg.showAndWait();
							result = false;
						} else {
							if (pfPassword2.getText().equals("")) {
								msg.setContentText("Bitte füllen Sie das zweite Passwort Feld aus!");
								msg.showAndWait();
								result = false;
							} else {
								if (!pat.matcher(txtEmail1.getText()).matches()) {
									msg.setContentText("Sie haben eine ungültige E-Mail Adresse angegeben!");
									msg.showAndWait();
									result = false;
								} else {
									if (!txtEmail1.getText().matches(txtEmail2.getText())) {
										msg.setContentText("Ihre E-Mail Adressen stimmen nicht überein");
										msg.showAndWait();
										result = false;
									}
								}
							}
						}
					}
				}
			}

		}
		return result;
	}
}