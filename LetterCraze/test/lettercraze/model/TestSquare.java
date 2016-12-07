package lettercraze.model;

import junit.framework.TestCase;

public class TestSquare extends TestCase {

	public void testSquare(){
		
		//Create Test Squares 
		Square test1 = new Square(1,1);
		Square test2 = new Square(1,2);
		Square test3 = new Square(4,4);
		
		// test that getRow, getColumn return correct values
		assertEquals(test1.getRow(), 1);
		assertEquals(test2.getColumn(), 2);
		
		//Check to see if isActive and isSelected is defaulted to false
		assertFalse(test1.isActive);
		assertFalse(test1.isSelected);
		
		// Check to see if toggleActive() & toggleSelected() toggle
		// true to false and false to true 
		assertEquals(test1.toggleActive(), true);
		assertEquals(test1.toggleSelected(), true);
		assertEquals(test1.isActive(), true);
		assertEquals(test1.isSelected(), true);
		assertEquals(test1.toggleActive(), true);
		assertEquals(test1.toggleSelected(), true);
		assertEquals(test1.isActive(), false);
		assertEquals(test1.isSelected(), false);
		
		// Check to see if setActive is working correctly
		test3.setActive(true);
		assertEquals(test3.isActive, true);
		
		// Check isAdjacent method 
		assertEquals(test1.isAdjacent(test1, test2), true);
		assertEquals(test1.isAdjacent(test1, test3), false);
		
		// Check that .newLetter() gives a given square a new random letter
		Letter testLetter = test1.getLetter();
		assertEquals(test1.getLetter(), testLetter);
		test1.newLetter();
		assertFalse(test1.getLetter() == testLetter);
		
		// Check that the alphabet instance equals the Alphabet stored
		assertEquals(test1.alphInst, test1.getAlphInst());
		
		
		
		
	}
}
