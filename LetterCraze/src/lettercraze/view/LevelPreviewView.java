package lettercraze.view;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lettercraze.PlayerApplication;
import lettercraze.controller.player.SelectAvailableLevelController;
import lettercraze.model.Level;
import net.miginfocom.swing.MigLayout;

public class LevelPreviewView extends DefaultViewPanel implements IModelChangedView {
	
	/**
	 * The level type for the boxView
	 */
	private String levelType;
	
	/**
	 * Number of stars already earned for this level
	 */
	private Integer numStars = 0;

	private Color color;
	
	private JPanel parent;

	private Integer levelNumber;

	private JLabel levelLabel;

	private JLabel levelTypeLabel;

	private JButton levelButton;
	
	private StarRater starRater;
	
	private CardLayout cardlayout;

	private int highScore;

	private PlayerApplication app;

	private int[] starThreshold;

	private Level level;
	
		
	public LevelPreviewView(String levelType, Color color, Integer levelNumber, Integer numStars, JPanel cl, PlayerApplication app){
		this.levelType = levelType;
		this.levelNumber = levelNumber;
		this.numStars = numStars;
		this.color = color;
//		this.parenCl = cl;
		this.app = app;
		this.cardlayout = (CardLayout) cl.getLayout();
		initialize();
	}
	
	public LevelPreviewView(Level level, Color color, JPanel parent, PlayerApplication app){
		this.level = level;
		this.levelType = level.getLevelType();
		this.levelNumber = level.getLevelNum();
		this.highScore = level.getHighScore();
		this.starThreshold = level.getStarThreshold();
		this.numStars = level.getHighStars(level.getHighScore());
		this.color = color;
		this.cardlayout = (CardLayout) parent.getLayout();
		this.parent = parent;
		this.app = app;
		initialize();
	}
	
	private void initialize(){
		
		setBackground(this.color);
		
		
		setLayout(new MigLayout("", "[grow]", "[][][grow]"));
		
		levelTypeLabel = new JLabel(levelType);
		add(levelTypeLabel, "cell 0 0");
		
		levelButton = new JButton("Level " + this.levelNumber);
		levelButton.addActionListener(new SelectAvailableLevelController(levelNumber, this.cardlayout, app)); 
		add(levelButton, "cell 0 1");
		
		// setup star view here
		JPanel starView = new JPanel();
		starRater = new StarRater(3, this.numStars );
		setHighScore(highScore);
		starRater.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub

			}

		});
//				
		starView.add(starRater);
		add(starView, "cell 0 2,grow");
		
	}

	@Override
	public String getPanelName() {
		return "BoxView";
	}
	
	@Override
	public void setEnabled(boolean enabled) {
	    super.setEnabled(enabled);
	    for (Component component : getComponents())
	        component.setEnabled(enabled);
	}
	
	/**
	 * Gets the level number text field
	 * 
	 * @return JLabel
	 */
	public JLabel getLevelNumTextField(){
		return this.levelLabel;
	}
	
	/**
	 * Gets the starRater module
	 * 
	 * @return StarRater
	 */
	public StarRater getStarField(){
		return this.starRater;
	}
	
	/**
	 * Gets the levelType textField
	 * 
	 * @return
	 */
	public JLabel getLevelTypeLabel(){
		return levelTypeLabel;
	}
	
	/**
	 * Returns the button for the level.
	 * 
	 * @return
	 */
	public JButton getLevelButton(){
		return  this.levelButton;
	}
	
	/**
	 * set the highScore to the given value
	 * @param highScore : integer value representing the new high score for the level
	 */
	public void setHighScore(int highScore){
		this.highScore = highScore;
		int i = 0;
		for(i = 0; i < 3; i ++){
			System.out.println(highScore + ", " + starThreshold[i]);
			if(highScore >= starThreshold[i]){
				numStars = i +1;
				System.out.println("Set starRater to: " + numStars);
			} 
		}
		starRater.setRating((float) numStars);
		starRater.repaint();
	}

	@Override
	public void modelChanged() {
		// TODO Auto-generated method stub
		
	}

	public int getLevelNum() {
		
		return levelNumber.intValue();
	}

	public void updateInfo(Level level) {
		this.level = level;
		this.level = level;
		this.levelType = level.getLevelType();
		this.levelNumber = level.getLevelNum();
		this.highScore = level.getHighScore();
		this.starThreshold = level.getStarThreshold();
		this.numStars = level.getHighStars(level.getHighScore());
		setHighScore(level.getHighScore());
		setEnabled(level.getIsUnlocked());
		//this.repaint();
	}
	
}


