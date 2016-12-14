
package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import lettercraze.PlayerApplication;
import lettercraze.model.Model;
import lettercraze.model.Puzzle;
import lettercraze.model.Word;
import lettercraze.view.GameView;

/**
 * UndoController which handles all undo actions on our player board.
 * 
 * @author ddeisadze
 *
 */
public class UndoController extends MouseAdapter{

	/** The game to be manipulated **/
	Model model;

	/** the top level application for navigation purposes **/
	PlayerApplication application;

	/** the squareview that was clicked **/
	GameView gameView;

	/**
	 * The main constructor for this class.
	 * 
	 * @param application as the main application instance in player
	 * @param model as the main model instance from applciation
	 * @param gameView as the main gameView panel which holds the game structure
	 */
	public UndoController(PlayerApplication application, Model model, GameView gameView) {
		// TODO Auto-generated constructor stub
		this.application = application;
		this.model = model;
		this.gameView = gameView;
	}

	/**
	 * MousePressed method as the main actionable method in this class.
	 */
	public void mousePressed(MouseEvent me){
		if(model.getCurrentBoardState().getFoundWords().size() >= 1){
			//model.getBoardStateArray().remove(model.getBoardStateArray().size()-1);
			//int index = model.getCurrentBoardState().getFoundWords().size();
			int index = model.getCurrentBoardState().getFoundWords().size() - 1;
			//Word remove = model.getCurrentBoardState().getFoundWords().get(0);
			Word remove = model.getCurrentBoardState().getFoundWords().get(index);
			System.out.println(remove.getLetters());

			if(model.getCurrentWord() != null){
				if(model.getCurrentWord().getWordLength() != 0){
					model.getCurrentBoardState().deselectAllSquares();
					model.setCurrentWord(null);
					gameView.getBoardView().repaintAllSquares();
				}
			}
			//takes the calculated score of the played word
			//adds it to the current score and displays it
			int value = remove.calculateValue();
			int currentScore = model.getCurrentBoardState().getScore();
			int newScore = 0;
			//increment score by the value of the word if puzzle
			if(model.getCurrentLevelObject().getLevelType().equals("Puzzle"))
				newScore = currentScore - value;
			else //if lightning or theme, increment by one
				newScore = currentScore - 1;
			//set the newly incremented score
			model.getCurrentBoardState().setScore(newScore);


			//checks new score against star threshold and displays update accordingly
			int currentStars = model.getLevel(model.getCurrentLevel()).getHighStars(newScore);
			model.getCurrentBoardState().setStars(currentStars);

			model.getCurrentBoardState().getFoundWords().remove(model.getCurrentBoardState().getFoundWords().size()-1);
			model.getCurrentBoardState().floatTileDown(model.getCurrentBoardState().getSquares(), remove);

			gameView.removeWordModel();

			if(gameView.getLevelType().getText().equals("Puzzle")){
				Puzzle puzzle = (Puzzle) model.getLevel(model.getCurrentLevel());
				int wordsLeft = puzzle.getMaxWords() - model.getCurrentBoardState().getFoundWords().size();
				gameView.setTypeSpecificLabel("Moves Left: " + wordsLeft);
				
				if(wordsLeft >= 0){
					gameView.getAddWordBtn().setEnabled(true);
					gameView.getAddWordBtn().repaint();
				}
			}

			System.out.println("Floating down word: " + remove.toString());

			gameView.setStarRater();
			gameView.getStarRater().repaint();
			gameView.getBoardView().repaintAllSquares();
			gameView.setScoreView();
			gameView.getScoreTextField().repaint();
			gameView.getTypeSpecific().repaint();
			System.out.println(model.getCurrentBoardState().getSquares());
		}
		
		
	}
}
