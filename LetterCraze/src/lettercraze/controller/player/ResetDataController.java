package lettercraze.controller.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;

import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.view.LevelPreviewView;
import lettercraze.view.MenuView;

/**
 * This controller resets all data including highscores, stars, etc. in the levels from 
 * the mainmenu view.
 * 
 * @author ddeisadze
 *
 */
public class ResetDataController implements ActionListener{

	/** MenuView to be repainted */
	MenuView mv;
	
	/**
	 * The main constructor for this controller
	 * @param mv menuView as initialized in the main appplication level.
	 */
	public ResetDataController (MenuView mv){
		this.mv = mv;
	}
	
	/**
	 * ActionPerformed method which wraps this controller in an actionable method.
	 */
	public void actionPerformed(ActionEvent act) {
		File source = new File("default_levels_original");
		File destination = new File("default_levels");
		
		try {
		    FileUtils.copyDirectory(source, destination);
		    System.out.println("Reseting the views...");
		    ArrayList<Level> levels = FileIO.loadDefaultLevelsFromDisk();
		    ArrayList<LevelPreviewView> levelViews = mv.getLevels();
		    for(int i = 0; i < levels.size(); i++){
		    	levelViews.get(i).updateInfo(levels.get(i));
		    	levelViews.get(i).getStarField().repaint();
		    	levelViews.get(i).repaint();
		    }
//		    for(LevelPreviewView lpv: mv.getLevels()){
//		    	lpv.updateInfo();
//		    	lpv.getStarField().repaint();
//		    	lpv.repaint();
//		    }mv.repaint();
		    
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
	}
	
}
