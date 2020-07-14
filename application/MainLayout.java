package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class MainLayout extends BorderPane{
File file;
Scanner scan;
ContactList contacts = new ContactList();

public MainLayout() throws FileNotFoundException {
	File file = new File("input.txt");
	scan = new Scanner(file);
//insert contacts from file into the list
	int count = 1;
	while(scan.hasNextLine()) {
		String infoStr = scan.nextLine();
		String[] info = infoStr.split(",");
		Contact newContact = new Contact(info[1] +" " + info[0], info[2]);
		contacts.insert(newContact);
		System.out.print(count + " ");
		contacts.print();
		count++;
		}
	
   VBox rows = new VBox();
   HBox columns;
   int index = 0;
	while(index < contacts.size()) {
		columns = new HBox();
		int i = 0;
		while(i <5 && index < contacts.size()){
		ContactShallow lay = new ContactShallow(contacts.get(index));
		columns.getChildren().add(lay);
		index++;
		i++;
	}
	rows.getChildren().add(columns);
	}
	//Set the Buttons on the bottom of the screen

		Button add = new Button("Add Contact");
		Button remove = new Button("Remove Contact");
		Button close = new Button("Close");
		HBox buttons = new HBox(10);
		buttons.getChildren().addAll(add, remove, close);
		this.setBottom(buttons);
		this.setCenter(rows);
		Label header = new Label("Contacts");
		header.setFont(new Font("Arial", 40));
		this.setTop(header);
		this.setAlignment(header, Pos.TOP_CENTER);

}
}
