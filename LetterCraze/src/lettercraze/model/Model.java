//Needs commenting and functions 

package lettercraze.model;


import java.io.IOException;
import java.util.ArrayList;



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
	
	/** Number of the current level the model is using */ 
	protected int currentLevel;


	/**
	 * Model Constructor that holds all the entity objects. It creates the dictionary when the model \
	 * instance is made by the player application then loads in all the levels. 
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
	 * Return last board state in array list
	 * @return BoardState 
	 */
	public BoardState getCurrentBoardState(){
		return boardState;
	}
	
	/**
	 * Sets the model's current BoardState to the input BoardState
	 * @param board as a BoardState
	 */
	public void setCurrentBoardState(BoardState board){
		this.boardState = board;	
	}

	
	/**
	 * Get an ArrayList of all the levels 
	 * @return ArrayList<Level>
	 */
	public ArrayList<Level> getAllLevels(){
		return levels;
	}
	
	
	/**
	 * Get the Level Object corresponding to the input level number 
	 * @param levelNum as a Integer
	 * @return Level
	 */
	public Level getLevel(int levelNum){
		return levels.get(levelNum - 1);
	}
	
	// Set Functions 
	
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
	 * Get the Current Word 
	 * @return Word 
	 */
	public Word getCurrentWord(){
		return this.currentWord;
	}
	
	/**
	 * Set the Current Word
	 * @param wordIn as a Word 
	 */
	public void setCurrentWord(Word wordIn){
		this.currentWord = wordIn;
	}
	
	/**
	 * Get the Current Level 
	 * @return Integer
	 */
	public int getCurrentLevel(){
		return this.currentLevel + 1;
	}
	
	/**
	 * Get Current Level Object
	 * @return Level 
	 */
	public Level getCurrentLevelObject(){
		return levels.get(currentLevel);
	}
	
	/**
	 * Set Current Level
	 * @param currentLevel as an Integer 
	 */
	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel - 1;
	}
}


