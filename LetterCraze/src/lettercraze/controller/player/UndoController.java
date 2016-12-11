package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import lettercraze.PlayerApplication;
import lettercraze.model.BoardState;
import lettercraze.model.Model;
import lettercraze.view.GameView;

public class UndoController extends MouseAdapter{

	/** The game to be manipulated **/
	Model model;
	
	/** the top level application for navigation purposes **/
	PlayerApplication application;
	
	/** the squareview that was clicked **/
	GameView gameView;
	
	public UndoController(PlayerApplication application, Model model, GameView gameView) {
		// TODO Auto-generated constructor stub
		this.application = application;
		this.model = model;
		this.gameView = gameView;
	}
	
	public void mousePressed(MouseEvent me){
		model.getBoardStateArray().remove(model.getBoardStateArray().size()-1);
		gameView.getStarRater().repaint();
		gameView.getBoardView().repaintAllSquares();
		gameView.getScoreTextField().repaint();
		System.out.println(model.getCurrentBoardState().getSquares());
	}
}
