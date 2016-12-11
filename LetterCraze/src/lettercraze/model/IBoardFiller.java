// Needs to commented  

package lettercraze.model;
//
/**
 * The IBoardFiller interface is
 * <p>
 * 
 * <p>
 * Creation Date: (11/24/16 11:05 AM)
 * @author Hoodie
 *
 */
abstract public interface IBoardFiller {

	/**
	 * Floats tiles up after played word has been played
	 * @param squares
	 * @return Square[][]
	 */
	public abstract Square[][] floatTilesUp(Square[][] squares);
	
	/**
	 * Fills empty squares with a random letter
	 * @param squares
	 * @return Square[][]
	 */
	public abstract Square[][] fillEmptySquares(Square[][] squares);
	
	/**
	 * Fill the board at the start of a level
	 * @param squares
	 * @return Square[][]
	 */
	public abstract Square[][] initialFill(Square[][] squares) ;
}
