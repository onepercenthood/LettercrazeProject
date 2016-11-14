package ui;
import java.awt.BorderLayout;
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

public class MainMenu extends DefaultJFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu frame = new MainMenu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainMenu() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblLettercrazeMainMenu = new JLabel("LetterCraze Main Menu");
		
		JPanel panel_1 = new JPanel();
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(152, Short.MAX_VALUE)
					.addComponent(lblLettercrazeMainMenu)
					.addGap(145))
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(42)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(41, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblLettercrazeMainMenu)
					.addGap(18)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(35, Short.MAX_VALUE))
		);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[]{88, 88, 88, 88, 0};
		gbl_panel_1.rowHeights = new int[]{171, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_1.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
		
		Box horizontalBox = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox = new GridBagConstraints();
		gbc_horizontalBox.fill = GridBagConstraints.BOTH;
		gbc_horizontalBox.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalBox.gridx = 0;
		gbc_horizontalBox.gridy = 0;
		panel_1.add(horizontalBox, gbc_horizontalBox);
		
		JButton btnNewButton = new JButton("Level 1");
		horizontalBox.add(btnNewButton);
		
		Box horizontalBox_1 = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox_1 = new GridBagConstraints();
		gbc_horizontalBox_1.fill = GridBagConstraints.BOTH;
		gbc_horizontalBox_1.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalBox_1.gridx = 1;
		gbc_horizontalBox_1.gridy = 0;
		panel_1.add(horizontalBox_1, gbc_horizontalBox_1);
		
		JButton button = new JButton("Level 2");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		horizontalBox_1.add(button);
		
		Box horizontalBox_2 = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox_2 = new GridBagConstraints();
		gbc_horizontalBox_2.fill = GridBagConstraints.BOTH;
		gbc_horizontalBox_2.insets = new Insets(0, 0, 0, 5);
		gbc_horizontalBox_2.gridx = 2;
		gbc_horizontalBox_2.gridy = 0;
		panel_1.add(horizontalBox_2, gbc_horizontalBox_2);
		
		JButton button_1 = new JButton("Level 3");
		horizontalBox_2.add(button_1);
		
		Box horizontalBox_3 = Box.createHorizontalBox();
		GridBagConstraints gbc_horizontalBox_3 = new GridBagConstraints();
		gbc_horizontalBox_3.fill = GridBagConstraints.BOTH;
		gbc_horizontalBox_3.gridx = 3;
		gbc_horizontalBox_3.gridy = 0;
		panel_1.add(horizontalBox_3, gbc_horizontalBox_3);
		
		JButton button_2 = new JButton("Level 4");
		horizontalBox_3.add(button_2);
		

		panel.setLayout(gl_panel);
	}
}
