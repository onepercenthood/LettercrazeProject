// Needs to commented  

package lettercraze.model;

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

	/** */
	public abstract void floatTilesUp();
	
	/** */
	public abstract void fillEmptySquares();
	
	/** */ 
	public abstract void initialFill() ;
}
