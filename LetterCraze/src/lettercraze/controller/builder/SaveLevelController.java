package lettercraze.controller.builder;
//Completely Done
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.view.BuilderPuzzlePanelView;
import lettercraze.view.BuilderView;
import lettercraze.view.IBuilderLevelPanel;
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
	
	/** the object to handle writing the file to disk */
	FileIO fileWriter;

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
		this.fileWriter = new FileIO();
	}
	
	/**
	 * on a mouse press, the controller gathers all the data about the level, gives it
	 * to the level panel to parse, then saves the returned level
	 */
	public void mousePressed(MouseEvent me){
		boolean shape[][] = builderView.getBoardView().getBoardShape();
		IBuilderLevelPanel panel = builderView.getCurrentLevelPanel();
		Level level = panel.compileLevelInfo(shape, 2);
		System.out.println(panel.compileLevelInfo(shape, 3).debugString());
		fileWriter.saveLevelToDisk(level);
	}
	
	
}
