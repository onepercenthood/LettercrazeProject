package lettercraze.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;

import lettercraze.controller.builder.BackToMenuController;
import lettercraze.model.FileIO;
import lettercraze.model.Level;

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

	public void initialize(){
		int numLevels = levels.size();
		
		if(numLevels != 0){
			System.out.println("Number of Levels Found: "+ numLevels);
			setLayout(new GridLayout((int) Math.sqrt(numLevels), (int) Math.sqrt(numLevels), 10, 10));				
			
			JButton Menubutton = new JButton("Back To Menu");
	    	Menubutton.addMouseListener(new BackToMenuController(parent, this));
			add(Menubutton); 
			
			for(Level toLoad: levels){
				BuilderLevelThumbnail levelThumbnail = new BuilderLevelThumbnail(toLoad, parent);	
				add(levelThumbnail);
			}
		} else {
			System.err.println("There were no levels on the disk!");
		}
		
	}
	
	public String getPanelName(){
		return "BuilderLevelSelecter";
	}
	
	

}
