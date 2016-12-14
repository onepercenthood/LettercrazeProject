package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.model.Model;
import lettercraze.view.BuilderLevelSelecterView;
import lettercraze.view.BuilderView;

/**
 * Back to menu controller handles back to menu in the event the user is in the builder
 * and wishes to go back and either choose 'Create New Level' or 'Edit Existing Level'.
 * 
 * @author ddeisadze
 *
 */
public class BackToMenuController extends MouseAdapter {

	/** the panel containing the menuView and the builderView exists. **/
	JPanel parentPanel;
	
	/** the manager for the parent JPanel. */
	CardLayout cardLayout;
	
	/** the model to be edited in the builder. **/
	Model model;
	
	/** the builderView, to be wiped. **/
	BuilderView builderView;
	
	/**
	 * MainPanel which acts as the topmost panel and holds the card layouts.
	 */
	BuilderLevelSelecterView mainPanel;
	
	/**
	 * Main constructor for this controller.
	 * 
	 * @param parentPanel as the parentPanel which holds the card layouts
	 * @param mainPanel as the BuilderLevelSelectorView which is initialized in the OpenLevelSelecterController
	 */
	public BackToMenuController(JPanel parentPanel, BuilderLevelSelecterView mainPanel){
		this.parentPanel = parentPanel;
		this.mainPanel = mainPanel;
		this.cardLayout = (CardLayout) parentPanel.getLayout();
	}
	
	/**
	 * MousePressed method which acts a the main actionable method in this class.
	 */
	public void mousePressed(MouseEvent me){
		
		//gets the cardLayout manager of the level-specific panels and sets it to show the puzzle panel
		//((CardLayout) builderView.getPnlLevelSwitch().getLayout()).first(builderView.getPnlLevelSwitch());
		cardLayout.show(parentPanel, "Builder Menu View");
		
		parentPanel.remove(mainPanel);
	}
}