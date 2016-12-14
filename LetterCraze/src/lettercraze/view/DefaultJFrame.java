package lettercraze.view;
import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * the default JFrame for use in the applications
 * @author Everett
 *
 */
public class DefaultJFrame extends JFrame{
	
	/**
	 * Basic Constructor, sets preferred size
	 */
	public DefaultJFrame() {
		this.getContentPane().setPreferredSize(new Dimension(1000, 1000));
	    this.pack();

	}

}
