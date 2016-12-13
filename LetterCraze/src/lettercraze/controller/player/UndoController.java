
package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import lettercraze.PlayerApplication;
import lettercraze.model.BoardState;
import lettercraze.model.Model;
import lettercraze.model.Word;
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
		//model.getBoardStateArray().remove(model.getBoardStateArray().size()-1);
		//int index = model.getCurrentBoardState().getFoundWords().size();
		int index = model.getCurrentBoardState().getFoundWords().size() - 1;
		//Word remove = model.getCurrentBoardState().getFoundWords().get(0);
		Word remove = model.getCurrentBoardState().getFoundWords().get(index);
		System.out.println(remove.getLetters());
		
		//takes the calculated score of the played word
		//adds it to the current score and displays it
		int value = remove.calculateValue();
		int currentScore = model.getCurrentBoardState().getScore();
		int newScore = currentScore - value;
		model.getCurrentBoardState().setScore(newScore);
		
		//checks new score against star threshold and displays update accordingly
		int currentStars = model.getLevel(model.getCurrentLevel() + 1).getHighStars(newScore);
		model.getCurrentBoardState().setStars(currentStars);
		
		model.getCurrentBoardState().getFoundWords().remove(model.getCurrentBoardState().getFoundWords().size()-1);
		model.getCurrentBoardState().floatTileDown(model.getCurrentBoardState().getSquares(), remove);
		
		gameView.removeWordModel();
		
		System.out.println("Floating down word: " + remove.toString());
		
		gameView.setStarRater();
		gameView.getStarRater().repaint();
		gameView.getBoardView().repaintAllSquares();
		gameView.setScoreView();
		gameView.getScoreTextField().repaint();
		System.out.println(model.getCurrentBoardState().getSquares());
	}
}
