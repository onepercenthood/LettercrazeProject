package lettercraze.controller.builder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import lettercraze.BuilderApplication;
import lettercraze.view.SquareView;
import lettercraze.model.Model;
import lettercraze.model.Square;

/**
 * This controller is responsible for selecting the board in order to design the level in our
 * builder application.
 * 
 * @author ddeisadze
 *
 */
public class SelectBoardSquareController extends MouseAdapter{

	/** The game to be manipulated **/
	Model model;
	
	/** the top level application for navigation purposes **/
	BuilderApplication application;
	
	/** the squareview that was clicked **/
	SquareView squareView;
	
	/**
	 * The main constructor for this class.
	 * 
	 * @param app as the main BuilderApplication
	 * @param squareView as the SquareView which was clicked by the user
	 * @param model as the global application model
	 */
	public SelectBoardSquareController(BuilderApplication app, SquareView squareView, Model model) {
		super();
		this.model = model;
		this.application = app;
		this.squareView = squareView;
	}
	
	/**
	 * The main MousePressed event which is the main actionable method.
	 */
	public void mousePressed(MouseEvent me){
		Square toEdit = squareView.getSquare();
		//toggle whether the square is active
		toEdit.setActive(!toEdit.isActive());
		squareView.repaintSquare();
		System.out.println("Selected: " + toEdit.isSelected() + "Active: " + toEdit.isActive());
	}
	

}
