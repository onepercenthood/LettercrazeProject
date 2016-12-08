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

	Alphabet alphInst = Alphabet.getInstance();

	public Square(int r, int c){
		this.row = r;
		this.column = c;
		this.letter = null;
		this.isActive = false;
		this.isSelected = false;

	}



	public int getRow() {
		return row;
	}



	public int getColumn() {
		return column;
	}



	public Alphabet getAlphInst() {
		return alphInst;
	}



	/** Removes the current letter from the Square and randomly places a new one */
	public void newLetter(){
		this.letter = alphInst.getRandomLetter();
		System.out.println(letter.letter);		
	}


	/** Return the letter in the given square.
	 * @return Letter
	 * 
	 * */
	public Letter getLetter(){

		return letter;

	}
	
	public void setLetter(Letter letter){
		this.letter = letter;
	}

	/**
	 * Updates the isSelected variable if a Player performs a Mouse Clicks 
	 * on a square while playing the game 
	 * 
	 * @return True is isSelected is changed to true 
	 */
	public boolean toggleActive(){
		this.isActive = !this.isActive;
		return true;
	}

	public boolean toggleSelected(){
		this.isSelected = !this.isSelected;
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
		if (((s1.getRow() == s2.getRow() -1) ||
			 (s1.getRow() == s2.getRow()) ||
			 (s1.getRow() == s2.getRow() +1)) &&
			((s1.getColumn() == s2.getColumn() -1) ||
			 (s1.getColumn() == s2.getColumn()) ||
			 (s1.getColumn() == s2.getColumn() +1)))
				{return true;}
		else{return false;}
				
		
	}



	public boolean isActive() {
		return isActive;
	}



	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}



	public boolean isSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean isSelected) {

		this.isSelected = isSelected;
	}


}
