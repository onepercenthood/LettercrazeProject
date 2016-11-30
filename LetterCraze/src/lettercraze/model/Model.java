//Needs commenting and functions 

package lettercraze.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * The LetterCraze Model contains all the entity objects 
 * <p>
 * This class provides a top level entity class that can be used to 
 * to locate all entity objects by means of some relationship. 
 * It can be the view as a "container" for model elements 
 * <p>
 * Creation Data: (11/24/16 10:58 AM)
 * @author Hoodie
 */
public class Model {
	
	/** List of the BoardStates */
	protected ArrayList<BoardState> boardstate;
	
	/** List of all the levels stored in the Game */
	protected ArrayList<Level> level; 
	
	/** The Current Word being played */
	protected Word currentWord;
	
	/** HashTable of the frequency for each letter to appear [key = letter, object = frequency (Double)] */
	protected LinkedHashMap<String,Letter> letters = new LinkedHashMap<String,Letter>();

	
	/** Dictionary that stores all possible words that can be played */
	protected Dictionary possibleWords;
	
	/**
	 * Model Constructor
	 */
	public Model() {
		super();
		letters.put("A", new Letter("A", 2, 8.17)); 
		 letters.put("B", new Letter("B", 4, 1.49)); 
		 letters.put("C", new Letter("C", 3, 2.78)); 
		 letters.put("D", new Letter("D", 3, 4.25)); 
		 letters.put("E", new Letter("E", 1, 12.70)); 
		 letters.put("F", new Letter("F", 4, 2.23)); 
		 letters.put("G", new Letter("G", 4, 2.02)); 
		 letters.put("H", new Letter("H", 2, 6.09)); 
		 letters.put("I", new Letter("I", 2, 6.97)); 
		 letters.put("J", new Letter("J", 7, 0.15)); 
		 letters.put("K", new Letter("K", 5, 0.77)); 
		 letters.put("L", new Letter("L", 3, 4.03)); 
		 letters.put("M", new Letter("M", 3, 2.41)); 
		 letters.put("N", new Letter("N", 2, 6.75)); 
		 letters.put("O", new Letter("O", 2, 7.51)); 
		 letters.put("P", new Letter("P", 4, 1.93)); 
		 letters.put("R", new Letter("R", 2, 5.99)); 
		 letters.put("S", new Letter("S", 2, 6.33)); 
		 letters.put("T", new Letter("T", 1, 9.06)); 
		 letters.put("U", new Letter("U", 3, 2.76)); 
		 letters.put("V", new Letter("V", 5, 0.98)); 
		 letters.put("W", new Letter("W", 3, 2.36)); 
		 letters.put("X", new Letter("X", 7, 0.15)); 
		 letters.put("Y", new Letter("Y", 4, 1.97)); 
		 letters.put("Z", new Letter("Z", 8, 0.07)); 
		 letters.put("Qu", new Letter("Qu", 11, 0.10));	
	}
	
	// Get Functions 
	
	
	// Set Functions 
	
	/**
	 * Each solitaire game provides its own initialization routine.
	 * <p>
	 * By the time this method is called, the game is part of its Container.
	 */
	public void initialize(){
		initializeModel();
		initializeView(); 
		initializeControllers(); 
		
	}
	
	private void initializeModel(){
		
	}
	
	private void initializeView(){
		
	}
	
	private void initializeControllers(){

	}
	
	/**
	 * 
	 * @param bs
	 * @param played
	 * @return boolean true if the Move has been successfully played
	 * 	and a new BoardState 
	 */
	public boolean addMove(BoardState bs, Word played){
		return true ;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean undoMove(){
		return false;
	}
	
	/**
	 * 
	 * @param levelNum
	 */
	public void intiateLevel(int levelNum){
		
	}

	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean addSelectedSquare(Square s){
		return true;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean removeSelectedSquare( Square s){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean clearCurrentWord(){
		return true;
	}
	
	/**
	 * 
	 * @param w
	 * @return
	 */
	public boolean checkPlayedWord(Word w){
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isBeaten(){
		return true;
	}
	
}


