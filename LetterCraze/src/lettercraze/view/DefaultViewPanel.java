package lettercraze.view;

import javax.swing.JPanel;

/**
 * the defaultViewPanel for the applications.
 * @author Everett
 *
 */
public abstract class DefaultViewPanel extends JPanel {
	

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor for the view panel
	 */
	public DefaultViewPanel(){
		
	}
	
	/**
	 * returns the name of the panel.
	 * @return String
	 */
	public abstract String getPanelName();

}
