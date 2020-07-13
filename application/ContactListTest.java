package application;

import static org.junit.jupiter.api.Assertions.fail;

public class ContactListTest {

public static void main(String []args) {
	System.out.println("Input_Multiple_Contacts(): " +  Input_Multiple_Contacts());
}
public static boolean Input_Multiple_Contacts() {
	ContactList ds = new ContactList();
	String name = "John Doe";
	String phoneNumber = "000-000-0000";
	String pic = "defaultPic.png";
	
	for(int i = 0; i < 25; i++) {
		try {
		Contact person = new Contact (name + i, phoneNumber, pic);
		ds.insert(person);}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
			return false;
		}
	}
	if(ds.size() != 5) {
		return false;
	}
	for(int i = 0; i < ds.size(); i++) {
		try{
			ds.get(i);
		}catch(IndexOutOfBoundsException e) {
			return false;
		}
	}
	return true;
}
}