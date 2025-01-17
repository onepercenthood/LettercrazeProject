package lettercraze.view;
import java.awt.BorderLayout;

import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;

import lettercraze.PlayerApplication;
import lettercraze.controller.player.ResetDataController;
import lettercraze.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Font;
import java.awt.Color;
/**
 * MenuView for selecting levels to play
 * @author Everett
 *
 */
public class MenuView extends DefaultViewPanel implements IModelChangedView {


	/**
	 * Unique UID for gui element
	 */
	private static final long serialVersionUID = -1199792392732674767L;

	/**
	 * Model containing application data
	 */
	private Model model;
	
	private ArrayList<LevelPreviewView> levels = new ArrayList<LevelPreviewView>();

	private JLabel lblCustomLevels;

	private JPanel regularLevelsPanel;
	private JPanel customLevelsPanel;

	private GridBagLayout gbl_panel_defaultLevels;

	private GridBagConstraints gbc_lblDefaultLevels;

	private GroupLayout gl_panel;

	private int rowCountDef = 0;
	private int colCountDef = 1;
	
	private int rowCountCus = 0;
	private int colCountCus = 1;

	private GridBagLayout gbl_panel_customLevels;

	private GridBagConstraints gbc_lblCustomLevels;

	private JPanel cardLayoutPanel;
	
	/**
	 * Constructor for the MenuView.
	 * @param cardLayoutPanel as JPanel
	 * @param m as Model
	 * @param playerApplication as PlayerApplication
	 */
	public MenuView(JPanel cardLayoutPanel, Model m, PlayerApplication playerApplication){
		setBackground(new Color(153, 204, 255));
		model = m;
		
		this.cardLayoutPanel = cardLayoutPanel;
		
		
		createPanel();

	}

	/**
	 * Create the Panel.
	 */
	public void createPanel() {

		JPanel panel = new JPanel();
		panel.setBackground(new Color(153, 204, 255));
		add(panel, BorderLayout.CENTER);

		JLabel lblLettercrazeMainMenu = new JLabel("LetterCraze Main Menu");
		lblLettercrazeMainMenu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		JScrollPane scrollPane = new JScrollPane();
		
		JButton btnResetAllProgress = new JButton("Reset All Progress");
		btnResetAllProgress.addActionListener(new ResetDataController(this)); 
		add(btnResetAllProgress, "Reset Data Button");
 
		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 770, Short.MAX_VALUE)
					.addContainerGap())
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(23)
					.addComponent(btnResetAllProgress)
					.addPreferredGap(ComponentPlacement.RELATED, 128, Short.MAX_VALUE)
					.addComponent(lblLettercrazeMainMenu, GroupLayout.PREFERRED_SIZE, 197, GroupLayout.PREFERRED_SIZE)
					.addGap(323))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblLettercrazeMainMenu, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnResetAllProgress))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 496, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(59, Short.MAX_VALUE))
		);
		
		
		Container cont = new Container();

		regularLevelsPanel = new JPanel();
		regularLevelsPanel.setBackground(new Color(204, 255, 255));
		customLevelsPanel = new JPanel();
		customLevelsPanel.setBackground(new Color(204, 255, 255));
		
		
		gbl_panel_defaultLevels = new GridBagLayout();
		gbl_panel_defaultLevels.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_defaultLevels.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_defaultLevels.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_defaultLevels.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		gbl_panel_customLevels = new GridBagLayout();
		gbl_panel_customLevels.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_customLevels.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_customLevels.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_customLevels.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		regularLevelsPanel.setLayout(gbl_panel_defaultLevels);
		customLevelsPanel.setLayout(gbl_panel_customLevels);

		JLabel lblDefaultLevels = new JLabel("Default Levels");
		gbc_lblDefaultLevels = new GridBagConstraints();
		gbc_lblDefaultLevels.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefaultLevels.gridx = 0;
		gbc_lblDefaultLevels.gridy = 0;
		regularLevelsPanel.add(lblDefaultLevels, gbc_lblDefaultLevels);
		
		cont.add(regularLevelsPanel);
		
		cont.setLayout(new GridLayout());
		
		scrollPane.setViewportView(cont);

		lblCustomLevels = new JLabel("Custom Levels");
		
		gbc_lblCustomLevels = new GridBagConstraints();
		gbc_lblCustomLevels.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomLevels.gridx = 0;
		gbc_lblCustomLevels.gridy = 0;
		customLevelsPanel.add(lblCustomLevels, gbc_lblCustomLevels);

		cont.add(customLevelsPanel);
		
		panel.setLayout(gl_panel);
	}
	
	/**
	 * Main logic where the menu is added.
	 * 
	 * @param level
	 * @param isDefaultLevel
	 * @param panel
	 * @param row
	 * @param col
	 * @return
	 */
	private boolean addMenuItem(LevelPreviewView level, boolean isDefaultLevel, JPanel panel, Integer row, Integer col){
		
		GridBagConstraints gdb = new GridBagConstraints();
		gdb.insets = new Insets(0, 0, 5, 5);
		gdb.gridx = row;
		gdb.gridy = col;
		panel.add(level, gdb);
		
		levels.add(level);

		
		row++;
		
		return false;
	}
	
	/**
	 * Adds LevelPreviewView to custom menu.
	 * @param level as LevelPreviewView
	 * @return true if added successfully, false otherwise
	 */
	public boolean addMenuItemToCustom(LevelPreviewView level){
		if(rowCountCus == 3){
			rowCountCus = 0;
			colCountCus++;
		}
		
		rowCountCus++;
		return addMenuItem(level, false, customLevelsPanel,rowCountCus-1, colCountCus);
		
	}
	/**
	 * Adds menu item to default menu, this is private because we do not want to change the default levels.
	 * @param level as LevelPreviewView
	 * @return true if added successfully, false otherwise
	 */
	public boolean addMenuItemToDefault(LevelPreviewView level){
		if(rowCountDef == 3){
			rowCountDef = 0;
			colCountDef++;
		}
		
		rowCountDef++;
		return addMenuItem(level, true, regularLevelsPanel, rowCountDef-1, colCountDef);
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "MainMenu";
	}

	/**
	 * returns the list of all LevelPreviewViews
	 * @return ArrayList<LevelPreviewView>
	 */
	public ArrayList<LevelPreviewView> getLevels() {
		return levels;
	}

	@Override
	public void modelChanged() {
		// TODO Auto-generated method stub
		
	}
}
