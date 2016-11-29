package lettercraze.view;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Container;

import javax.swing.JPanel;
import javax.swing.JLabel;
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

import net.miginfocom.swing.MigLayout;

public class MenuView extends DefaultViewPanel {


	/**
	 * Unique UID for gui element
	 */
	private static final long serialVersionUID = -1199792392732674767L;

	/**
	 * Model containing application data
	 */
	private Model model;
	
	private ArrayList<LevelThumbnail> levels = new ArrayList<LevelThumbnail>();

	private JLabel lblCustomLevels;

	private JPanel regularLevelsPanel;
	private JPanel customLevelsPanel;


	private GridBagLayout gbl_panel_defaultLevels;

	private GridBagConstraints gbc_lblDefaultLevels;

	private GroupLayout gl_panel;

	private int col;
	private int row;
	
	private int rowCountDef = 0;
	private int colCountDef = 1;
	
	private int rowCountCus = 0;
	private int colCountCus = 1;

	private GridBagLayout gbl_panel_customLevels;

	private GridBagConstraints gbc_lblCustomLevels;
	
	public MenuView(Model m){
		model = m;
		
		createPanel();

	}

	/**
	 * Create the Panel.
	 * @param row 
	 */
	public void createPanel() {

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		JLabel lblLettercrazeMainMenu = new JLabel("LetterCraze Main Menu");

		JScrollPane scrollPane = new JScrollPane();

		gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
				gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
						.addContainerGap(328, Short.MAX_VALUE)
						.addComponent(lblLettercrazeMainMenu)
						.addGap(319))
				.addGroup(gl_panel.createSequentialGroup()
						.addGap(45)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 692, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(53, Short.MAX_VALUE))
				);
		gl_panel.setVerticalGroup(
				gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
						.addContainerGap()
						.addComponent(lblLettercrazeMainMenu)
						.addGap(18)
						.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 377, GroupLayout.PREFERRED_SIZE)
						.addContainerGap(173, Short.MAX_VALUE))
				);
		
		
		Container cont = new Container();

		regularLevelsPanel = new JPanel();
		customLevelsPanel = new JPanel();
		
		
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
		cont.add(customLevelsPanel);
		
		cont.setLayout(new GridLayout());
		
		scrollPane.setViewportView(cont);

		lblCustomLevels = new JLabel("Custom Levels");
		
		gbc_lblCustomLevels = new GridBagConstraints();
		gbc_lblCustomLevels.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomLevels.gridx = 0;
		gbc_lblCustomLevels.gridy = 0;
		customLevelsPanel.add(lblCustomLevels, gbc_lblCustomLevels);


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
	private boolean addMenuItem(LevelThumbnail level, boolean isDefaultLevel, JPanel panel, Integer row, Integer col){

		System.out.println(rowCountDef);
		
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
	 * Adds level to custom menu.
	 * 
	 * This is public.
	 * 
	 * @param level
	 * @return
	 */
	public boolean addMenuItemToCustom(LevelThumbnail level){
		if(rowCountCus == 5-1){
			rowCountCus = 0;
			colCountCus++;
		}
		
		rowCountCus++;
		return addMenuItem(level, false, customLevelsPanel,rowCountCus, colCountCus);
		
	}
	/**
	 * Adds menu item to default menu, this is private because we do not want to change the default levels.
	 * @param level
	 * @return
	 */
	public boolean addMenuItemToDefault(LevelThumbnail level){
		if(rowCountDef == 5-1){
			rowCountDef = 0;
			colCountDef++;
		}
		
		rowCountDef++;
		return addMenuItem(level, true, regularLevelsPanel, rowCountDef, colCountDef);
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "MainMenu";
	}

}
