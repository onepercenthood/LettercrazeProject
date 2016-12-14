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
import lettercraze.view.GameView;


public class ResetLevelController extends MouseAdapter{


	private PlayerApplication application;
	private Model model;
	private GameView gameView;
	
	/** Counter to set the number of seconds for the Timer */
	private int counter;
	
	/** Create Timer Instance */
    private static Timer timer;
   	
	/** Delay for the time between each tick, default to 1000 mS to represent a second tick period */
    protected int delay = 1000; 	
	/**
	 * 
	 * Controls the timer functionality in the lighting type level 
	 * 
	 * @param application Main application level
	 * @param model Model that stores application wide data
	 * @param gameView GameView Boundary class access to views
	 * @param seconds seconds is the number of seconds to start the count down timer at 
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
		
		model.getCurrentBoardState().initialFill(model.getCurrentBoardState().getSquares());
		
		gameView.setScoreView();
		gameView.setStarRater();
		
		gameView.getWordBox().repaint();
		gameView.getScoreTextField().repaint();
		gameView.getStarRater().repaint();
		gameView.getBoardView().repaintAllSquares();
    }

}
