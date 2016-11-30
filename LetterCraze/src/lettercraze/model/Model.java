//Needs commenting and functions 

package lettercraze.model;

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
	protected ArrayList<BoardState> boardstates;
	
	/** List of all the levels stored in the Game */
	protected ArrayList<Level> levels; 
	
	/** The Current Word being played */
	protected Word currentWord;

	
	/** Dictionary that stores all possible words that can be played */
	protected Dictionary possibleWords;
	
	/**
	 * Model Constructor
	 */
	public Model() {
		super();
		levels = new ArrayList<Level>();
		boolean[][] sampleShape = new boolean[6][6];
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				sampleShape[row][col] = true;
			}
		}
		Puzzle level1 = new Puzzle(1, new int[]{1, 2, 3} , 10);
		level1.setBoardShape(sampleShape);
		level1.setUnLocked(true);
		levels.add(level1);	
	}
	
	// Get Functions 
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

		boardstates.add(new BoardState(levels.get(levelNum - 1).getBoardShape()));
		
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


