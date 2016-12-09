
package lettercraze.model;

import junit.framework.TestCase;

/**
 * Test Case for Word 
 * 
 * @author Hoodie
 *
 */
public class TestWord extends TestCase {
	
	public void testWord(){
		
		// Test letters to use
		Square D = new Square(1,1); 
		Square O = new Square(1,2);
		Square G = new Square(2,2);
		D.letter = new Letter("D", 2, 2.0);
		O.letter = new Letter("O", 2, 2.0);
		G.letter = new Letter("G", 2, 2.0);
		
		// Create instance to test - Start with letter D
		Word testWord = new Word(D);
		
		// check to make sure the size of word = 1 ;
		int size1 = testWord.getLetters().size();
		assertEquals(size1, 1);
		
		// check to make sure getWordStringReturns single letter
		String singleLetter = testWord.getWordString();
		assertEquals(singleLetter, "D");
		
		// Since a word is valid only if it has 3 or more letters
		// and is in WordList, should return false 
		assertFalse(testWord.isValid());
		
		// add "O" and "G" to complete word "DOG"
		testWord.addSquare(O);
		testWord.addSquare(G);
		
		// check to make sure conversion to string is correct
		String wordDOG = testWord.getWordString();
		assertEquals(wordDOG, "DOG");
		
		// test to make sure word in valid and value is correct
		assertTrue(testWord.isValid());
		assertEquals(testWord.calculateValue(), 6);
		
		// add new letter Q to make invalid word 
		testWord.addSquare(O);
		
		// since DOGO is not a word, should return false
		assertFalse(testWord.isValid());
		
		//Check to make sure the last added square is returned
		// when getLastSquare is called.
		assertEquals(testWord.getLastSquare(), O);
		
		// The next three lines confirm that if removeSquare
		// is called on the current word, the last square is removed
		assertEquals(testWord.getWordString(), "DOGO");
		assertEquals(testWord.removeSquare(), true);
		assertEquals(testWord.getWordString(), "DOG");
		
		// Specify a Square in the array of squares that make up a word
		assertEquals(testWord.getCertainSquare(2), O);
		
		
	}
	
	
}

