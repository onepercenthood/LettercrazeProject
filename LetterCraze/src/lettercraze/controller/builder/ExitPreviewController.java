package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.model.Model;
import lettercraze.view.BuilderDummyGameView;
import lettercraze.view.BuilderView;

/**
 * for exiting the level preview screen
 * @author Everett
 *
 */
public class ExitPreviewController extends MouseAdapter {

	/** builder view for getting the data make the preview **/
	BuilderDummyGameView bView;
	
	/** model to maybe setup the boardState **/
	Model model;
	
	/** the parent container **/
	JPanel parent;
	
	/**
	 * 
	 * @param parent
	 * @param bdgv
	 */
	public ExitPreviewController(JPanel parent, BuilderDummyGameView bdgv) {
		this.bView = bdgv;
		this.parent = parent;
	}

	/**
	 * on a mouse press, delete the bdgv and switch back to the builderView
	 * @param me as MouseEvent
	 */
	public void mousePressed(MouseEvent me){
		//switch back to builderView
		CardLayout cl = (CardLayout) parent.getLayout();
		cl.show(parent, "BuilderView");
		
		//remove the preview view
		parent.remove(bView);
	}
}
