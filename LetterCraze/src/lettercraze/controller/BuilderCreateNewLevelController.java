package lettercraze.controller;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import lettercraze.model.Model;

/**
 * 
 * @author Everett Harding
 * 
 */
public class BuilderCreateNewLevelController extends MouseAdapter{

	/** The top level application **/
	BuilderApplication app;
	
	/** the model to be changed **/
	Model model;
	
	/**the layout manager, for switching "Active" views **/
	CardLayout cardLayout;	
	
	public BuilderCreateNewLevelController(BuilderApplicaiton app, CardLayout cardLayout, Model model) {
		super();
		this.app = app;
		this.cardLayout = cardLayout;
		this.model = model;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		cardLayout.show(app.getContentPane(), "BuilderView");
	}

}
