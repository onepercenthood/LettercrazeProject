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
	private ArrayList<Square> letters = new ArrayList<Square>();

	/**
	 * Model Constructor 
	 * <p>
	 * A word needs at least one letter to exits.
	 * <p>
	 * @param s the first letter in the word to create a word instance 
	 */
	public Word(Square s){
		letters.add(s);
	}

	public boolean addSquare(Square s){
		letters.add(s);
		return true;
	}

	public boolean removeSquare(){
		letters.remove(getWordLength()-1);
		return true;
	}

	/**
	 * A word is only valid if it is at least 3 letters long and 
	 * 
	 * @return true if both conditions states above are met 
	 */
	public boolean isValid(){
		String word = this.getWordString();
		System.out.println(WordTable.wordTable);
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
		for(Square s : letters){
			wordScore += s.getLetter().getValue();
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
			for(Square s : letters){
				if(s.getLetter() == null){
					return wordString += "_";
				}
				else{
				wordString += s.getLetter().getLetter();
				}
			}
			return wordString;
	}

	public Square getLastSquare(){
		Square lastSquare = this.letters.get(letters.size() - 1);
		return lastSquare;
	}

 
	public int getWordLength(){
		int length = this.letters.size();
		return length;
	}

	public Square getCertainSquare(int num){
		Square retSquare = this.letters.get(num - 1);
		return retSquare;
	}


}

