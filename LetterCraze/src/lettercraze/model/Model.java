//Needs commenting and functions 

package lettercraze.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The LetterCraze Model contains all the entity objects 
 * <p>
 * This class provides a top level entity class that can be used to 
 * to locate all entity objects by means of some relationship. 
 * It can be the view as a "container" for model elements 
 * <p>
 * @author Hoodie
 */
public class Model {
	
	/** List of the BoardStates */
	protected BoardState boardState;
	
	/** List of all the levels stored in the Game */
	protected ArrayList<Level> levels = new ArrayList<Level>(); 
	
	/** The Current Word being played */
	protected Word currentWord;

	/** Dictionary that stores all possible words that can be played */
	protected WordTable possibleWords;
	
	protected int currentLevel;

	/**
	 * Model Constructor
	 */
	public Model() {
		super();
		
		// Create Dictionary 
		try {
			WordTable.loadWordTable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
				
		levels = FileIO.loadDefaultLevelsFromDisk();
		System.out.println(levels);
		//initiateLevel(1);
		ArrayList<Level> custom = new ArrayList<Level>();
		custom = FileIO.loadCustomLevelsFromDisk();
		levels.addAll(custom);
		System.out.println(levels);
		//initiateLevel(1);
		
	}
	
	// Get Functions 
	/**
	 * 
	 * Return last board state in array list
	 * @return level corresponding to the given level number
	 */
	public BoardState getCurrentBoardState(){
		return boardState;
	}
	
	public void setCurrentBoardState(BoardState board){
		this.boardState = board;
		
	}

	
	/**
	 * 
	 * @return the entire levels arraylist
	 */
	public ArrayList<Level> getAllLevels(){
		return levels;
	}
	
	
	/**
	 * 
	 * @param int levelNum
	 * @return level corresponding to the given level number
	 */
	public Level getLevel(int levelNum){
		return levels.get(levelNum - 1);
	}
	
	// Set Functions 
	
	
	
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
	 * Set up a new initial boardstate from a given level.
	 * for the first deliverable, this is using the sample level 1
	 * @param levelNum
	 */
	public void initiateLevel(int levelNum){
		
		//simple sample shape with a 6x6 grid
		System.out.println("value of level 0: "  + levels.get(0));
		//BoardState newState = new BoardState(levels.get(levelNum - 1).getBoardShape());
		BoardState newState = new BoardState(levels.get(levelNum - 1));
		boardState = newState;
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
	public boolean removeSelectedSquare(Square s){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public Word getCurrentWord(){
		return this.currentWord;
	}
	
	public void setCurrentWord(Word wordIn){
		this.currentWord = wordIn;
	}
	
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
	
	public int getCurrentLevel(){
		return this.currentLevel + 1;
	}
	
	public Level getCurrentLevelObject(){
		return levels.get(currentLevel);
	}
	
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel - 1;
	}
}


