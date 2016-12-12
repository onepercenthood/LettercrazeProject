package lettercraze.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class FileIO {
	/**
	 * Convert given level file to JSON file, stored in default_levels if levelNum <= 15, otherwise in custom_levels.
	 * Relies on Jackson annotations in Level and all 3 subclasses
	 */
	public static void saveLevelToDisk(Level level){
		ObjectMapper mapper = new ObjectMapper();
		//for (Iterator<Level> i = levels.iterator(); i.hasNext(); ) {
			try {
				//currentLevel = i.next();
				if(level.getLevelNum() <= 15){
					mapper.writeValue(new File("default_levels/lettercraze_level" + level.getLevelNum() + "_" + level.getLevelType() + ".json"), level);
				}else{
					mapper.writeValue(new File("custom_levels/lettercraze_level" + level.getLevelNum() + "_" + level.getLevelType() + ".json"), level);
				}
				
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
	 * Convert all default levels from persistent JSON files to java objects stored in levels ArrayList.
	 * Default levels are stored in src/default_levels 
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

		    		if(name.contains("Puzzle") && name.contains("lettercraze")){
		    			
		    			Level currentLevel = mapper.readValue(levelFiles[i], Level.class);
						levels.add(currentLevel);
						
		    		}else if(name.contains("Lightning") && name.contains("lettercraze")){
		    			Lightning currentLevel = mapper.readValue(levelFiles[i], Lightning.class);
		    			levels.add(currentLevel);
						
		    		}else if(name.contains("Theme") && name.contains("lettercraze")){
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
		    		if(name.contains("Puzzle") && name.contains("lettercraze")){
		    			
		    			Puzzle currentLevel = mapper.readValue(levelFiles[i], Puzzle.class);
						levels.add(currentLevel);
						
		    		}else if(name.contains("Lightning") && name.contains("lettercraze")){
		    			Lightning currentLevel = mapper.readValue(levelFiles[i], Lightning.class);
		    			levels.add(currentLevel);
						
		    		}else if(name.contains("Theme") && name.contains("lettercraze")){
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
	
	public int getNumLevels(){
		File levelFolder = new File("levels");
		File[] levelFiles = levelFolder.listFiles();
		return levelFiles.length;
	}
	
	public static void main(String args[]){
		boolean[][] sampleShape = new boolean[6][6];
		boolean active = true;
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				sampleShape[row][col] = active;
				//active = !active;
			}
			//active = !active;
		}
		Puzzle level1 = new Puzzle(1, new int[]{1, 2, 3} , 10);
		level1.setBoardShape(sampleShape);
		level1.setUnLocked(true);
		
		
		FileIO.saveLevelToDisk(level1);
		ArrayList<Level> levels = FileIO.loadDefaultLevelsFromDisk();
		Iterator<Level> i = levels.iterator();
		Level l = i.next();
		System.out.println("size of 1: " + levels.size());
		System.out.println("level 1: " + l.getLevelType());
		
		
	}
}
