// Need to isCompleted method 

package lettercraze.model;

import java.util.ArrayList;

/**
 * Theme specific level class
 * 
 * Creation Date (11/25/16 3:56 PM)
 * @author Hoodie
 *
 */
public class Theme extends Level{
	
	/** Holds the Theme Word/Phrase of the level */
	protected String themeCategory;
	
	/** Holds the targetWords needed to be found to complete the Level */
	protected ArrayList<String> targetWords = new ArrayList<String>();
	
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
		this.themeCategory = theme;
		this.targetWords = targetWords;
		
		// Determine star threshold based on the number of words required to find 
		int size = targetWords.size();
		this.starThreshold[0] = size - 2;
		this.starThreshold[1] = size - 1;
		this.starThreshold[2] = size;
	}

	@Override
	public boolean isCompleted(int score) {
		// TODO Auto-generated method stub
		return false;
	}
}
