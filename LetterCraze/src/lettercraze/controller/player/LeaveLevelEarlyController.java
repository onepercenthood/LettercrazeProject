package lettercraze.controller.player;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

import lettercraze.PlayerApplication;
import lettercraze.model.FileIO;
import lettercraze.model.Model;
import lettercraze.view.GameView;

public class LeaveLevelEarlyController extends MouseAdapter{
	
	/** The game to be manipulated **/
	Model model;
	
	JPanel parent;
	
	/** the squareview that was clicked **/
	GameView gameView;

	public LeaveLevelEarlyController(JPanel parent, Model model, GameView gameView){
		// TODO Auto-generated constructor stub
		this.parent = parent;
		this.model = model;
		this.gameView = gameView;
	}
	
	@Override
	public void mousePressed(MouseEvent me){
		
		//***stub for later***
		if(model.getCurrentBoardState().getScore() > model.getCurrentLevelObject().getHighScore()){
			//need a get level obj method in 
			//model.getCurrentLevelObject().setHighScore(model.getCurrentLevelObject().getHighScore());
			
		}
		
		FileIO.saveLevelToDisk(model.getCurrentLevelObject());
		//save high score if needed
		//save level to disk
		//check if first star was reached, if next level not unlocked
		//set boardstate to null in model

		CardLayout clay = (CardLayout) parent.getLayout();
		clay.first(parent); //revert to the menu screen
	}
	
}
