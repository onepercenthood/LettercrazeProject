package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;

import lettercraze.PlayerApplication;
import lettercraze.model.BoardState;
import lettercraze.model.Model;
import lettercraze.model.Word;
import lettercraze.view.GameView;
import lettercraze.view.SquareView;

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
		DefaultListModel wordsListModel = (DefaultListModel) gameView.getWordsJList().getModel();

		if( word != null){
			if(word.isValid() && !wordsListModel.contains(word)){
				System.out.println("Word is valid");
				System.out.println(word.getWordString());
				
				//make a new boardState with this word removed
				BoardState currentState = model.getCurrentBoardState();
				Word copyOfWord = word.copyWord();
				BoardState newState = new BoardState (currentState, copyOfWord);
				
				//remove the word from current word
				model.setCurrentWord(null);
				//update the model boardstate
				model.setCurrentBoardState(newState);
				gameView.getBoardView().setSquareViewTargets(newState);
				gameView.getBoardView().repaintAllSquares();
				//gameView.repaint();
				
				
				wordsListModel.addElement(copyOfWord);
//				BoardState tempBoard = model.getCurrentBoardState();
//				tempBoard.removeLetterFromSquares(word);
//				tempBoard.deselectAllSquares();
//				model.setCurrentWord(null);
//				//tempBoard.floatTilesUp(tempBoard.getSquares());
//				model.setCurrentBoardState(tempBoard);
//				gameView.getBoardView().repaintAllSquares();
				
			}
			else{
				System.out.println("Word is not valid."); 
			}
		}
			

		

		
	}
	
	
	
	
	

}
