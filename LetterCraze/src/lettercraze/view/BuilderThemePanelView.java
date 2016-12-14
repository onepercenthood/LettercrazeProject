package lettercraze.view;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lettercraze.model.Level;
import lettercraze.model.Theme;

/**
 * BuilderThemePanel contains the input fields for getting the theme's title and 
 * list of target words
 * @author Everett
 *
 */
public class BuilderThemePanelView extends AbsBuilderLevelPanel{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8471595327519170917L;
	private JTextField txtfldThemeTitle;
	private JTextArea txtAreaWordList;
	private Font labelFont;

	/**
	 * Constructor for the BuidlerThemePanelView. Takes in font for the labels
	 * @param labelFont as Font
	 */
	public BuilderThemePanelView(Font labelFont){
		this.labelFont = labelFont;
		initialize();
	}
	
	void initialize(){
		setLayout(null);
		
		txtfldThemeTitle = new JTextField();
		txtfldThemeTitle.setBounds(49, 52, 146, 26);
		add(txtfldThemeTitle);
		txtfldThemeTitle.setColumns(10);
		
		JLabel lblThemeTitle = new JLabel("Theme Title");
		lblThemeTitle.setFont(labelFont);
		lblThemeTitle.setBounds(49, 26, 146, 20);
		add(lblThemeTitle);
		
		JLabel lblThemeWordList = new JLabel("Theme Word List (one word per line)");
		lblThemeWordList.setFont(labelFont);
		lblThemeWordList.setBounds(49, 90, 340, 20);
		add(lblThemeWordList);
		
		txtAreaWordList = new JTextArea();
		txtAreaWordList.setBounds(49, 126, 125, 158);
		add(txtAreaWordList);
	}

	@Override
	public int getOneStarThreshhold() {
		return getWordList().size()-2;
	}

	@Override
	public int getTwoStarThreshhold() {
		return getWordList().size()-1;
	}

	@Override
	public int getThreeStarThreshhold() {
		return getWordList().size();
	}
	
	/**
	 * returns the list of targetWords from the txtAreaWordlist
	 * @return ArrayList<String> 
	 */
	public ArrayList<String> getWordList(){
		String s[] = txtAreaWordList.getText().split("\\r?\\n");
	    ArrayList<String>targetWords = new ArrayList<>(Arrays.asList(s)) ;
	    return targetWords;
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "Theme";
	}
	
	@Override
	public Level compileLevelInfo(boolean[][] boardShape, int levelNum) {
		//obatin the text from the area word list
		String s[] = txtAreaWordList.getText().split("\\r?\\n");
	    ArrayList<String>targetWords = new ArrayList<>(Arrays.asList(s)) ;
	    
	    //get the star thresholds
	    //int starThresholds[] = {getOneStarThreshhold(), getTwoStarThreshhold(), getThreeStarThreshhold()};
	    
	    String title = this.txtfldThemeTitle.getText();
	    //build new themelevel from the info and set its board shape
	    //Theme themeLevel = new Theme(levelNum, starThresholds, title, targetWords);
	    Theme themeLevel = new Theme(levelNum, title, targetWords);
	    themeLevel.setBoardShape(boardShape);
	    themeLevel.setUnLocked(true);
		return themeLevel;
	}
	
	@Override
	public void resetFields(){
		//set all textfields to the empty string
		this.txtAreaWordList.setText("");
		this.txtfldThemeTitle.setText("");
	}
	@Override
	public boolean fillAllFields(Level level) {
		if(level.getLevelType().equals("Theme")){
			Theme theme = (Theme) level;
			
			this.txtfldThemeTitle.setText(theme.getThemeCategory());
			String s = "";
			for(String t: theme.getTargetWords()){
				s += t + "\n";
			}
			this.txtAreaWordList.setText(s);			
			this.setLevelLoaded(theme);
			return true;
		} else {
			return false;
		}
	}
	
	@Override 
	public boolean isFilledOut(){
		boolean allDone = true;
		//check that the text fields are populated
		if(txtfldThemeTitle.getText().equals("") ||
				txtAreaWordList.getText().equals("")){
			allDone = false;
		} else { //now we know they're all populated, now make sure they're populated with numbers
			//check if there are any non-number characters in the timer field
			for(char c: txtAreaWordList.getText().toCharArray()){
				if(Character.isDigit(c)){
					allDone = false;
				}
			}
		}
		
		return allDone;
	}
}
