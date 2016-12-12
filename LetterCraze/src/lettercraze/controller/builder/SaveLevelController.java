package lettercraze.controller.builder;
//Completely Done
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.view.BuilderPuzzlePanelView;
import lettercraze.view.BuilderView;
import lettercraze.view.AbsBuilderLevelPanel;
import lettercraze.view.SquareView;

public class SaveLevelController extends MouseAdapter{
	
	/** the parent builderView panel. **/
	BuilderView builderView;
	
	/** the parent panel for the level-specific panels. **/
	JPanel cardLayoutPanel;
	
	/** the layout manager of the level-specific panels. **/
	CardLayout cardLayout;
	
	/** the mode associated with this builder session. */
	Model model;
	
	/**
	 * Constructor for the SaveLevelControllerObject
	 * @param view: the builderView that contains the level-specific panel to pull information from.
	 * @param model: the model associated with this Builder Application
	 */
	public SaveLevelController(BuilderView view, Model model) {
		super();
		this.builderView = view;
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
		Level level;
		
		//if the level was already saved, use the saved level number & overwrite
		if(panel.getLevelLoaded() != null){
			level = panel.compileLevelInfo(shape, panel.getLevelLoaded().getLevelNum());

		} //otherwise, give it a new level number at the end of the list
		else {
			int numLevels = levels.size();
			level = panel.compileLevelInfo(shape, 16 + numLevels);
		} 
		
		System.out.println(level.debugString());
		FileIO.saveLevelToDisk(level);
		
	}
	
	
}
