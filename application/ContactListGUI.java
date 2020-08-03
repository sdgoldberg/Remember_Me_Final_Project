//////////////// FILE HEADER//////////////////////////////////////////////
//
// Title: HelloFX
// Files:  MainLayout.java, ContactListGUI.java, ContactListADT.java,ContactListTest.java, ContactShallow.java, MainLayout.java, TestInputTxt.java
// Course:  CS 400, Summer, 2020
// Lecture: 002
// Author:  Sam Goldberg
// Email:   sdgoldberg@wisc.edu
// Lecturer's Name: Florian Heimerl
//
//////////////////////////////////////////////////////////////////////////////
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ContactListGUI extends Application {
	ContactList contacts = new ContactList();
	private static final int WINDOW_WIDTH = 1200;
	private static final int WINDOW_HEIGHT = 700;
	private static final String APP_TITLE = "Remember Me?";
//Scenes
	Scene fileScene;
	Scene mainScene;
//Labels
	Label fileError = new Label("File could not be found, please enter a diffeent file name");
//TextFields
	TextField fileInput;
//Strings
	String filename;
//Layouts
	MainLayout mainLayout;
	BorderPane mainFileLayout;
	ScrollPane scroll;
//Stages
	Stage primary;

	@Override
	public void start(Stage pStage) throws Exception {
		primary = pStage;
//////////////////////////////////
//File Input Scene
/////////////////////////////////
		mainFileLayout = new BorderPane();
		HBox filePrompt = new HBox(8);
		VBox directions = new VBox(8);
		Label directionsLabel = new Label("Directions");
		Label instructions = new Label(
				"  Please enter the name of your input file below. The input file Should be a text file with the following CSV Format"
						+ "\n  Last Name, First Name, Phone Number. \n  Please click Enter after typing the file name to see your contact list.");
		directionsLabel.setFont(new Font("Times New Roman", 20));
		instructions.setFont(new Font("Times New Roman", 15));
		directions.getChildren().addAll(directionsLabel, instructions);
		Label fileLabel = new Label("Input File Name Here (must be a CSV file)");
		fileLabel.setFont(new Font("Times New Roman", 20));
		fileInput = new TextField("input.txt");
		filePrompt.getChildren().addAll(fileLabel, fileInput);
		mainFileLayout.setTop(directions);
		mainFileLayout.setCenter(filePrompt);
		mainFileLayout.setAlignment(directions, Pos.TOP_CENTER);
		mainFileLayout.setAlignment(filePrompt, Pos.CENTER);
		Button enter = new Button("Enter");
		EnterHandler eh = new EnterHandler();
		enter.setOnAction(eh);
		filePrompt.getChildren().add(enter);
		mainFileLayout.setBottom(fileError);
		fileError.setVisible(false);
		mainFileLayout.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
		fileScene = new Scene(mainFileLayout, 800, 200);
		
/////////////////////////////////////////////
//main Scene with ContactShallow list
////////////////////////////////////////////
		// BorderPane is the main layout of the mainScene

		pStage.setTitle(APP_TITLE);
		pStage.setScene(fileScene);
		pStage.show();
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	private class EnterHandler implements EventHandler<ActionEvent> {

		/*
		 * Stage s; private EnterHandler(Stage s) { this.s = s; }
		 */
		@Override
		public void handle(ActionEvent e) {
			fileError.setVisible(false);
			filename = fileInput.getText();
			try {
				mainLayout = new MainLayout(filename, primary);
			} catch (FileNotFoundException e1) {
				fileError.setVisible(true);
			}
			scroll = new ScrollPane(mainLayout);
			scroll.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
			mainScene = new Scene(scroll, WINDOW_WIDTH, WINDOW_HEIGHT);
			primary.setScene(mainScene);
			primary.show();
		}

	}
}
