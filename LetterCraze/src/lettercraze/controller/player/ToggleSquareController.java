package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
import lettercraze.PlayerApplication;
import lettercraze.view.SquareView;
import lettercraze.model.Model;
import lettercraze.model.Square;

public class ToggleSquareController extends MouseAdapter{

	/** The game to be manipulated **/
	Model model;
	
	/** the top level application for navigation purposes **/
	PlayerApplication application;
	
	/** the squareview that was clicked **/
	SquareView squareView;
	
	public ToggleSquareController(PlayerApplication playerApp, SquareView squareView, Model model) {
		super();
		this.model = model;
		this.application = playerApp;
		this.squareView = squareView;
	}

	public void mousePressed(MouseEvent me){
		Square toEdit = squareView.getSquare();
		//toggle whether the square is active
		toEdit.toggleSelected();
		squareView.repaintSquare();
		System.out.println("Selected: " + toEdit.isSelected() + "Active: " + toEdit.isActive());
	}
	
	

}
