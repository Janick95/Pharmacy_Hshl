package application;

import java.io.FileNotFoundException;
import java.io.IOException;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Text;
import products.Medicine;

public class TestController {
	

	
	
	public static Parent createScene() throws FileNotFoundException {
		
		// UI elements
		BorderPane root = new BorderPane();
		GridPane grid = new GridPane();
		
		ScrollPane scroll1 = new ScrollPane();
		ScrollPane scroll2 = new ScrollPane();
		ScrollPane scroll3 = new ScrollPane();
		ScrollPane scroll4 = new ScrollPane();
		
		TextArea text1 = new TextArea(showProductAssortment());
		TextArea text2 = new TextArea(showProductAssortment());
		TextArea text3 = new TextArea(showProductAssortment());
		TextArea text4 = new TextArea(showProductAssortment());
		
		Button button1 = new Button("Bubble_Preis");
		Button button2 = new Button("Kategorien");
		Button button3 = new Button("");
		Button button4 = new Button("");
		
		// optical adjustments
		scroll1.setContent(text1);
		scroll2.setContent(text2);
		scroll3.setContent(text3);
		scroll4.setContent(text4);
		
		text1.setPrefWidth(250);
		text2.setPrefWidth(250);
		text3.setPrefWidth(250);
		text4.setPrefWidth(250);
		
		text1.setPrefHeight(250);
		text2.setPrefHeight(250);
		text3.setPrefHeight(250);
		text4.setPrefHeight(250);
		
		root.setCenter(grid);
		grid.add(scroll1, 0, 0);
		grid.add(scroll2, 1, 0);
		grid.add(scroll3, 2, 0);
		grid.add(scroll4, 3, 0);
		
		grid.add(button1, 0, 1);
		grid.add(button2, 1, 1);
		grid.add(button3, 2, 1);
		grid.add(button4, 3, 1);
		
		grid.setHgap(10);
		grid.setVgap(10);
		grid.setPadding(new Insets(10, 10, 10, 10));
		
		GridPane.setHgrow(scroll1, Priority.ALWAYS);
		GridPane.setHgrow(scroll2, Priority.ALWAYS);
		GridPane.setHgrow(scroll3, Priority.ALWAYS);
		GridPane.setHgrow(scroll4, Priority.ALWAYS);
		
		GridPane.setVgrow(scroll1, Priority.ALWAYS);
		GridPane.setVgrow(scroll2, Priority.ALWAYS);
		GridPane.setVgrow(scroll3, Priority.ALWAYS);
		GridPane.setVgrow(scroll4, Priority.ALWAYS);
		
		GridPane.setHalignment(button1, HPos.CENTER);
		GridPane.setHalignment(button2, HPos.CENTER);
		GridPane.setHalignment(button3, HPos.CENTER);
		GridPane.setHalignment(button4, HPos.CENTER);
		
		
		
		
		//action methods
		button1.setOnAction(e -> {
			
			int textLines = 0;
			try {
				textLines = InformationOrganizer.countLines();
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			Medicine[] meds = new Medicine[textLines];
			InformationOrganizer info = new InformationOrganizer();
			
			// get the informations from the textfile and save them in the array meds 
			for(int i = 0; i < 10; i++) {
				try {
					meds[i] = info.readMedicine();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			Medicine[] sorted = sortPrice(meds);
			String output = showProductAssortment(sorted);
			
			
			scroll1.setContent(new Text(output));
		});
		
		
		
		return root;
	}
	
	
	// gets Medicineobjects from the textfile and gives them back as one string
	public static String showProductAssortment() throws FileNotFoundException {
		InformationOrganizer info = new InformationOrganizer();
		StringBuilder sb = new StringBuilder();
		Medicine[] meds = new Medicine[10];
		
		// get the informations from the textfile and save them in the array meds 
		for(int i = 0; i < 10; i++) {
			meds[i] = info.readMedicine();
		}
		
		// bundle up the information from meds to one String
		for(int i = 0; i < meds.length; i++) {
			sb.append(meds[i].toString());
			sb.append("\n\n");
		}
		String output = sb.toString();
		
		InformationOrganizer.closeFile();
		
		return output;
	}
	
	
	public static String showProductAssortment(Medicine[] meds) {
		StringBuilder sb = new StringBuilder();
		
		// bundle up the information from meds to one String
				for(int i = 0; i < meds.length; i++) {
					sb.append(meds[i].toString());
					sb.append("\n\n");
				}
				String output = sb.toString();
				return output;
	}
	
	//
	//
	//search and sort algorythms
	//
	//
	
	//BubbleSort
	public static Medicine[] sortPrice(Medicine[] meds) {
		
		int n = meds.length;
		boolean swapped= false;
		
			do{
				swapped = false;
				for (int i=0; i<n-1; i++){
					if (meds[i].price > meds[i+1].price){
				        meds = swap(meds, i, i+1);
				        swapped = true;
				    }
				}
				n = n-1;
			} while (swapped);
		
		return meds;
	} 
	
	public static Medicine[] swap(Medicine[] meds, int x, int y) {
		
		Medicine med = meds[x];
		meds[x] = meds[y];
		meds[y] = med;
		
		return meds;
	}
	
	
}
