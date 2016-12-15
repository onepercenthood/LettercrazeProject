package lettercraze.controller.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import lettercraze.PlayerApplication;
import lettercraze.model.Model;
import lettercraze.model.Puzzle;
import lettercraze.model.Theme;
import lettercraze.view.GameView;

/**
 * Resets the level after a click of the button
 * @author Dean
 *
 */
public class ResetLevelController extends MouseAdapter{


	private PlayerApplication application;
	private Model model;
	private GameView gameView;


	/**
	 * 
	 * Controls the reset board function for all level types
	 * 
	 * @param application Main application level
	 * @param model Model that stores application wide data
	 * @param gameView GameView Boundary class access to view 
	 */
	public ResetLevelController(PlayerApplication application, Model model, GameView gameView) {

		this.application = application;
		this.model = model;
		this.gameView = gameView;

	}

	public void mousePressed(MouseEvent me){
		System.out.println("Reseting Level");
		if(model.getLevel(model.getCurrentLevel()).getLevelType().equals("Puzzle")){
			gameView.setTypeSpecificLabel("Moves Left: " + ((Puzzle)model.getLevel(model.getCurrentLevel())).getMaxWords());
		}
		int i = 0;
		while(model.getCurrentBoardState().getFoundWords().size() > i){
			gameView.removeWordModel();
			i++;
		}

		model.getCurrentBoardState().setClearFoundWords();
		model.getCurrentBoardState().setScore(0);
		model.getCurrentBoardState().setStars(0);

		if(model.getLevel(model.getCurrentLevel()).getLevelType().equals("Theme")){
			model.getCurrentBoardState().initialFill(model.getCurrentBoardState(), ((Theme)model.getLevel(model.getCurrentLevel())).getTargetWords());
		}
		
		else{
			model.getCurrentBoardState().initialFill(model.getCurrentBoardState().getSquares());
		}
		gameView.setScoreView();
		gameView.setStarRater();

		gameView.getWordBox().repaint();
		gameView.getScoreTextField().repaint();
		gameView.getStarRater().repaint();
		gameView.getBoardView().repaintAllSquares();
	}

}
