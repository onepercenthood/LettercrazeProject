package lettercraze.view;

import javax.swing.JPanel;

import lettercraze.controller.builder.EditExistingLevelController;
import lettercraze.model.Level;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JButton;

public class BuilderLevelThumbnail extends JPanel {

	/** the level to be represented **/
	Level level;
	
	/** the top level parent to switch to editor **/
	JPanel grandParentPanel;
		
	/**
	 * Create the panel.
	 */
	public BuilderLevelThumbnail(Level level, JPanel grandParent) {
		this.grandParentPanel = grandParent;
		this.level = level;
		initialize();
	}
	
	public void initialize(){
		setLayout(null);
		switch(level.getLevelType()){
		case "Puzzle": 
		case "puzzle": this.setBackground(Color.GREEN); break;
		case "lightning":
		case "Lightning": this.setBackground(Color.ORANGE); break;
		case "theme":
		case "Theme": this.setBackground(Color.PINK); break;
		default: this.setBackground(Color.WHITE); break;
		}
		
		JLabel lblLevelType = new JLabel("Level Type: " + level.getLevelType());
		lblLevelType.setBounds(15, 0, 270, 58);
		add(lblLevelType);
		
		JLabel lblLevelNumber = new JLabel("Level Number: " + level.getLevelNum());
		lblLevelNumber.setBounds(15, 49, 122, 37);
		add(lblLevelNumber);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(90, 102, 120, 29);
		btnEdit.addMouseListener(new EditExistingLevelController(grandParentPanel, level));
		add(btnEdit);
		
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    };
}