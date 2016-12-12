package lettercraze.view;

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

	public void initialize(){
		int numLevels = levels.size();
		
		if(numLevels != 0){
			System.out.println("Number of Levels Found: "+ numLevels);
			setLayout(new GridLayout((int) Math.sqrt(numLevels), (int) Math.sqrt(numLevels), 10, 10));				
			for(Level toLoad: levels){
				BuilderLevelThumbnail levelThumbnail = new BuilderLevelThumbnail(toLoad, parent);	
				add(levelThumbnail);
			}
		} else {
			this.setLayout(null);
			JButton btnReturn = new JButton("Return to Main Screen");
			btnReturn.setBounds(100,20,getWidth()/2,getHeight()/2);
			btnReturn.addMouseListener(new MouseAdapter(){
				@Override
				public void mousePressed(MouseEvent me){
					
				}
			});
			add(btnReturn);
			System.err.println("There were no levels on the disk!");
		}
		
	}
	
	public String getPanelName(){
		return "BuilderLevelSelecter";
	}
	
	

}
