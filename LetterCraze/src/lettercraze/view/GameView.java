package lettercraze.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Window;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javafx.scene.shape.Box;
import lettercraze.PlayerApplication;
import lettercraze.model.Model;
import lettercraze.view.BoardView;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class GameView extends DefaultViewPanel implements IModelChangedView {

	
	private JPanel playerPanel;
	
	private final Color colorPlayer = new Color(0, 204, 204);
	
	private ArrayList<JPanel> gridPanels = new ArrayList<JPanel>();

	private JLabel titleTextField;

	private JLabel levelType;

	private JLabel scoreTextField;

	private StarRater starRater;
	
	private BoardView boardview;

	private Model model;
	
	protected int levelNum;

	private JButton btnExitLevel;
	
	private JPanel parent;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
			        frame.setPreferredSize(new Dimension(800,800));
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			        Model m = new Model();
			        //frame.getContentPane().add(new GameView(m, 1)); //using just lev1 for now, change later
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
	public GameView(Model m, int levelNum, PlayerApplication app) {
		super();
		this.model = m;
		this.levelNum = levelNum;
		this.boardview = new BoardView(colorPlayer, this.model, levelNum, app);
		boardview.playerInitialize(app);
		createPanel();
	}
	
	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public GameView(Model m, JPanel parent, PlayerApplication app) {
		this.model = m;
		this.levelNum = 1;
		this.boardview = new BoardView(colorPlayer, this.model, levelNum, app);
		boardview.playerInitialize(app);
		this.parent = parent;
		createPanel();
	}
	

	/**
	 * Loads in all the GUI elements
	 */
	public void createPanel(){
				
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		add(boardview);
		
		titleTextField = new JLabel("LetterCraze");
		titleTextField.setBounds(6, 6, 94, 26);
		add(titleTextField);
		
		JLabel scoreLabelTextField = new JLabel("Score:");
		scoreLabelTextField.setBounds(6, 30, 94, 26);
		add(scoreLabelTextField);
		 
		scoreTextField = new JLabel("400");
		scoreTextField.setBounds(56, 30, 94, 26);
		add(scoreTextField);
				
		JScrollPane wordsScrollPane = new JScrollPane();
		wordsScrollPane.setBounds(439, 82, 338, 414);
		add(wordsScrollPane);
			
		JLabel lblWords = new JLabel("Words");
		lblWords.setBounds(439, 49, 61, 16);
		add(lblWords);
		
		btnExitLevel = new JButton("Exit Level");

		btnExitLevel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent me){
				CardLayout clay = (CardLayout) parent.getLayout();
				clay.first(parent); //revert to the menu screen
			}
		});
		btnExitLevel.setBounds(660, 6, 117, 29);
		add(btnExitLevel);
		
		JPanel panel_stars = new JPanel();
		panel_stars.setBounds(6, 56, 94, 26);
		starRater = new StarRater(3, 0 );
		starRater.setBounds(0, 6, 48, 16);
		//starRater.addStarListener(new StarRater.StarListener() {

		//	@Override
			//public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
		//	}
	//}

		panel_stars.setLayout(null);
	    panel_stars.add(starRater);
		add(panel_stars);
		
		levelType = new JLabel("N/A");
		levelType.setBounds(383, 11, 61, 16);
		add(levelType);
		
	}
	
	public JPanel getPlayerPanel() {
		return playerPanel;
	}

	public ArrayList<JPanel> getGridPanels() {
		return gridPanels;
	}

	public JLabel getLevelType() {
		return levelType;
	}

	public JLabel getScoreTextField() {
		return scoreTextField;
	}

	public Model getModel() {
		return model;
	}

	public int getLevelNum() {
		return levelNum;
	}

	public JButton getBtnExitLevel() {
		return btnExitLevel;
	}

	public JPanel getParent() {
		return parent;
	}

	public void getExitButton(){
		
	}
	
	

	@Override
	public void modelChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "GameView";
	}

	public JLabel getTitleTextField() {
		return titleTextField;
	}

	public void setTitleTextField(JLabel titleTextField) {
		this.titleTextField = titleTextField;
	}

	public StarRater getStarRater() {
		return starRater;
	}
}