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
	protected ArrayList<BoardState> boardStates = new ArrayList<BoardState>();;
	
	/** List of all the levels stored in the Game */
	protected ArrayList<Level> levels = new ArrayList<Level>(); 
	
	/** The Current Word being played */
	protected Word currentWord;

	/** Dictionary that stores all possible words that can be played */
	protected WordTable possibleWords;
	
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
		
		boolean[][] sampleShape = new boolean[6][6];
		boolean active = true;
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				sampleShape[row][col] = active;
				//active = !active;
			}
			//active = !active;
		}
		Puzzle level1 = new Puzzle(1, new int[]{1, 2, 3} , 10);
		level1.setBoardShape(sampleShape);
		level1.setUnLocked(true);
		levels.add(level1);	
		initiateLevel(1);
	}
	
	// Get Functions 
	/**
	 * 
	 * Return last board state in array list
	 * @return level corresponding to the given level number
	 */
	public BoardState getCurrentBoardState(){
		return boardStates.get(boardStates.size() - 1);
	}
	
	public void setCurrentBoardState(BoardState board){
		this.boardStates.add(board);
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
	public boolean addMove(BoardState bs, TestWord played){
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
		BoardState newState = new BoardState(levels.get(levelNum - 1).getBoardShape());
		boardStates.add(newState);
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
	public boolean checkPlayedWord(TestWord w){
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


