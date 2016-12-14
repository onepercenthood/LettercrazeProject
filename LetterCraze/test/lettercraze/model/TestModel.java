package lettercraze.model;

import junit.framework.TestCase;

public class TestModel extends TestCase {

		public void testModel(){
			Model m = new Model();
			
			assertTrue(m.getAllLevels().size() > 1);
			
			
		}
}
