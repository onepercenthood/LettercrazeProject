
package lettercraze.view;

import java.awt.CardLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;

import lettercraze.BuilderApplication;
import lettercraze.controller.builder.ExitWithoutSavingController;
import lettercraze.controller.builder.ResetBoardSquaresController;
import lettercraze.controller.builder.SaveLevelController;
import lettercraze.model.Model;

import java.awt.Color;
import java.awt.Component;
import java.awt.SystemColor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.Font;

/**
 * BuilderView is the main screen for building levels.
 * It contains the boardView for selecting.
 * @author Everett
 *
 */
public class BuilderView extends DefaultViewPanel implements ItemListener{


	/**
	 * returns the parent panel for the level specific views
	 * @return JPanel
	 */
	public JPanel getPnlLevelSwitch() {
		return pnlLevelSwitch;
	}

	private JPanel contentPane;
	private JPanel cardLayoutPanel;
	private Model model;
	private Font labelFont;
	private Font titleFont;
	private Color bgColor;
	private JPanel pnlLevelSwitch;
	private BuilderApplication app;
	private BoardView boardView;
	private JComboBox<String> comboBox;

	/**
	 * Constructor for the BuilderView object. Takes in the model 
	 * for editing, the parent panel and the parent BuilderApplicaiton.
	 * @param model as Model
	 * @param parent as JPanel
	 * @param app as BuilderApplication
	 */
	public BuilderView(Model model, JPanel parent, BuilderApplication app) {
		super();
		this.model = model;
		this.cardLayoutPanel = parent;
		this.bgColor = new Color(178, 34, 34);
		this.app = app;
		this.labelFont = new Font("Times New Roman", Font.BOLD, 18);
		setBackground(new Color(102,255,102));
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
		pnlPuzzle.setBackground(new Color(102,255,102));
		pnlPuzzle.setLayout(null);

		JPanel pnlLightning = new BuilderLightningPanelView();
		pnlLightning.setBackground(Color.ORANGE);
		pnlLevelSwitch.add(pnlLightning, "Lightning");
		pnlLightning.setLayout(null);


		JPanel pnlTheme = new BuilderThemePanelView(labelFont);
		pnlTheme.setBackground(Color.PINK);
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
		btnSaveLevel.addMouseListener(new SaveLevelController(this, cardLayoutPanel, model));
		//btnSaveLevel.addMouseListener(new ExitWithoutSavingController(this, cardLayoutPanel, model));
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
	 * @return the currently active level pane
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
	/**
	 * @deprecated no longer uses contentPane
	 * gets the content pane from the builderView, content pane does nothing.
	 * @return JPanel
	 */
	public JPanel getContentPane() {
		return contentPane;
	}

	/**
	 * returns the BuilderView's parent container as a JPanel.
	 * @return JPanel
	 */
	public JPanel getParent() {
		return cardLayoutPanel;
	}

	/**
	 * returns the model stored here.
	 * @return Model
	 */
	public Model getModel() {
		return model;
	}

	/**
	 * returns the parent application.
	 * @return BuilderApplication
	 */
	public BuilderApplication getApp() {
		return app;
	}

	/**
	 * returns the boardView.
	 * @return BoardView
	 */
	public BoardView getBoardView() {
		return boardView;
	}


	@Override
	public String getPanelName() {
		return "BuilderView";
	}

	/**
	 * returns the box for switching between the levels.
	 * @return JComboBox<String> with fields: 0 = "Puzzle"; 1 = "Lightning"; 2 = "Theme"
	 */
	public JComboBox<String> getComboBox() {
		return comboBox;
	}

	//when the combo box triggers an item state change, switch the input panels
	@Override
	public void itemStateChanged(ItemEvent evt) {
		Color levelColor = null;
		CardLayout cl = (CardLayout) pnlLevelSwitch.getLayout();
		cl.show(pnlLevelSwitch, (String) evt.getItem());
		
		String string = (String) evt.getItem();
		
		if(string.equals("Puzzle")){
			levelColor = new Color(102,255,102);
		}
		else if(string.equals("Lightning")){
			levelColor = Color.ORANGE;
		}
		else if(string.equals("Theme")){
			levelColor = Color.PINK;
		}
		this.setBackground(levelColor);

	}

	/**
	 * resets all the fields in the builder screen
	 * @return true
	 */
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


