package lettercraze.controller.builder;
//Completely Done
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.view.BuilderView;
import lettercraze.view.AbsBuilderLevelPanel;

/**
 * This controller handles saving the level designed in the builder class
 * it will exit the builder screen if the file saves successfully
 * @author Everett
 *
 */
public class SaveLevelController extends MouseAdapter{

	/** the parent builderView panel. **/
	BuilderView builderView;

	/** the parent panel for the level-specific panels. **/
	JPanel cardLayoutPanel;
	
	/** the parent panel for the builder/menu/levelSelector views **/
	JPanel parentPanel;

	/** the layout manager of the level-specific panels. **/
	CardLayout cardLayout;
	
	/** the layout manager of the builder/menu/levelSelector views **/
	CardLayout parentLayout;

	/** the mode associated with this builder session. */
	Model model;

	/**
	 * Constructor for the SaveLevelControllerObject
	 * @param view as a BuilderView 
	 * @param parentPanel as a JPanel
	 * @param model as a Model 
	 */
	public SaveLevelController(BuilderView view, JPanel parentPanel, Model model) {
		super();
		this.builderView = view;
		this.parentPanel = parentPanel;
		this.parentLayout = (CardLayout) parentPanel.getLayout();
		this.cardLayoutPanel = view.getPnlLevelSwitch();
		this.cardLayout = (CardLayout) cardLayoutPanel.getLayout();
		this.model = model;
	}

	/**
	 * on a mouse press, the controller gathers all the data about the level, gives it
	 * to the level panel to parse, then saves the returned level
	 */
	public void mousePressed(MouseEvent me){
		boolean shape[][] = builderView.getBoardView().getBoardShape();
		ArrayList<Level> levels = FileIO.loadCustomLevelsFromDisk();
		AbsBuilderLevelPanel panel = builderView.getCurrentLevelPanel();
		
		//check that all the information needed to build a level is filled in
		if(!panel.isFilledOut()){
			System.err.println("Some information is missing!");
		} 
		else {
			Level level;

			//if the level was already saved, use the saved level number & overwrite
			if(panel.getLevelLoaded() != null){
				level = panel.compileLevelInfo(shape, panel.getLevelLoaded().getLevelNum());

			} //otherwise, give it a new level number at the end of the list
			else {
				//find how many levels are in the folder
				int numLevels = levels.size();
				//if there were none, this will be the first
				if(numLevels == 0){
					numLevels = 1;
				}
				level = panel.compileLevelInfo(shape, 16 + numLevels);

			} 

			System.out.println(level.debugString());
			//try to save the file, will return true if successful
			if(FileIO.saveLevelToDisk(level)){
				//create an anonymous exitWithOutSavingController, and exit to the menu Screen
				new ExitWithoutSavingController(builderView, parentPanel, model).mousePressed(me);
			} else{
				System.err.println("There was an issue saving level:" + level.getLevelType() +", " + level.getLevelNum());
			}
		}
	}


}
