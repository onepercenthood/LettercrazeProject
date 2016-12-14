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

	/**
	 * adds the givens square to the word
	 * @param s : the square to be added
	 * @return true if the square was added successfully, false otherwise
	 */
	public boolean addSquare(Square s){
		letters.add(s);
		return true;
	}

	/**
	 * remove the most recent square from the word
	 * @return true if the square was removed successfully, false otherwise
	 */
	public boolean removeSquare(){
		if(letters.isEmpty()){
			return false;
		}else {
			letters.remove(getWordLength()-1);
		}
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
	 * returns true if this word is in the given list of target words.
	 * @param targetWords : the list of allowed words in a theme level.
	 * @return true if the word is in the list, false otherwise.
	 */
	public boolean isValid (ArrayList<String> targetWords){
		String word = this.getWordString();
		for(String s: targetWords){
			String use = s.toUpperCase();
			System.out.println("Comparing " + word + " to target: " + use); 
			if(use.equals(word)){
				return true;
			}
		}
		return false;
	}
	/**
	 * A word has a value based on the letters it consist of.
	 * <p> 
	 * @return the total calculated value of the word .
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
	 * Changes the ArrayList of Letters into a String.
	 * <p>
	 * @return a String object of the word 
	 */
	public String getWordString(){
		String wordString = "";

		for(Square s : letters){
			if(null == s.getLetter()){
				//					return wordString += "_";
				wordString += "_";
			}
			else{
				wordString += s.getLetter().getLetter();
			}
		}
		return wordString;
	}

	/**
	 * returns the square at the end of the word.
	 * @return the square at the end of the word.
	 */
	public Square getLastSquare(){
		Square lastSquare = this.letters.get(letters.size() - 1);
		return lastSquare;
	}

	/**
	 * returns all the squares in the word (they contain the letters)
	 * @return ArrayList<Square>
	 */
	public ArrayList<Square> getLetters(){
		return this.letters;
	}

	/**
	 * returns the number of characters in the word
	 * @return int
	 */
	public int getWordLength(){
		int length = this.letters.size();
		return length;
	}

	/**
	 * gets the specified square in the word
	 * @param num as int
	 * @return Square
	 */
	public Square getCertainSquare(int num){
		Square retSquare = this.letters.get(num - 1);
		return retSquare;
	}

	/**
	 * returns a deep copy of this word, with no common objects in the copy.
	 * @return Word
	 */
	public Word copyWord(){
		Word copy = new Word(new Square(0, 0));
		copy.removeSquare();
		for(Square s: this.letters){
			copy.addSquare(s.copySquare());
		}
		return copy;
	}


}

