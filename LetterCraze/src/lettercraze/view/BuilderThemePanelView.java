package lettercraze.view;

import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lettercraze.model.Level;
import lettercraze.model.Theme;

public class BuilderThemePanelView extends DefaultViewPanel implements IBuilderLevelPanel{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8471595327519170917L;
	private JTextField txtfldOneStar;
	private JTextField txtfldTwoStar;
	private JTextField txtfldThreeStar;
	private JTextField txtfldThemeTitle;
	private JTextArea txtAreaWordList;
	private Font labelFont;

	public BuilderThemePanelView(Font labelFont){
		this.labelFont = labelFont;
		initialize();
	}
	void initialize(){
		JLabel lblWords = new JLabel("words");
		lblWords.setBounds(189, 11, 72, 22);
		lblWords.setFont(labelFont);
		add(lblWords);
		
		JLabel lblTwoStarWords = new JLabel("words");
		lblTwoStarWords.setFont(labelFont);
		lblTwoStarWords.setBounds(189, 48, 72, 22);
		add(lblTwoStarWords);
		
		JLabel lblThreeStarWords = new JLabel("words");
		lblThreeStarWords.setFont(labelFont);
		lblThreeStarWords.setBounds(189, 88, 72, 22);
		add(lblThreeStarWords);
		
		txtfldThemeTitle = new JTextField();
		txtfldThemeTitle.setBounds(35, 134, 142, 20);
		add(txtfldThemeTitle);
		txtfldThemeTitle.setColumns(10);
		
		JLabel lblThemeTitle = new JLabel("Theme Title");
		lblThemeTitle.setFont(labelFont);
		lblThemeTitle.setBounds(189, 131, 120, 22);
		add(lblThemeTitle);
		
		JLabel lblThemeWordList = new JLabel("Theme Word List (one word per line)");
		lblThemeWordList.setFont(labelFont);
		lblThemeWordList.setBounds(35, 169, 295, 22);
		add(lblThemeWordList);
		
		txtAreaWordList = new JTextArea();
		txtAreaWordList.setBounds(35, 205, 295, 135);
		add(txtAreaWordList);
		
		txtfldOneStar = new JTextField();
		txtfldOneStar.setColumns(10);
		txtfldOneStar.setBounds(93, 14, 86, 20);
		add(txtfldOneStar);
		
		txtfldTwoStar = new JTextField();
		txtfldTwoStar.setColumns(10);
		txtfldTwoStar.setBounds(93, 51, 86, 20);
		add(txtfldTwoStar);
		
		txtfldThreeStar = new JTextField();
		txtfldThreeStar.setColumns(10);
		txtfldThreeStar.setBounds(93, 91, 86, 20);
		add(txtfldThreeStar);
		
		JPanel pnlTheme_star_1 = new JPanel();
		pnlTheme_star_1.setBounds(44, 11, 26, 26);
		add(pnlTheme_star_1);
		StarRater thmStarRater1 = new StarRater(1, 1 );
		thmStarRater1.setBounds(0, 6, 48, 16);
		thmStarRater1.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		pnlTheme_star_1.add(thmStarRater1);
		
		JPanel pnlTheme_star_2 = new JPanel();
		pnlTheme_star_2.setBounds(26, 48, 42, 26);
		add(pnlTheme_star_2);
		StarRater thmStarRater2 = new StarRater(2, 2 );
		thmStarRater2.setBounds(0, 6, 48, 16);
		thmStarRater2.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		pnlTheme_star_2.add(thmStarRater2);
		
		JPanel pnlTheme_star_3 = new JPanel();
		pnlTheme_star_3.setBounds(10, 88, 58, 26);
		add(pnlTheme_star_3);
		StarRater thmStarRater3 = new StarRater(3, 3 );
		thmStarRater3.setBounds(0, 6, 48, 16);
		thmStarRater3.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		pnlTheme_star_3.add(thmStarRater3);
	}

	@Override
	public int getOneStarThreshhold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getTwoStarThreshhold() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getThreeStarThreshhold() {
		// TODO Auto-generated method stub
		return 0;
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
		this.txtfldOneStar.setText("");
		this.txtfldTwoStar.setText("");
		this.txtfldThreeStar.setText("");
		this.txtfldThemeTitle.setText("");
	}
}
