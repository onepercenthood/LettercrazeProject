package lettercraze.controller.builder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import lettercraze.model.Model;
import lettercraze.view.BuilderView;
import lettercraze.view.SquareView;

/**
 * 
 * @extends MouseAdapter
 * @author Everett
 *
 */
public class ResetBoardSquaresController extends MouseAdapter{

	/**the builder view with everything that needs to be reset */
	BuilderView builderView;
	
	/**the model that contains the squares that need to be reset */
	Model model;
	
	public ResetBoardSquaresController(BuilderView builderView, Model model) {
		super();
		this.builderView = builderView;
		this.model = model;
	}
	
	public void mousePressed(MouseEvent me){
		builderView.resetAllFields();
	}

}
