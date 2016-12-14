package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;
import javax.swing.JPanel;

import lettercraze.model.Model;
import lettercraze.view.BuilderView;

/**
 * Controller to handle exit the editing or creating of a new level without saving progress.
 * 
 * @author ddeisadze
 *
 */
public class ExitWithoutSavingController extends MouseAdapter {

	/** the panel containing the menuView and the builderView exists **/
	JPanel parentPanel;
	
	/** the manager for the parent JPanel */
	CardLayout cardLayout;
	
	/** the model to be edited in the builder **/
	Model model;
	
	/** the builderView, to be wiped **/
	BuilderView builderView;
	
	/**
	 * Main constructor for this class.
	 * 
	 * @param builderView as the builderView panel from the main application instance
	 * @param parentPanel as the main JPanel which holds the cardLayouts
	 * @param model as the global application wide model
	 */
	public ExitWithoutSavingController(BuilderView builderView, JPanel parentPanel, Model model){
		this.builderView = builderView;
		this.parentPanel = parentPanel;
		this.cardLayout = (CardLayout) parentPanel.getLayout();
		this.model = model;
	}
	
	/**
	 * MousePressed event as the main actionable method in this class
	 */
	public void mousePressed(MouseEvent me){
		//reset all fields in the builder except the combo box
		builderView.resetAllFields();
		
		//gets the cardLayout manager of the level-specific panels and sets it to show the puzzle panel
		((CardLayout) builderView.getPnlLevelSwitch().getLayout()).first(builderView.getPnlLevelSwitch());
		cardLayout.show(parentPanel, "BuilderMenuView");
		
		//sets the combo box to puzzle
		JComboBox<String> box = builderView.getComboBox();
		box.setSelectedIndex(0);
	}
}
