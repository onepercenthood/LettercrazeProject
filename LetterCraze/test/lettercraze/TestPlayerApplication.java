package lettercraze;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import junit.framework.TestCase;
import lettercraze.controller.player.ClearWordController;
import lettercraze.controller.player.LeaveLevelEarlyController;
import lettercraze.controller.player.PlayWordController;
import lettercraze.controller.player.ResetDataController;
import lettercraze.controller.player.SelectAvailableLevelController;
import lettercraze.controller.player.ToggleSquareController;
import lettercraze.controller.player.UndoController;
import lettercraze.model.Alphabet;
import lettercraze.model.BoardState;
import lettercraze.model.Letter;
import lettercraze.model.Model;
import lettercraze.model.Puzzle;
import lettercraze.model.Square;
import lettercraze.model.Theme;
import lettercraze.model.Word;
import lettercraze.model.WordTable;
import lettercraze.view.GameView;
import lettercraze.view.SplashScreen;
import lettercraze.view.SquareView;

/**
 * Test case to test Player Application
 * 
 * @author Hoodie
 *
 */
public class TestPlayerApplication extends TestCase {
	
	private PlayerApplication pa;
	private JPanel cdlPanel;
	private CardLayout cdl;
	
	private BoardState bs;
	private Square[][] squares;
	private boolean[][] shape;
	private boolean[][] shapeTheme;

	/**
	 * Test Splash Screen and create Player Application to test
	 */
	public TestPlayerApplication(){
		int initialWidth = 900;
		int initialHeight = 635;
		Dimension size = new Dimension(initialWidth, initialHeight);

		JFrame splashFrame = SplashScreen.createAndShowGUI(size, "Player");
		splashFrame.setVisible(false);
		
		pa = new PlayerApplication();
//		pa.main(new String[0]);
		cdlPanel = pa.getCardLayoutParent();
		cdl = (CardLayout) pa.getCardLayoutParent().getLayout();
		
		Alphabet alp = Alphabet.getInstance();
		
		Letter l = alp.letters.get("L");
		Letter i = alp.letters.get("I");
		Letter t = alp.letters.get("T");
			
		
		shape = new boolean[6][6];
		shapeTheme = new boolean[6][6];

		 squares = new Square[6][6];
		Square square;
		for( int row =0; row < 6; row++){
			for( int col=0; col < 6; col++){
				shape[row][col] = true;
				shapeTheme[row][col] = false;
				square = new Square(row, col);
				
				if( col % 3 == 0){
					square.setLetter(l);
				}else if( col % 3 == 1){
					square.setLetter(i);
				}else{
					square.setLetter(t);
				}
				
				square.setActive(true);
				
				squares[row][col] = square;
				
			}
		}
		
		shapeTheme[0][0] = true;
		shapeTheme[0][1] = true;
		shapeTheme[0][2] = true;

		
		System.out.println(squares);
		
		Puzzle puzLevel = new Puzzle(1, new int[]{1,2,3}, 3);
		
		puzLevel.setBoardShape(shape);
		bs = new BoardState(puzLevel);
		
		bs.setSquares(squares);

	}
	
	/**
	 * Test Player Application 
	 */
	public void testPlayLevel1(){
		
		Model model = pa.getModel();
		
		pa.model.setCurrentBoardState(bs);
		
		ArrayList<String> temp = new ArrayList<String>();
		temp.add("LIT");
//		Theme theme = new Theme(pa.model.getAllLevels().size(), "LIT", temp);
//		theme.setBoardShape(shapeTheme);
		
//		pa.model.addLevel(theme);
		
		pa.model.setCurrentLevel(1);

		
		new SelectAvailableLevelController(1, pa.getModel(), cdl, pa, true).actionPerformed(null);
		
//		pa.model.setCurrentBoardState(bs);
		
		
		GameView gameView = (GameView) pa.getCardLayoutParent().getComponent(1);
		
//		GameView gameView = new GameView(model, 1, pa.getCardLayoutParent(), pa);
		
		pa.gameView = gameView;

		
		gameView.getBoardView().repaintAllSquares();

		
		SquareView[][] squareViews = gameView.getBoardView().getSquareViews();
		
		SquareView firstLetter = squareViews[0][0];
		SquareView secondLetter = squareViews[0][1];
		SquareView thirdLetter = squareViews[0][2];

		
		System.out.println(firstLetter.getLetter().toString());
		System.out.println(secondLetter.getLetter().toString());
		System.out.println(thirdLetter.getLetter().toString());
		
		String word = "";
		
		word += firstLetter.getSquare().getLetter().getLetter();
		word += secondLetter.getSquare().getLetter().getLetter();
		word += thirdLetter.getSquare().getLetter().getLetter();

		System.out.println("Word: " + word);
		

		new ToggleSquareController(pa, firstLetter, model).mousePressed(null);
		new ToggleSquareController(pa, secondLetter, model).mousePressed(null);
		new ToggleSquareController(pa, thirdLetter, model).mousePressed(null);
		System.out.println("Cur word: " + model.getCurrentWord().getWordString());

		
		new ClearWordController(pa, gameView.getBoardView(), model).mousePressed(null);;

		
		new ToggleSquareController(pa, firstLetter, model).mousePressed(null);
		new ToggleSquareController(pa, secondLetter, model).mousePressed(null);
		new ToggleSquareController(pa, thirdLetter, model).mousePressed(null);
		
		System.out.println("Cur word: " + model.getCurrentWord().getWordString());
		
		new PlayWordController(pa, model, gameView).mousePressed(null);
		new UndoController(pa, model, gameView).mousePressed(null);;
		
		
		assertEquals(word, "LIT");
		
		Square s1 = new Square(0,1);
		s1.setLetter(new Letter("L",2,2.1));
		Square s2 = new Square(0,2);
		s2.setLetter(new Letter("I",2,2.1));
		Square s3 = new Square(0,3);
		s3.setLetter(new Letter("T",2,2.1));
		
		Word testWord = new Word(s1);
		testWord.addSquare(s2);
		testWord.addSquare(s3);
		
		ArrayList<String> list = new ArrayList<String>();
		list.add("LIT");
		
		boolean validTest = testWord.isValid(list);
		
		assertEquals(validTest, true);
		
		BoardState test = new BoardState(model.getCurrentBoardState(), testWord);

		assertEquals(model.getCurrentLevel(), 1 );
		
	}
	
	/**
	 * Test Player Application 
	 */
	public void testPlayLevel2(){
		new SelectAvailableLevelController(2, cdl, pa).actionPerformed(null);
		
		assertEquals(pa.model.getCurrentLevel(), 2);

		
		new LeaveLevelEarlyController(pa.getCardLayoutParent(), pa.model, pa.gameView).mousePressed(null);
		
		new ResetDataController(pa.menuView).actionPerformed(null);
				

	}
	
	/**
	 * Test Player Application 
	 */
	public void testPlayLevel3(){
		new SelectAvailableLevelController(3, cdl, pa).actionPerformed(null);
		
		assertEquals(pa.model.getCurrentLevel(), 3);

	}
	
	

}
