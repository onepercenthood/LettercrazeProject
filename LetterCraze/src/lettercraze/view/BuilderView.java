
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

import lettercraze.BuilderApplication;
import lettercraze.controller.builder.ExitWithoutSavingController;
import lettercraze.controller.builder.ResetBoardSquaresController;
import lettercraze.controller.builder.SaveLevelController;
import lettercraze.model.Model;

import java.awt.Color;
import java.awt.Component;
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


	public JPanel getPnlLevelSwitch() {
		return pnlLevelSwitch;
	}

	private JPanel contentPane;
	private JPanel cardLayoutPanel;
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
	private BuilderApplication app;
	private BoardView boardView;
	private JComboBox<String> comboBox;


	public BuilderView(Model model, JPanel parent, BuilderApplication app) {
		super();
		this.model = model;
		this.cardLayoutPanel = parent;
		this.bgColor = new Color(178, 34, 34);
		this.app = app;
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
		//buildBoardImage();

		boardView = new BoardView(new Color(20,200,160), model, 1, app);
		boardView.builderInitialize(app);
		boardView.setSize(408, 440);
		boardView.setLocation(39, 158);
		add(boardView);

		comboBox = new JComboBox<String>();
		comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Puzzle", "Lightning", "Theme"}));
		comboBox.setToolTipText("");
		comboBox.setMaximumRowCount(3);
		comboBox.setBounds(593, 158, 97, 26);
		comboBox.addItemListener(this);
		this.add(comboBox, "ComboBox");

		JLabel lblTitle = new JLabel("LetterCraze: Builder");
		lblTitle.setFont(new Font("Impact", Font.BOLD | Font.ITALIC, 40));
		lblTitle.setBounds(39, 11, 522, 109);
		add(lblTitle);

		pnlLevelSwitch = new JPanel();
		pnlLevelSwitch.setName("pnlLevelSwitch");
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
		JButton btnReset = new JButton("Reset Level");
		btnReset.addMouseListener(new ResetBoardSquaresController(this, model));
		btnReset.setBounds(39, 118, 107, 29);
		add(btnReset);

		JButton btnSaveLevel = new JButton("Save And Exit");
		btnSaveLevel.setBounds(156, 118, 111, 29);
		btnSaveLevel.addMouseListener(new SaveLevelController(this, model));
		btnSaveLevel.addMouseListener(new ExitWithoutSavingController(this, cardLayoutPanel, model));
		add(btnSaveLevel);

		JLabel lblLevelType = new JLabel("Level Type");
		lblLevelType.setFont(labelFont);
		lblLevelType.setBounds(491, 158, 92, 26);
		add(lblLevelType);

		JButton btnCloseWithoutSaving = new JButton("Close Without Saving");
		//TODO replace with close builder controller
		btnCloseWithoutSaving.addMouseListener(new ExitWithoutSavingController(this, cardLayoutPanel, model));
		btnCloseWithoutSaving.setBounds(273, 118, 174, 29);
		add(btnCloseWithoutSaving);
		repaint();
	}

	/**
	 * returns the active level panel for inputting level-specific information
	 * @return
	 */
	public AbsBuilderLevelPanel getCurrentLevelPanel()
	{
		AbsBuilderLevelPanel card = null;

		//find the component that is set to visible (will be a JPanel
		for (Component comp : pnlLevelSwitch.getComponents() ) {
			if (comp.isVisible() == true) {
				card = (AbsBuilderLevelPanel)comp;
			}
		}

		return card;
	}

	//Getter Methods
	public JPanel getContentPane() {
		return contentPane;
	}

	public JPanel getParent() {
		return cardLayoutPanel;
	}

	public JTextField getTxtfldTwoStar() {
		return txtfldTwoStar;
	}

	public JTextField getTxtfldOneStar() {
		return txtfldOneStar;
	}

	public JTextField getTxtfldThreeStar() {
		return txtfldThreeStar;
	}

	public JTextField getTxtFldInputMaxMoves() {
		return txtFldInputMaxMoves;
	}

	public Model getModel() {
		return model;
	}

	public JTextField getTextField() {
		return textField;
	}

	public JTextField getTextField_1() {
		return textField_1;
	}

	public JTextField getTextField_2() {
		return textField_2;
	}

	public JTextField getTextField_3() {
		return textField_3;
	}

	public JTextField getTxtfldThemeTitle() {
		return txtfldThemeTitle;
	}

	public JTextField getTextField_4() {
		return textField_4;
	}

	public JTextField getTextField_6() {
		return textField_6;
	}

	public BuilderApplication getApp() {
		return app;
	}

	public BoardView getBoardView() {
		return boardView;
	}


	@Override
	public String getPanelName() {
		return "BuilderView";
	}

	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	//when the combo box triggers an item state change, switch the input panels
	@Override
	public void itemStateChanged(ItemEvent evt) {
		CardLayout cl = (CardLayout) pnlLevelSwitch.getLayout();
		cl.show(pnlLevelSwitch, (String) evt.getItem());

	}

	public boolean resetAllFields(){
		//first reset all the squares in the board to true
		boardView.setAllSquaresActive(this);
		
		//next make sure all the textFields in every panel are set to empty
		for(Component comp: pnlLevelSwitch.getComponents()){
			AbsBuilderLevelPanel panel = (AbsBuilderLevelPanel) comp;
			panel.resetFields();
		}
		return true;
	}
}


