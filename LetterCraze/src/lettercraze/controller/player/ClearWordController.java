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

/**
 * ClearWordController clears the currently toggled squares that the user has selected. It clears
 * the current word on the view as well as clearing in the model.
 * @author ddeisadze
 *
 */
public class ClearWordController extends MouseAdapter{

	/** The game to be manipulated. **/
	Model model;

	/** the top level application for navigation purposes. **/
	PlayerApplication application;

	/** the squarViews of the active boardState. **/
	SquareView[][] squareViews;
	
	/** the boardView where the word is selected. **/
	BoardView boardView;

	/**
	 * ClearWordController constructor.
	 * 
	 * @param playerApp as the main PlayerApplication
	 * @param boardView the boardView from the gameView or from model, by calling model
	 * @param model as the model singleton of the entire application
	 */
	public ClearWordController(PlayerApplication playerApp, BoardView boardView, Model model) {
		super();
		this.model = model;
		this.application = playerApp;
		this.boardView = boardView;
		this.squareViews = boardView.getSquareViews();
	}

	/**
	 * Mouse pressed event simulator.
	 */
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
	}
}
