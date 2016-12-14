//Functions need to be done 

package lettercraze.model;

import java.util.ArrayList;

/**
 * Models a BoardState that contains a instance of a Board currently being played. 
 * <p>
 * Upon a start of a new level, a BoardState is made using a board shape. A new 
 * BoardState is created upon each Word made in the game. A BoardState holds the current
 * Board, score, and list of words played so far.
 * <p>
 * Creation Date: (11/24/16 11:03 AM)
 * @author Hoodie
 *
 */
public class BoardState extends BoardFiller{

	/** Current Score of the day */
	protected int score;

	/** Current number of stars earned */
	protected int stars;

	/** Array List of the words that have been played so far */ 
	protected ArrayList<Word> foundWords = new ArrayList<Word>();

	/** Two dimensional representations of the squares on the board */
	protected Square[][] squares = new Square[6][6] ;
	
	/**
	 * Construct for initial BoardState when a Level is selected 
	 * @param level as a Level 
	 */
	public BoardState(Level level){
		boolean[][] shape = level.getBoardShape();
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				squares[row][col]= new Square(row, col);
				if(shape[row][col]){
					squares[row][col].toggleActive();
				}				
			}
		}
		
		// Check to see what type of level
		// If Theme, specific theme initial fill fucntion must be called 
		switch(level.getLevelType()){
		case "Puzzle": initialFill(squares); break;
		case "Lightning" : initialFill(squares); break;
		case "Theme": Theme theme = (Theme) level; 
						initialFill(this, theme.getTargetWords());
						break;
		default: initialFill(squares);
		}
		// initialize stars and score to zero 
		score = 0;
		stars = 0;
	}

	/**
	 * Construct used to create a new BoardState when a word in played.
	 * Produces a new BoardState which then becomes the current state the
	 * Player sees. Assumes the given word is already determined to be valid word
	 * 
	 * @param oldState is the current state the board is in
	 * @param playedWord is the word submitted to be played
	 */
	public BoardState(BoardState oldState, Word playedWord){
		System.out.println("Loading new BoardState");
		//first create copy of each square in the old board, with the same letters in it
		for(int i = 0; i < 6; i ++){
			for(int j = 0; j < 6; j ++){
				this.squares[i][j] = oldState.getSquares()[i][j].copySquare();
			}
		}
		//now add the filler objects to this boardState
		//this.basicFiller = oldState.basicFiller;
		//this.themeFiller = oldState.themeFiller;
		//now use the remove word function to get rid of all the letters from the squares that were selected
		this.removeLetterFromSquares(playedWord);
		this.deselectAllSquares();
		//float all squares below them up...

		//...and fill in any open spaces on the bottom
		for(int i = 0; i < 6; i ++){
			for(int j = 0; j < 6; j ++){
				if(this.squares[i][j].getLetter() == null){
					this.squares[i][j].newLetter();
				}
			}
		}
	}

	/**
	 * De-selects all the squares in the board
	 */
	public void deselectAllSquares(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j ++){
				this.squares[i][j].setSelected(false);
			}
		}
	}

	/**
	 * Removes the Letter from each square in a word. 
	 * @param word as a Word 
	 */
	public void removeLetterFromSquares(Word word){

		ArrayList<Square> squareArr = word.getLetters();

		for(Square curSquare : squareArr){
			int row = curSquare.getRow();
			int col = curSquare.getColumn();
			this.squares[row][col].removeLetterFromSquare(null);
		}
	}

	/**
	 * Return the squares in this board state
	 * @return squares[][]
	 */
	public Square[][] getSquares(){
		return squares;
	}

	/**
	 * Get Score of BoardState
	 * @return Integer 
	 */
	public int getScore(){
		return this.score;
	}

	/**
	 * Sets the current Score of the BoardState 
	 * @param score as an Integer 
	 */
	public void setScore(int score){
		this.score = score;
	}
	
	/** 
	 * Get Stars of the BoardState
	 * @return Integer 
	 */
	public int getStars(){
		return this.stars;
	}
	
	/**
	 * Set the current Stars in the BoardState 
	 * @param stars as an Integer 
	 */
	public void setStars(int stars){
		this.stars = stars;
	}

	/**
	 * Get the Found Words Array List as Word type
	 * @return AraryList<Word>
	 */
	public ArrayList<Word> getFoundWords() {
		return foundWords;
	}
	
	/**
	 * Get the Found Words Array List as String type 
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> getFoundWordsStrings(){
		ArrayList<String> stringList = new ArrayList<String>();
		for(int i = 0; i < foundWords.size(); i++){
			stringList.add(foundWords.get(i).getWordString());
		}
		return stringList;
	}

	/**
	 * Adds a word to the foundWords ArrayList
	 * @param word as a Word 
	 * @return True if word was added to foundWord Array List, false if it was not added
	 */
	public boolean addWordToFoundWords(Word word){
		return this.foundWords.add(word);
	}

	/**
	 * Set the Squares of the BoardState to the input parameter
	 * @param squares as a Square[][]
	 */
	public void setSquares(Square[][] squares) {
		// TODO Auto-generated method stub
		
		this.squares = squares;
		
	}

}
