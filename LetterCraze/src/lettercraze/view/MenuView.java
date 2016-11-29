package lettercraze.view;
import java.awt.BorderLayout;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import lettercraze.model.Model;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
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
	
	private ArrayList<BoxView> levels = new ArrayList<BoxView>();

	public MenuView(Model m){
		model = m;
		
		createPanel();

	}

	/**
	 * Create the Panel.
	 */
	public void createPanel() {

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		JLabel lblLettercrazeMainMenu = new JLabel("LetterCraze Main Menu");

		JScrollPane scrollPane = new JScrollPane();

		GroupLayout gl_panel = new GroupLayout(panel);
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


		JPanel panel_2 = new JPanel();
		scrollPane.setViewportView(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.rowHeights = new int[]{0, 0, 0, 0, 0};
		gbl_panel_2.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);

		JLabel lblDefaultLevels = new JLabel("Default Levels");
		GridBagConstraints gbc_lblDefaultLevels = new GridBagConstraints();
		gbc_lblDefaultLevels.insets = new Insets(0, 0, 5, 5);
		gbc_lblDefaultLevels.gridx = 0;
		gbc_lblDefaultLevels.gridy = 0;
		panel_2.add(lblDefaultLevels, gbc_lblDefaultLevels);


		
		// initialize all the menu boxes here
		int col =5;
		int row = 4;

		int total_count = 0;

		String[] levelTypes = {"Puzzle", "Lightning", "Theme"};
		Color[] levelColors = {Color.GREEN, Color.ORANGE, Color.PINK};

		String levelType;
		int levelI;
		for( int rowi = 1; rowi < row; rowi++ ){

			for( int coli=0; coli < col; coli++){
				System.out.println(total_count);
				System.out.println("rowi" + rowi + " col" + coli);
				levelI = total_count % 3;
				levelType = levelTypes[levelI];

				total_count += 1;
				
				BoxView level = new BoxView(levelType, levelColors[levelI], total_count, 0);

				levels.add(level);
		
				GridBagConstraints gbc_panel_41 = new GridBagConstraints();
				gbc_panel_41.insets = new Insets(0, 0, 5, 5);
				gbc_panel_41.gridx = coli;
				gbc_panel_41.gridy = rowi;
				panel_2.add(level, gbc_panel_41);
				
			}


		}

		JLabel lblCustomLevels = new JLabel("Custom Levels");

		GridBagConstraints gbc_lblCustomLevels = new GridBagConstraints();
		gbc_lblCustomLevels.insets = new Insets(0, 0, 5, 5);
		gbc_lblCustomLevels.gridx = 0;
		gbc_lblCustomLevels.gridy = row+1;
		panel_2.add(lblCustomLevels, gbc_lblCustomLevels);

		panel.setLayout(gl_panel);
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "MainMenu";
	}

}
