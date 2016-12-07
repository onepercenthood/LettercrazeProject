package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.DefaultListModel;

import lettercraze.PlayerApplication;
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
				
		if( word != null){
			if(word.isValid()){
				System.out.println("Word is valid");
				System.out.println(word);
				
				DefaultListModel wordsListModel = (DefaultListModel) gameView.getWordsJList().getModel();
				
				wordsListModel.addElement(word);
				
//				gameView.get
			}
			else{
				System.out.println("Word is not valid.");
			}
		}
			

		

		
	}
	
	
	
	
	

}
