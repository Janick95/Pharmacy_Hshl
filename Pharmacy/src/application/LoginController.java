package application;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
	private void handleButtonLoginAction(ActionEvent event) throws IOException {
		// Path to text file
		Path path = Paths.get("users.txt");

		// Count number of line in text file
		long count = Files.lines(path).count();

		/// read each line
		for (int i = 0; i < count; i++) {
			String line = Files.readAllLines(path).get(i);
			if (!line.trim().equals("")) {
				// According to format Gender, Surname, Name, Email, Password
				String[] profile = line.split(",");

				String gender = profile[0];
				String surname = profile[1];
				String name = profile[2];
				String email = profile[3];
				String passw = profile[4];

				// Matching Email
				if (email.trim().equals(txtEmail.getText())) {// Note trim() method remove space from front and behind
																// of string if there is any
																// Now checking if password match
					if (passw.trim().equals(pfPassword.getText())) {
						Alert msg = new Alert(AlertType.CONFIRMATION);
						msg.setTitle(txtEmail.getText());
						msg.setContentText("Email and password matched");
						msg.showAndWait();

						// Store values
						Storage.setGender(gender);
						Storage.setSurName(surname);
						Storage.setName(name);
						Storage.setEmail(email);
						Storage.setPassword(passw);

						break;
					}

				}
			}
		}
		if (validateData()) {
			if (Storage.getEmail() == null) {
				System.out.println("Diese Email gibt es nicht!");

				Alert msg = new Alert(AlertType.ERROR);
				msg.setTitle(txtEmail.getText());
				msg.setContentText("Diese Email gibt es nicht: " + txtEmail.getText());
				msg.showAndWait();
			} else if (Storage.getPassword() == null) {
				System.out.println("Dieses Passwort gibt es nicht!");
				Alert msg = new Alert(AlertType.ERROR);
				msg.setTitle(pfPassword.getText());
				msg.setContentText("Falsches Passwort " + pfPassword.getText());
				msg.showAndWait();
			}

		}
	}

	//
	@FXML
	private void handleOnClickEvent(MouseEvent event) {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Registration.fxml"));
			Parent root = (Parent) fxmlLoader.load();
			Stage stage = new Stage();
			stage.setScene(new Scene(root));
			stage.show();
			Main.stg.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
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
		if (txtEmail.getText().equals("")) {
			msg.setContentText("Bitte füllen Sie das E-Mail Feld aus!");
			msg.showAndWait();
			result = false;
		} else {
			if (pfPassword.getText().equals("")) {
				msg.setContentText("Bitte füllen Sie das Passwort Feld aus!");
				msg.showAndWait();
				result = false;
			} else {
				if (!pat.matcher(txtEmail.getText()).matches()) {
					msg.setContentText("Sie haben eine ungültige E-Mail Adresse angegeben!");
					msg.showAndWait();
					result = false;
				}
			}
		}
		return result;
	}
}
