//Done 

package lettercraze.model;
/**
 * Models a Letter  
 * <p>
 * This class provides the instance of the letters that are contained in the
 * squares on the board 
 * <p>
 * Creation Date: (11/24/16 10:59 AM) 
 * @author Hoodie
 *
 */

public class Letter {
	
	/** String to contain letter character. Must be String to use "Qu" */
	protected String letter;
	
	/** Integer to store the value of the letter */
	protected int value;
	
	public Letter(String letter, Integer value){
		super();
	}
	
	/** Create letter objects */
	 Letter A = new Letter ("A",2); 
	 Letter B = new Letter ("B",4); 
	 Letter C = new Letter ("C",3); 
	 Letter D = new Letter ("D",3); 
	 Letter E = new Letter ("E",1); 
	 Letter F = new Letter ("F",4); 
	 Letter G = new Letter ("G",4); 
	 Letter H = new Letter ("H",2); 
	 Letter I = new Letter ("I",2); 
	 Letter J = new Letter ("J",7); 
	 Letter K = new Letter ("K",5); 
	 Letter L = new Letter ("L",3); 
	 Letter M = new Letter ("M",3); 
	 Letter N = new Letter ("N",2); 
	 Letter O = new Letter ("O",2); 
	 Letter P = new Letter ("P",4); 
	 Letter Q = new Letter ("Q",8); 
	 Letter R = new Letter ("R",2); 
	 Letter S = new Letter ("S",2); 
	 Letter T = new Letter ("T",1); 
	 Letter U = new Letter ("U",3); 
	 Letter V = new Letter ("V",5); 
	 Letter W = new Letter ("W",3); 
	 Letter X = new Letter ("X",7); 
	 Letter Y = new Letter ("Y",4); 
	 Letter Z = new Letter ("Z",8); 
	 Letter Qu = new Letter ("Qu", 11);	

}
