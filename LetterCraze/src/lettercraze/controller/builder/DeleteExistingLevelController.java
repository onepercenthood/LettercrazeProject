package lettercraze.controller.builder;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;

import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.view.BuilderLevelSelecterView;
import lettercraze.view.BuilderLevelThumbnail;
import lettercraze.view.BuilderView;

/**
 * This controller is responsible for allowing the user to delete
 * existing levels.
 * 
 * @author ddeisadze
 *
 */
public class DeleteExistingLevelController extends java.awt.event.MouseAdapter{

	
	/** the level to be edited **/
	Level level;

	private BuilderLevelSelecterView selectorView;

	private BuilderLevelThumbnail thumbnailView;
	

	/**
	 * Main constructor for this controller.
	 * @param selectorView as the selector parent view
	 * @param thumbnailView as the thumbnail view
	 * 
	 * @param parent the main JPanel which holds the cardLayouts
	 * @param level The level to delete
	 */
	public DeleteExistingLevelController(BuilderLevelSelecterView selectorView, BuilderLevelThumbnail thumbnailView, Level level) {
		this.selectorView = selectorView;
		this.thumbnailView = thumbnailView;
		this.level = level;
	}
	
	/**
	 * on mousePress: load the level-specific panel with all text fields filled out with the data from the level 
	 */
	public void mousePressed(MouseEvent me){
		
		int levelNumber = level.getLevelNum();
				
		ArrayList<Level> levels = selectorView.getAllLevels();
		
		ArrayList<Level> newLevels = new ArrayList<Level>();
		
		Level curLevel;
		boolean afterLevelDeletion = false;
		for( int li = 0; li < levels.size(); li++){
			curLevel = levels.get(li);
			
			if( curLevel.equals(level)){
				afterLevelDeletion = true;
				FileIO.deleteExistingCustomLevel(curLevel);
				continue;
			}
			
			if(afterLevelDeletion){
				FileIO.deleteExistingCustomLevel(curLevel);

				curLevel.decrementLevelNumber();
				
				FileIO.saveLevelToDisk(curLevel);
				
				newLevels.add(li-1, curLevel);
				continue;
				
			}
			
			newLevels.add(li, levels.get(li));
		}		
		
		JPanel curParent = selectorView.getParent();
		curParent.remove(selectorView);
		
		CardLayout cdl = (CardLayout) curParent.getLayout();
		
		// HACK BITCHES
		new OpenLevelSelecterController(curParent).mousePressed(me);
		
		
	}

}
