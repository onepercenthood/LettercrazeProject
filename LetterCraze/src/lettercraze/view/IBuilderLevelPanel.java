package lettercraze.view;

import lettercraze.model.Level;
/**
 * ILevelPanel is used to provide a consistent interface for retrieving 
 * information about the desired level specifications from the GUI
 * @author Rett
 * 
 */
public interface IBuilderLevelPanel {

	/*
	 * returns the integer value of the required achievement to reach one star
	 */
	public int getOneStarThreshhold();
	
	/*
	 * returns the integer value of the required achievement to reach two stars
	 */
	public int getTwoStarThreshhold();
	
	/*
	 * returns the integer value of the required achievement to reach three stars
	 */
	public int getThreeStarThreshhold();
	
	/*
	 * returns a level with the parameters as specified from user inputs
	 */
	public Level makeLevelFromInputs();
	
}
