// Needs to commented  

package lettercraze.model;
//
/**
 * 
 * <p>
 * 
 * <p>
 * Creation Date: (11/24/16 11:05 AM)
 * @author Hoodie
 *
 */
abstract public interface IBoardFiller {

	/**
	 * 
	 * @param squares
	 * @return
	 */
	public abstract Square[][] floatTilesUp(Square[][] squares);
	
	/**
	 * 
	 * @param squares
	 * @return
	 */
	public abstract Square[][] fillEmptySquares(Square[][] squares);
	
	/**
	 *  
	 * @param squares
	 * @return
	 */
	public abstract Square[][] initialFill(Square[][] squares) ;
}
