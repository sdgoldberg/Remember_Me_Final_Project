package application;

import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class AddContactLayout extends BorderPane{
MainLayout mainLayout;
Stage stage;
	//Labels
	private Label addContact;
	private Label directions;
	private Label firstName;
	private Label lastName;
	private Label phoneNumber;
	private Label photoURL;
	private Label DOB;
	private Label month;
	private Label day;
	private Label year;
	private Label school;
	private Label major;
	private Label work;
	private Label closeFriend;
	private Label relationship;
//TextField
	private TextField firstNameInput;
	private TextField lastNameInput;
	private TextField phoneNumberInput;
	private TextField photoURLInput;
	private TextField schoolInput;
	private TextField majorInput;
	private TextField workInput;
//ComboBox
	private ComboBox<String> monthCombo;
	private ComboBox<String> dayCombo;
	private ComboBox<String> yearCombo;
	private ComboBox<String> closeFriendCombo;
	private ComboBox<String> relationshipCombo;
//HBox
	private HBox data; //holds all inputs and labels on left, picture on right
	private HBox firstNameBox;
	private HBox lastNameBox;
	private HBox phoneNumberBox;
	private HBox photoURLBox;
	private HBox DOBBox; //holds DOB and DOBCombos
		private HBox DOBMonthBox;
		private HBox DOBDayBox;
		private HBox DOBYearBox;
	private HBox schoolBox;
	private HBox majorBox;
	private HBox workBox;
	private HBox closeFriendBox;
	private HBox relationshipBox;
//VBox
	private VBox title;
	private VBox inputs;
	private VBox DOBCombos; 
//Image
	private String photoString;
	private Image picture;
	private ImageView picView;
//Button
	private Button enter;
	public AddContactLayout(Stage s) {
		stage = s;
		
		addContact = new Label("Add Contact");
		addContact.setFont(Font.font("Times New Roman", FontWeight.BOLD, 30));
		directions = new Label("Input the information in the boxes below. (Note: * = required) ");
		title = new VBox(5);
		title.getChildren().addAll(addContact, directions);
		this.setTop(title);
		AddContactLayout.setAlignment(title, Pos.TOP_CENTER);
		
		inputs = new VBox(8);
	//FirstName
		firstName = new Label("* First Name: ");
		firstNameInput = new TextField("");
		firstNameBox = new HBox(5);
		firstNameBox.getChildren().addAll(firstName,firstNameInput);
	//LastName
		lastName = new Label("* Last Name: ");
		lastNameInput = new TextField("");
		lastNameBox = new HBox(5);
		lastNameBox.getChildren().addAll(lastName, lastNameInput);
	//phoneNumber
		phoneNumber = new Label ("* Phone Number: ");
		phoneNumberInput = new TextField("");
		phoneNumberBox = new HBox(5);
		phoneNumberBox.getChildren().addAll(phoneNumber,phoneNumberInput);
	//PhotoURL
		photoURL = new Label("Photo Name: ");
		photoURLInput = new TextField("");
		photoURLBox = new HBox(5);
		photoURLBox.getChildren().addAll(photoURL, photoURLInput);
	//DOB
		DOB = new Label("DOB: ");
		//Month
			month = new Label("Month: ");
			monthCombo = new ComboBox<String>();
			monthCombo.getItems().addAll("", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
			monthCombo.setValue("");
			DOBMonthBox = new HBox(5);
			DOBMonthBox.getChildren().addAll(month, monthCombo);
		//Day
			day = new Label("Day: ");
			dayCombo = new ComboBox<String>();
			dayCombo.getItems().add("");
			for(int i = 1; i < 32; i++) {
				dayCombo.getItems().add("" + i);
			}
			dayCombo.setValue("");
			DOBDayBox  = new HBox(5);
			DOBDayBox.getChildren().addAll(day, dayCombo);
		//Year
			year = new Label("Year: ");
			yearCombo = new ComboBox<String>();
			yearCombo.getItems().add("");
			for(int i = 2020; i > 1899; i--) {
				yearCombo.getItems().add("" + i);
			}
			yearCombo.setValue("");
			DOBYearBox = new HBox(5);
			DOBYearBox.getChildren().addAll(year, yearCombo);
		DOBCombos = new VBox(5);
		DOBCombos.getChildren().addAll(DOBMonthBox, DOBDayBox, DOBYearBox);
		DOBBox = new HBox(5);
		DOBBox.getChildren().addAll(DOB, DOBCombos);
		
	//School
		school = new Label("School: ");
		schoolInput = new TextField("");
		schoolBox = new HBox(5);
		schoolBox.getChildren().addAll(school, schoolInput);
	//Major
		major = new Label("Major: ");
		majorInput = new TextField("");
		majorBox = new HBox(5);
		majorBox.getChildren().addAll(major, majorInput);
	//work
		work = new Label("Work: ");
		workInput = new TextField("");
		workBox = new HBox(5);
		workBox.getChildren().addAll(work, workInput);
	//CloseFriend
		closeFriend = new Label("Close Friend: ");
		closeFriendCombo = new ComboBox<String>();
		closeFriendCombo.getItems().addAll("Yes", "No");
		closeFriendCombo.setValue("No");
		closeFriendBox = new HBox(5);
		closeFriendBox.getChildren().addAll(closeFriend, closeFriendCombo);
	//Relationship
		relationship = new Label("Relationship: ");
		relationshipCombo = new ComboBox<String>();
		relationshipCombo.getItems().addAll("", "Family", "Friends", "Aquaintance", "Mutual Friends");
		relationshipCombo.setValue("");
		relationshipBox = new HBox(5);
		relationshipBox.getChildren().addAll(relationship, relationshipCombo);
	//Enter
		enter = new Button("Enter");
		enter.setOnAction(new EnterNewHandler());
	inputs.getChildren().addAll(firstNameBox, lastNameBox, phoneNumberBox, photoURLBox, DOBBox, schoolBox, majorBox, workBox, closeFriendBox, relationshipBox, enter);
	//Image
		photoString = getClass().getResource("defaultPic.png").toExternalForm();
		picture = new Image(photoString);
		picView = new ImageView(picture);
		picView.setFitWidth(300);
		picView.setPreserveRatio(true);
		picView.setSmooth(true);
		picView.setCache(true);
	data = new HBox(5);
	data.getChildren().addAll(inputs, picView);
	data.setPadding(new Insets(20,20,20,20));
	this.setCenter(data);
	}
	private class EnterNewHandler implements EventHandler<ActionEvent>{
		private String firstNameStr;
		private String lastNameStr;
		private String name;
		private String phoneNumberStr;
		private String photoURLStr;
		private String DOBStr;
		private String schoolStr;
		private String majorStr;
		private String workStr;
		private boolean closeFriendBool;
		private String relationshipStr;
		private Contact newContact;
	
		@Override
		public void handle(ActionEvent e) {
			firstNameStr = firstNameInput.getText();
			lastNameStr = lastNameInput.getText();
			name = firstNameStr + " " + lastNameStr;
			phoneNumberStr = phoneNumber.getText();
			try {
			if(!photoURLInput.equals("")) {
			photoURLStr = photoURLInput.getText();
			}
			}catch(Exception e2) {
				photoURLStr = "defaultPic.png";
			}
			if(monthCombo.getValue().equals("") && dayCombo.getValue().equals("") && yearCombo.getValue().equals("")) {
				DOBStr = "";
			}else {
			DOBStr = monthCombo.getValue() + "/" + dayCombo.getValue() + "/" + yearCombo.getValue();
		}
			schoolStr = schoolInput.getText();
			majorStr = majorInput.getText();
			workStr = workInput.getText();
			closeFriendBool = false;
			if(closeFriendCombo.getValue().toLowerCase().equals("yes")) {
				closeFriendBool = true;
			}
			relationshipStr = relationshipCombo.getValue();
			if(firstNameStr.equals("") && lastNameStr.equals("") || phoneNumberStr.equals("")) {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setContentText("Please Input a proper name and Phone Number.");
				alert.show();
			}else {
				newContact = new Contact(name, phoneNumberStr, photoURLStr);
				newContact.setDob(DOBStr);
				newContact.setSchool(schoolStr);
				newContact.setMajor(majorStr);
				newContact.setWork(workStr);
				newContact.setCloseFriend(closeFriendBool);
				newContact.setRelationship(relationshipStr);
				LayoutManage.getContacts().insert(newContact);
				try {
				mainLayout = new MainLayout(LayoutManage.getFileName(), stage);
				}catch(Exception e1) {
					System.out.println("An unexpected Errror Occured");
				}
				Scene mainScene = new Scene(mainLayout, stage.getWidth(), stage.getHeight());
				stage.setScene(mainScene);
				stage.show();
			}
			
		}
	}
}
