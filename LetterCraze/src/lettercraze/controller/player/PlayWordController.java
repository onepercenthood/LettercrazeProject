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


public class PlayWordController extends MouseAdapter{
	
	/** The game to be manipulated **/
	Model model;
	
	/** the top level application for navigation purposes **/
	PlayerApplication application;
	
	/** the squareview that was clicked **/
	GameView gameView;
	
	public PlayWordController(PlayerApplication application, Model model, GameView gameView) {
		// TODO Auto-generated constructor stub
		this.application = application;
		this.model = model;
		this.gameView = gameView;
	}
	
	public void mousePressed(MouseEvent me){
		Word word = model.getCurrentWord();
		ArrayList<Word> wordsListModel = model.getCurrentBoardState().getFoundWords();
		//DefaultListModel wordsListModel = (DefaultListModel) gameView.getWordsJList().getModel();

		if( word != null){
			if(word.isValid() && !wordsListModel.contains(word)){
				System.out.println("Word is valid");
				System.out.println(word.getWordString());
				
				//make a new boardState with this word removed
				//BoardState currentState = model.getCurrentBoardState();
				Word copyOfWord = word.copyWord();
				//BoardState newState = new BoardState (currentState, copyOfWord);
				  
				 
				//wordsListModel.add(copyOfWord);
				
				BoardState tempBoard = model.getCurrentBoardState();
				
				tempBoard.addWordToFoundWords(copyOfWord);
				
				//takes the calculated score of the played word
				//adds it to the current score and displays it
				int value = word.calculateValue();
				int currentScore = tempBoard.getScore();
				int newScore = 0;
				
				//increment score by the value of the word if puzzle
				if(model.getCurrentLevelObject().getLevelType().equals("Puzzle"))
					newScore = value + currentScore;
				else //if lightning or theme, increment by one
					newScore = currentScore + 1;
				//set the newly incremented score
				tempBoard.setScore(newScore);
				
				//checks new score against star threshold and displays update accordingly
				int currentStars = model.getLevel(model.getCurrentLevel()).getHighStars(newScore);
				tempBoard.setStars(currentStars);
				
				//if lit is played the background turns red
				if(word.getWordString().equals("LIT")){
					gameView.setBackgroundRed();
					gameView.makeItLit();
				}
				
				//if its a puzzle level it keeps track of the moves left
				if(gameView.getLevelType().getText().equals("Puzzle")){
					Puzzle puzzle = (Puzzle) model.getLevel(model.getCurrentLevel());
					int wordsLeft = puzzle.getMaxWords() - model.getCurrentBoardState().getFoundWords().size();
					gameView.setTypeSpecificLabel("Moves Left: " + wordsLeft);
					
					if(wordsLeft <= 0){
						gameView.getAddWordBtn().setEnabled(false);
						gameView.getAddWordBtn().repaint();
					}
				}
				
				System.out.println("Before remove letter From Square");
				//removes the letter from the played squares to be floated into
				tempBoard.removeLetterFromSquares(word);
				
				System.out.println("Before deselect all");
				
				//deselects the played squares
				tempBoard.deselectAllSquares();
				
				System.out.println("Before set current word null");
				
				//sets current word to nothing so a new one can be played
				model.setCurrentWord(null);
			 
				//floats tiles up into empty squares, fills the new empty squares and sets boardstate
				tempBoard.floatTilesUp(tempBoard.getSquares());
				//re-fill the board if it is not a theme level
				if(!model.getCurrentLevelObject().getLevelType().equals("Theme"))
					tempBoard.fillEmptySquares(tempBoard.getSquares());
								
				model.setCurrentBoardState(tempBoard);
				 
				//repaints all changed attributes
				gameView.repaint();
				gameView.addWordModel();
				gameView.setStarRater();
				gameView.getStarRater().repaint();
				gameView.getBoardView().repaintAllSquares();
				gameView.setScoreView();
				gameView.getScoreTextField().repaint();
				gameView.getWordBox().repaint();
				
				System.out.println(model.getCurrentBoardState().getFoundWordsStrings());
				
				 
			}
			else{
				System.out.println("Word is not valid."); 
			}
		}
			

		

		
	}
	
	
	
	
	

}
