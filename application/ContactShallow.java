package application;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class ContactShallow extends Pane{
Contact person;
Image star;
ImageView starImage = new ImageView();
HBox h;
VBox v;
Image picture;
ImageView profilePic;
Label name;
Label phoneNumber;
Label dob;
Image filledStar = new Image(getClass().getResource("goldStarFilled.png").toExternalForm());
Image unfilledStar = new Image(getClass().getResource("starUnfilled.png").toExternalForm());
StarHandler change;
public ContactShallow (Contact p) {
	person = p;
//create orderPane layout
	BorderPane bor = new BorderPane();
//create a new VBox to format the ShallowContact	
	 v = new VBox();
//insert profile picture into layout
	picture = new Image(person.getPhotoURL());
    profilePic = new ImageView(picture);
	profilePic.setFitWidth(100);
	profilePic.setPreserveRatio(true);
	profilePic.setSmooth(true);
	profilePic.setCache(true);
	v.getChildren().add(profilePic);
	
	name = new Label("Name: " + person.getName());
	phoneNumber = new Label("Phone: " + person.getPhoneNumber());
	dob = new Label("Date of Birth: " + person.getDob());
	v.getChildren().addAll(name, phoneNumber, dob);
	if(person.getCloseFriend()) {
		starImage.setImage(filledStar);
	}else {
		starImage.setImage(unfilledStar);
	}
	starImage.setFitWidth(40);
	starImage.setPreserveRatio(true);
	starImage.setSmooth(true);
	starImage.setCache(true);
	change = new StarHandler(starImage);
	starImage.setOnMouseClicked(change);
	bor.setLeft(starImage);
	bor.setCenter(v);
	this.getChildren().add(bor);
}
/**
 * @return the person
 */
public Contact getPerson() {
	return person;
}
/**
 * @param person the person to set
 */
public void setPerson(Contact person) {
	this.person = person;
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
if(starImage.getImage().equals(filledStar)) {
	starImage.setImage(unfilledStar);
}else {
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
private class StarHandler implements EventHandler <MouseEvent>{
ImageView star;
public StarHandler(ImageView star) {
	this.star= star;
}
	@Override
	public void handle(MouseEvent e) {
		if(star.getImage().equals(filledStar)) {
			star.setImage(unfilledStar);
		}else {
			star.setImage(filledStar);
		}
		
	}
	
}
}

