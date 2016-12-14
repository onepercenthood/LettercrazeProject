package lettercraze.controller.builder;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import lettercraze.BuilderApplication;
import lettercraze.view.SquareView;
import lettercraze.model.Model;
import lettercraze.model.Square;

public class SelectBoardSquareController extends MouseAdapter{

	/** The game to be manipulated **/
	Model model;
	
	/** the top level application for navigation purposes **/
	BuilderApplication application;
	
	/** the squareview that was clicked **/
	SquareView squareView;
	
	public SelectBoardSquareController(BuilderApplication app, SquareView squareView, Model model) {
		super();
		this.model = model;
		this.application = app;
		this.squareView = squareView;
	}
	
	public void mousePressed(MouseEvent me){
		Square toEdit = squareView.getSquare();
		//toggle whether the square is active
		toEdit.setActive(!toEdit.isActive());
		squareView.repaintSquare();
		System.out.println("Selected: " + toEdit.isSelected() + "Active: " + toEdit.isActive());
	}
	

}
