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
public class BoardState{
	
	/** Current Score of the day */
	protected int score;
	
	/** Current number of stars earned */
	protected int stars;
	
	/** Array List of the words that have been played so far */ 
	protected ArrayList<TestWord> foundWords = new ArrayList<TestWord>();
	
	/** Two dimensional representations of the squares on the board */
	protected Square[][] squares = new Square[6][6] ;
	
	/** */
	protected BasicFiller basicFiller;
	
	/** */ 
	protected ThemeFiller themeFiller;
	
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
		basicFiller = new BasicFiller();
		squares = basicFiller.initialFill(squares);
		score = 0;
		stars = 0;
	}
	
	/**
	 * Construct used to create a new BoardState when a word in played.
	 * Produces a new BoardState which then becomes the current state the
	 * Player sees. 
	 * 
	 * @param oldState is the current state the board is in
	 * @param playedWord is the word submitted to be played
	 */
	public BoardState(BoardState oldState, TestWord playedWord){
		
	}
	
	/**
	 * deselects all the squares in the board
	 */
	public void deselectAllSquares(){
		for(int i = 0; i < 6; i++){
			for(int j = 0; i < 6; i ++){
				this.squares[i][j].setSelected(false);
			}
		}
	}
	/**
	 * 
	 * Return the squares in this board state
	 * @return squares[][]
	 */
	public Square[][] getSquares(){
		return squares;
	}

}
