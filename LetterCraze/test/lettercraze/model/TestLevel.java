package lettercraze.model;

import java.util.ArrayList;

import junit.framework.TestCase;

public class TestLevel extends TestCase {

		public void testLevel(){
			
			boolean[][] sampleShape = new boolean[6][6];
			boolean active = true;
			for(int row = 0; row < 6; row++){
				for(int col = 0; col < 6; col++){
					sampleShape[row][col] = active;
					//active = !active;
				}
			}
				
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
			
			
			Level testPuzzleDebug = new Puzzle(9, new int[]{100, 200, 300}, 15);
			testPuzzleDebug.setBoardShape(sampleShape);
			String testPuzzleString = testPuzzleDebug.debugString();
			System.out.println(testPuzzleString);
			Level testThemeDebug = new Theme(10, "Schools", testThemeWords);
			testThemeDebug.setBoardShape(sampleShape);
			String testThemeString = testThemeDebug.debugString();
			System.out.println(testThemeString);
			Level testLightningDebug = new Lightning(11, new int[]{5, 10, 15}, 30);
			testLightningDebug.setBoardShape(sampleShape);
			String testLightningString = testLightningDebug.debugString();
			System.out.println(testLightningString);
		}
}
