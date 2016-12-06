package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
import lettercraze.PlayerApplication;
import lettercraze.view.SquareView;
import lettercraze.model.Model;
import lettercraze.model.Square;
import lettercraze.model.Word;

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
		Word word = model.getCurrentWord();
		
		if(word != null){
			Square lastSquare = word.getLastSquare();
			if(toEdit.isAdjacent(lastSquare, toEdit)){
				word.addSquare(toEdit);
				model.setCurrentWord(word);
				toEdit.toggleSelected();
				squareView.repaintSquare();
			}
			else{}
		}
		else{
			word = new Word(toEdit);
			model.setCurrentWord(word);
			toEdit.toggleSelected();
			squareView.repaintSquare();
		}
		
		//toggle whether the square is active
		System.out.println(word.getWordString());
		System.out.println("Selected: " + toEdit.isSelected() + "Active: " + toEdit.isActive());
	}
	
	

}
