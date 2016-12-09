package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.BuilderApplication;
import lettercraze.PlayerApplication;
import lettercraze.view.BoardView;
import lettercraze.view.SquareView;
import lettercraze.model.BoardState;
import lettercraze.model.Model;
import lettercraze.model.Square;
import lettercraze.model.Word;

public class ClearWordController extends MouseAdapter{

	/** The game to be manipulated **/
	Model model;

	/** the top level application for navigation purposes **/
	PlayerApplication application;

	/** the squarViews of the active boardState **/
	SquareView[][] squareViews;
	
	/** the boardView where the word is selected **/
	BoardView boardView;

	public ClearWordController(PlayerApplication playerApp, BoardView boardView, Model model) {
		super();
		this.model = model;
		this.application = playerApp;
		this.boardView = boardView;
		this.squareViews = boardView.getSquareViews();
	}

	public void mousePressed(MouseEvent me){
		Word word = model.getCurrentWord();
		BoardState tempBoard = model.getCurrentBoardState();
		tempBoard.deselectAllSquares();
		model.setCurrentWord(null);
		model.setCurrentBoardState(tempBoard);
		boardView.repaintAllSquares();
		for(SquareView[] row: boardView.getSquareViews()){
			for(SquareView s: row){
				System.out.print("[" + s.getSquare().isSelected() + "]");
			}
			System.out.println();
		}
//		Square toEdit = squareView.getSquare();
//		while(word.getWordLength() > 0){
//			word = model.getCurrentWord();
//			word.removeSquare();
//			model.setCurrentWord(word);
//			toEdit.toggleSelected();
//			squareView.repaintSquare();
//		}

	}
}
