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
		
		//set up the parent panel/layout manager for switching the level-specific info panels
		JPanel levelSwitch = bView.getPnlLevelSwitch();
		CardLayout levelCards = (CardLayout) levelSwitch.getLayout();
		
		//add some flags for indicating when we're done
		boolean foundCard = false;
		int i = 0;
		while(!foundCard && i < 3){ 
			
			//try to fill the current pane. If it is the right pane, this will return true
			if(bView.getCurrentLevelPanel().fillAllFields(level)){
				
				//switch the panels to match the level type
				levelCards.show(levelSwitch, level.getLevelType());
				bView.getBoardView().setBoardShape(level.getBoardShape());
				
				//set the level selector box to the correct header
				switch(level.getLevelType()){
				case "Puzzle": bView.getComboBox().setSelectedIndex(0); break; //sets combo box to Puzzle
				case "Lightning": bView.getComboBox().setSelectedIndex(1); break; //sets combo box to Lightning
				case "Theme": bView.getComboBox().setSelectedIndex(2); break; //sets combo box to Theme
				default: bView.getComboBox().setSelectedIndex(0); // the default is to set it to Puzzle
				} 
				
				//repaint the boardView
				bView.getBoardView().repaintAllSquares();
				
				//return true, because it all worked
				foundCard = true;
			} else {//the card was incorrect, so try the next card and count that we tried that one
				levelCards.next(levelSwitch);
				i ++;
			}
		}

	}

}
