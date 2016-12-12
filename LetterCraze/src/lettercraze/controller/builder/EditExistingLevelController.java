package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.model.Level;

public class EditExistingLevelController extends java.awt.event.MouseAdapter{

	/** the container for the builderViews **/
	JPanel parent;
	
	/** the level to be edited **/
	Level level;
	
	/** the cardLayout for switching views **/
	CardLayout cardLayout;
	

	public EditExistingLevelController(JPanel parent, Level level) {
		this.parent = parent;
		this.cardLayout = (CardLayout) parent.getLayout();
		this.level = level;
	}
	
	/**
	 * on mousePress: load the level-specific panel with all text fields filled out with the data from the level 
	 */
	public void mousePressed(MouseEvent me){
		cardLayout.show(parent, "Builder View");
	}

}
