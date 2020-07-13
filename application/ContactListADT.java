package application;

public interface ContactListADT <T extends Comparable<T>>{

//inserts an element into the data structure in alphabetical order
	//if element is already in the data structure an IllegalArgumentException is thrown
    void insert(T addition);
    
    // If T is found, Removes the key from the data structure and decreases size
    // If T is null, throws IllegalArgumentException("null key") without decreasing size
    // If T is not found, returns false.
    boolean remove(T removeMe);

//gets the index of the object in the list
    int getIndex(T findMe);

//returns true if object is in the data structure and false otherwise
    boolean contains(T object);

    // Returns the number of elements in the data structure
    int size();
    
   //return the contact at the given index
    T get(int index);

}
