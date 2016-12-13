//Commenting and Functions

package lettercraze.model;

import java.util.ArrayList;

/**
 * 
 * <p>
 * Creation Date: (11/24/16 11:08 AM)
 * @author Hoodie
 *
 */
public class BoardFiller{


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

	public Square[][] initialThemeFill(Square[][] squares, ArrayList<String> targetWords) {
		// TODO Auto-generated method stub
		//Convert Strings -> Words
			//Convert Strings -> Chars -> Letters -> Squares
			//Determine relative locations for squares
			//
		return null;
	}
}
