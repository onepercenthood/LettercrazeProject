package lettercraze.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Window;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javafx.scene.shape.Box;
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
			        frame.getContentPane().add(new GameView(m));
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
	public GameView(Model m) {
		this.model = m;
		this.boardview = new BoardView(colorPlayer, this.model);
		createPanel();
		loadBoardView();

	}
	
	private void loadBoardView() {
		// TODO Auto-generated method stub
		
		JPanel boardViewPanel = boardview.getBoardPanel();
		
		Dimension size = playerPanel.getSize();
		size.height = size.height - 5;
		
		boardViewPanel.setPreferredSize(size);
		
		playerPanel.add(boardview.getBoardPanel());
	}

	/**
	 * Loads in all the GUI elements
	 */
	public void createPanel(){
				
		setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
		setLayout(null);
		
		titleTextField = new JLabel("LetterCraze");
		titleTextField.setBounds(6, 6, 94, 26);
		add(titleTextField);
		
		JLabel scoreLabelTextField = new JLabel("Score:");
		scoreLabelTextField.setBounds(6, 30, 94, 26);
		add(scoreLabelTextField);
		
		scoreTextField = new JLabel("400");
		scoreTextField.setBounds(56, 30, 94, 26);
		add(scoreTextField);
		
		playerPanel = new JPanel();

		playerPanel.setBackground(colorPlayer);
//		playerPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		playerPanel.setBounds(16, 82, 383, 414);
		add(playerPanel);
//		playerPanel.setLayout(new GridLayout(6, 6, 0, 0));
		
//		loadInPlayerGrid();
		
		JScrollPane wordsScrollPane = new JScrollPane();
		wordsScrollPane.setBounds(439, 82, 338, 414);
		add(wordsScrollPane);
		
//		Box box = Box.createVerticalBox();
		
		JLabel lblWords = new JLabel("Words");
		lblWords.setBounds(439, 49, 61, 16);
		add(lblWords);
		
		JButton btnExitLevel = new JButton("Exit Level");
		btnExitLevel.setBounds(660, 6, 117, 29);
		add(btnExitLevel);
		
		JPanel panel_stars = new JPanel();
		panel_stars.setBounds(6, 56, 94, 26);
		starRater = new StarRater(3, 3 );
		starRater.setBounds(0, 6, 48, 16);
		starRater.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		panel_stars.setLayout(null);
		panel_stars.add(starRater);
		add(panel_stars);
		
		levelType = new JLabel("N/A");
		levelType.setBounds(383, 11, 61, 16);
		add(levelType);
		
	}
	
	public void loadInPlayerGrid(){
		
		int row = 6;
		int col = 6;
		

		
		for( int i = 1; i <= col; i++ ){
			for( int j = 1; j <= row; j++){
				JPanel newPanel = new JPanel();
				newPanel.setBackground(SystemColor.activeCaption);
				newPanel.setBorder(new LineBorder(colorPlayer));
				playerPanel.add(newPanel);
				gridPanels.add(newPanel);

			}
		}
		
		
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