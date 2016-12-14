package lettercraze.controller.player;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.Timer;

import lettercraze.PlayerApplication;
import lettercraze.model.BoardState;
import lettercraze.model.Level;
import lettercraze.model.Lightning;
import lettercraze.model.Model;
import lettercraze.view.GameView;
import lettercraze.view.LevelPreviewView;

public class SelectAvailableLevelController implements ActionListener{

	/**the model object to be manipulated **/
	Model mod;
	
	/** the top level application **/
	PlayerApplication app;
	
	/** number of the level to be called when this button is pressed **/
	int levelNum;
	
	CardLayout cardlayout;
	
	GameView gameView;
	
	public SelectAvailableLevelController(int lvl, Model model, CardLayout cl, PlayerApplication app){
		super();
		this.levelNum = lvl;
		this.cardlayout = cl;
		this.app = app;
		this.mod = app.getModel();
	}
	
	public SelectAvailableLevelController(Integer levelNumber, CardLayout cardLayout, PlayerApplication app2) {
		// TODO Auto-generated constructor stub
		
		this.levelNum = levelNumber;
		this.cardlayout = cardLayout;
		this.app = app2;
		this.mod = app.getModel();
		//mod.initiateLevel(levelNum);
		//app.getModel().initiateLevel(levelNum);
	}

	/**
	 * When a mousePressed event occurs the level associated with the panel is loaded
	 * to the gui and opened to be played 
	 */
	@Override
	public void actionPerformed(ActionEvent act) {
		//TODO check a bunch of preconditions:
		/**
		 * valid level number
		 * no levels are currently open
		 * level is unlocked
		 */
		//mod.initiateLevel(levelNum);
		//switch to GameView
		Level curLevel = app.getModel().getLevel(levelNum);
		//app.getModel().setCurrentBoardState(new BoardState(curLevel.getBoardShape()));
		app.getModel().setCurrentBoardState(new BoardState(curLevel));
		
		//GameView curGameView = app.getGameView();
		gameView = new GameView(mod, levelNum, app.getCardLayoutParent(), app);
		app.getCardLayoutParent().add(gameView, gameView.getPanelName());
		gameView.getBoardView().repaintAllSquares();
		//Level curLevel = app.getModel().getLevel(levelNum);
		cardlayout.show(app.getCardLayoutParent(), "GameView");
		//curGameView.updateLevelTypeLabel(curLevel.getLevelType());

		if( curLevel.getLevelType() == "Lightning" ){
			
			System.out.println("Timer initialized");
			System.out.print("Time till exp: " + ((Lightning) curLevel).getSeconds());
			
			
			//TimeController timeCont = new TimeController(app, app.getModel(), curGameView, ((Lightning) curLevel).getSeconds());
			
			//TimeController.startTimer(((Lightning) curLevel).getSeconds() * 1000, timeCont);
			
		}
		else if(curLevel.getLevelType() == "Theme"){
			
		}
		 
	}
}
