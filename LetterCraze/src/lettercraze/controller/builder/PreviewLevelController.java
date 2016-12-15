package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import lettercraze.model.BoardState;
import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.view.BuilderDummyGameView;
import lettercraze.view.BuilderView;

/**
 * This controller opens a preview window that loads the data from the
 * builder to show what the level would look like
 * @author Everett
 *
 */
public class PreviewLevelController extends MouseAdapter {

	/** builder view for getting the data make the preview **/
	BuilderView bView;
	
	/** model to maybe setup the boardState **/
	Model model;
	
	/** the parent container **/
	JPanel parent;

	private Object level;
	
	/** Constructor for the PreviewLevelController object
	 * takes in the BuilderView from which to gather data, and the model to edit?
	 * @param bView as BuilderView
	 * @param m as Model
	 * @param parent as JPanel
	 */
	public PreviewLevelController(BuilderView bView, Model m, JPanel parent) {
		this.bView = bView;
		this.model = m; 
		this.parent = parent;
	}
	
	/**
	 * on a mousePress, the controller will gather all the data in the frame and display a gameView mock-up
	 */
	public void mousePressed(MouseEvent me){
		//first we need to compile all the information about the level:
		//so collect the boardShape...
		boolean shape[][] = bView.getBoardView().getBoardShape();
		
		//...and use that to compile the demo level (levelNum 1000)
		Level toDemo = bView.getCurrentLevelPanel().compileLevelInfo(shape, 1000);
		
		this.model.setCurrentBoardState(new BoardState(toDemo));
		BuilderDummyGameView bdgv = new BuilderDummyGameView(toDemo, this.model, parent);
		CardLayout cl = (CardLayout) parent.getLayout();
		parent.add(bdgv, bdgv.getPanelName());
		cl.show(parent, bdgv.getPanelName());
		
	}
	
	

}
