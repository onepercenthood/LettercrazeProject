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
	public void floatTilesUp() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fillEmptySquares() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Square[][] initialFill(Square[][] squares) {
		// TODO Auto-generated method stub
		// for each square
		
		Square[][] squares1 = squares;
		
	
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				if(squares[row][col].isActive){
					squares[row][col].newLetter();
				}
			}
		}
		squares1 = squares;
		return squares;
	}

}
