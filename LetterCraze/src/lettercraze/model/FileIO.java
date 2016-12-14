package lettercraze.model;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
/**
 * FileIO handles all reading and writing the levels to disk functionality in order to save states of
 * Level progress and load game progress when launched. FileIO interacts with both the Builder and Player 
 * Application 
 * <p>
 * The file system for saving levels in LetterCraze consist of three different folders: A custom_levels folder
 * that holds all the custom levels made by a Player. A default_levels folder that holds the current state of 
 * the default levels played by a Player. A defaults_levels_orginal which holds the original state of all the 
 * default as if someone was running the game for the first time.
 * <p>
 * When someone makes progress on a level and the level is exited, the updated progress is saved to that Level's
 * file in the default_levels folder. In addition, if enough progress was made to unlock the next level, FileIO will
 * also write to the next Level. 
 * The same process is done when a custom level is played and progress is made except that all custom levels are
 * unlocked, so only a single custom level is written when exiting a level.
 * Finally, the default_levels_original is used when the ResetAllProgress button is pressed by the Player. The 
 * Application copies the files in this folder and overwrites the files in default_levels folder. 
 * 
 * @author Hoodie
 */
public class FileIO {
	/**
	 * Convert given level file to JSON file, stored in default_levels if levelNum <= 15, otherwise in custom_levels.
	 * Relies on Jackson annotations in Level and all 3 subclasses
	 * @param level as a Level
	 * @return True if level was sucessfully saves, false if there was a error
	 */
	public static boolean saveLevelToDisk(Level level){
		ObjectMapper mapper = new ObjectMapper();
		//for (Iterator<Level> i = levels.iterator(); i.hasNext(); ) {
			try {
				//currentLevel = i.next();
				if(level.getLevelNum() <= 9){
					mapper.writeValue(new File("default_levels/lettercraze_level0" + level.getLevelNum() + "_" + level.getLevelType() + ".json"), level);
				} else if(level.getLevelNum() <= 15){
					mapper.writeValue(new File("default_levels/lettercraze_level" + level.getLevelNum() + "_" + level.getLevelType() + ".json"), level);
				}
				else{
					mapper.writeValue(new File("custom_levels/lettercraze_level" + level.getLevelNum() + "_" + level.getLevelType() + ".json"), level);
				}
				
				System.out.println("Wrote file to disk");
				return true;
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
		//}
	}
	
	/**
	 * Convert all default levels from persistent JSON files to java objects stored in levels ArrayList.
	 * Default levels are stored in src/default_levels 
	 * @return ArrayList<Level>
	 */
	public static ArrayList<Level> loadDefaultLevelsFromDisk(){
		File levelFolder = new File("default_levels");
		File[] levelFiles = levelFolder.listFiles();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Level> levels = new ArrayList<Level>();
		    for (int i = 0; i < levelFiles.length; i++) {

		    	//convert JSON in file into level object and store in levels arraylist
		    	try {
		    		String name = levelFiles[i].getName();

		    		if((name.contains("Puzzle") || name.contains("puzzle")) && name.contains("lettercraze")){
		    			
		    			Level currentLevel = mapper.readValue(levelFiles[i], Level.class);
						levels.add(currentLevel);
						
		    		}else if((name.contains("Lightning") || name.contains("lightning")) && name.contains("lettercraze")){
		    			Lightning currentLevel = mapper.readValue(levelFiles[i], Lightning.class);
		    			levels.add(currentLevel);
						
		    		}else if((name.contains("Theme") || name.contains("theme")) && name.contains("lettercraze")){
		    			Theme currentLevel = mapper.readValue(levelFiles[i], Theme.class);
		    			levels.add(currentLevel);
		    		}else{
		    			//throw exception?
		    		}
					
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    return levels;
	}
	
	/**
	 * Convert all custom levels from persistent JSON files to java objects stored in levels ArrayList.
	 * Default levels are stored in src/custom_levels
	 * @return ArrayList<Level>
	 */
	public static ArrayList<Level> loadCustomLevelsFromDisk(){
		File levelFolder = new File("custom_levels");
		File[] levelFiles = levelFolder.listFiles();
		ObjectMapper mapper = new ObjectMapper();
		ArrayList<Level> levels = new ArrayList<Level>();
		    for (int i = 0; i < levelFiles.length; i++) {

		    	//convert JSON in file into level object and store in levels arraylist
		    	try {
		    		String name = levelFiles[i].getName();
		    		if((name.contains("Puzzle") || name.contains("puzzle")) && name.contains("lettercraze")){		    			
		    			Puzzle currentLevel = mapper.readValue(levelFiles[i], Puzzle.class);
						levels.add(currentLevel);
						
		    		}else if((name.contains("Lightning") || name.contains("lightning")) && name.contains("lettercraze")){
		    			Lightning currentLevel = mapper.readValue(levelFiles[i], Lightning.class);
		    			levels.add(currentLevel);
						
		    		}else if((name.contains("Theme") || name.contains("theme")) && name.contains("lettercraze")){
		    			Theme currentLevel = mapper.readValue(levelFiles[i], Theme.class);
		    			levels.add(currentLevel);
		    		}else{
		    			//throw exception?
		    		}
					
				} catch (JsonParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (JsonMappingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		    }
		    return levels;
	}
	
	/**
	 * Get the total number of levels in Default and Custom folders 
	 * @return Integer 
	 */
	public int getNumLevels(){
		File levelFolder = new File("levels");
		File[] levelFiles = levelFolder.listFiles();
		return levelFiles.length;
	}

	
	/**
	 * 
	 * Deletes an existing custom level
	 * @param oldLevel the level to delete
	 * @return boolean depending on if it was deleted
	 */
	public static boolean deleteExistingCustomLevel(Level oldLevel){
		File existingFile = new File("custom_levels/lettercraze_level" + oldLevel.getLevelNum() + "_" + oldLevel.getLevelType() + ".json");
		boolean result;
		result = existingFile.delete(); 
		
		return result;
	}
}
