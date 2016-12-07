package lettercraze.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestLevel extends TestCase {

		public void testLevel(){
			
			// test puzzle level 
			Level testPuzzle = new Puzzle(1, new int[]{10, 20, 30} , 10);
			
			assertFalse(testPuzzle.isCompleted(0));
			assertTrue(testPuzzle.isCompleted(11));
			
			assertEquals(testPuzzle.getHighStars(8), 0);
			assertEquals(testPuzzle.getHighStars(12), 1);
			assertEquals(testPuzzle.getHighStars(25), 2);
			assertEquals(testPuzzle.getHighStars(38), 3);
			
			assertEquals(testPuzzle.highScore, 0);
			testPuzzle.updateHighScore(5);
			assertEquals(testPuzzle.highScore, 5);
			testPuzzle.updateHighScore(4);
			assertEquals(testPuzzle.highScore, 5);
			
			
			
			ArrayList<String> testThemeWords = new ArrayList<String>();
			testThemeWords.add("WPI");
			testThemeWords.add("MIT");
			testThemeWords.add("Harvard");
			testThemeWords.add("Yale");
			
			Level testTheme = new Theme(2, "Schools", testThemeWords);
			
			assertEquals(testTheme.starThreshold[0], 2);
			assertEquals(testTheme.starThreshold[1], 3);
			assertEquals(testTheme.starThreshold[2], 4);
			
			Level testLightning = new Lightning(3,new int[]{1, 2, 3}, 30);
			
		}
}
