package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
import lettercraze.model.Model;
import lettercraze.view.BuilderPuzzlePanelView;
import lettercraze.view.SquareView;

public class SaveLevelController extends MouseAdapter{
	
	BuilderApplication app;
	
	JPanel cardLayoutPanel;
	
	CardLayout cardLayout;
	
	Model model;

	public SaveLevelController(BuilderApplication app, JPanel cardLayoutPanel, Model model) {
		super();
		this.app = app;
		this.cardLayoutPanel = cardLayoutPanel;
		this.cardLayout = (CardLayout) cardLayoutPanel.getLayout();
		this.model = model;
	}
	
	public void mousePressed(MouseEvent me){
		boolean shape[][] = getShape();
		BuilderPuzzlePanelView test = (BuilderPuzzlePanelView) app.getBuilderView().getPnlLevelSwitch().getComponent(0);
		System.out.println(test.compileLevelInfo(shape, 1));
	}
	
	/**
	 * Hack of a function, returns the desired boardshape from the squares pointed to by the gui.
	 * Does not gather any data through the level class
	 * @return
	 */
	private boolean[][] getShape(){
		boolean shape[][] = new boolean[6][6];
		SquareView[][] sqViews = app.getBuilderView().getBoardView().getSquareViews();
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				shape[row][col] = sqViews[row][col].getSquare().isActive();
			}
		}
		return shape;
	}

}
