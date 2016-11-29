// Needs functions to be done 

package lettercraze.model;
/**
 * Models a square that contains a letter and located on a board
 * <p>
 * 
 * <p>
 * Creation Date: (11/24/16 11:01 AM)
 * @author Hoodie
 */
public class Square {
	
	/** Holds the row number of the square in the board */
	protected int row;
	
	/** Holds the column number of the square in the board */
	protected int column;
	
	/** Each square can contain a letter */
	protected Letter letter;
	
	/** True is square is being used on the board for the specific level */
	protected boolean isActive;
	
	/** True if the square has been selected by the Player to form word */
	protected boolean isSelected; 
	
	public Square(int r, int c, Letter l, boolean active, boolean selected){
		this.row = r;
		this.column = c;
		this.letter = l;
		this.isActive = active;
		this.isSelected = selected;
	}
	
	/** Removes the current letter from the Square and randomly places a new one */
	public void updateLetter(){
		
	}
	
	/**
	 * Updates the isSelected variable if a Player performs a Mouse Clicks 
	 * on a square while playing the game 
	 * 
	 * @return True is isSelected is changed to true 
	 */
	public boolean toggleSelected(){
		return true;
	}
	
	/**
	 * Check to see if the two squares are adjacent to each other on the board
	 * 
	 * @param s1 The first square 
	 * @param s2 The second square 
	 * @return True if the Squares are adjacent to one another 
	 */
	public boolean isAdjacent(Square s1, Square s2){
		return true;
	}

}
