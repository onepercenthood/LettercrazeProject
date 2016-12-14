package lettercraze.view;

import javax.swing.JPanel;

import lettercraze.controller.builder.DeleteExistingLevelController;
import lettercraze.controller.builder.EditExistingLevelController;
import lettercraze.model.Level;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * the thumbnail representation of the level with a button to select it
 * @author Everett
 *
 */
public class BuilderLevelThumbnail extends JPanel {

	/** the level to be represented **/
	Level level;
	
	/** the top level parent to switch to editor **/
	JPanel grandParentPanel;
	
	/**
	 * The bulderLevelSelector view which is the parent of this view
	 */
	BuilderLevelSelecterView parent;
		
	/**
	 * Create the panel.
	 */
	public BuilderLevelThumbnail(Level level, JPanel grandParent, BuilderLevelSelecterView parent) {
		this.grandParentPanel = grandParent;
		this.level = level;
		this.parent = parent;
		initialize();
	}
	
	/**
	 * sets up the color, text labels, and JButton of the thumbnail
	 */
	public void initialize(){
		setLayout(null);
		switch(level.getLevelType()){
		case "Puzzle": 
		case "puzzle": this.setBackground(new Color(102,255,102)); break;
		case "lightning":
		case "Lightning": this.setBackground(Color.ORANGE); break;
		case "theme":
		case "Theme": this.setBackground(Color.PINK); break;
		default: this.setBackground(Color.WHITE); break;
		}
		
		JLabel lblLevelType = new JLabel("Level Type: " + level.getLevelType());
		lblLevelType.setBounds(15, 0, 122, 37);
		add(lblLevelType);
		
		JLabel lblLevelNumber = new JLabel("Level Number: " + level.getLevelNum());
		lblLevelNumber.setBounds(15, 33, 122, 37);
		add(lblLevelNumber);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.setBounds(17, 70, 120, 29);
		btnEdit.addMouseListener(new EditExistingLevelController(grandParentPanel, level));
		add(btnEdit);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(15, 97, 122, 29);
		btnDelete.addMouseListener(new DeleteExistingLevelController( this.parent, this, level));
		add(btnDelete);
		
	}
	
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(300, 300);
    }
}
