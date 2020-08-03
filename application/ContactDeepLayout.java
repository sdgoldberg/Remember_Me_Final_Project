package application;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class ContactDeepLayout extends BorderPane{
	private Contact person;
	private Image star;
	private MainLayout mainlayout;
	private Stage stage;
	private static final int WINDOW_WIDTH = 1200;
	private static final int WINDOW_HEIGHT = 700;
  //ImageView
	private ImageView starImage = new ImageView();
	
	//ScrollPane
	ScrollPane scroll;
	//layout
	private HBox h;
	private VBox v;
	private MainLayout mainLayout;
	private BorderPane bor;
	private HBox controls;
	private VBox fileDirect;
	//Images
	private Image filledStar = new Image(getClass().getResource("goldStarFilled.png").toExternalForm());
	private Image unfilledStar = new Image(getClass().getResource("starUnfilled.png").toExternalForm());
	private Image picture;
	private ImageView profilePic;
	//Labels
	private Label name;
	private Label phoneNumber;
	private Label dob;
	private Label school;
	private Label major;
	private Label work;
	private Label relationship;
	private Label origin;
	private Label notes;
	private Label currentFile;
	//Buttons
	Button back;
	Button editContact;

	//EventHandlers
	private StarHandler change;
	
	public ContactDeepLayout(Contact p, MainLayout l, String fileName, Stage stage) {
		person = p;
		this.stage = stage;
		mainLayout = l;
//create a new VBox to format the ShallowContact	
		v = new VBox();
//insert profile picture into layout
		picture = new Image(person.getPhotoURL());
		profilePic = new ImageView(picture);
		profilePic.setFitWidth(300);
		profilePic.setPreserveRatio(true);
		profilePic.setSmooth(true);
		profilePic.setCache(true);
		v.getChildren().add(profilePic);
		
		name = new Label("Name: " + person.getName());
		name.setFont(new Font("Times New Roman", 30));
		phoneNumber = new Label("Phone: " + person.getPhoneNumber());
		phoneNumber.setFont(new Font("Times New Roman", 30));
		dob = new Label("Date of Birth: " + person.getDob());
		dob.setFont(new Font("Times New Roman", 30));
		school = new Label("School: " + person.getSchool());
		school.setFont(new Font("Times New Roman", 30));
		major = new Label("Major: " + person.getMajor());
		major.setFont(new Font("Times New Roman", 30));
		work = new Label ("Work: " + person.getWork());
		work.setFont(new Font("Times New Roman", 30));
		relationship = new Label("Relationship: " + person.getRelationship());
		relationship.setFont(new Font("Times New Roman", 30));
		origin = new Label("From: " + person.getOrigin());
		origin.setFont(new Font("Times New Roman", 30));
		notes = new Label("Notes: " + person.getNotes());
		notes.setFont(new Font("Times New Roman", 30));
	
		v.getChildren().addAll(name, phoneNumber, dob, school, major, work, relationship, origin, notes);
		v.setBorder((new Border(new BorderStroke(Color.valueOf("#9E9E9E"), BorderStrokeStyle.SOLID, CornerRadii.EMPTY, new BorderWidths(10), Insets.EMPTY))));
		if (person.getCloseFriend()) {
			starImage.setImage(filledStar);
		} else {
			starImage.setImage(unfilledStar);
		}
		bor = new BorderPane();
		starImage.setFitWidth(100);
		starImage.setPreserveRatio(true);
		starImage.setSmooth(true);
		starImage.setCache(true);
		change = new StarHandler(starImage);
		starImage.setOnMouseClicked(change);
		bor.setLeft(starImage);
		bor.setCenter(v);
		this.setLeft(mainLayout.getRecentScroll());
		this.setCenter(bor);
		
		//Add Control Buttons
		controls = new HBox(10);
		back = new Button("Back");
		BackHandler bh = new BackHandler(this);
		back.setOnAction(bh);
		editContact = new Button("Edit Contact");
		controls.getChildren().addAll(back, editContact);
		this.setBottom(controls);
		
		//add file information
		currentFile = new Label("Current File: " + fileName);
		currentFile.setFont(new Font("Times New Roman", 20));
		fileDirect = new VBox(10);
		fileDirect.getChildren().add(currentFile);
		this.setRight(fileDirect);
		this.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
	}

	/**
	 * @return the person
	 */
	public Contact getPerson() {
		return person;
	}

	/**
	 * @return the star
	 */
	public Image getStar() {
		return star;
	}

	/**
	 * this method changes the star Image when star is pressed
	 */
	public void changeStarImage() {
		if (starImage.getImage().equals(filledStar)) {
			starImage.setImage(unfilledStar);
		} else {
			starImage.setImage(filledStar);
		}
	}

	/**
	 * @return the picture
	 */
	public Image getPicture() {
		return picture;
	}

	/**
	 * @param picture the picture to set
	 */
	public void setPicture(Image picture) {
		this.picture = picture;
	}

	/**
	 * @return the name
	 */
	public Label getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(Label name) {
		this.name = name;
	}

	/**
	 * @return the phoneNumber
	 */
	public Label getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(Label phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the dob
	 */
	public Label getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(Label dob) {
		this.dob = dob;
	}

	/**
	 * @return the school
	 */
	public Label getSchool() {
		return school;
	}

	/**
	 * @param school the school to set
	 */
	public void setSchool(Label school) {
		this.school = school;
	}

	private class StarHandler implements EventHandler<MouseEvent> {
		ImageView star;

		public StarHandler(ImageView star) {
			this.star = star;
		}

		@Override
		public void handle(MouseEvent e) {
			if (star.getImage().equals(filledStar)) {
				star.setImage(unfilledStar);
				person.setCloseFriend(false);
				mainLayout.getFavorites().remove(person);
				int index = mainLayout.getContacts().getIndex(person);
				mainLayout.getContacts().get(index).setCloseFriend(false);
			} else {
				star.setImage(filledStar);
				person.setCloseFriend(true);
				mainLayout.getFavorites().insert(person);
				int index = mainLayout.getContacts().getIndex(person);
				mainLayout.getContacts().get(index).setCloseFriend(true);
			}

		}

	}
	private class BackHandler implements EventHandler<ActionEvent>{
		ContactDeepLayout contactDeep;
		private BackHandler(ContactDeepLayout contactDeep) {
			this.contactDeep = contactDeep;
		}
		@Override
		public void handle(ActionEvent e) {
			scroll = new ScrollPane(mainLayout);
			scroll.setBackground(new Background(new BackgroundFill(Color.WHITE, new CornerRadii(0), Insets.EMPTY)));
			Scene mainScene = new Scene(scroll, WINDOW_WIDTH, WINDOW_HEIGHT);
			stage.setScene(mainScene);
			stage.show();
		}
		
	}
}
