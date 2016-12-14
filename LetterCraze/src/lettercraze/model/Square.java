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

	/**
	 * True if the square has been already used in a word
	 */
	protected boolean isLetterAlreadyUsedInWord;

	Alphabet alphInst = Alphabet.getInstance();

	/**
	 * constructor for a square, takes in the (row, column) location.
	 * @param r as int
	 * @param c as int
	 */
	public Square(int r, int c){
		this.row = r;
		this.column = c;
		this.letter = null;
		this.isActive = false;
		this.isSelected = false;
		this.isLetterAlreadyUsedInWord = false;

	}


	/**
	 * returns the row number that this square is in (0 to 5).
	 * @return int
	 */
	public int getRow() {
		return row;
	}


	/**
	 * sets the row location of this square to the given int
	 * @param row as int
	 */
	public void setRow(int row) {
		this.row = row;
	}


	/**
	 * gets the column location of the square
	 * @return int
	 */
	public int getColumn() {
		return column;
	}

	/**
	 * sets the column location to the given value
	 * @param column as int
	 */
	public void setColumn(int column) {
		this.column = column;
	}

	/**
	 * gets an instance of the alphabet object.
	 * @return Alphabet
	 */
	public Alphabet getAlphInst() {
		return alphInst;
	}



	/** Assigns a random letter to the square */
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

	/**
	 * sets the letter for this square to the given letter.
	 * @param letter as Letter
	 */
	public void setLetter(Letter letter){
		this.letter = letter;
	}

	/**
	 * Updates the letter to null, because it was already used in a word.
	 * @param val
	 */
	public void removeLetterFromSquare(boolean val){
		this.letter = null;
	}

	/**
	 * Updates the isSelected variable if a Player performs a Mouse Clicks 
	 * on a square while playing the game.
	 * 
	 * @return True is isSelected is changed to true 
	 */
	public boolean toggleActive(){
		this.isActive = !this.isActive;
		return true;
	}

	/**
	 * switches between selected/non selected
	 * @return the new value of isSelected
	 */
	public boolean toggleSelected(){
		this.isSelected = !this.isSelected;
		return isSelected;
	}

	/**
	 * Check to see if the two squares are adjacent to each other on the board.
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

	/**
	 * creates and returns a copy of this square for use in the next boardState.
	 * @return a new square whose fields match the values of this square's fields
	 */
	public Square copySquare(){
		Square copy = new Square(this.row, this.column);
		copy.setActive(isActive);
		copy.setSelected(isSelected);
		//give the copied square a copy of this letter
		copy.setLetter(new Letter(letter.getLetter(), letter.getValue(), letter.getFrequency()));
		return copy;
	}

	/**
	 * returns whether or not the square is active in this level.
	 * @return true if active, false if inactive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * sets the square to the given active/inactive value.
	 * @param isActive as boolean
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	/**
	 * @return true if the square is selected, false if not
	 */
	public boolean isSelected() {
		return isSelected;
	}

	/**
	 * sets the square to the given selection value
	 * @param isSelected as boolean
	 */
	public void setSelected(boolean isSelected) {

		this.isSelected = isSelected;
	}


}
