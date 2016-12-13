package lettercraze.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;

import lettercraze.controller.builder.BackToMenuController;
import lettercraze.controller.builder.EditExistingLevelController;
import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.model.Model;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
<<<<<<< HEAD
		
		if(numLevels != 0){
			System.out.println("Number of Levels Found: "+ numLevels);
			setLayout(new GridLayout((int) Math.sqrt(numLevels), (int) Math.sqrt(numLevels), 10, 10));				
			for(Level toLoad: levels){
				BuilderLevelThumbnail levelThumbnail = new BuilderLevelThumbnail(toLoad, parent);	
				add(levelThumbnail);
			}
		} else {
			System.err.println("There were no levels on the disk!");
=======
		System.out.println("Number of Levels Found: "+ numLevels);
		setLayout(new GridLayout((int) Math.sqrt(numLevels)+1, (int) Math.sqrt(numLevels)+1, 10, 10));
		
		JButton Menubutton = new JButton("Back To Menu");
	    Menubutton.addMouseListener(new BackToMenuController(parent, this));
		add(Menubutton);
				
		for(Level toLoad: levels){
			BuilderLevelThumbnail levelThumbnail = new BuilderLevelThumbnail(toLoad, parent);	
			add(levelThumbnail);
>>>>>>> refs/remotes/origin/development
		}
		
	}
	
	public String getPanelName(){
		return "BuilderLevelSelecter";
	}
	
	

}
