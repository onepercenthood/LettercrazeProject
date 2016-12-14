package lettercraze.view;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JButton;

import lettercraze.controller.builder.BackToMenuController;
import lettercraze.model.FileIO;
import lettercraze.model.Level;
import java.awt.Color;

/**
 * Provides the menu for selecting levels to load into the builder
 * @author Everett
 *
 */
public class BuilderLevelSelecterView extends JPanel{

	/** parent container **/
	JPanel parent;
	
	/** list of levels to select from **/
	ArrayList<Level> levels;
	/**
	 * Constructor for the BuilderLevelSelecterView, takes in the parent container
	 * @param parent as JPanel
	 */
	public BuilderLevelSelecterView(JPanel parent) {
		setBackground(new Color(204, 255, 255));
		this.parent = parent;
		this.levels = FileIO.loadCustomLevelsFromDisk();
		initialize();
	}

	/**
	 * sets up the builderLevelSelecterView panel for use
	 */
	public void initialize(){
		int numLevels = levels.size();
		
		if(numLevels != 0){
			System.out.println("Number of Levels Found: "+ numLevels);
			setLayout(new GridLayout((int) Math.sqrt(numLevels), (int) Math.sqrt(numLevels), 10, 10));				
			
			JButton Menubutton = new JButton("Back To Menu");
	    	Menubutton.addMouseListener(new BackToMenuController(parent, this));
			add(Menubutton); 
			
			for(Level toLoad: levels){
				BuilderLevelThumbnail levelThumbnail = new BuilderLevelThumbnail(toLoad, parent, this);	
				add(levelThumbnail);
				
			}
			
			parent.repaint();

		} else {
			System.err.println("There were no levels on the disk!");
		}
		
	}
	
	/**
	 * gets the name of the panel ("BuilderLevelSelecter")
	 * @return String
	 */
	public String getPanelName(){
		return "BuilderLevelSelecter";
	}
	
	/**
	 * Removes all panels
	 */
	public void removeAllPanels(){
		this.removeAll();
	}
	
	/**
	 * Get all levels
	 * @return as the ArrayList of levels
	 */
	public ArrayList<Level> getAllLevels(){
		return this.levels;
	}
	
	/**
	 * Set levels
	 * @param levels as the levels to set
	 */
	public void setAllLevels(ArrayList<Level> levels){
		this.levels = levels;
	}

	/**
	 * @return the parent
	 */
	public JPanel getParent() {
		return parent;
	}
	
	

}
