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

public class BuilderLevelSelecterVew extends JPanel{

	/** model to be edited **/
	Model model;
	
	/** parent container **/
	JPanel parent;
	
	/** list of levels to select from **/
	ArrayList<Level> levels;
	
	public BuilderLevelSelecterVew(JPanel parent, Model model) {
		this.parent = parent;
		this.model = model;
		this.levels = FileIO.loadCustomLevelsFromDisk();
		initialize();
	}

	public void initialize() {
		int numLevels = levels.size();
		setLayout(new GridLayout(5, 10, 1, 10));
				
		for(Level toLoad: levels){
			BuilderLevelThumbnail levelThumbnail = new BuilderLevelThumbnail(toLoad, parent);	
			add(levelThumbnail);
		}
		
	}
	
	public String getPanelName(){
		return "BuilderLevelSelecter";
	}
	
	

}
