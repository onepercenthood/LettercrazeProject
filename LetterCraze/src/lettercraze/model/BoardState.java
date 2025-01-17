//Functions need to be done 

package lettercraze.model;

import java.util.ArrayList;

/**
 * Models a BoardState that contains a instance of a Board 
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

	/** */
	//protected BasicFiller basicFiller;

	/** */ 
	//protected ThemeFiller themeFiller;

	/**
	 * Construct entity for initial start of playing a level. 
	 * @param shape is the initial shape of the board taken from the Level
	 */
	public BoardState(boolean[][] shape){
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				squares[row][col]= new Square(row, col);
				if(shape[row][col]){
					squares[row][col].toggleActive();
				}				
			}
		}
		//this.foundWords = null;
		//basicFiller = new BasicFiller();
		squares = this.initialFill(squares);
		score = 0;
		stars = 0;
	}

	/**
	 * Constructor for boardState objects. Takes in a level and populates the boardState
	 * based on the information in that level.
	 * @param level as Level
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
		switch(level.getLevelType()){
		case "Puzzle": initialFill(squares); break;
		case "Lightning" : initialFill(squares); break;
		case "Theme": 
			Theme theme = (Theme) level; 
			theme.setUsedWords(initialFill(this, theme.getTargetWords()));
			break;
		default: initialFill(squares);
		}
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
	 * deselects all the squares in the board
	 */
	public void deselectAllSquares(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j ++){
				this.squares[i][j].setSelected(false);
			}
		}
	}

	/**
	 * removes the given word from the squares in the boardState
	 * @param word as Word
	 */
	public void removeLetterFromSquares(Word word){

		ArrayList<Square> squareArr = word.getLetters();

		for(Square curSquare : squareArr){
			int row = curSquare.getRow();
			int col = curSquare.getColumn();
			this.squares[row][col].removeLetterFromSquare(false);
		}
	}

	/**
	 * 
	 * Return the squares in this board state.
	 * @return squares[][]
	 */
	public Square[][] getSquares(){
		return squares;
	}

	/**
	 * sets the squares in this boardstate to the given collection of squares.
	 * @param squares
	 */
	public void setSquares(Square[][] squares) {
		this.squares = squares;
	}

	/**
	 * returns the current score
	 * @return int
	 */
	public int getScore(){
		return this.score;
	}

	/**
	 * sets the score to the give value	
	 * @param score as int
	 */
	public void setScore(int score){
		this.score = score;
	}
	
	/**
	 * returns the number of stars earned so far in the level
	 * @return int
	 */
	public int getStars(){
		return this.stars;
	}
	
	/**
	 * sets the number of stars earned to the given value
	 * @param stars as int
	 */
	public void setStars(int stars){
		this.stars = stars;
	}

	/**
	 * returns an arryaList<Word> of all the words currently found in the level
	 * @return ArrayList<String>
	 */
	public ArrayList<Word> getFoundWords() {
		return foundWords;
	}
	
	/**
	 * returns an arrayList<String> of all the words currently found in the level
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
	 * adds the given word to the list of found words
	 * @param word as Word
	 * @return true if successful, false otherwise
	 */
	public boolean addWordToFoundWords(Word word){
		return this.foundWords.add(word);
	}
	
	/**
	 * removes all words from the list of found words
	 */
	public void setClearFoundWords(){
		int i = this.foundWords.size();
		while(0 < i){
			this.foundWords.remove(i-1);
			i--;
		}	
	}

}
