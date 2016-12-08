//package lettercraze.model;
//
//import junit.framework.TestCase;
//
///**
// * Test Case for Word 
// * 
// * @author Hoodie
// *
// */
//public class TestWord extends TestCase {
//	
//	public void testWord(){
//		
//		// Test letters to use
//		Letter D = new Letter("D",2,0.0); 
//		Letter O = new Letter("O",2,0.0);
//		Letter G = new Letter("G",2,0.0);
//		
//		// Create instance to test - Start with letter D
//		//Word testWord = new Word(D);
//		
//		// check to make sure the size of word = 1 ;
//	//	int size1 = testWord.letters.size();
//	//	assertEquals(size1, 1);
//		
//		// check to make sure getWordStringReturns single letter
//		String singleLetter = testWord.getWordString();
//		assertEquals(singleLetter, "D");
//		
//		// Since a word is valid only if it has 3 or more letters
//		// and is in WordList, should return false 
//		assertFalse(testWord.isValid());
//		
//		// add "O" and "G" to complete word "DOG"
//		//testWord.addLetter(O);
//		//testWord.addLetter(G);
//		
//		// check to make sure conversion to string is correct
//		String wordDOG = testWord.getWordString();
//		assertEquals(wordDOG, "DOG");
//		
//		// test to make sure word in valid and value is correct
//		assertTrue(testWord.isValid());
//		assertEquals(testWord.calculateValue(), 6);
//		
//		// add new letter Q to make invalid word 
//		//testWord.addLetter(new Letter("Q",2,2.0));
//		
//		// since DOGQ is not a word, should return false
//		assertFalse(testWord.isValid());
//		
//		
//	}
//	
//	
//}
