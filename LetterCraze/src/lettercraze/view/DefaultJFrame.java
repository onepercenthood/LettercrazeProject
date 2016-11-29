package lettercraze.view;
import java.awt.Dimension;

import javax.swing.JFrame;

public class DefaultJFrame extends JFrame{
	
	public DefaultJFrame() {
		this.getContentPane().setPreferredSize(new Dimension(1000, 1000));
	    this.pack();

	}

}
