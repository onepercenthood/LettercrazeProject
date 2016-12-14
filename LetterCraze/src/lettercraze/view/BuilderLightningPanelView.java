package lettercraze.view;

import javax.swing.JPanel;
import javax.swing.JTextField;

import lettercraze.model.Level;
import lettercraze.model.Lightning;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

/**
 * Extends the AbsBuilderLevelPanel to build lightning levels
 * contains text fields for user determined star thresholds and timer start value
 * @author Everett
 *
 */

public class BuilderLightningPanelView extends AbsBuilderLevelPanel{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -7852280215069353848L;
	private JTextField txtfldOneStarPoints;
	private JTextField txtfldTwoStarPoints;
	private JTextField txtfldThreeStarPoints;
	private JTextField txtfldmaxTimer;

	/**
	 * Constructor for the BuidlerLightningPanelView
	 */
	public BuilderLightningPanelView(){
		setBackground(new Color(255, 140, 0));
		setLayout(null);
		initialize();				
	}

	/**
	 * intializes the panel. Sets up all four text fields with appropriate labes next to them
	 */
	void initialize(){
		txtfldOneStarPoints = new JTextField();
		txtfldOneStarPoints.setBounds(78, 14, 86, 20);
		add(txtfldOneStarPoints);
		txtfldOneStarPoints.setColumns(10);

		txtfldTwoStarPoints = new JTextField();
		txtfldTwoStarPoints.setColumns(10);
		txtfldTwoStarPoints.setBounds(78, 51, 86, 20);
		add(txtfldTwoStarPoints);

		txtfldThreeStarPoints = new JTextField();
		txtfldThreeStarPoints.setColumns(10);
		txtfldThreeStarPoints.setBounds(78, 91, 86, 20);
		add(txtfldThreeStarPoints);

		txtfldmaxTimer= new JTextField();
		txtfldmaxTimer.setColumns(10);
		txtfldmaxTimer.setBounds(78, 133, 86, 20);
		add(txtfldmaxTimer);

		JLabel lblOneWords = new JLabel("words");
		lblOneWords.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblOneWords.setBounds(174, 12, 63, 22);
		add(lblOneWords);

		JLabel lblTwoWords = new JLabel("words");
		lblTwoWords.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTwoWords.setBounds(174, 48, 63, 22);
		add(lblTwoWords);

		JLabel lblThreeWords = new JLabel("words");
		lblThreeWords.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblThreeWords.setBounds(174, 88, 63, 22);
		add(lblThreeWords);

		JLabel lblTimerseconds = new JLabel("Timer (seconds)");
		lblTimerseconds.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblTimerseconds.setBounds(174, 131, 138, 22);
		add(lblTimerseconds);

		JPanel pnlLightning_star_1 = new JPanel();
		pnlLightning_star_1.setBackground(Color.ORANGE);
		pnlLightning_star_1.setBounds(44, 11, 26, 26);
		add(pnlLightning_star_1);
		StarRater ltngStarRater1 = new StarRater(1, 1 );
		ltngStarRater1.setBounds(0, 6, 48, 16);
		ltngStarRater1.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub

			}

		});
		pnlLightning_star_1.add(ltngStarRater1);

		JPanel pnlLightning_star_2 = new JPanel();
		pnlLightning_star_2.setBackground(Color.ORANGE);
		pnlLightning_star_2.setBounds(26, 48, 42, 26);
		add(pnlLightning_star_2);
		StarRater ltngStarRater2 = new StarRater(2, 2 );
		ltngStarRater2.setBounds(0, 6, 48, 16);
		ltngStarRater2.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub

			}

		});
		pnlLightning_star_2.add(ltngStarRater2);

		JPanel pnlLightning_star_3 = new JPanel();
		pnlLightning_star_3.setBackground(Color.ORANGE);
		pnlLightning_star_3.setBounds(10, 88, 58, 26);
		add(pnlLightning_star_3);
		StarRater ltngStarRater3 = new StarRater(3, 3 );
		ltngStarRater3.setBounds(0, 6, 48, 16);
		ltngStarRater3.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub

			}

		});

		pnlLightning_star_3.add(ltngStarRater3);
	}

	@Override
	public String getPanelName(){
		return "Lightning";
	}

	@Override
	public int getOneStarThreshhold() {
		//check that the input is a positive number
		//check the input is a possible threshhold to reach
		return Integer.parseInt(txtfldOneStarPoints.getText());
	}

	@Override
	public int getTwoStarThreshhold() {
		//check that the input is a positive number
		//check the input is a possible threshhold to reach
		return Integer.parseInt(txtfldTwoStarPoints.getText());
	}

	@Override
	public int getThreeStarThreshhold() {
		//check that the input is a positive number
		//check the input is a possible threshhold to reach
		return Integer.parseInt(txtfldThreeStarPoints.getText());
	}

	@Override
	public Level compileLevelInfo(boolean[][] boardShape, int levelNum) {
		//gather score threshholds 
		int threshholds[] = {getOneStarThreshhold(), getTwoStarThreshhold(), getThreeStarThreshhold()};
		int maxTime = Integer.parseInt(this.txtfldmaxTimer.getText());

		//create a puzzle level with the specified threshholds, maximum moves, and level number
		Lightning lightning = new Lightning(levelNum, threshholds, maxTime);

		//assign the given boardShape, set it to unlocked
		lightning.setBoardShape(boardShape);
		lightning.setUnLocked(true);
		return lightning;
	}

	@Override
	public void resetFields(){
		this.txtfldmaxTimer.setText("");
		this.txtfldOneStarPoints.setText("");
		this.txtfldTwoStarPoints.setText("");
		this.txtfldThreeStarPoints.setText("");
	}

	@Override
	public boolean fillAllFields(Level level) {
		if(level.getLevelType().equals("Lightning")){
			Lightning lit = (Lightning) level;
			this.txtfldmaxTimer.setText(Integer.toString(lit.getSeconds()));
			this.txtfldOneStarPoints.setText(Integer.toString(lit.getStarThreshold()[0]));
			this.txtfldTwoStarPoints.setText(Integer.toString(lit.getStarThreshold()[1]));
			this.txtfldThreeStarPoints.setText(Integer.toString(lit.getStarThreshold()[2]));
			this.setLevelLoaded(lit);
			return true;
		} else{
			return false;
		}

	}
	
	@Override 
	public boolean isFilledOut(){
		boolean allDone = true;
		//check that the text fields are populated
		if(txtfldmaxTimer.getText().equals("") ||
				txtfldOneStarPoints.getText().equals("") ||
				txtfldTwoStarPoints.getText().equals("") ||
				txtfldThreeStarPoints.getText().equals("")){
			allDone = false;
		} else { //now we know they're all populated, now make sure they're populated with numbers
			//check if there are any non-number characters in the timer field
			for(char c: txtfldmaxTimer.getText().toCharArray()){
				if(!Character.isDigit(c)){
					allDone = false;
				}
			}
			//check if there are any non-number characters in the one star points field
			for(char c: txtfldOneStarPoints.getText().toCharArray()){
				if(!Character.isDigit(c)){
					allDone = false;
				}
			}
			//check if there are any non-number characters in the two star points field
			for(char c: txtfldTwoStarPoints.getText().toCharArray()){
				if(!Character.isDigit(c)){
					allDone = false;
				}
			}
			//check if there are any non-number points in the three star points field
			for(char c: txtfldThreeStarPoints.getText().toCharArray()){
				if(!Character.isDigit(c)){
					allDone = false;
				}
			}
		}
		
		return allDone;
	}

}
