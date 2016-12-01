package lettercraze.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import lettercraze.model.Model;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuilderView extends DefaultViewPanel {


	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private Model model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model model = new Model();
					BuilderView frame = new BuilderView(model);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param model 
	 */
	public BuilderView(Model model) {
		super();
		//setBackground(Color.BLUE);
		
		
		this.model = model;
		
		setBounds(100, 100, 816, 491);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GREEN);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		
		JPanel panel_39 = new JPanel();
		panel_39.setBounds(493, 360, 256, -281);
		contentPane.add(panel_39);
		panel_39.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Difficulty");
		lblNewLabel.setBounds(0, -270, 61, 16);
		panel_39.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		panel.setBounds(20, 27, 410, 399);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(6, 6, 0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SystemColor.activeCaption);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_1);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.activeCaption);
		panel_4.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(SystemColor.activeCaption);
		panel_5.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(SystemColor.activeCaption);
		panel_7.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_7);
		
		JPanel panel_8 = new JPanel();
		panel_8.setBackground(SystemColor.activeCaption);
		panel_8.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_8);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(SystemColor.activeCaption);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBackground(SystemColor.activeCaption);
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(SystemColor.activeCaption);
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(SystemColor.activeCaption);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(SystemColor.activeCaption);
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(SystemColor.activeCaption);
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(SystemColor.activeCaption);
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBackground(SystemColor.activeCaption);
		panel_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBackground(SystemColor.activeCaption);
		panel_17.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBackground(SystemColor.activeCaption);
		panel_18.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBackground(SystemColor.activeCaption);
		panel_19.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBackground(SystemColor.activeCaption);
		panel_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBackground(SystemColor.activeCaption);
		panel_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBackground(SystemColor.activeCaption);
		panel_22.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBackground(SystemColor.activeCaption);
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(SystemColor.activeCaption);
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_24);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(SystemColor.activeCaption);
		panel_25.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(SystemColor.activeCaption);
		panel_26.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBackground(SystemColor.activeCaption);
		panel_27.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_27);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBackground(SystemColor.activeCaption);
		panel_28.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_28);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBackground(SystemColor.activeCaption);
		panel_29.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_29);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBackground(SystemColor.activeCaption);
		panel_30.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_30);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBackground(SystemColor.activeCaption);
		panel_31.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_31);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBackground(SystemColor.activeCaption);
		panel_32.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_32);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBackground(SystemColor.activeCaption);
		panel_33.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_33);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBackground(SystemColor.activeCaption);
		panel_35.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_35);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBackground(SystemColor.activeCaption);
		panel_34.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_34);
		
		JPanel panel_36 = new JPanel();
		panel_36.setBackground(SystemColor.activeCaption);
		panel_36.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_36);
		
		JPanel panel_37 = new JPanel();
		panel_37.setBackground(SystemColor.activeCaption);
		panel_37.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_37);
		
		JPanel panel_38 = new JPanel();
		panel_38.setBackground(SystemColor.activeCaption);
		panel_38.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.add(panel_38);

		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Puzzle", "Lightning", "Theme"}));
		comboBox.setToolTipText("");
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(553, 41, 124, 27);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBounds(493, 397, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save Level");
		btnNewButton_1.setBounds(632, 397, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblLevelType = new JLabel("Level Type");
		lblLevelType.setBounds(587, 14, 90, 16);
		contentPane.add(lblLevelType);
		
		JLabel lblNewLabel_1 = new JLabel("points");
		lblNewLabel_1.setBounds(670, 130, 79, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("points");
		lblNewLabel_2.setBounds(670, 193, 79, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("points");
		lblNewLabel_3.setBounds(670, 258, 79, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("max moves");
		lblNewLabel_4.setBounds(603, 321, 129, 16);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_star_1 = new JPanel();
		panel_star_1.setBounds(524, 119, 34, 27);
		StarRater starRater1 = new StarRater(1, 1 );
		starRater1.setBounds(0, 6, 48, 16);
		starRater1.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		panel_star_1.add(starRater1);
		contentPane.add(panel_star_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(524, 182, 53, 27);
		StarRater starRater2 = new StarRater(2, 2 );
		starRater2.setBounds(0, 6, 48, 16);
		starRater2.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		panel_2.add(starRater2);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(524, 247, 69, 27);
		StarRater starRater3 = new StarRater(3, 3 );
		starRater3.setBounds(0, 6, 48, 16);
		starRater3.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		panel_3.add(starRater3);
		
		contentPane.add(panel_3);
		
		lettercraze.view.DrawStarShapePanel drawStarShapePanel = new DrawStarShapePanel();
		contentPane.add(drawStarShapePanel);
		
		textField = new JTextField();
		textField.setBounds(599, 128, 61, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(599, 189, 61, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(603, 256, 61, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(532, 319, 61, 20);
		contentPane.add(textField_3);
		
		JButton btnCloseWithoutSaving = new JButton("Close Without Saving");
		btnCloseWithoutSaving.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				
			}
		});
		btnCloseWithoutSaving.setBounds(543, 444, 155, 29);
		contentPane.add(btnCloseWithoutSaving);
		contentPane.repaint();

	
	}

	@Override
	public String getPanelName() {
		return "BuilderView";
	}
}
