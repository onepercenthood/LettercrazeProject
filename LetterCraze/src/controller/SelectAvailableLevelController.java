package controller;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.view.LevelPreviewView;

public class SelectAvailableLevelController implements ActionListener{

	/**the model object to be manipulated **/
	Model mod;
	
	/** the levelThumbnail object to be associated with the level and levelView **/
	/*TODO add button to add eventlistener */
	LevelPreviewView ltnail;
	
	/** the button to be associated with the level **/
	JButton lvlButt;
	
	/** number of the level to be called when this button is pressed **/
	int levelNum;
	
	CardLayout clay;
	
	public SelectAvailableLevelController(LevelPreviewView l, JButton b, int lvl, CardLayout cl){
		super();
		//mod = m;
		ltnail = l;
		lvlButt = b;
		levelNum = lvl;
		clay = cl;
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
		mod.intiateLevel(levelNum);
		//TODO switch to GameView
		clay.show();
		
	}
}
