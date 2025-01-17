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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javafx.scene.shape.Box;
import lettercraze.PlayerApplication;
import lettercraze.controller.player.ClearWordController;
import lettercraze.controller.player.PlayWordController;
import lettercraze.controller.player.ResetLevelController;
import lettercraze.controller.player.UndoController;
import lettercraze.controller.player.LeaveLevelEarlyController;
import lettercraze.controller.builder.SelectBoardSquareController;
import lettercraze.model.Model;
import lettercraze.model.Puzzle;
import lettercraze.model.Theme;
import lettercraze.model.Word;
import lettercraze.view.BoardView;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;

/**
 * GameView provides the interface for playing each level. Instances are created upon selecting a level to play.
 * @author All
 *
 */
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

	private JButton btnUndoMove;

	private JButton btnClearWord;

	private PlayerApplication app;

	private JList<Word> validWordsJList;

	private JLabel typeSpecificLabel;

	private JScrollPane wordsScrollPane;

	private JList<Object> listToDisplay;

	private JScrollPane wordScrollPane;

	private DefaultListModel<String> wordList;
	
	private JPanel panel_stars;
	
	private JButton btnResetLevel;


	/**
	 * Constructor for the gameView objects. Takes in the model to update, the number of the level to load, the parent container
	 * and the parent appliaction.
	 * @param m as Model: the model to be played
	 * @param levelNum as in : the number of the level to load
	 * @param parent as JPanel: the container of this GameView
	 * @param app as PlayerApplication: the parent applicaiton
	 */
	public GameView(Model m, int levelNum, JPanel parent, PlayerApplication app) {
		super();
		this.app = app;
		this.model = m;
		this.levelNum = levelNum;
		this.parent = parent;
		this.boardview = new BoardView(colorPlayer, this.model, levelNum, app);
		boardview.setBackground(Color.BLACK);
		boardview.setBounds(16, 82, 471, 471);
		boardview.playerInitialize(app);
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


		wordList = new DefaultListModel<>();
		JList<String> list = new JList<>( wordList );

		ArrayList<String> foundWords = model.getCurrentBoardState().getFoundWordsStrings(); 

		for ( int i = 0; i < foundWords.size(); i++ ){
			wordList.addElement( foundWords.get(i));
		}

		//JScrollPane wordsScrollPane = new JScrollPane(model.getCurrentBoardState().getFoundWordsStrings());
		JScrollPane wordsScrollPane = new JScrollPane(list);
		wordScrollPane = wordsScrollPane;


		wordsScrollPane.setBounds(542, 82, 235, 471);
		add(wordsScrollPane);

		JLabel lblWords = new JLabel("Words");
		lblWords.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWords.setBounds(542, 40, 94, 29);
		add(lblWords);

		btnExitLevel = new JButton("Exit Level");
		btnExitLevel.setBounds(670, 6, 107, 29);
		btnExitLevel.addMouseListener(new LeaveLevelEarlyController(parent, model, this)) ;
		add(btnExitLevel);

		panel_stars = new JPanel();
		panel_stars.setBounds(6, 56, 94, 26);
		starRater = new StarRater(3, 0 );
		starRater.setBounds(10, 0, 61, 22);

		Color levelColor = Color.RED;
		if(model.getLevel(model.getCurrentLevel()).getLevelType().equals("Puzzle")){
			levelColor = new Color(102,255,102);
		}
		else if(model.getLevel(model.getCurrentLevel()).getLevelType().equals("Lightning")){
			levelColor = Color.ORANGE;
		}
		else if(model.getLevel(model.getCurrentLevel()).getLevelType().equals("Theme")){
			levelColor = Color.PINK;
		}
		this.setBackground(levelColor);
		panel_stars.setBackground(levelColor);
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

		btnClearWord = new JButton("Clear Word");
		btnClearWord.setBounds(243, 42, 117, 29);
		btnClearWord.addMouseListener(new ClearWordController(app, this.boardview, model));
		add(btnClearWord);

		btnUndoMove = new JButton("Undo Move");
		btnUndoMove.setBounds(116, 42, 117, 29);
		btnUndoMove.addMouseListener(new UndoController(app, model, this));
		add(btnUndoMove);

		if(model.getLevel(levelNum).getLevelType().equals("Theme")){
			Theme theme = (Theme) model.getLevel(levelNum);
			typeSpecificLabel = new JLabel(theme.getThemeCategory());
		}
		else if(model.getLevel(levelNum).getLevelType().equals("Puzzle")){
			Puzzle puzzle = (Puzzle) model.getLevel(levelNum);
			typeSpecificLabel = new JLabel("Moves Left: " + puzzle.getMaxWords());
		}
		else{
			typeSpecificLabel = new JLabel("___");
		}
		typeSpecificLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		typeSpecificLabel.setBounds(284, 12, 200, 16);
		add(typeSpecificLabel);
		
		btnResetLevel = new JButton("Reset Level");
		btnResetLevel.setBounds(542, 7, 107, 29);
		btnResetLevel.addMouseListener(new ResetLevelController(app, model, this));
		add(btnResetLevel);

	}

	/**
	 * Gets the textfield for displaying the current score.
	 * @return JLabel
	 */
	public JLabel getScoreTextField() {
		return scoreTextField;
	}

	/**
	 * returns the number of the current level.
	 * @return int
	 */
	public int getLevelNum() {
		return levelNum;
	}

	/**
	 * gets the button for exiting the level.
	 * @return JButton
	 */
	public JButton getBtnExitLevel() {
		return btnExitLevel;
	}

	/**
	 * returns the parent Container for the GameView.
	 * @return JPanel
	 */
	public JPanel getParent() {
		return parent;
	}

	/**
	 * gets the button that triggers adding words.
	 * @return JButton
	 */
	public JButton getAddWordBtn(){
		return this.btnAddWord;
	}

	/**
	 * gets the JList of all the found words.
	 * @return JList<Word>
	 */
	public JList<Word> getWordsJList(){
		return this.validWordsJList;
	}

	/**
	 * gets the label that displays the type-specific data.
	 * @return JLabel
	 */
	public JLabel getTypeSpecific(){
		return typeSpecificLabel;
	}

	/**
	 * sets the type-specific data display to the given string.
	 * @param display as String
	 */
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

	/**
	 * gets the Star Rater object for displaying earned stars.
	 * @return StarRater
	 */
	public StarRater getStarRater() {
		return starRater;
	}

	/**
	 * returns the boardView for displaying the current state of each square.
	 * @return BoardView
	 */
	public BoardView getBoardView(){
		return boardview;
	}

	/**
	 * returns the scoreVeiw for displaying the current score.
	 * @return JLabel
	 */
	public JLabel getScoreView(){
		return scoreTextField;
	}

	/**
	 * sets the score view to the current score.
	 */
	public void setScoreView(){
		int currentScore = model.getCurrentBoardState().getScore();
		scoreTextField.setText(Integer.toString(currentScore));
	}

	/**
	 * sets the starRater display to the current number of earned stars.
	 */
	public void setStarRater(){
		int currentStars = model.getCurrentBoardState().getStars();
		starRater.setRating(currentStars);
	}

	/**
	 * returns the list of valid Words to be used
	 * @return JList<Word>
	 */
	public JList<Word> getWordList(){
		return validWordsJList;
	}
	
	/**
	 * returns the box where the found words are displayed
	 * @return JScrollPane
	 */
	public JScrollPane getWordBox(){
		return wordScrollPane;
	}
	
	/**
	 * adds the most recently found word to the list of words shown in the wordScrollPane
	 */
	public void addWordModel(){
		ArrayList<String> foundWords = model.getCurrentBoardState().getFoundWordsStrings(); 
		wordList.addElement( foundWords.get(foundWords.size()-1));
		System.out.println("WORDS");
		System.out.println(wordList.getSize());
	}
	
	/**
	 * pops the word from the top of the wordList
	 */
	public void removeWordModel(){
		wordList.remove(wordList.size()-1);
		System.out.println("WORDS");
		System.out.println(wordList.getSize());
	}

	/**
	 * sets the backgroundColor to red
	 */
	public void setBackgroundRed(){
		this.setBackground(Color.RED);
		panel_stars.setBackground(Color.RED);
	}

	/**
	 * gets the button that triggers undo actions
	 * @return JButton
	 */
	public JButton getBtnUndoMove() {
		return btnUndoMove;
	}

	/**
	 * sets the button to undo moves
	 * @param btnUndoMove
	 */
	public void setBtnUndoMove(JButton btnUndoMove) {
		this.btnUndoMove = btnUndoMove;
	}
	
	/**
	 * returns the button used to reset the level
	 * @return JButton
	 */
	public JButton getResetLevelBtn(){
		return btnResetLevel;
	}

	/**
	 * makes the game lit AF
	 */

	public void makeItLit(){
		try {
			BufferedImage img = ImageIO.read(new File("lit.jpg"));
			ImageIcon icon = new ImageIcon(img);
			JLabel label = new JLabel(icon);
			JOptionPane.showMessageDialog(null, label);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	/**
	 * returns the JLabel describing the type of the level
	 * @return JLabel
	 */
	public JLabel getLevelType() {
		// TODO Auto-generated method stub
		return this.levelType;
	}
}