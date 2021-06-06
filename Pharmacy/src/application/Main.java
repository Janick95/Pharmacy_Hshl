package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("/gui/application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * public static void main(String[] args) { launch(args);
	 * 
	 * }
	 * 
	 * File Login = new File ("User.txt"); try { Scanner read = new Scanner(Login);
	 * String line;
	 * 
	 * while (read.hasNextLine() && !isBlank(line = read.nextLine())) { String[]
	 * accountData = line.split("/"); String user = accountData[0]; String password
	 * = accountData[1]; System.out.println(user+ ", " +password); } }
	 * 
	 * private static boolean isBlank(String s) { return s == null || s.isEmpty(); }
	 */

	/*
	 * public static boolean login(String user, String pass) {
	 * 
	 * 
	 * //create users.txt file File file = new File("users.txt");
	 * 
	 * FileReader fr;
	 * 
	 * boolean Login = false;
	 * 
	 * 
	 * try {
	 * 
	 * fr = new FileReader(file); BufferedReader br = new BufferedReader(fr); String
	 * line;
	 * 
	 * while((line = br.readLine()) !=null) { String[] split = line.split(", ");
	 * String username; String password;
	 * 
	 * username = split[0]; password = split[1]; } } finally{
	 * 
	 * } return Login;
	 * 
	 * }
	 * 
	 * public static ArrayList<User> getUsersList() { ArrayList<User> userList = new
	 * ArrayList<>(); if (username.equals(user) && password.equals(pass)) { Login =
	 * true; break; } return userList; =======
	 * 
	 * public static void main(String[] args) throws FileNotFoundException {
	 * launch(args);
	 * 
	 * MedicineSearch.showProductAssortment();
	 * 
	 * 
	 * 
	 *  }
	 * 
	 * public static void addUser() {
	 * 
	 * }
	 * 
	 * private void addUserToFile(String username, String password) { if(!Login) {
	 * try { System.out.println("Anmeldung nicht möglich"); }catch (IOException e) {
	 * 
	 * } } }
	 */
}
