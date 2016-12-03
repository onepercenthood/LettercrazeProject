
package lettercraze.view;
import java.awt.BorderLayout;

import java.awt.CardLayout;
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
import java.awt.Container;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JTextArea;

public class BuilderView extends DefaultViewPanel implements ItemListener{


	private JPanel contentPane;
	private JPanel parent;
	private JTextField txtfldTwoStar;
	private JTextField txtfldOneStar;
	private JTextField txtfldThreeStar;
	private JTextField txtFldInputMaxMoves;
	private Model model;
	private Font labelFont;
	private Font titleFont;
	private Color bgColor;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPanel pnlLevelSwitch;
	private JTextField txtfldThemeTitle;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Model model = new Model();
					JFrame jFrame = new DefaultJFrame();
					BuilderView frame = new BuilderView(model);
					jFrame.getContentPane().add(frame);
					jFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @param model 
	 * @wbp.parser.constructor
	 */
	public BuilderView(Model model) {
		super();
		this.model = model;
		this.bgColor = new Color(178, 34, 34);
		this.labelFont = new Font("Times New Roman", Font.BOLD, 18);
		setBackground(bgColor);
		initialize();
	}
	public BuilderView(Model model, JPanel parent) {
		super();
		this.model = model;
		this.parent = parent;
		this.bgColor = new Color(178, 34, 34);
		this.labelFont = new Font("Times New Roman", Font.BOLD, 18);
		setBackground(bgColor);
		initialize();
	}
	
	/** set up the whole board view **/
	public void initialize(){		
		
		setBounds(100, 100, 900, 620);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setLayout(null);
		
		//build the image of the board for toggling the active squares
		buildBoardImage();
		
//		BoardView boardView = new BoardView(new Color(20,200,160), model, 1);
//		boardView.setSize(408, 440);
//		boardView.setLocation(39, 158);
//		add(boardView);

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Puzzle", "Lightning", "Theme"}));
		comboBox.setToolTipText("");
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(593, 158, 97, 26);
		comboBox.addItemListener(this);
		add(comboBox);
		
		JButton btnReset = new JButton("Reset Level");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnReset.setBounds(39, 118, 107, 29);
		add(btnReset);
		
		JButton btnSaveLevel = new JButton("Save Level");
		btnSaveLevel.setBounds(156, 118, 107, 29);
		add(btnSaveLevel);
		
		JLabel lblLevelType = new JLabel("Level Type");
		lblLevelType.setFont(labelFont);
		lblLevelType.setBounds(491, 158, 92, 26);
		add(lblLevelType);
		
		JButton btnCloseWithoutSaving = new JButton("Close Without Saving");
		//TODO replace with close builder controller
		btnCloseWithoutSaving.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {
				CardLayout clay = (CardLayout) parent.getLayout();
				clay.first(parent);
			}
		});
		btnCloseWithoutSaving.setBounds(273, 118, 174, 29);
		add(btnCloseWithoutSaving);
		
		JLabel lblTitle = new JLabel("LetterCraze: Builder");
		lblTitle.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 40));
		lblTitle.setBounds(39, 11, 522, 109);
		add(lblTitle);
		
		pnlLevelSwitch = new JPanel();
		pnlLevelSwitch.setBounds(479, 192, 379, 362);
		pnlLevelSwitch.setLayout(new CardLayout());
		add(pnlLevelSwitch);
		
		JPanel pnlPuzzle = new BuilderPuzzlePanelView(labelFont);
		pnlLevelSwitch.add(pnlPuzzle, "Puzzle");
		pnlPuzzle.setBackground(new Color(0, 128, 0));
		pnlPuzzle.setLayout(null);
				
		JPanel pnlLightning = new BuilderLightningPanelView();
		pnlLightning.setBackground(new Color(255, 140, 0));
		pnlLevelSwitch.add(pnlLightning, "Lightning");
		pnlLightning.setLayout(null);
		
		
		JPanel pnlTheme = new BuilderThemePanelView(labelFont);
		pnlTheme.setBackground(new Color(255, 0, 255));
		pnlLevelSwitch.add(pnlTheme, "Theme");
		pnlTheme.setLayout(null);
		
		contentPane.setVisible(true);
		contentPane.repaint();
		repaint();
//        f.setSize(600, 600);
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
	}

	public void buildBoardImage(){
		JPanel pnlBoardArrangement = new JPanel();
		pnlBoardArrangement.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		pnlBoardArrangement.setBounds(39, 158, 408, 398);
		add(pnlBoardArrangement);
		pnlBoardArrangement.setLayout(null);
		
		JPanel pnlRow1Col1 = new JPanel();
		pnlRow1Col1.setBounds(4, 4, 67, 65);
		pnlRow1Col1.setBackground(SystemColor.activeCaption);
		pnlRow1Col1.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(pnlRow1Col1);
		
		JPanel pnlRow1Col2 = new JPanel();
		pnlRow1Col2.setBounds(71, 4, 67, 65);
		pnlRow1Col2.setBackground(SystemColor.activeCaption);
		pnlRow1Col2.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(pnlRow1Col2);
		
		JPanel pnlRow1Col3 = new JPanel();
		pnlRow1Col3.setBounds(138, 4, 67, 65);
		pnlRow1Col3.setBackground(SystemColor.activeCaption);
		pnlRow1Col3.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(pnlRow1Col3);
		
		JPanel pnlRow1Col4 = new JPanel();
		pnlRow1Col4.setBounds(205, 4, 67, 65);
		pnlRow1Col4.setBackground(SystemColor.activeCaption);
		pnlRow1Col4.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(pnlRow1Col4);
		
		JPanel pnlRow1Col5 = new JPanel();
		pnlRow1Col5.setBounds(272, 4, 67, 65);
		pnlRow1Col5.setBackground(SystemColor.activeCaption);
		pnlRow1Col5.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(pnlRow1Col5);
		
		JPanel pnlRow1Col6 = new JPanel();
		pnlRow1Col6.setBounds(339, 4, 67, 65);
		pnlRow1Col6.setBackground(SystemColor.activeCaption);
		pnlRow1Col6.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(pnlRow1Col6);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBounds(4, 69, 67, 65);
		panel_9.setBackground(SystemColor.activeCaption);
		panel_9.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_9);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(71, 69, 67, 65);
		panel_10.setBackground(SystemColor.activeCaption);
		panel_10.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_10);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(138, 69, 67, 65);
		panel_11.setBackground(SystemColor.activeCaption);
		panel_11.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBounds(205, 69, 67, 65);
		panel_12.setBackground(SystemColor.activeCaption);
		panel_12.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBounds(272, 69, 67, 65);
		panel_13.setBackground(SystemColor.activeCaption);
		panel_13.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_13);
		
		JPanel panel_14 = new JPanel();
		panel_14.setBounds(339, 69, 67, 65);
		panel_14.setBackground(SystemColor.activeCaption);
		panel_14.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_14);
		
		JPanel panel_15 = new JPanel();
		panel_15.setBounds(4, 134, 67, 65);
		panel_15.setBackground(SystemColor.activeCaption);
		panel_15.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_15);
		
		JPanel panel_16 = new JPanel();
		panel_16.setBounds(71, 134, 67, 65);
		panel_16.setBackground(SystemColor.activeCaption);
		panel_16.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_16);
		
		JPanel panel_17 = new JPanel();
		panel_17.setBounds(138, 134, 67, 65);
		panel_17.setBackground(SystemColor.activeCaption);
		panel_17.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_17);
		
		JPanel panel_18 = new JPanel();
		panel_18.setBounds(205, 134, 67, 65);
		panel_18.setBackground(SystemColor.activeCaption);
		panel_18.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_18);
		
		JPanel panel_19 = new JPanel();
		panel_19.setBounds(272, 134, 67, 65);
		panel_19.setBackground(SystemColor.activeCaption);
		panel_19.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setBounds(339, 134, 67, 65);
		panel_20.setBackground(SystemColor.activeCaption);
		panel_20.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_20);
		
		JPanel panel_21 = new JPanel();
		panel_21.setBounds(4, 199, 67, 65);
		panel_21.setBackground(SystemColor.activeCaption);
		panel_21.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_21);
		
		JPanel panel_22 = new JPanel();
		panel_22.setBounds(71, 199, 67, 65);
		panel_22.setBackground(SystemColor.activeCaption);
		panel_22.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_22);
		
		JPanel panel_23 = new JPanel();
		panel_23.setBounds(138, 199, 67, 65);
		panel_23.setBackground(SystemColor.activeCaption);
		panel_23.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_23);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBounds(205, 199, 67, 65);
		panel_24.setBackground(SystemColor.activeCaption);
		panel_24.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_24);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBounds(272, 199, 67, 65);
		panel_25.setBackground(SystemColor.activeCaption);
		panel_25.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_25);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBounds(339, 199, 67, 65);
		panel_26.setBackground(SystemColor.activeCaption);
		panel_26.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_26);
		
		JPanel panel_27 = new JPanel();
		panel_27.setBounds(4, 264, 67, 65);
		panel_27.setBackground(SystemColor.activeCaption);
		panel_27.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_27);
		
		JPanel panel_28 = new JPanel();
		panel_28.setBounds(71, 264, 67, 65);
		panel_28.setBackground(SystemColor.activeCaption);
		panel_28.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_28);
		
		JPanel panel_29 = new JPanel();
		panel_29.setBounds(138, 264, 67, 65);
		panel_29.setBackground(SystemColor.activeCaption);
		panel_29.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_29);
		
		JPanel panel_30 = new JPanel();
		panel_30.setBounds(205, 264, 67, 65);
		panel_30.setBackground(SystemColor.activeCaption);
		panel_30.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_30);
		
		JPanel panel_31 = new JPanel();
		panel_31.setBounds(272, 264, 67, 65);
		panel_31.setBackground(SystemColor.activeCaption);
		panel_31.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_31);
		
		JPanel panel_32 = new JPanel();
		panel_32.setBounds(339, 264, 67, 65);
		panel_32.setBackground(SystemColor.activeCaption);
		panel_32.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_32);
		
		JPanel panel_33 = new JPanel();
		panel_33.setBounds(4, 329, 67, 65);
		panel_33.setBackground(SystemColor.activeCaption);
		panel_33.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_33);
		
		JPanel panel_35 = new JPanel();
		panel_35.setBounds(71, 329, 67, 65);
		panel_35.setBackground(SystemColor.activeCaption);
		panel_35.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_35);
		
		JPanel panel_34 = new JPanel();
		panel_34.setBounds(138, 329, 67, 65);
		panel_34.setBackground(SystemColor.activeCaption);
		panel_34.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_34);
		
		JPanel panel_36 = new JPanel();
		panel_36.setBounds(205, 329, 67, 65);
		panel_36.setBackground(SystemColor.activeCaption);
		panel_36.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_36);
		
		JPanel panel_37 = new JPanel();
		panel_37.setBounds(272, 329, 67, 65);
		panel_37.setBackground(SystemColor.activeCaption);
		panel_37.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_37);
		
		JPanel panel_38 = new JPanel();
		panel_38.setBounds(339, 329, 67, 65);
		panel_38.setBackground(SystemColor.activeCaption);
		panel_38.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnlBoardArrangement.add(panel_38);
		
		System.out.print(Double.toString(panel_38.getSize().getHeight()));
		System.out.print(Double.toString(panel_38.getSize().getWidth()));
	}
	@Override
	public String getPanelName() {
		return "BuilderView";
	}

	//when the combo box triggers an item state change, switch the input panels
	@Override
	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout) pnlLevelSwitch.getLayout();
		cl.show(pnlLevelSwitch, (String) evt.getItem());
		
	}
}


