
package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import lettercraze.PlayerApplication;
import lettercraze.model.BoardState;
import lettercraze.model.Model;
import lettercraze.model.Puzzle;
import lettercraze.model.Word;
import lettercraze.view.GameView;
import lettercraze.view.SquareView;

public class UndoController extends MouseAdapter{

	/** The game to be manipulated **/
	Model model;

	/** the top level application for navigation purposes **/
	PlayerApplication application;

	/** the squareview that was clicked **/
	GameView gameView;

	public UndoController(PlayerApplication application, Model model, GameView gameView) {
		// TODO Auto-generated constructor stub
		this.application = application;
		this.model = model;
		this.gameView = gameView;
	}

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
			int newScore = currentScore - value;
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
			}

			System.out.println("Floating down word: " + remove.toString());

			gameView.setStarRater();
			gameView.getStarRater().repaint();
			gameView.getBoardView().repaintAllSquares();
<<<<<<< HEAD
			gameView.setScoreView();
			gameView.getScoreTextField().repaint();
			gameView.getTypeSpecific().repaint();
			System.out.println(model.getCurrentBoardState().getSquares());
=======
		}
		//takes the calculated score of the played word
		//adds it to the current score and displays it
		int value = remove.calculateValue();
		int currentScore = model.getCurrentBoardState().getScore();
		int newScore = currentScore - value;
		model.getCurrentBoardState().setScore(newScore);


		//checks new score against star threshold and displays update accordingly
		int currentStars = model.getLevel(model.getCurrentLevel() + 1).getHighStars(newScore);
		model.getCurrentBoardState().setStars(currentStars);

		model.getCurrentBoardState().getFoundWords().remove(model.getCurrentBoardState().getFoundWords().size()-1);
		model.getCurrentBoardState().floatTileDown(model.getCurrentBoardState().getSquares(), remove);

		gameView.removeWordModel();

		if(gameView.getLevelType().getText().equals("Puzzle")){
			Puzzle puzzle = (Puzzle) model.getLevel(model.getCurrentLevel());
			int wordsLeft = puzzle.getMaxWords() - model.getCurrentBoardState().getFoundWords().size();
			gameView.setTypeSpecificLabel("Moves Left: " + wordsLeft);
>>>>>>> refs/heads/J
		}
		
	}
}
