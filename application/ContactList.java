package application;

import java.util.ArrayList;

public class ContactList implements ContactListADT<Contact> {
	private class ContactNode {
		private Contact person;
		private ContactNode next;
		private ContactNode previous;

		private ContactNode(Contact person) {
			this.person = person;
			next = null;
			previous = null;
		}

		/**
		 * @return the next
		 */
		public ContactNode getNext() {
			return next;
		}

		/**
		 * @param next the next to set
		 */
		public void setNext(ContactNode next) {
			this.next = next;
		}

		public boolean hasNext() {
			if (next != null) {
				return true;
			} else {
				return false;
			}
		}

		/**
		 * @return the previous
		 */
		public ContactNode getPrevious() {
			return previous;
		}

		/**
		 * @param previous the previous to set
		 */
		public void setPrevious(ContactNode previous) {
			this.previous = previous;
		}

		/**
		 * @return the person
		 */
		public Contact getPerson() {
			return person;
		}
	}

	private ContactNode root;
	private int size;

	public ContactList() {
		size = 0;
	}

	public ContactList(Contact root) {
		this.root = new ContactNode(root);
		size = 1;
	}

	/**
	 * inserts the contact into the ContactList 
	 * @param addition- the Contact to be inserted
	 * throws an IllegalArgumentException if addition == null or if Contact is already in the list
	 * 
	 */
	@Override
	public void insert(Contact addition) {
		if (addition == null) {
			throw new IllegalArgumentException("null contact");
		} else {
			ContactNode newNode = new ContactNode(addition);
			if (size == 0) {
				root = newNode;
				size++;
			} else {
				ContactNode current = root;
				boolean inserted = false;
				int i = 0;
				while (i < size && inserted == false) {
					if (current.getPerson().equals(addition)) {
						throw new IllegalArgumentException(
								"Person is already in this Contact List: cannot add duplicates");
					} else if ((current.getPerson()).compareTo(addition) > 0) {
						current.getPrevious().setNext(newNode);
						newNode.setNext(current);
						current.setPrevious(newNode);
						size++;
						inserted = true;
					} else if (current.getPerson().compareTo(addition) == 0) {
						current.getNext().setPrevious(newNode);
						newNode.setPrevious(current);
						current.setNext(newNode);
						size++;
						inserted = true;
					} else {
						if (!current.hasNext()) {
							current.setNext(newNode);
							newNode.setPrevious(current);
							size++;
						} else {
							current = current.getNext();
							i++;
						}
					}
				}
			}
		}
	}

	/**
	 * removes the Contact from the ContactList
	 * 
	 * @param removeMe the Contact to remove from the list
	 * @return true if contact is removed and false if contact is not found
	 */
	@Override
	public boolean remove(Contact removeMe) {
		if (size == 0) {
			return false;
		} else if (removeMe == null) {
			throw new IllegalArgumentException("null Contact");
		} else {
			ContactNode find = findNode(removeMe);
			if (find != null) {
				find.getPrevious().setNext(find.getNext());
				find.getNext().setPrevious(find.getPrevious());
				size--;
				return true;
			} else {
				return false;
			}
		}
	}

	private ContactNode findNode(Contact find) {
		ContactNode current = root;
		int i = 0;
		while (i < size) {
			if (current.getPerson().equals(find)) {
				return current;
			} else {
				current = current.getNext();
				i++;
			}
		}
		return null;

	}

	/**
	 * returns the position in the array of the Contact
	 * 
	 * @param findMe the Contact to find in the array
	 * @return the position of the Contact in the ContactList returns -1 if Contact
	 *         is not in list
	 */
	@Override
	public int getIndex(Contact findMe) {
		int i = 0;
		ContactNode current = root;
		while (i < size) {
			if (current.getPerson().equals(findMe)) {
				return i;
			} else {
				i++;
				current = current.getNext();
			}
		}
		return -1;
	}

	@Override
	public boolean contains(Contact con) {
		int index = this.getIndex(con);
		if(index == -1) {
			return false;
		}else {
			return true;
		}
	}
/**
 * 
 * @return the size of this ContactList
 */
	@Override
	public int size() {
		return size;
	}

}
