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
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MainLayout extends BorderPane {
	File file;
	Scanner scan;
	ContactList contacts = new ContactList();

	public MainLayout(String filename) throws FileNotFoundException {
		File file = new File(filename);
		scan = new Scanner(file);
//insert contacts from file into the list
		int count = 1;
		while (scan.hasNextLine()) {
			String infoStr = "" + scan.nextLine();
			String[] info = infoStr.split(",");
			Contact newContact = new Contact(info[1] + " " + info[0], info[2]);
			contacts.insert(newContact);
			System.out.print(count + " ");
			contacts.print();
			count++;
		}

		VBox rows = new VBox();
		HBox columns;
		int index = 0;
		while (index < contacts.size()) {
			columns = new HBox();
			int i = 0;
			while (i < 4 && index < contacts.size()) {
				ContactShallow lay = new ContactShallow(contacts.get(index));
				columns.getChildren().add(lay);
				index++;
				i++;
			}
			rows.getChildren().add(columns);
		}
		// Set the Buttons on the bottom of the screen
		Button add = new Button("Add Contact");
		Button remove = new Button("Remove Contact");
		Button close = new Button("Close Application");
		ComboBox filterBy = new ComboBox();
		Label filterLabel = new Label("Filter By");
		filterBy.getItems().addAll("Favorites", "Family", "Recent");
		HBox buttons = new HBox(10);
		buttons.getChildren().addAll(add, remove, close, filterLabel, filterBy);
		this.setBottom(buttons);
		this.setCenter(rows);
		//Set the header of this scene
		Label header = new Label("Contacts");
		header.setFont(new Font("Arial", 40));
		this.setTop(header);
		this.setAlignment(header, Pos.TOP_CENTER);
		//create a recents tab on the left
		VBox recent = new VBox(8);
		Label recents = new Label("      Recents           ");
		recents.setFont(new Font("Times New Roman", 30));
		this.setMargin(recents, new Insets(20));
		recent.getChildren().add(recents);
		this.setLeft(recent);
		this.setAlignment(recents, Pos.TOP_LEFT);
		VBox fileDirect = new VBox(10);
		Label currentFile = new Label("Current File: " + filename);
		Button changeFile = new Button("Select a Different Contact File");
		fileDirect.getChildren().addAll(currentFile, changeFile);
		fileDirect.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
		this.setRight(fileDirect);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));

	}
}
