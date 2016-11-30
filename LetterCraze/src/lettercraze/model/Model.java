//Needs commenting and functions 

package lettercraze.model;

import java.util.ArrayList;
import java.util.Hashtable;

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
	protected Hashtable<String,Double> letterFrequency = new Hashtable<String,Double>();
	
	/** Dictionary that stores all possible words that can be played */
	protected Dictionary possibleWords;
	
	/**
	 * Model Constructor
	 */
	public Model() {
		super();
		
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


