package lettercraze.controller.player;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import lettercraze.model.FileIO;
import lettercraze.model.Model;
import lettercraze.view.GameView;
import lettercraze.view.LevelPreviewView;
import lettercraze.view.MenuView;

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

		int nextLevel = model.getCurrentLevelObject().getLevelNum() + 1;

		int highScore = model.getCurrentLevelObject().getHighScore();
		int currentPlayedScore = model.getCurrentBoardState().getScore();
		boolean isNextLevelUnlocked = model.getLevel(nextLevel).getIsUnlocked();
		//int firstStarThreshold[] = model.getCurrentLevelObject().getStarThreshold();

		int highStarsScored = model.getCurrentLevelObject().getHighStars(currentPlayedScore);

		//***stub for later***
		model.getCurrentLevelObject().updateHighScore(currentPlayedScore);
		System.out.println("highStarsScored " + highStarsScored);
		System.out.println("isNextUnlocked " + isNextLevelUnlocked);
		if((highStarsScored >= 1) && (isNextLevelUnlocked == false)){
			model.getLevel(nextLevel).setUnLocked(true);
			System.out.println("Setting level " + nextLevel + " unlocked to true");
			MenuView menu = (MenuView) parent.getComponent(0);
			menu.getLevels().get(nextLevel - 1).setEnabled(true);
		}
		//need a get level obj method in 
		//model.getCurrentLevelObject().setHighScore(model.getCurrentLevelObject().getHighScore());



		FileIO.saveLevelToDisk(model.getCurrentLevelObject());
		FileIO.saveLevelToDisk(model.getLevel(nextLevel));
		//save high score if needed
		//save level to disk
		//check if first star was reached, if next level not unlocked
		//set boardstate to null in model

		// clear current model objects
		model.setCurrentBoardState(null);
		//model.getCurrentBoardState().setScore(0);
		//model.getCurrentBoardState().getFoundWords().clear();
		model.setCurrentWord(null);

		CardLayout clay = (CardLayout) parent.getLayout();
		clay.first(parent); //revert to the menu screen
		MenuView mv = (MenuView) parent.getComponent(0);
		for(LevelPreviewView lpv: mv.getLevels()){
			if(lpv.getLevelNum() == model.getCurrentLevel()){
				lpv.setHighScore(model.getCurrentLevelObject().getHighScore());
				lpv.getStarField().repaint();						
			}
		}
		parent.repaint();
	}

}
