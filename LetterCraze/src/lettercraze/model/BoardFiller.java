//Commenting and Functions

package lettercraze.model;

import java.util.ArrayList;

import lettercraze.controller.player.ThemeBuilder;

/**
 * 
 * <p>
 * Creation Date: (11/24/16 11:08 AM)
 * @author Hoodie
 *
 */
public class BoardFiller{

	/*
	public Square[][] floatTilesUp(Square[][] squares) {
		// TODO Auto-generated method stub
		for(int col = 0; col < 6; col++){

			for(int row = 0; row < 6; row++){

				//if the square is active, is missing a letter, and is not the last row...
				if((squares[row][col].isActive) & (squares[row][col].letter == null) & (squares[row][col].row < 5)){

					// If it is not the last row and the square below it does contains a letter
					if(squares[row+1][col].letter != null){
						squares[row][col].letter = squares[row+1][col].letter;
						squares[row+1][col].setLetter(null);
					// If it is not the last row and the 2nd square below it does not contain a letter
					} else if (squares[row][col].row < 4){ 
						if(squares[row+2][col].letter != null){
							squares[row][col].letter = squares[row+2][col].letter;
							squares[row+2][col].setLetter(null);
						}
					// If it is not the last row and the 3rd square below it does not contain a letter
					} else if (squares[row][col].row < 3){ 
						if(squares[row+3][col].letter != null){
							squares[row][col].letter = squares[row+3][col].letter;
							squares[row+3][col].setLetter(null); 
						}
					// If it is not the last row and the 4th square below it does not contain a letter
					} else if (squares[row][col].row < 2){ 
						if(squares[row+4][col].letter != null){
						squares[row][col].letter = squares[row+4][col].letter;
						squares[row+4][col].setLetter(null); 
						}
					// If it is not the last row and the 5th square below it does not contain a letter
					} else if (squares[row][col].row < 1){ 
						if(squares[row+5][col].letter != null){
							squares[row][col].letter = squares[row+5][col].letter;
							squares[row+5][col].setLetter(null);
						}

					}
				}
			}		
		}
		return squares;	
	}*/

	public Square[][] floatTilesUp(Square[][] squares){
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col ++){
				//if the square is active, is missing a letter, and is not the last row...
				if((squares[row][col].isActive) & (squares[row][col].letter == null)){
					Square currentSquare = squares[row][col];
					Square nextActive = this.getNextActiveSquareInColumn(currentSquare, squares);
					if(nextActive != null){
						currentSquare.setLetter(nextActive.getLetter());
						nextActive.setLetter(null);
					}
				}
			}
		}
		return squares;
	}

	public Square[][] floatTileDown(Square[][] squares, Word word){
//		for(int i = word.getLetters().size()- 1; i >=0; i--){
//			Square s = word.getLetters().get(i);
//			pushColumnDown(squares, s);
//			//squares[s.getRow()][s.getColumn()].setLetter(s.getLetter());
//		}
		ArrayList<Square> sorted = this.sortWord(word);
		for(Square s: sorted){
			pushColumnDown(squares, s);
		}
		return squares;
	}

	private ArrayList<Square> sortWord(Word word) {
		ArrayList<Square> sortedSquares = new ArrayList<Square>();
		//loop through the columns first
		for(int col = 0; col < 6; col++){
			for(int row =0; row <6; row++){
				for(Square s: word.getLetters()){
					//insert the squares from the current column into the new arraylist from top rows to bottom rows
					if(s.getColumn() == col && s.getRow() == row){
						sortedSquares.add(s);
					}
				}
			}
		}
		return sortedSquares;
	}

	/**
	 * for a given location (currentSquare) in squares, pushes all the letters in that column down one square
	 * and sets the letter at currentSquare to null
	 * @param squares
	 * @param currentSquare
	 */
	private void pushColumnDown(Square[][] squares, Square topSquare){
		int row = topSquare.getRow();
		int col = topSquare.getColumn();
		Letter setLetter = topSquare.getLetter();
		for(int r = row; r < 6; r++){
			Square currentSquare = squares[r][col];			
			if(currentSquare.isActive()){
				System.out.println("Shifting "+ r +", " + col);
				//System.out.println(setLetter.getLetter() + "   " + currentSquare.getLetter().getLetter() +"   ");
				Letter tempLetter = currentSquare.getLetter();
				//System.out.println(setLetter.getLetter() + "   " + currentSquare.getLetter().getLetter() +"   " + tempLetter);
				currentSquare.setLetter(setLetter);
				//System.out.println(setLetter.getLetter() + "   " + currentSquare.getLetter().getLetter() +"   " + tempLetter);
				setLetter = tempLetter;
				//System.out.println(setLetter.getLetter() + "   " + currentSquare.getLetter().getLetter() +"   " + tempLetter);
			}
			
		}
		//squares[row][col].setLetter(null); //set the letter at the initial location to null
	}

	
	/**
	 * fills all the empty cells in the given squares[][] board with random letters
	 * @param squares
	 * @return
	 */
	public Square[][] fillEmptySquares(Square[][] squares) {
		// TODO Auto-generated method stub

		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				if((squares[row][col].isActive) & (squares[row][col].letter == null)){
					squares[row][col].newLetter();
				}
			}
		}
		return squares;
	}

	/*
	public Square[][] floatTileDown(Square[][] squares, Word word){
		Letter temp = null;
		Letter newTemp ;
		Letter oldTemp ;
		boolean found = false ;

		for(int col = 0; col < 6; col++){
			for(int row = 0; row < 6; row++){
				//System.out.println(word.getWordString());


				for (Square s : word.getLetters()){
					if((s.row == row) & (s.column == col)){
						temp = s.letter;
						System.out.println(temp.getLetter());
						found = true;
						break;
					} else found = false ;
				}

				if(found){
					// case for when letter is in the 1st row
					if((squares[row][col].isActive) & (squares[row][col].row == 0)){
						newTemp = squares[row][col].letter;
						squares[row][col].letter = temp;

						for(int z = 1; z < 6; z++){
							if(squares[row+z][col].isActive){
								oldTemp= newTemp;
								newTemp = squares[row+1][col].letter;
								squares[row+z][col].letter = oldTemp;
							}
						}
					// case for when letter is in the 2nd row	
					}else if((squares[row][col].isActive) & (squares[row][col].row == 1)){

						newTemp = squares[row][col].letter;
						squares[row][col].letter = temp;


						for(int z = 1; z < 5; z++){
							if(squares[row+z][col].isActive){
								oldTemp= newTemp;
								newTemp = squares[row+1][col].letter;
								squares[row+z][col].letter = oldTemp;
							}
						}
					// case for when letter is in the 3rd row
					}else if((squares[row][col].isActive) & (squares[row][col].row == 2)){

						newTemp = squares[row][col].letter;
						squares[row][col].letter = temp;

						for(int z = 1; z < 4; z++){
							if(squares[row+z][col].isActive){
								oldTemp= newTemp;
								newTemp = squares[row+1][col].letter;
								squares[row+z][col].letter = oldTemp;
							}
						}
					// case for when letter is in the 4th row	
					}else if((squares[row][col].isActive) & (squares[row][col].row == 3)){

						newTemp = squares[row][col].letter;
						squares[row][col].letter = temp;

						for(int z = 1; z < 3; z++){
							if(squares[row+z][col].isActive){
								oldTemp= newTemp;
								newTemp = squares[row+1][col].letter;
								squares[row+z][col].letter = oldTemp;
							}
						}
					// case for when letter is in the 5th row
					}else if((squares[row][col].isActive) & (squares[row][col].row == 4)){
						newTemp = squares[row][col].letter;
						squares[row][col].letter = temp;

						for(int z = 1; z < 2; z++){
							if(squares[row+z][col].isActive){
								oldTemp= newTemp;
								newTemp = squares[row+1][col].letter;
								squares[row+z][col].letter = oldTemp;
							}
						}
					// case for when letter is in the 6th row
					}else if((squares[row][col].isActive) & (squares[row][col].row == 5)){
						squares[row][col].letter = temp;
					}

				}
			}
		}

		return squares;	
	}
	 */

	public Square[][] initialFill(Square[][] squares) {
		// for each square

		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				if(squares[row][col].isActive){
					squares[row][col].newLetter();
				}
			}
		}
		return squares;
	}

	public Square[][] initialFill(BoardState bState, ArrayList<String> targetWords) {
		// TODO Auto-generated method stub
		ThemeBuilder tBuild = new ThemeBuilder(bState, targetWords);		
		return tBuild.populateSquares();
	}

	private Square getNextActiveSquareInColumn(Square currentSquare, Square[][] squares){
		for(int row = currentSquare.getRow() + 1 ; row < 6; row ++){
			if(squares[row][currentSquare.getColumn()].isActive() && squares[row][currentSquare.getColumn()].getLetter() != null){
				return squares[row][currentSquare.getColumn()];
			}
		}
		return null;
	}
}
