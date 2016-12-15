package lettercraze.model;

import junit.framework.TestCase;

/**
 * Test case for Model 
 * @author Hoodie
 *
 */
public class TestModel extends TestCase {

		/**
		 * Test Model 
		 */
		public void testModel(){
			Model m = new Model();
			
			assertTrue(m.getAllLevels().size() > 1);
			
			
		}
}
