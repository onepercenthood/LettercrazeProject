package lettercraze.view;


import lettercraze.model.Level;
/**
 * ILevelPanel is used to provide a consistent interface for retrieving 
 * information about the desired level specifications from the GUI
 * @author Everett
 * 
 */
public abstract class AbsBuilderLevelPanel extends DefaultViewPanel {
	
	/**
	 * level loaded to the builder. if no level was loaded: levelLoaded = null.
	 * */
	private Level levelLoaded;

	/**
	 * returns the integer value of the required achievement to reach one star.
	 * @return int
	 */
	abstract public int getOneStarThreshhold();
	
	/**
	 * returns the integer value of the required achievement to reach two stars.]
	 * @return int
	 */
	abstract public int getTwoStarThreshhold();
	
	/**
	 * returns the integer value of the required achievement to reach three stars.
	 * @return int
	 */
	abstract public int getThreeStarThreshhold();
	
	/**
	 * returns a level with the given boardShape and the user-specified parameters.
	 * @param boardShape as boolean[][]
	 * @param levelNum as int
	 * @return Level
	 */
	abstract public Level compileLevelInfo(boolean[][] boardShape, int levelNum);
	
	/**
	 * resets all the text fields in the level builder panel.
	 */
	abstract public void resetFields();
	
	/**
	 * fill all text fields with the data prescribed in the given level.
	 * @param level : the level information from which to fill the textfields.
	 * @return true if filled successfully, false otherwise
	 */
	abstract public boolean fillAllFields(Level level);
	
	/**
	 * checks if all the panels textfields are filled out.
	 * @return true if all the text fields are filled out correctly, false otherwise.
	 */
	abstract public boolean isFilledOut();
	
	/**
	 * determine if this level was loaded in or is new.
	 * @return true if the level was loaded in, false otherwise.
	 */
	public Level getLevelLoaded(){
		return levelLoaded;
	}
	
	/**
	 * sets levelLoaded to the given level.
	 * @param loaded : the level loaded into the builder for editing.
	 */
	protected void setLevelLoaded(Level loaded){
		this.levelLoaded = loaded;
	}
	
}
