package application;

import javafx.scene.layout.Pane;

public class LayoutManage extends Pane{
	private static ContactList contacts = new ContactList();
	private static ContactList recentsList = new ContactList();
	private static ContactList favorites = new ContactList();
	/**
	 * @return the contacts
	 */
	public static ContactList getContacts() {
		return contacts;
	}
	/**
	 * @param contacts the contacts to set
	 */
	public static void setContacts(ContactList contacts) {
		LayoutManage.contacts = contacts;
	}
	/**
	 * @return the recentsList
	 */
	public static ContactList getRecentsList() {
		return recentsList;
	}
	/**
	 * @param recentsList the recentsList to set
	 */
	public static void setRecentsList(ContactList recentsList) {
		LayoutManage.recentsList = recentsList;
	}
	/**
	 * @return the favorites
	 */
	public static ContactList getFavorites() {
		return favorites;
	}
	/**
	 * @param favorites the favorites to set
	 */
	public static void setFavorites(ContactList favorites) {
		LayoutManage.favorites = favorites;
	}
	
}
