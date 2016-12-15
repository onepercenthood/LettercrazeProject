package lettercraze.view;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import lettercraze.PlayerApplication;
import lettercraze.controller.builder.ExitPreviewController;
import lettercraze.controller.player.ClearWordController;
import lettercraze.model.BoardState;
import lettercraze.model.Level;
import lettercraze.model.Lightning;
import lettercraze.model.Model;
import lettercraze.model.Puzzle;
import lettercraze.model.Theme;

/**
 * this provides an inert copy of the GameView panel. 
 * @author Everett
 *
 */
public class BuilderDummyGameView extends DefaultViewPanel {

	/** the level to create the view from **/
	Level level;
	
	/** the model needed to build the view **/
	Model model;
	
	/** the parent contaier **/
	JPanel parent;
	/**
	 * Constructor for the BuilderDummyGameView, that builds the dummy panel based off the 
	 * given level
	 * @param level as Level
	 * @param model as Model
	 * @param parent as JPanel
	 */
	public BuilderDummyGameView(Level level, Model model, JPanel parent) {
		this.level = level;
		this.model = model;
		this.parent = parent;
		initialize();
	}
	
	private void initialize(){

		PlayerApplication pApp = new PlayerApplication();
		
		BoardView boardview  = new BoardView(Color.RED, this.model, 1, pApp);
		boardview.setBackground(Color.BLACK);
		boardview.setBounds(16, 82, 471, 471);
		boardview.playerInitialize(pApp);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		add(boardview);

		JLabel titleTextField = new JLabel("LetterCraze");
		titleTextField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		titleTextField.setBounds(6, 6, 94, 26);
		add(titleTextField);

		JLabel scoreLabelTextField = new JLabel("Score:");
		scoreLabelTextField.setBounds(6, 30, 94, 26);
		add(scoreLabelTextField);

		int currentScore = model.getCurrentBoardState().getScore();
		JLabel scoreTextField = new JLabel(Integer.toString(currentScore));
		scoreTextField.setBounds(56, 30, 94, 26);
		add(scoreTextField);


		DefaultListModel wordList = new DefaultListModel<>();
		JList<String> list = new JList<>(wordList);
//
//		ArrayList<String> foundWords = model.getCurrentBoardState().getFoundWordsStrings(); 
//
//		for ( int i = 0; i < foundWords.size(); i++ ){
//			wordList.addElement( foundWords.get(i));
//		}

		//JScrollPane wordsScrollPane = new JScrollPane(model.getCurrentBoardState().getFoundWordsStrings());
		JScrollPane wordsScrollPane = new JScrollPane(list);
		wordsScrollPane.setBounds(542, 82, 235, 471);
		add(wordsScrollPane);

		JLabel lblWords = new JLabel("Words");
		lblWords.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblWords.setBounds(542, 40, 94, 29);
		add(lblWords);

		JButton btnExitLevel = new JButton("Exit Level");
		btnExitLevel.setBounds(670, 6, 107, 29);
		add(btnExitLevel);

		JPanel panel_stars = new JPanel();
		panel_stars.setBounds(6, 56, 94, 26);
		StarRater starRater = new StarRater(3, 0 );
		starRater.setBounds(10, 0, 61, 22);

		Color levelColor = Color.PINK;
		if(level.getLevelType().equals("Puzzle")){
			levelColor = new Color(102,255,102);
		}
		else if(level.getLevelType().equals("Lightning")){
			levelColor = Color.ORANGE;
		}
		else if(level.getLevelType().equals("Theme")){
			levelColor = Color.PINK;
		}
		setBackground(levelColor);
		panel_stars.setBackground(levelColor);
		
		panel_stars.setLayout(null);
		panel_stars.add(starRater);
		add(panel_stars);

		String levelString = level.getLevelType();
		JLabel levelType = new JLabel(levelString);
		levelType.setFont(new Font("Tahoma", Font.PLAIN, 16));
		levelType.setBounds(131, 11, 117, 16);
		add(levelType);

		JButton btnAddWord = new JButton("Add Word");
		btnAddWord.setBounds(370, 42, 117, 29);
		add(btnAddWord);		

		JButton btnClearWord = new JButton("Clear Word");
		btnClearWord.setBounds(243, 42, 117, 29);
		btnClearWord.addMouseListener(new ClearWordController(pApp, boardview, model));
		add(btnClearWord);

		JButton btnUndoMove = new JButton("Undo Move");
		btnUndoMove.setBounds(116, 42, 117, 29);
		add(btnUndoMove);

		JLabel typeSpecificLabel;
		if(this.level.getLevelType().equals("Theme")){
			Theme theme = (Theme) level;
			typeSpecificLabel = new JLabel(theme.getThemeCategory());
		}
		else if(this.level.getLevelType().equals("Puzzle")){
			Puzzle puzzle = (Puzzle) level;
			typeSpecificLabel = new JLabel("Moves Left: " + puzzle.getMaxWords());
		}
		else{
			typeSpecificLabel = new JLabel(Integer.toString(((Lightning)level).getSeconds()));
		}
		
		typeSpecificLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		typeSpecificLabel.setBounds(284, 12, 117, 16);
		add(typeSpecificLabel);
		
		JButton btnResetLevel = new JButton("Exit Preview");
		btnResetLevel.setBounds(542, 7, 107, 29);
		btnResetLevel.addMouseListener(new ExitPreviewController(parent, this));
		add(btnResetLevel);
		
			
		repaint();

	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "DummyView";
	}

}
