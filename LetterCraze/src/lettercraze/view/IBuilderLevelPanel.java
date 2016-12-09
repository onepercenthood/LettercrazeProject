package lettercraze.view;

import lettercraze.model.Level;
/**
 * ILevelPanel is used to provide a consistent interface for retrieving 
 * information about the desired level specifications from the GUI
 * @author Rett
 * 
 */
public interface IBuilderLevelPanel {

	/**
	 * returns the integer value of the required achievement to reach one star.
	 */
	public int getOneStarThreshhold();
	
	/**
	 * returns the integer value of the required achievement to reach two stars.
	 */
	public int getTwoStarThreshhold();
	
	/**
	 * returns the integer value of the required achievement to reach three stars.
	 */
	public int getThreeStarThreshhold();
	
	/**
	 * returns a level with the given boardShape and the user-specified parameters.
	 */
	public Level compileLevelInfo(boolean[][] boardShape, int levelNum);
	
	/**
	 * resets all the text fields in the level builder panel.
	 */
	public void resetFields();
	
	/**
	 * fill all text fields with the data prescribed in the given level.
	 * @param level : the level information from which to fill the textfields
	 * @throws Exception throws exception when the wrong level type is passed in
	 */
	public void fillAllFields(Level level) throws Exception;
	
}
