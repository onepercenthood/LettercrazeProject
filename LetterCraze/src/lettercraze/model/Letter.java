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
		this.letter = letter;
		this.value = value;
		this.frequency = frequency;
	}	

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


