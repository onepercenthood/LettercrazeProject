package lettercraze.view;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import lettercraze.model.Model;
 
public class BoardView extends DefaultViewPanel implements IModelChangedView {
	private JPanel boardPanel;
	Color colorPlayer;
	SquareView[][] squareBoxes = new SquareView[6][6];
	JPanel[][] squareBoxesPanels = new JPanel[6][6];

	public BoardView(Color colorPlayer, Model model) {
		this.colorPlayer = colorPlayer;
		createPanel();
		
		loadInPlayerGrid();
		
		
	}
	
	public void createPanel(){
		setLayout(null);

		boardPanel = new JPanel();
		boardPanel.setBounds(6, 6, 383, 414);
		boardPanel.setBackground(colorPlayer);
		boardPanel.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		boardPanel.setBounds(16, 82, 383, 414);
		add(boardPanel);
		boardPanel.setLayout(new GridLayout(6, 6, 0, 0));
		
		add(boardPanel);
	}
	
	public void loadInPlayerGrid(){
		
		int row = 6;
		int col = 6;
		

		
		for( int i = 1; i <= col; i++ ){
			for( int j = 1; j <= row; j++){
				JPanel newPanel = new JPanel();
				newPanel.setBackground(SystemColor.activeCaption);
				newPanel.setBorder(new LineBorder(colorPlayer));
				boardPanel.add(newPanel);
				squareBoxesPanels[i-1][j-1] = newPanel;

			}
		}
		
		
	}

	@Override
	public void modelChanged() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "BoardView";
	}
}
