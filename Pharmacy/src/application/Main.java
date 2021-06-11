package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Main extends Application {
	static Stage stg;

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.stg = primaryStage;
		try {
								
			AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Login.fxml"));
			Scene scene = new Scene(root, 650, 500);
			scene.getStylesheets().add(getClass().getResource("/gui/application.css").toExternalForm());
			primaryStage.setScene(new Scene(TestController.createScene()));
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws IOException {

		 launch(args);
		 
		 products.MedicineSearch.showProductAssortment();
		 
		 int elements = InformationOrganizer.countLines();
		 
		  }


	//	 MedicineSearch.showProductAssortment();
	 
	 
	 
	  }

