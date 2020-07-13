package application;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class ContactListGUI extends Application {
ContactList contacts = new ContactList();
private static final int WINDOW_WIDTH = 1000;
private static final int WINDOW_HEIGHT = 600;
private static final String APP_TITLE = "Remember Me?";

	@Override
	public void start(Stage pStage) throws Exception {
//main Scene with ContactShallow list
	//BorderPane is the main layout of the mainScene
	BorderPane root = new BorderPane();
	String picURL = "defaultPic.png";
	int personNumber = 0;

  
	for(int i = 0; i < 25; i++) {
		System.out.println("John Doe " + i);
      contacts.insert(new Contact("John Doe " + i, "000-000-0000", picURL));
	  contacts.print();
	   personNumber++;
   }
   VBox rows = new VBox();
   HBox columns;
   
   
 int index = 0;
	while(index < contacts.size()) {
		columns = new HBox();
	for(int i = 0; i < 5; i++) {
		ContactShallow lay = new ContactShallow(contacts.get(index));
		columns.getChildren().add(lay);
		index++;
	}
	rows.getChildren().add(columns);
	}
	
	//Set the Buttons on the bottom of the screen
	Button add = new Button("Add Contact");
	Button remove = new Button("Remove Contact");
	Button close = new Button("Close");
	HBox buttons = new HBox(10);
	buttons.getChildren().addAll(add, remove, close);
	root.setBottom(buttons);
	root.setCenter(rows);
	Label header = new Label("Contacts");
	header.setFont(new Font("Arial", 40));
	root.setTop(header);
	root.setAlignment(header, Pos.TOP_CENTER);
	ScrollPane scroll = new ScrollPane(root);
	Scene mainScene = new Scene(scroll, WINDOW_WIDTH, WINDOW_HEIGHT);

	
	
	pStage.setTitle(APP_TITLE);
	pStage.setScene(mainScene);
	pStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
launch(args);
	}

}
