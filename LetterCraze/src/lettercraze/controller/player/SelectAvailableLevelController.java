package lettercraze.controller.player;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import lettercraze.PlayerApplication;
import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.view.LevelPreviewView;

public class SelectAvailableLevelController implements ActionListener{

	/**the model object to be manipulated **/
	Model mod;
	
	/** the top level application **/
	PlayerApplication app;
	
	/** number of the level to be called when this button is pressed **/
	int levelNum;
	
	CardLayout cardlayout;
	
	public SelectAvailableLevelController(int lvl, CardLayout cl, PlayerApplication app){
		super();
		levelNum = lvl;
		cardlayout = cl;
		this.app = app;
	}
	
	public SelectAvailableLevelController(Integer levelNumber, CardLayout cardLayout, PlayerApplication app2) {
		// TODO Auto-generated constructor stub
		
		this.levelNum = levelNumber;
		this.cardlayout = cardLayout;
		this.app = app2;
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
		//mod.intiateLevel(levelNum);
		//switch to GameView
		cardlayout.show(app.getCardLayoutParent(), "GameView");
		
	}
}
