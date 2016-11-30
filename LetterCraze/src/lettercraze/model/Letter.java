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
	
	/** Double to store the frequency of the letter appearing */
	protected double frequency;
	
	public Letter(String letter, Integer value, Double frequency){
		super();
	}
	
	/** Create letter objects */
	 Letter A = new Letter ("A",2,8.17); 
	 Letter B = new Letter ("B",4,1.49); 
	 Letter C = new Letter ("C",3,2.78); 
	 Letter D = new Letter ("D",3,4.25); 
	 Letter E = new Letter ("E",1,12.70); 
	 Letter F = new Letter ("F",4,2.23); 
	 Letter G = new Letter ("G",4,2.02); 
	 Letter H = new Letter ("H",2,6.09); 
	 Letter I = new Letter ("I",2,6.97); 
	 Letter J = new Letter ("J",7,0.15); 
	 Letter K = new Letter ("K",5,0.77); 
	 Letter L = new Letter ("L",3,4.03); 
	 Letter M = new Letter ("M",3,2.41); 
	 Letter N = new Letter ("N",2,6.75); 
	 Letter O = new Letter ("O",2,7.51); 
	 Letter P = new Letter ("P",4,1.93); 
	 //Letter Q = new Letter ("Q",8); 
	 Letter R = new Letter ("R",2,5.99); 
	 Letter S = new Letter ("S",2,6.33); 
	 Letter T = new Letter ("T",1,9.06); 
	 Letter U = new Letter ("U",3,2.76); 
	 Letter V = new Letter ("V",5,0.98); 
	 Letter W = new Letter ("W",3,2.36); 
	 Letter X = new Letter ("X",7,0.15); 
	 Letter Y = new Letter ("Y",4,1.97); 
	 Letter Z = new Letter ("Z",8,0.07); 
	 Letter Qu = new Letter ("Qu",11,0.10);	

	 /**
	  * Get The string of the Letter 
	  * @return String with Letter 
	  */
	 public String getLetter(){
		 return this.letter;
	 }
	 
	 /**
	  * Get Value of the Letter
	  * @return Integer with value 
	  */
	 public int getValue(){
		 return this.value;
	 }
	 
	 /**
	  * Get Frequency of the Letter
	  * @return Double with frequency 
	  */
	 public double getFrequency(){
		 return this.frequency;
	 }
}


