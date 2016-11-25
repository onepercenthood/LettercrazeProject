// Done 

package lettercraze.model;

import java.util.ArrayList;

/**
 * Models a word that is a collection of Letter values 
 * <p>
 * Each word must have at least one word to exist 
 * <p>
 * Creation Date: (11/24/16 10:59 AM)
 * @author Hoodie
 *
 */
public class Word {
	
	/** An Array List to track all the letters contained in a word */
	protected ArrayList<Letter> letter = new ArrayList<Letter>();
	
	/**
	 * Model Constructor 
	 * <p>
	 * A word needs at least one letter to exits.
	 * <p>
	 * @param l the first letter in the word to create a word instance 
	 */
	public Word(Letter l){
		letter.add(l);
	}
	
	/**
	 * A word has a value based on the letters it consist of
	 * <p> 
	 * @return the total calculated value of the word 
	 */
	public int calculateValue(){
		return 0 ;
	}
	
	/**
	 * Changes the ArrayList of Letters into a String 
	 * <p>
	 * @return a String object of the word 
	 */
	public String getWordString(){
		return "";
	}
	

}

