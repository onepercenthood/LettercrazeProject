package lettercraze.controller.player;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.view.GameView;
import lettercraze.view.LevelPreviewView;
import lettercraze.view.MenuView;

/**
 * This controller handles leaving the level you are in early in order to 
 * go back to the menu.
 * 
 * It reacts to a MousePress event.
 * 
 * @author ddeisadze
 *
 */
public class LeaveLevelEarlyController extends MouseAdapter{

	/** The game to be manipulated. **/
	Model model;

	/** 
	 * Main Parent panel which holds the cardlayout.
	 */
	JPanel parent;

	/** the squareview that was clicked. **/
	GameView gameView;

	/**
	 * LeaveLevelEarlyController handles leaving the level early to go back to menu.
	 * 
	 * @param parent as the main JPanel from the application which holds the cardLayouts
	 * @param model as the model of the main application
	 * @param gameView as the gameView from the main Application
	 */
	public LeaveLevelEarlyController(JPanel parent, Model model, GameView gameView){
		// TODO Auto-generated constructor stub
		this.parent = parent;
		this.model = model;
		this.gameView = gameView;
	} 

	@Override
	public void mousePressed(MouseEvent me){

		Level thislevel = model.getCurrentLevelObject();
		if(thislevel.getLevelType().equals("Lightning")){
			TimeController.stopTimer();
		}

		int nextLevel = model.getCurrentLevelObject().getLevelNum() + 1;

		int highScore = model.getCurrentLevelObject().getHighScore();
		int currentPlayedScore = model.getCurrentBoardState().getScore();
		//int firstStarThreshold[] = model.getCurrentLevelObject().getStarThreshold();

		int highStarsScored = model.getCurrentLevelObject().getHighStars(currentPlayedScore);

		model.getCurrentLevelObject().updateHighScore(currentPlayedScore);
		//unlocks the next default level, unless this was the last level
		if(thislevel.getLevelNum() < 16){
			boolean isNextLevelUnlocked = model.getLevel(nextLevel).getIsUnlocked();
			//check if first star was reached, if next level not unlocked
			if((highStarsScored >= 1) && (isNextLevelUnlocked == false)){
				model.getLevel(nextLevel).setUnLocked(true);
				System.out.println("Setting level " + nextLevel + " unlocked to true");
				MenuView menu = (MenuView) parent.getComponent(0);
				menu.getLevels().get(nextLevel - 1).setEnabled(true);
			}
			FileIO.saveLevelToDisk(model.getLevel(nextLevel));
		}
		FileIO.saveLevelToDisk(model.getCurrentLevelObject());
		//save high score if needed
		
		// clear current model objects
		model.setCurrentBoardState(null);
		model.setCurrentWord(null);

		CardLayout clay = (CardLayout) parent.getLayout();
		clay.first(parent); //revert to the menu screen
		MenuView mv = (MenuView) parent.getComponent(0);
		//update the levelPreviewView if there's a new highscore
		for(LevelPreviewView lpv: mv.getLevels()){
			if(lpv.getLevelNum() == model.getCurrentLevel()){
				lpv.setHighScore(model.getCurrentLevelObject().getHighScore());
				lpv.getStarField().repaint();						
			}
		}
		parent.repaint();
	}

}
