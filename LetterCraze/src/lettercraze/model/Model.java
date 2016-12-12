//Needs commenting and functions 

package lettercraze.model;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * The LetterCraze Model contains all the entity objects 
 * <p>
 * This class provides a top level entity class that can be used to 
 * to locate all entity objects by means of some relationship. 
 * It can be the view as a "container" for model elements 
 * <p>
 * @author Hoodie
 */
public class Model {
	
	/** List of the BoardStates */
	protected ArrayList<BoardState> boardStates = new ArrayList<BoardState>();;
	
	/** List of all the levels stored in the Game */
	protected ArrayList<Level> levels = new ArrayList<Level>(); 
	
	/** The Current Word being played */
	protected Word currentWord;

	/** Dictionary that stores all possible words that can be played */
	protected WordTable possibleWords;
	
	protected int currentLevel;
	
	/**
	 * Model Constructor
	 */
	public Model() {
		super();
		
		// Create Dictionary 
		try {
			WordTable.loadWordTable();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		boolean[][] sampleShape = new boolean[6][6];
		boolean active = true;
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				sampleShape[row][col] = active;
				//active = !active;
			}
			//active = !active;
		}
		Puzzle level1 = new Puzzle(1, new int[]{25, 50, 100} , 10);
		level1.setBoardShape(sampleShape);
		level1.setUnLocked(true);
		levels.add(level1);	
		initiateLevel(1);

		
		Lightning level2 = new Lightning(2, new int[]{25, 50, 100} , 30);
		level2.setBoardShape(sampleShape);
		level2.setUnLocked(true);
		levels.add(level2);	
		initiateLevel(2);

		//loadLevelsFromDisk();
		//saveLevelsToDisk();
	}
	
	// Get Functions 
	/**
	 * 
	 * Return last board state in array list
	 * @return level corresponding to the given level number
	 */
	public BoardState getCurrentBoardState(){
		return boardStates.get(boardStates.size() - 1);
	}
	
	public void setCurrentBoardState(BoardState board){
		this.boardStates.add(board);
	}
	
	public ArrayList<BoardState> getBoardStateArray(){
		return this.boardStates;
	}
	
	/**
	 * 
	 * @param int levelNum
	 * @return level corresponding to the given level number
	 */
	public Level getLevel(int levelNum){
		return levels.get(levelNum - 1);
	}
	
	// Set Functions 
	
	
	
	/**
	 * 
	 * @param bs
	 * @param played
	 * @return boolean true if the Move has been successfully played
	 * 	and a new BoardState 
	 */
	public boolean addMove(BoardState bs, Word played){
		return true ;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean undoMove(){
		return false;
	}
	
	/**
	 * Set up a new initial boardstate from a given level.
	 * for the first deliverable, this is using the sample level 1
	 * @param levelNum
	 */
	public void initiateLevel(int levelNum){
		
		//simple sample shape with a 6x6 grid
		System.out.println("value of level 0: "  + levels.get(0));
		BoardState newState = new BoardState(levels.get(levelNum - 1).getBoardShape());
		boardStates.add(newState);
	}
	
	/**
	 * Write all the levels to disk in JSON format
	 */
	/*public void saveLevelsToDisk(){
		ObjectMapper mapper = new ObjectMapper(); 
		Level currentLevel;
		for (Iterator<Level> i = levels.iterator(); i.hasNext(); ) {
			try {
				currentLevel = i.next();
				mapper.writeValue(new File("levels/level" + currentLevel.getLevelNum() + "_" + currentLevel.getLevelType() + ".json"), currentLevel);
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
		}
	}
	
	
	/**
	 * Convert all levels from persistent JSON files to java objects stored in levels ArrayList
	 */
	/*public void loadLevelsFromDisk(){
		File levelFolder = new File("levels");
		File[] levelFiles = levelFolder.listFiles();
		ObjectMapper mapper = new ObjectMapper();
		Level currentLevel;
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
	}*/

	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean addSelectedSquare(Square s){
		return true;
	}
	
	/**
	 * 
	 * @param s
	 * @return
	 */
	public boolean removeSelectedSquare(Square s){
		return false;
	}
	
	/**
	 * 
	 * @return
	 */
	public Word getCurrentWord(){
		return this.currentWord;
	}
	
	public void setCurrentWord(Word wordIn){
		this.currentWord = wordIn;
	}
	
	public boolean clearCurrentWord(){
		return true;
	}
	
	/**
	 * 
	 * @param w
	 * @return
	 */
	public boolean checkPlayedWord(Word w){
		return true;
	}
	
	/**
	 * 
	 * @return
	 */
	public boolean isBeaten(){
		return true;
	}
	
	public int getCurrentLevel(){
		return this.currentLevel;
	}
}


