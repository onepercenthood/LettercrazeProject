//Need to do isCompleted Method

package lettercraze.model;

/**
 * Puzzle specific level class 
 * 
 * Creation Date (11/25/16 3:08 PM)
 * @author Hoodie
 *
 */
public class Puzzle extends Level{
	
	/** Holds the maximum number of Words the Player is allowed to play in this level */
	protected int maxWords;
	
	/**
	 * Constructor for a Puzzle Level 
	 * @param levelNum is the level number 
	 * @param starThreshold is a int[] of the threshold values to earn the 3 stars. Based on number of points
	 * @param maxMoves is the maximum number of words the Player is allowed to make 
	 */
	public Puzzle (int levelNum, int[] starThreshold, int maxWords){
		super();
		this.levelNum = levelNum;
		this.levelType = "Puzzle";
		this.starThreshold[0] = starThreshold[0];
		this.starThreshold[1] = starThreshold[1];
		this.starThreshold[2] = starThreshold[2];
		this.maxWords = maxWords;
	}

//	@Override
//	public boolean isCompleted(int score) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
