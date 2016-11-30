package lettercraze.controller;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
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
	
	JPanel cardLayoutParent;	
	
	public BuilderCreateNewLevelController(BuilderApplication app, JPanel cardLayoutParent, Model model) {
		super();
		this.app = app;
		this.cardLayoutParent = cardLayoutParent;
		this.cardLayout = (CardLayout) cardLayoutParent.getLayout();
		this.model = model;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		cardLayout.show(cardLayoutParent, "BuilderView");
	}

}
