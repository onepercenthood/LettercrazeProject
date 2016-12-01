package lettercraze.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import lettercraze.model.Model;
import lettercraze.model.Square;
 
public class BoardView extends DefaultViewPanel implements IModelChangedView {
	private JPanel boardPanel;
	protected Color colorPlayer;
	protected Model model;
	protected int levelNum;
	
	SquareView[][] squareViews = new SquareView[6][6];
	JPanel[][] squarePanels = new JPanel[6][6];
	

	public BoardView(Color colorPlayer, Model model, int levelNum) {
		this.colorPlayer = colorPlayer;
		this.model = model;
		this.levelNum = levelNum;
		createPanel();
		loadInPlayerGrid();
		
		
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame frame = new JFrame();
			        frame.setPreferredSize(new Dimension(800,800));
			        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);		
			        Model m = new Model();
			        frame.getContentPane().add(new BoardView(Color.RED, m, 1)); //change from 1 later
			        frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				//squares[row][col]= new Square(row, col);
				if(model.getLevel(levelNum).getBoardShape()[row][col]){
					JPanel newPanel = new JPanel();
					newPanel.setBackground(SystemColor.activeCaption);
					newPanel.setLayout(new GridLayout(1, 1, 0, 0));
					newPanel.setBorder(new LineBorder(colorPlayer));
					squareViews[row][col] = new SquareView(model.getCurrentBoardState().getSquares()[row][col]);
					
					SquareView panelToAdd = squareViews[row][col];
					
					Dimension prefSize = new Dimension(10,10);
					
					
					JLabel letter = panelToAdd.getLetterLabel();
					
					letter.setHorizontalAlignment(JLabel.CENTER);
					newPanel.add(letter);
					
					newPanel.add(panelToAdd);
					
					System.out.println(newPanel.getBounds());
					boardPanel.add(newPanel);
					//squareBoxesPanels[row][col] = newPanel;
					//squareBoxes[i-1][j-1] = new SquareView(model.getLevel(levelNum));
					squarePanels[row][col] = newPanel;
					//squareBoxes[i-1][j-1] = new SquareView(model.getLevel(levelNum));
					//what even is a squareBox? our terminology is messed
				}				
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

	public JPanel getBoardPanel() {
		return boardPanel;
	}
}
