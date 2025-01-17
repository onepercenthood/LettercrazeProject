package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
import lettercraze.model.Model;

/**
 * This controller handles the creating of new level button in the main builder view.
 * 
 * This will allow the user to build custom levels.
 * 
 * @author Everett Harding
 * 
 */
public class CreateNewLevelController extends MouseAdapter{

	/** The top level application **/
	BuilderApplication app;
	
	/** the model to be changed **/
	Model model;
	
	/**the layout manager, for switching "Active" views **/
	CardLayout cardLayout;

	/** the parent container for the cardLayout **/
	Container cardLayoutPanel;	
	
	/**
	 * The main constructor for this controller. 
	 * 
	 * @param app as the main BuilderApplication
	 * @param cardLayoutPanel as the main panel which holds the card layout structure
	 * @param model as the model from the main BuilderApplication
	 */
	public CreateNewLevelController(BuilderApplication app, JPanel cardLayoutPanel, Model model) {
		super();
		this.app = app;
		this.cardLayoutPanel = cardLayoutPanel;
		this.cardLayout = (CardLayout) cardLayoutPanel.getLayout();
		this.model = model;
	}
	
	/**
	 * On a mouse press, the cardLayout switches the top view of the GUI
	 * to the "BuilderView", and loads a blank level from the model
	 */
	@Override
	public void mousePressed(MouseEvent arg0) {
		
		CardLayout clay = (CardLayout) cardLayoutPanel.getLayout();			
		clay.show(cardLayoutPanel, "BuilderView");
		System.out.println("Switched to BuilderView");
	}

}
