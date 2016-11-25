package lettercraze.model;

import java.util.ArrayList;

abstract public class Level {
	
	/** Stores the level number */
	protected int levelNum; 
	
	/** Type of level (Puzzle, Lightning, or Theme) */
	protected String levelType;
	
	/** Active Squares in each level */
	protected boolean[][] boardShape[][];
	
	/** Stores the High Score for the level*/
	protected int highScore;
	
	/** Stores the required score to each each Star */
	protected ArrayList<Integer> starThreshold;
	
	/** True if level has been unlocked and available to be played */
	protected boolean isUnlocked;
	
	/**
	 * Default Constructor for Level subclasses 
	 */
	protected Level(){
		super() ;
	}

}
