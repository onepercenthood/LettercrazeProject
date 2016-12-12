package lettercraze.view;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import lettercraze.BuilderApplication;
import lettercraze.PlayerApplication;
import lettercraze.controller.builder.SelectBoardSquareController;
import lettercraze.controller.player.ToggleSquareController;
import lettercraze.model.BoardState;
import lettercraze.model.Letter;
import lettercraze.model.Model;
import lettercraze.model.Square;
 
public class BoardView extends DefaultViewPanel implements IModelChangedView {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel boardPanel;
	protected Color colorPlayer;
	protected Model model;
	protected int levelNum;
	
	SquareView[][] squareViews = new SquareView[6][6];
	JPanel[][] squarePanels = new JPanel[6][6];
	private BuilderApplication builderApp;
	private PlayerApplication playerApp;
	

	/**
	 * Constructor for the Builder Context
	 * @param colorPlayer
	 * @param model
	 * @param levelNum
	 * @param app
	 */
	public BoardView(Color colorPlayer, Model model, int levelNum, BuilderApplication app) {
		this.colorPlayer = colorPlayer;
		this.model = model;
		this.levelNum = levelNum;
		this.builderApp = app;
		createPanel();
		//builderInitialize(app);
	}
	
	/**
	 * Constructor for the Player context
	 * @param colorPlayer
	 * @param model
	 * @param levelNum
	 * @param app
	 */
	public BoardView(Color colorPlayer, Model model, int levelNum, PlayerApplication app) {
		this.colorPlayer = colorPlayer;
		this.model = model;
		this.levelNum = levelNum;
		this.playerApp = app;
		createPanel();
		//playerInitialize(app);
	}

	public void createPanel(){
		setLayout(null);
		setBounds(6, 6, 383, 414);
		setBackground(colorPlayer);
		setBorder(new LineBorder(new Color(0, 0, 0), 3));
		setBounds(16, 82, 383, 414);
		setLayout(new GridLayout(6, 6, 0, 0));
		
	}

	/**
	 * intializes the board view for use in the player, with letter views in each square view
	 * @param app
	 */
	public void playerInitialize(PlayerApplication app) {
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				//save some typing
				Square thisSquare = model.getCurrentBoardState().getSquares()[row][col];
				
				//initialize the squareview at row, col
				squareViews[row][col] = new SquareView(thisSquare, colorPlayer, true);
				squareViews[row][col].setPreferredSize(new Dimension(100,100));
				squareViews[row][col].setLayout(null);
				squareViews[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
				squareViews[row][col].addMouseListener(new ToggleSquareController(playerApp, squareViews[row][col], model));
				
				//check if the square is active for this level
				if(thisSquare.isActive()){ 
					if(thisSquare.isSelected()){
						//active, selected squares are colored yellow
						squareViews[row][col].setBackground(Color.YELLOW);
					}else {
						//active, unselected squares are the color specified when the board is initialized
						squareViews[row][col].setBackground(colorPlayer);
					}
				} else {
					//inactive squares are colored black
					squareViews[row][col].setBackground(Color.BLACK);
				}
				add(squareViews[row][col]);
			}
		}	
	}
	

	/**
	 * use this to initialize a board view for building a level
	 * it loads in no letters, only blank squareViews
	 * @param app
	 */
	public void builderInitialize(BuilderApplication app){
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				//save some typing
				Square thisSquare = model.getCurrentBoardState().getSquares()[row][col];
				
				//initialize the squareview at row, col, and to hide the letter
				squareViews[row][col] = new SquareView(thisSquare, colorPlayer, false);
				squareViews[row][col].setPreferredSize(new Dimension(64,64));
				squareViews[row][col].setLayout(null);
				squareViews[row][col].setBorder(BorderFactory.createLineBorder(Color.black));
				squareViews[row][col].addMouseListener(new SelectBoardSquareController(builderApp, squareViews[row][col], model));
				
				//check if the square is active for this level
				if(thisSquare.isActive()){
					//color active squares to the default color
					squareViews[row][col].setBackground(colorPlayer);
				} else {
					//inactive squares are colored black
					squareViews[row][col].setBackground(Color.BLACK);
				}
				add(squareViews[row][col]);
			}
		}	
	}
	
	/**
	 * sets all the squares associated with the squareViews in this boardView to active = true.
	 */
	public void setAllSquaresActive(BuilderView bv){
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j++){
				squareViews[i][j].getSquare().setActive(true);
				squareViews[i][j].repaintSquare();
			}
		}
	}
	
	/**
	 * @return the desired boardShape from the squares pointed to by the gui
	 */
	public boolean[][] getBoardShape(){
		boolean shape[][] = new boolean[6][6];
		//get all the squareViews from the GUI
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				shape[row][col] = squareViews[row][col].getSquare().isActive();
			}
		}
		return shape;
	}
	
	/**
	 * sets the squares in the board to the given shape
	 * @param shape : the shape that holds which squares will be active
	 */
	public void setBoardShape(boolean[][] shape){
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col++){
				squareViews[row][col].getSquare().setActive(shape[row][col]);
			}
		}
	}
	
	public Color getColorPlayer() {
		return colorPlayer;
	}


	public Model getModel() {
		return model;
	}


	public int getLevelNum() {
		return levelNum;
	}


	public SquareView[][] getSquareViews() {
		return squareViews;
	}


	public JPanel[][] getSquarePanels() {
		return squarePanels;
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
	
	public void repaintAllSquares(){
		//super.repaint();
		SquareView currentSquareView ;
		LetterView currentLetterView;
		for(int i = 0; i < 6; i++){
			for(int j = 0; j < 6; j ++){
				currentSquareView = squareViews[i][j];
//				System.out.print(squareViews[i][j].getLetter().getLetter()+ " ");
				
				if( currentSquareView.getSquare().getLetter() == null){
					
//					Square nullSquare = new Square(i,j);
//					nullSquare.setLetter(null);
					currentSquareView.getSquare().setLetter(null);
					currentLetterView = (LetterView) currentSquareView.getComponent(0);
//					currentLetterView.setLetter(nullSquare.getLetter());
					currentLetterView.setText(" ");
					currentLetterView.repaint();
				} else {
					currentLetterView = (LetterView) currentSquareView.getComponent(0);
					currentLetterView.setText(currentSquareView.getSquare().getLetter().getLetter());
					currentLetterView.repaint();
				}	
				
				currentSquareView.repaintSquare();

				
				squareViews[i][j] = currentSquareView;
				
			}
		}
		this.repaint();
	}
	
	
}
