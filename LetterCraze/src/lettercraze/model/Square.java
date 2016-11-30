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
	
	public Square(int r, int c){
		this.row = r;
		this.column = c;
		this.letter = null;
		this.isActive = false;
		this.isSelected = false;
				
	}
	
	/** Create square objects */
	Square s1 = new Square(1,1);
	Square s2 = new Square(1,2);
	Square s3 = new Square(1,3);
	Square s4 = new Square(1,4);
	Square s5 = new Square(1,5);
	Square s6 = new Square(1,6);
	Square s7 = new Square(2,1);
	Square s8 = new Square(2,2);
	Square s9 = new Square(2,3);
	Square s10 = new Square(2,4);
	Square s11 = new Square(2,5);
	Square s12 = new Square(2,6);
	Square s13 = new Square(3,1);
	Square s14 = new Square(3,2);
	Square s15 = new Square(3,3);
	Square s16 = new Square(3,4);
	Square s17 = new Square(3,5);
	Square s18 = new Square(3,6);
	Square s19 = new Square(4,1);
	Square s20 = new Square(4,2);
	Square s21 = new Square(4,3);
	Square s22 = new Square(4,4);
	Square s23 = new Square(4,5);
	Square s24 = new Square(4,6);
	Square s25 = new Square(5,1);
	Square s26 = new Square(5,2);
	Square s27 = new Square(5,3);
	Square s28 = new Square(5,4);
	Square s29 = new Square(5,5);
	Square s30 = new Square(5,6);
	Square s31 = new Square(6,1);
	Square s32 = new Square(6,2);
	Square s33 = new Square(6,3);
	Square s34 = new Square(6,4);
	Square s35 = new Square(6,5);
	Square s36 = new Square(6,6);
	
	
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
		this.isActive = !this.isActive;
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
