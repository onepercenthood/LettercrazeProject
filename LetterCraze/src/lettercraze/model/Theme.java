// Need to isCompleted method 

package lettercraze.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Theme specific level class
 * 
 * Creation Date (11/25/16 3:56 PM)
 * @author Hoodie
 *
 */
@JsonTypeName("Theme")
public class Theme extends Level{

	/** Holds the Theme Word/Phrase of the level */
	protected String themeCategory;

	/** Holds the targetWords needed to be found to complete the Level */
	protected ArrayList<String> targetWords = new ArrayList<String>();

	/*Default constructor necessary for Jackson deserialization*/
	public Theme(){};
	
	/**
	 * Constructor for Theme Level 
	 * 
	 * @param levelNum is the level number 
	 * @param theme is the theme word/phrase for the level 
	 * @param targetWords are the words needed to be found to compete the level
	 */
	public Theme(int levelNum, String theme, ArrayList<String> targetWords){
		super();
		this.levelNum = levelNum;
		this.levelType = "Theme";
		this.themeCategory = theme;
		this.targetWords = targetWords;

		// Determine star threshold based on the number of words required to find 
		int size = targetWords.size();
		this.starThreshold[0] = size - 2;
		this.starThreshold[1] = size - 1;
		this.starThreshold[2] = size;
	}

	@Override
	public String debugString(){
		String s = levelType + ", ";
		s = s + "Level Number: " + Integer.toString(levelNum) +",\n";
		s = s + "First Threshold: " + Integer.toString(starThreshold[0]) + ",";
		s = s + "Second Threshold: " + Integer.toString(starThreshold[1]) + ", ";
		s = s + "Third Threshold: " + Integer.toString(starThreshold[2]) + ", \n";
		s = s + "Target Words: ";
		for(String word: targetWords){
			s = s + word+", ";
		}
		s = s + "\n";
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

	public String getThemeCategory() {
		return themeCategory;
	}

	public ArrayList<String> getTargetWords() {
		return targetWords;
	}
	
	
	//	@Override
	//	public boolean isCompleted(int score) {
	//		// TODO Auto-generated method stub
	//		return false;
	//	}
}
