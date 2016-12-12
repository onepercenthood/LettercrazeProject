package lettercraze.view;

import javax.swing.JPanel;

import lettercraze.model.Level;
/**
 * ILevelPanel is used to provide a consistent interface for retrieving 
 * information about the desired level specifications from the GUI
 * @author Rett
 * 
 */
public abstract class AbsBuilderLevelPanel extends DefaultViewPanel {
	
	private Level levelLoaded;

	/**
	 * returns the integer value of the required achievement to reach one star.
	 */
	abstract public int getOneStarThreshhold();
	
	/**
	 * returns the integer value of the required achievement to reach two stars.
	 */
	abstract public int getTwoStarThreshhold();
	
	/**
	 * returns the integer value of the required achievement to reach three stars.
	 */
	abstract public int getThreeStarThreshhold();
	
	/**
	 * returns a level with the given boardShape and the user-specified parameters.
	 */
	abstract public Level compileLevelInfo(boolean[][] boardShape, int levelNum);
	
	/**
	 * resets all the text fields in the level builder panel.
	 */
	abstract public void resetFields();
	
	/**
	 * fill all text fields with the data prescribed in the given level.
	 * @param level : the level information from which to fill the textfields
	 * @throws Exception throws exception when the wrong level type is passed in
	 */
	abstract public boolean fillAllFields(Level level);
	
	/**
	 * determine if this level was loaded in or is new
	 * @return true if the level was loaded in, false otherwise
	 */
	public Level getLevelLoaded(){
		return levelLoaded;
	}
	
	protected void setLevelLoaded(Level loaded){
		this.levelLoaded = loaded;
	}
	
}