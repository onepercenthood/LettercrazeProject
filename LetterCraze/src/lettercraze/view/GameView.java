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
import lettercraze.controller.player.ClearWordController;
import lettercraze.controller.player.PlayWordController;
import lettercraze.controller.player.UndoController;
import lettercraze.controller.builder.SelectBoardSquareController;
import lettercraze.model.Model;
import lettercraze.model.Word;
import lettercraze.view.BoardView;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Font;

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

	private JButton btnAddWord;

	private PlayerApplication app;

	private JList<Word> validWordsJList;
	
	private JLabel typeSpecificLabel;
	
	private JScrollPane wordsScrollPane;
	
	private JList<Object> listToDisplay;


	/**
	 * Create the frame.
	 */
	public GameView(Model m, int levelNum, PlayerApplication app) {
		super();
		this.app = app;
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
		setBackground(SystemColor.menu);
		this.model = m;
		this.levelNum = 1;
		this.boardview = new BoardView(colorPlayer, this.model, levelNum, app);
		boardview.setBounds(16, 82, 471, 471);
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
		titleTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleTextField.setBounds(6, 6, 94, 26);
		add(titleTextField);
		
		JLabel scoreLabelTextField = new JLabel("Score:");
		scoreLabelTextField.setBounds(6, 30, 94, 26);
		add(scoreLabelTextField);
		 
		int currentScore = model.getCurrentBoardState().getScore();
		scoreTextField = new JLabel(Integer.toString(currentScore));
		scoreTextField.setBounds(56, 30, 94, 26);
		add(scoreTextField);

	
		ArrayList<Word> foundWords = model.getCurrentBoardState().getFoundWords();
		JList<Object> listToDisplay = new JList<>(foundWords.toArray());
        wordsScrollPane = new JScrollPane(listToDisplay);

		wordsScrollPane.setBounds(542, 82, 235, 414);
		add(wordsScrollPane);
			
		JLabel lblWords = new JLabel("Words");
		lblWords.setBounds(542, 55, 61, 16);
		add(lblWords);
		
		btnExitLevel = new JButton("Exit Level");

		btnExitLevel.addMouseListener(new MouseAdapter() {
			@Override
			//TODO change to exit controller that resets the level as you exit, recording if you won or not
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
		
		String levelString = model.getLevel(levelNum).getLevelType();
		levelType = new JLabel(levelString);
		levelType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		levelType.setBounds(131, 11, 117, 16);
		add(levelType);
		
		btnAddWord = new JButton("Add Word");
		btnAddWord.setBounds(370, 42, 117, 29);
		add(btnAddWord);		
		btnAddWord.addMouseListener(new PlayWordController(app, model, this ));
		
		JButton btnClearWord = new JButton("Clear Word");
		btnClearWord.setBounds(243, 42, 117, 29);
		btnClearWord.addMouseListener(new ClearWordController(app, this.boardview, model));
		add(btnClearWord);
		
		JButton btnUndoMove = new JButton("Undo Move");
		btnUndoMove.setBounds(116, 42, 117, 29);
		btnUndoMove.addMouseListener(new UndoController(app, model, this));
		add(btnUndoMove);
		
		typeSpecificLabel = new JLabel("___");
		typeSpecificLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		typeSpecificLabel.setBounds(284, 12, 117, 16);
		add(typeSpecificLabel);
		
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
	
	public JButton getExitButton(){
		return this.btnExitLevel;
	}
	
	public JButton getAddWordBtn(){
		return this.btnAddWord;
	}
	
	public JList<Word> getWordsJList(){
		return this.validWordsJList;
	}
	
	public JLabel getTypeSpecific(){
		return typeSpecificLabel;
	}
	
	public void setTypeSpecificLabel(String display){
		typeSpecificLabel.setText(display);
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
	
	public BoardView getBoardView(){
		return boardview;
	}
	
	public JLabel getScoreView(){
		return scoreTextField;
	}
	
	public void setScoreView(){
		int currentScore = model.getCurrentBoardState().getScore();
		scoreTextField.setText(Integer.toString(currentScore));
	}
	
	public void setStarRater(){
		int currentStars = model.getCurrentBoardState().getStars();
		starRater.setRating(currentStars);
	}
	
	public JList<Word> getWordList(){
		return validWordsJList;
	}

	public void updateLevelTypeLabel(String levelType2) {
		// TODO Auto-generated method stub
		
	}
}