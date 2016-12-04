package lettercraze.model;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Random;

/**
 * The Alphabet class contains a LinkedHashMap of all the letters, frequencies and values.
 * <p>
 * This class has a getRandomLetter() function which is used to fill the board according to the letter frequencies.
 * <p>
 * Creation Data: (11/24/16 10:58 AM)
 * @author Derek
 */

public class Alphabet {
	/** LinkedHasMap of the frequency for each letter to appear [key = letter, object = frequency (Double)] 
	 * Allows for iteration in order of entry. */
	protected static LinkedHashMap<String,Letter> letters = new LinkedHashMap<String,Letter>();
	private static Alphabet instance;
	
	public Alphabet(){
	letters.put("A", new Letter("A", 2, 8.17)); 
	 letters.put("B", new Letter("B", 4, 1.49)); 
	 letters.put("C", new Letter("C", 3, 2.78)); 
	 letters.put("D", new Letter("D", 3, 4.25)); 
	 letters.put("E", new Letter("E", 1, 12.70)); 
	 letters.put("F", new Letter("F", 4, 2.23)); 
	 letters.put("G", new Letter("G", 4, 2.02)); 
	 letters.put("H", new Letter("H", 2, 6.09)); 
	 letters.put("I", new Letter("I", 2, 6.97)); 
	 letters.put("J", new Letter("J", 7, 0.15)); 
	 letters.put("K", new Letter("K", 5, 0.77)); 
	 letters.put("L", new Letter("L", 3, 4.03)); 
	 letters.put("M", new Letter("M", 3, 2.41)); 
	 letters.put("N", new Letter("N", 2, 6.75)); 
	 letters.put("O", new Letter("O", 2, 7.51)); 
	 letters.put("P", new Letter("P", 4, 1.93)); 
	 letters.put("R", new Letter("R", 2, 5.99)); 
	 letters.put("S", new Letter("S", 2, 6.33)); 
	 letters.put("T", new Letter("T", 1, 9.06)); 
	 letters.put("U", new Letter("U", 3, 2.76)); 
	 letters.put("V", new Letter("V", 5, 0.98)); 
	 letters.put("W", new Letter("W", 3, 2.36)); 
	 letters.put("X", new Letter("X", 7, 0.15)); 
	 letters.put("Y", new Letter("Y", 4, 1.97)); 
	 letters.put("Z", new Letter("Z", 8, 0.07)); 
	 letters.put("Qu", new Letter("Qu", 11, 0.10));	
	}
	
	/**
	 * Get a new random Letter according to letter frequencies.
	 * @return new random Letter
	 * */
	public Letter getRandomLetter(){
		Random r = new Random();
		double randCumulativeFreq = r.nextDouble();
		double freqSum = 0.0;
		
		Iterator<Letter> vals = letters.values().iterator();
		
		Letter l = letters.get("A");
		
		while((freqSum < randCumulativeFreq) && vals.hasNext()){
			l = vals.next();
			freqSum += l.getFrequency() / 100;
			//System.out.println("freqSum: " + freqSum + "rand cum freq: " + l.getFrequency() / 100);
		}
		//System.out.println("freqSum: " + freqSum + "rand cum freq: " + randCumulativeFreq);
		
		return l;
		
	}
	
	public static Alphabet getInstance(){
		if( instance == null){
			instance = new Alphabet();
		}
				
		return instance;
		
	}
}
