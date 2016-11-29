package lettercraze.view;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class LevelThumbnail extends DefaultViewPanel {
	
	/**
	 * The level type for the boxView
	 */
	private String levelType;
	
	/**
	 * Number of stars already earned for this level
	 */
	private Integer numStars = 0;

	private Color color;
	
	private JPanel starView;

	private Integer levelNumber;

	private JLabel levelLabel;

	private Component levelTypeLabel;

	private JButton levelButton;
	
	public LevelThumbnail(String levelType, Color color, Integer levelNumber, Integer numStars){
		this.levelType = levelType;
		this.levelNumber = levelNumber;
		this.numStars = numStars;
		this.color = color;
		
		initialize();
	}
	
	private void initialize(){
		
		setBackground(this.color);
		
		
		setLayout(new MigLayout("", "[grow]", "[][][grow]"));
		
		levelTypeLabel = new JLabel(levelType);
		add(levelTypeLabel, "cell 0 0");
		
		levelButton = new JButton("Level " + this.levelNumber);
		add(levelButton, "cell 0 1");
		
		// setup star view here
		JPanel starView = new JPanel();
		StarRater starRater21 = new StarRater(3, this.numStars );
		starRater21.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub

			}

		});
//				
		starView.add(starRater21);
		add(starView, "cell 0 2,grow");
		
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub


		return "BoxView";
	}
	
	@Override
	public void setEnabled(boolean enabled) {
	    super.setEnabled(enabled);
	    for (Component component : getComponents())
	        component.setEnabled(enabled);
	}
	
}


