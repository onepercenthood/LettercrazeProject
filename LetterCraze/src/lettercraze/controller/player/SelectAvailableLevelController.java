package lettercraze.controller.player;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import lettercraze.PlayerApplication;
import lettercraze.model.BoardState;
import lettercraze.model.Level;
import lettercraze.model.Lightning;
import lettercraze.model.Model;
import lettercraze.view.GameView;

/**
 * SelectAvailableLevelController handles the selection of the level from the main-menu.
 * 
 * This controller is responsible for the loading of the BoardView and initialization of the BoardState for the
 * gameview component in our application.
 * 
 * @author ddeisadze
 *
 */
public class SelectAvailableLevelController implements ActionListener{

	/**the model object to be manipulated. **/
	Model model;
	
	/** the top level application. **/
	PlayerApplication app;
	
	/** number of the level to be called when this button is pressed. **/
	int levelNum;
	
	/**
	 * CardLayout which holds the sequentila panels from our main application.
	 */
	CardLayout cardlayout;
	
	GameView gameView;

	private boolean isOverWrite = false;
	
	public SelectAvailableLevelController(int lvl, Model model, CardLayout cl, PlayerApplication app){
		super();
		this.levelNum = lvl;
		this.cardlayout = cl;
		this.app = app;
		this.model = app.getModel();
	}
	
	public SelectAvailableLevelController(Integer levelNumber, CardLayout cardLayout, PlayerApplication app2) {
		// TODO Auto-generated constructor stub
		
		this.levelNum = levelNumber;
		this.cardlayout = cardLayout;
		this.app = app2;
		this.model = app.getModel();
		//mod.initiateLevel(levelNum);
		//app.getModel().initiateLevel(levelNum);
	}
	
	public SelectAvailableLevelController(int lvl, Model model, CardLayout cl, PlayerApplication app, boolean isOverwrite){
		super();
		this.levelNum = lvl;
		this.cardlayout = cl;
		this.app = app;
		this.model = app.getModel();
		this.isOverWrite  = isOverwrite;
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
		
		// Get the Current Level and create a new BoardState with that Level's Board Shape 
		Level curLevel = model.getLevel(levelNum);
		model.setCurrentLevel(levelNum);
		if( !isOverWrite){
			model.setCurrentBoardState(new BoardState(curLevel));
		}		
		
		// Create a new GameView with the model
		gameView = new GameView(model, levelNum, app.getCardLayoutParent(), app);
		app.getCardLayoutParent().add(gameView, gameView.getPanelName());
		
		// Paint the Squares onto the GameView 
		gameView.getBoardView().repaintAllSquares();
		
		
		// Display the Game View to the Player 
		cardlayout.show(app.getCardLayoutParent(), "GameView");
		
		System.out.println(curLevel.getLevelType());

		// If it is a lightning level, the a Timer needs to be initialized 
		if(curLevel.getLevelType().equals("Lightning")){
			
			// Print statements for confirmations 
			System.out.println("Timer initialized");
			System.out.print("Time till exp: " + ((Lightning) curLevel).getSeconds());
			
			// Create Time Instance 
			TimeController timeCont = new TimeController(app, app.getModel(), gameView, ((Lightning) curLevel).getSeconds());
			//Start the timer, the timer runs and updates the GUI in its own thread
			TimeController.startTimer(((Lightning) curLevel).getSeconds() * 1000, timeCont);
			
		}
		else if(curLevel.getLevelType() == "Theme"){
			
		}
		 
	}
}
