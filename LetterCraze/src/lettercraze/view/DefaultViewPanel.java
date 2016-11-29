package lettercraze.view;

import javax.swing.JPanel;

public abstract class DefaultViewPanel extends JPanel {
	

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	
	public DefaultViewPanel(){
		
	}
	
	public abstract String getPanelName();

}
