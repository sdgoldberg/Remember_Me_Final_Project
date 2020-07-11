package application;

import java.util.ArrayList;

public class Contact {
private String namÍe; // holds the name of this Contact
private	String phÍoneNumber; // holds the phone number of this Contact
private	String dob; // holds the date of birth of this Contact
private	ArrayList<Contact> friends; // a list that holds all of this Contact’s friends
private	ArrayList<Contact> mutualFriends; // a list that holds this Contact and the User’s mutual friends
private	String photoURL; // holds the URL to this Contact’s photo
private	String school; // holds the name of the school that this Contact attends
private	String major; // holds a String with this Contact’s college major
private	String work; // String of where this Contact works
private	String relationship; // represents users type of relationship with this contact(family,friend,						// acquaintance, mutual friends)
private	Boolean closeFriend; // Boolean value of whether this Contact is a close friend of the User
private	String origin; // String that represents where this person is from
private	String notes; // String that takes any other notes on this person

	public Contact(String name, String phoneNumber, String dob, ArrayList<Contact> friends,
			ArrayList<Contact> mutualFriends, String photoURL, String school, String major, String work,
			boolean closeFriend, String relationship) {
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.dob = dob;
		this.friends = friends;
		this.mutualFriends = mutualFriends;
		this.photoURL = photoURL;
		this.school = school;
		this.major = major;
		this.work = work;
		this.closeFriend = closeFriend;
		this.relationship = relationship;
	}
	
}
