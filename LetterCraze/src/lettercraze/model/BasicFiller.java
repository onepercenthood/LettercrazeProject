//Commenting and Functions

package lettercraze.model;

/**
 * 
 * <p>
 * Creation Date: (11/24/16 11:08 AM)
 * @author Hoodie
 *
 */
public class BasicFiller implements IBoardFiller{

	@Override
	public Square[][] floatTilesUp(Square[][] squares) {
		// TODO Auto-generated method stub
		for(int col = 0; col < 6; col++){
			
			for(int row = 0; row < 6; row++){
				
				if((squares[row][col].isActive) & (squares[row][col].letter == null) & (squares[row][col].row < 5)){
					
					// If it is not the last row and the square below it does not contain a letter
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
	}

	@Override
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

	@Override
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

}
