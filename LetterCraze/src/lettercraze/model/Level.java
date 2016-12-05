// Done 

package lettercraze.model;


/**
 * Abstract Level class. Serves as the superclass of all the different types
 * of levels in the LetterCraze game. 
 * <p>
 * Each subclass will have a specific method for determining how that type of level is
 * won along with a few level specific attributes to assist with setting up the level.
 * 
 * Creation Date: (11/25/16 3:05 PM)
 * @author Hoodie
 *
 */
abstract public class Level {
	
	/** Stores the level number */
	protected int levelNum; 
	
	/** Type of level (Puzzle, Lightning, or Theme) */
	protected String levelType;
	
	/** Active Squares in each level */
	protected boolean[][] boardShape;
	
	/** Stores the High Score for the level*/
	protected int highScore;
	
	/** Stores the required score to each each Star
	 * Puzzle = number of points
	 * Lightning = number of words 
	 * Theme = number of theme words found 
	 *  */
	protected int[] starThreshold = new int[3]; 
	
	/** True if level has been unlocked and available to be played */
	protected boolean isUnlocked;
	
	/**
	 * Default Constructor for Level subclasses 
	 */
	protected Level(){
		super();
		
	}
	
	
	/**
	 * Set the board shape to the 2D boolean array passed in.
	 * 
	 * @param boolean[6][6]
	 */
	public void setBoardShape(boolean[][] boardShape){
		this.boardShape = boardShape;
	}
	
	/**
	 * Return the 2D boolean array corresponding to the level's board shape.
	 * 
	 * @return boolean[6][6]
	 */
	public boolean[][] getBoardShape(){
		return this.boardShape;
	}
	
	
	 
	 
	/**
	 * Set the unlocked state of the level. True for unlocked, false for locked.
	 * 
	 * @param boolean
	 */
	public void setUnLocked(boolean unlocked){
		isUnlocked = unlocked;
	}
	
	
	/** Method to determine how a Player beats each level, varies per type of level */
	public boolean isCompleted(int score){
		if(score > this.starThreshold[0]){return true;}
		return false ;
	}
	
	/**
	 * If the score from the last played game by the Player is higher
	 * than the previous high score of the level just played. 
	 * 
	 * @param score is the score from the most recent round played by
	 * the Player 
	 */
	public void updateHighScore(int score){
		if(score > this.highScore){ this.highScore = score;}
	}
	
	/**
	 * Determines the number of Stars currently earned on the Level
	 * 
	 * @param score is either the current high score to determine the number of stars earned
	 * to display on the menu or the current score in a level the Player is currently playing.
	 * @return the number of stars the Player has earned based on the score
	 */
	public int getHighStars(int score){
		int stars = 0;
		if(score > this.starThreshold[0]) {stars = 1;}
		if(score > this.starThreshold[1]) {stars = 2;}
		if(score > this.starThreshold[2]) {stars = 3;}
		return stars;
	}
	
//	/**TODO
//	 * Converts the level to a string describing the values of each field
//	 */
//	public abstract String toString();

}
