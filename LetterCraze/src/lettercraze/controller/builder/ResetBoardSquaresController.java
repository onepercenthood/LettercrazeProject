package lettercraze.controller.builder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import lettercraze.model.Model;
import lettercraze.view.BuilderView;

/**
 * 
 * This controller will reset the squares on the builderView
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
	
	/**
	 * The main constructor for this class.
	 * 
	 * @param builderView as the buidlerView panel from mainApplication
	 * @param model as the global model 
	 */
	public ResetBoardSquaresController(BuilderView builderView, Model model) {
		super();
		this.builderView = builderView;
		this.model = model;
	}
	
	/**
	 * MousePressed method as the main actionable method in this class.
	 */
	public void mousePressed(MouseEvent me){
		builderView.resetAllFields();
	}

}
