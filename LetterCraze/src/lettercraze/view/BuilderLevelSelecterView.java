package lettercraze.view;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.model.Model;

public class BuilderLevelSelecterView extends JPanel{

	/** parent container **/
	JPanel parent;
	
	/** list of levels to select from **/
	ArrayList<Level> levels;
	
	public BuilderLevelSelecterView(JPanel parent) {
		this.parent = parent;
		this.levels = FileIO.loadCustomLevelsFromDisk();
		initialize();
	}

	public void initialize() {
		int numLevels = levels.size();
		System.out.println("Number of Levels Found: "+ numLevels);
		setLayout(new GridLayout((int) Math.sqrt(numLevels), (int) Math.sqrt(numLevels), 10, 10));
				
		for(Level toLoad: levels){
			BuilderLevelThumbnail levelThumbnail = new BuilderLevelThumbnail(toLoad, parent);	
			add(levelThumbnail);
		}
		
	}
	
	public String getPanelName(){
		return "BuilderLevelSelecter";
	}
	
	

}
