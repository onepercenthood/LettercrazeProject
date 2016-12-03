package lettercraze.view;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import lettercraze.model.Level;

public class BuilderThemePanelView extends DefaultViewPanel implements IBuilderLevelPanel{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 8471595327519170917L;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
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
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(93, 14, 86, 20);
		add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(93, 51, 86, 20);
		add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(93, 91, 86, 20);
		add(textField_6);
		
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
	public Level makeLevelFromInputs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return null;
	}
}
