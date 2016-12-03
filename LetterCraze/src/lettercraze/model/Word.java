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
	protected ArrayList<Letter> letters = new ArrayList<Letter>();
	
	/**
	 * Model Constructor 
	 * <p>
	 * A word needs at least one letter to exits.
	 * <p>
	 * @param l the first letter in the word to create a word instance 
	 */
	public Word(Letter l){
		letters.add(l);
	}
	
	public boolean addLetter(Letter l){
		letters.add(l);
		return true;
	}
	
	/**
	 * A word is only valid if it is at least 3 letters long and 
	 * 
	 * @return true if both conditions states above are met 
	 */
	public boolean isValid(){
		String word = this.getWordString();
		if(letters.size() >= 3 && WordTable.isWord(word)){ return true; }
		return false; 
	}
	/**
	 * A word has a value based on the letters it consist of
	 * <p> 
	 * @return the total calculated value of the word 
	 */
	public int calculateValue(){
		int wordScore = 0 ;
		int wordLength = letters.size();
		for(Letter l : letters){
			wordScore += l.getValue();
		}
		return wordScore * (wordLength-2);
	}
	
	/**
	 * Changes the ArrayList of Letters into a String 
	 * <p>
	 * @return a String object of the word 
	 */
	public String getWordString(){
		String wordString = "";
		for(Letter l : letters){
			wordString += l.getLetter();
		}
		return wordString;
	}
	

}

