package lettercraze.model;

import junit.framework.TestCase;

public class TestLetter extends TestCase {

	public void testLetter(){
		
		// Letter Object to Test
		Letter Z = new Letter("Z", 9, 3.14);
		
		assertEquals(Z.getLetter(), "Z");
		assertEquals(Z.getValue(), 9);
		assertEquals(Z.getFrequency(), 3.14);
		assertEquals(Z.toString(), "Z, 9");
	}
}
