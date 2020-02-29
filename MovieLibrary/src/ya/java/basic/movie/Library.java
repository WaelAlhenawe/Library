package ya.java.basic.movie;


import java.util.Collections;
import java.util.List;

/**
 * This interface is a general description of a Library holding any type of items, <T>
 * All methods are public abstract although not stated in the method signatures 
 *
 * @param <T> a placeholder for the specific type to store when implementing the interface
 */
public interface Library<T> {

	/**
	 * This routine should add an item of type T to the storage
	 * @param item the item to store
	 * @return a boolean true if item is stored, otherwise false
	 */
	boolean addItem(T item);

	/**
	 * This routine should remove an item of type T from the storage if available
	 * @param item the item to remove
	 * @return a boolean true if item is removed, otherwise false
	 */
	boolean removeItem(T item);
	
	/**
	 * This routine is responsible for keeping track of the number of items currently in storage
	 * @return an int holding the current no of items in library
	 */
	int getNoOfItems();
	
	/**
	 * This routine should present the entire contents of the library to console
	 */
	void showLibraryContents();
	
	/**
	 * This routine should store the entire contents of the library in a textfile, item by item
	 * @param filename a String defining the full name of the file to write to
	 */
	void storeItemsToTextfile(String filename);
	
	/**
	 * This routine should read data from a textfile and pass it on to the library
	 * @param filename a String defining the full name of the file to read from
	 */
	void readItemsFromTextfile(String filename);
	/**
	 * This routine should support searching within the library for specific data
	 * NB! The default implementation return an empty list to avoid using null  
	 */
	default List<T> searchItem(){return Collections.emptyList();}
	
	/**
	 * This routine provides a way to get hold of a single item from storage 
	 * NB! The default implementation return a null reference 
	 * @param a Movie reference if available
	 */
	default Movie getItem(int movieId) {return null;}
	
	}
