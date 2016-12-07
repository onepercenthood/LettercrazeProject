package lettercraze.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileIO {

	public void saveLevelToDisk(Level level){
		ObjectMapper mapper = new ObjectMapper(); 
		//for (Iterator<Level> i = levels.iterator(); i.hasNext(); ) {
			try {
				//currentLevel = i.next();
				mapper.writeValue(new File("levels/level" + level.getLevelNum() + "_" + level.getLevelType() + ".json"), level);
				System.out.println("Wrote file to disk");
			} catch (JsonGenerationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JsonMappingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		//}
	}
	
	/**
	 * Convert all levels from persistent JSON files to java objects stored in levels ArrayList
	 */
	public ArrayList<Level> loadLevelsFromDisk(){
		File levelFolder = new File("levels");
		File[] levelFiles = levelFolder.listFiles();
		ObjectMapper mapper = new ObjectMapper();
		Level currentLevel;
		ArrayList<Level> levels = new ArrayList<Level>();
		    for (int i = 0; i < levelFiles.length; i++) {

		    	//convert JSON in file into level object and store in levels arraylist
		    	try {
		    		if(levelFiles[i].getName().contains("puzzle")){
		    			currentLevel = mapper.readValue(levelFiles[i], Puzzle.class);
						levels.set(currentLevel.getLevelNum() - 1, currentLevel);
						
		    		}else if(levelFiles[i].getName().contains("lightning")){
		    			currentLevel = mapper.readValue(levelFiles[i], Lightning.class);
						levels.set(currentLevel.getLevelNum() - 1, currentLevel);
						
		    		}else if(levelFiles[i].getName().contains("theme")){
		    			currentLevel = mapper.readValue(levelFiles[i], Theme.class);
						levels.set(currentLevel.getLevelNum() - 1, currentLevel);
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
	
	public int getNumLevels(){
		File levelFolder = new File("levels");
		File[] levelFiles = levelFolder.listFiles();
		return levelFiles.length;
	}
	
	public static void main(String args[]){
		FileIO io = new FileIO();
		ArrayList<Level> levels = io.loadLevelsFromDisk();
		System.out.println("level 1: " + levels.get(0));
		
	}
}
