package lettercraze.view;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.Box;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.SpringLayout;
import net.miginfocom.swing.MigLayout;

public class MainMenu extends DefaultViewPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = -1199792392732674767L;

	/**
	 * Create the Panel.
	 */
	public MainMenu() {
		
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
//		
//		JPanel panel_3 = new JPanel();
//		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
//		gbc_panel_3.insets = new Insets(0, 0, 5, 5);
//		gbc_panel_3.gridx = 1;
//		gbc_panel_3.gridy = 1;
//		panel_2.add(panel_3, gbc_panel_3);
//		panel_3.setLayout(new MigLayout("", "[grow]", "[][][grow]"));
//		
//		JLabel label = new JLabel("Puzzle");
//		panel_3.add(label, "cell 0 0");
//		
//		JButton button = new JButton("Level 1");
//		panel_3.add(button, "cell 0 1");
//		
//		JPanel panel_1_star = new JPanel();
//		panel_3.add(panel_1_star, "cell 0 2,grow");
//		
//		StarRater starRater = new StarRater(3, 2, 3);
//		starRater.addStarListener(new StarRater.StarListener() {
//
//			@Override
//			public void handleSelection(int selection) {
//				// TODO Auto-generated method stub
//				
//			}
//		
//		});
//		//		
//				panel_1_star.add(starRater);
//				
//				JPanel panel_4 = new JPanel();
//				GridBagConstraints gbc_panel_4 = new GridBagConstraints();
//				gbc_panel_4.insets = new Insets(0, 0, 5, 5);
//				gbc_panel_4.gridx = 2;
//				gbc_panel_4.gridy = 1;
//				panel_2.add(panel_4, gbc_panel_4);
//				panel_4.setLayout(new MigLayout("", "[grow]", "[][][grow]"));
//				
//				JLabel lblLightning = new JLabel("Lightning");
//				panel_4.add(lblLightning, "cell 0 0");
//				
//				JButton btnLevel = new JButton("Level 2");
//				panel_4.add(btnLevel, "cell 0 1");
//				
//				JPanel panel_2_star = new JPanel();
//				
//				StarRater starRater2 = new StarRater(3, 2, 3);
//				starRater2.addStarListener(new StarRater.StarListener() {
//
//					@Override
//					public void handleSelection(int selection) {
//						// TODO Auto-generated method stub
//						
//					}
//				
//				});
//				//		
//				panel_2_star.add(starRater2);
//				panel_4.add(panel_2_star, "cell 0 2,grow");
//				
//				JPanel panel_button_3 = new JPanel();
//				GridBagConstraints gbc_panel_41 = new GridBagConstraints();
//				gbc_panel_41.insets = new Insets(0, 0, 5, 5);
//				gbc_panel_41.gridx = 3;
//				gbc_panel_41.gridy = 1;
//				panel_2.add(panel_button_3, gbc_panel_41);
//				panel_button_3.setLayout(new MigLayout("", "[grow]", "[][][grow]"));
//				
//				JLabel lblLightning1 = new JLabel("Theme");
//				panel_button_3.add(lblLightning1, "cell 0 0");
//				
//				JButton btnLevel1 = new JButton("Level 3");
//				panel_button_3.add(btnLevel1, "cell 0 1");
//				
//				JPanel panel_2_star1 = new JPanel();
//				
//				StarRater starRater21 = new StarRater(3, 1, 3);
//				starRater21.addStarListener(new StarRater.StarListener() {
//
//					@Override
//					public void handleSelection(int selection) {
//						// TODO Auto-generated method stub
//						
//					}
//				
//				});
//				//		
//				panel_2_star1.add(starRater21);
//				panel_button_3.add(panel_2_star1, "cell 0 2,grow");
				
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
						
						
						JPanel panel_button_3 = new JPanel();
						panel_button_3.setBackground(levelColors[levelI]);
						GridBagConstraints gbc_panel_41 = new GridBagConstraints();
						gbc_panel_41.insets = new Insets(0, 0, 5, 5);
						gbc_panel_41.gridx = coli;
						gbc_panel_41.gridy = rowi;
						panel_2.add(panel_button_3, gbc_panel_41);
						panel_button_3.setLayout(new MigLayout("", "[grow]", "[][][grow]"));
						
						JLabel lblLightning1 = new JLabel(levelType);
						panel_button_3.add(lblLightning1, "cell 0 0");
						
						JButton btnLevel1 = new JButton("Level " + total_count);
						panel_button_3.add(btnLevel1, "cell 0 1");
						
						JPanel panel_2_star1 = new JPanel();
						
						StarRater starRater21 = new StarRater(3, (coli % 3) + 1 );
						starRater21.addStarListener(new StarRater.StarListener() {

							@Override
							public void handleSelection(int selection) {
								// TODO Auto-generated method stub
								
							}
						
						});
						//		
						panel_2_star1.add(starRater21);
						panel_button_3.add(panel_2_star1, "cell 0 2,grow");
						
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
