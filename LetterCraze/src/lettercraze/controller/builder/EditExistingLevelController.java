package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.model.Level;
import lettercraze.view.BuilderView;

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
		cardLayout.show(parent, "BuilderView");
		//remove the builderselector view from the container, to be re-loaded later
		parent.remove(2);
		BuilderView bView = null;
		for(Component comp: parent.getComponents()){
			if(comp instanceof BuilderView){
				bView = (BuilderView) comp;
			}
		}
		if(bView == null){
			System.err.println("Couldn't find the builderView!");
			return;
		}
		
		JPanel levelSwitch = bView.getPnlLevelSwitch();
		CardLayout levelCards = (CardLayout) levelSwitch.getLayout();
		boolean foundCard = false;
		int i = 0;
		while(!foundCard && i < 3){ 
			if(bView.getCurrentLevelPanel().fillAllFields(level)){
				levelCards.show(levelSwitch, level.getLevelType());
				bView.getBoardView().setBoardShape(level.getBoardShape());
				bView.getBoardView().repaintAllSquares();
				foundCard = true;
			} else {
				levelCards.next(levelSwitch);
				i ++;
			}
		}

	}

}
