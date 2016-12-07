package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
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
		boolean shape[][] = getShape();
		IBuilderLevelPanel panel = builderView.getCurrentLevelPanel();
		System.out.println(panel.compileLevelInfo(shape, 2).debugString());
		//TODO add saving the level with Derek's level export wizard
	}
	
	/**
	 * @return the desired boardShape from the squares pointed to by the gui
	 */
	private boolean[][] getShape(){
		boolean shape[][] = new boolean[6][6];
		//get all the squareViews from the GUI
		SquareView[][] sqViews = builderView.getBoardView().getSquareViews();
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				shape[row][col] = sqViews[row][col].getSquare().isActive();
			}
		}
		return shape;
	}

}
