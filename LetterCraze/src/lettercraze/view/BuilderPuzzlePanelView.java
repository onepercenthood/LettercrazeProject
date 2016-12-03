package lettercraze.view;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import lettercraze.model.Level;

public class BuilderPuzzlePanelView extends DefaultViewPanel implements IBuilderLevelPanel{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = 1L;
	private JTextField txtfldOneStar;
	private JTextField txtfldTwoStar;
	private JTextField txtfldThreeStar;
	private JTextField txtFldInputMaxMoves;
	private Font labelFont;

	public BuilderPuzzlePanelView(Font labelFont){
		this.labelFont = labelFont;
		initialize();
	}
	
	void initialize(){
		JLabel lblOneStarPoints = new JLabel("points");
		lblOneStarPoints.setBounds(189, 11, 48, 22);
		add(lblOneStarPoints);
		lblOneStarPoints.setFont(labelFont);
		
		JLabel lblTwoStarPoints = new JLabel("points");
		lblTwoStarPoints.setBounds(189, 48, 48, 22);
		add(lblTwoStarPoints);
		lblTwoStarPoints.setFont(labelFont);
		
		JLabel lblThreeStarPoints = new JLabel("points");
		lblThreeStarPoints.setBounds(189, 88, 48, 22);
		add(lblThreeStarPoints);
		lblThreeStarPoints.setFont(labelFont);
		
		JLabel lblMaxMoves = new JLabel("max moves");
		lblMaxMoves.setBounds(189, 130, 87, 22);
		add(lblMaxMoves);
		lblMaxMoves.setFont(labelFont);
		
		JPanel pnlPuzzle_star_1 = new JPanel();
		pnlPuzzle_star_1.setBounds(44, 11, 26, 26);
		add(pnlPuzzle_star_1);
		StarRater pzzlStarRater1 = new StarRater(1, 1 );
		pzzlStarRater1.setBounds(0, 6, 48, 16);
		pzzlStarRater1.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		pnlPuzzle_star_1.add(pzzlStarRater1);
		
		JPanel pnlPuzzle_star_2 = new JPanel();
		pnlPuzzle_star_2.setBounds(26, 48, 42, 26);
		add(pnlPuzzle_star_2);
		StarRater pzzlStarRater2 = new StarRater(2, 2 );
		pzzlStarRater2.setBounds(0, 6, 48, 16);
		pzzlStarRater2.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		pnlPuzzle_star_2.add(pzzlStarRater2);
		
		JPanel pnlPuzzle_star_3 = new JPanel();
		pnlPuzzle_star_3.setBounds(10, 88, 58, 26);
		add(pnlPuzzle_star_3);
		StarRater pzzlStarRater3 = new StarRater(3, 3 );
		pzzlStarRater3.setBounds(0, 6, 48, 16);
		pzzlStarRater3.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		pnlPuzzle_star_3.add(pzzlStarRater3);
		
		txtfldOneStar = new JTextField();
		txtfldOneStar.setBounds(78, 14, 86, 20);
		add(txtfldOneStar);
		txtfldOneStar.setColumns(10);
		
		txtfldTwoStar = new JTextField();
		txtfldTwoStar.setBounds(78, 51, 86, 20);
		add(txtfldTwoStar);
		txtfldTwoStar.setColumns(10);
		
		txtfldThreeStar = new JTextField();
		txtfldThreeStar.setBounds(78, 91, 86, 20);
		add(txtfldThreeStar);
		txtfldThreeStar.setColumns(10);
		
		txtFldInputMaxMoves = new JTextField();
		txtFldInputMaxMoves.setBounds(78, 133, 86, 20);
		add(txtFldInputMaxMoves);
		txtFldInputMaxMoves.setColumns(10);
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return null;
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
}
