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

public class ClearWordController extends MouseAdapter{

	/** The game to be manipulated **/
	Model model;

	/** the top level application for navigation purposes **/
	PlayerApplication application;

	/** the squareview that was clicked **/
	SquareView squareView;

	public ClearWordController(PlayerApplication playerApp, SquareView squareView, Model model) {
		super();
		this.model = model;
		this.application = playerApp;
		this.squareView = squareView;
	}

	public void mousePressed(MouseEvent me){
		Word word = model.getCurrentWord();
		Square toEdit = squareView.getSquare();
		while(word.getWordLength() > 0){
			word = model.getCurrentWord();
			word.removeSquare();
			model.setCurrentWord(word);
			toEdit.toggleSelected();
			squareView.repaintSquare();
		}

	}
}
