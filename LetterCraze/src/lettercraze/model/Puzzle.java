//Need to do isCompleted Method

package lettercraze.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Puzzle specific level class 
 * 
 * Creation Date (11/25/16 3:08 PM)
 * @author Hoodie
 *
 */

@JsonTypeName("Puzzle")
public class Puzzle extends Level{
	
	/** Holds the maximum number of Words the Player is allowed to play in this level */
	protected int maxWords;
	
	/**Default constructor necessary for Jackson deserialization*/
	public Puzzle(){};
	
	/**
	 * Constructor for a Puzzle Level 
	 * @param levelNum is the level number 
	 * @param starThreshold is a int[] of the threshold values to earn the 3 stars. Based on number of points
	 * @param maxWords is the maximum number of words the Player is allowed to make 
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

	@Override
	public String toString() {		
		return null;
	}

	/**
	 * 
	 * @return a string that shows the state of all the variables for use in debugging
	 */
	@Override
	public String debugString(){
		String s = levelType + ", ";
		s = s + "Level Number: " + Integer.toString(levelNum) +",\n";
		s = s + "First Threshold: " + Integer.toString(starThreshold[0]) + ",";
		s = s + "Second Threshold: " + Integer.toString(starThreshold[1]) + ", ";
		s = s + "Third Threshold: " + Integer.toString(starThreshold[2]) + ", \n";
		s = s + "Max Words: " + Integer.toString(maxWords) + ", \n";
		s = s + "Board Shape: \n";
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col ++){
				if(boardShape[row][col]){
					s = s + "[X]";
				} else {
					s = s + "[ ]";
				}
			}
			s = s + "\n";
		}
		return s;
	}

	/**
	 * sets the maximum allowed words to the given value
	 * @param maxWords as int
	 */
	public void setMaxWords(int maxWords) {
		this.maxWords = maxWords;
	}
	
	
	/**
	 * returns the maximum allowed number of words
	 * @return int
	 */
	public int getMaxWords() {
		return maxWords;
	}
	
//	@Override
//	public boolean isCompleted(int score) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
