package application;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ContactDeepLayout extends BorderPane{
	private Contact person;
	private Image star;
	private MainLayout mainlayout;
  //ImageView
	private ImageView starImage = new ImageView();
	//layout
	private HBox h;
	private VBox v;
	private MainLayout mainLayout;
	private BorderPane bor;
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

	//EventHandlers
	private StarHandler change;
	
	public ContactDeepLayout(Contact p, MainLayout l) {
		person = p;
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
		name.setFont(new Font("Times New Roman", 40));
		phoneNumber = new Label("Phone: " + person.getPhoneNumber());
		phoneNumber.setFont(new Font("Times New Roman", 40));
		dob = new Label("Date of Birth: " + person.getDob());
		dob.setFont(new Font("Times New Roman", 40));
		school = new Label("School: " + person.getSchool());
		school.setFont(new Font("Times New Roman", 40));
		major = new Label("Major: " + person.getMajor());
		major.setFont(new Font("Times New Roman", 40));
		work = new Label ("Work: " + person.getWork());
		work.setFont(new Font("Times New Roman", 40));
		relationship = new Label("Relationship: " + person.getRelationship());
		relationship.setFont(new Font("Times New Roman", 40));
		origin = new Label("From: " + person.getOrigin());
		origin.setFont(new Font("Times New Roman", 40));
		notes = new Label("Notes: " + person.getNotes());
		notes.setFont(new Font("Times New Roman", 40));
		
		v.getChildren().addAll(name, phoneNumber, dob, school, major, work, relationship, origin, notes);
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
		this.setLeft(mainLayout.getRecent());
		this.setCenter(bor);
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
			} else {
				star.setImage(filledStar);
				person.setCloseFriend(true);
				mainLayout.getFavorites().insert(person);
			}

		}

	}
}
