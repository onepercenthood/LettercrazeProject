package lettercraze.controller.player;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import lettercraze.PlayerApplication;
import lettercraze.view.SquareView;
import lettercraze.model.Model;
import lettercraze.model.Square;
import lettercraze.model.Word;

/**
 * Controller which toggles the square when the user clicks on it.
 * 
 * This controller is responsible for highlighting the square view, checking adjacency, and appending the letter
 * which the square holds to the currentWord.
 * 
 * @author ddeisadze
 *
 */
public class ToggleSquareController extends MouseAdapter{

	/** The game to be manipulated. **/
	Model model;

	/** the top level application for navigation purposes. **/
	PlayerApplication application;

	/** the squareview that was clicked. **/
	SquareView squareView;

	/**
	 * Main constructor for this controller
	 * 
	 * @param playerApp as the main playerApplication
	 * @param squareView as the main SquareView which was toggled
	 * @param model as the main application wide model
	 */
	public ToggleSquareController(PlayerApplication playerApp, SquareView squareView, Model model) {
		super();
		this.model = model;
		this.application = playerApp;
		this.squareView = squareView;
	}

	/**
	 * MousePressed event as the main actionable method in this class
	 */
	public void mousePressed(MouseEvent me){
		Square toEdit = squareView.getSquare();
		Square[][] boardSquares = model.getCurrentBoardState().getSquares();
		Square checkSquare = boardSquares[toEdit.getRow()][toEdit.getColumn()];
		Word word = model.getCurrentWord();

		//TODO check that letter is only added when toggled false -> true
		if(toEdit.isActive() == true && toEdit.getLetter() != null){
			if(word != null && word.getWordLength()>0){
				Square lastSquare = word.getLastSquare();
				if(toEdit.getRow() == word.getLastSquare().getRow() && toEdit.getColumn() == word.getLastSquare().getColumn()){
					toEdit.toggleSelected();
					//if(toEdit.isSelected()){
					word.removeSquare();
					model.setCurrentWord(word);
					//}
					squareView.repaintSquare();
				}
				//check that this square is adjacent to the previous square
				else if(toEdit.isAdjacent(lastSquare, toEdit) && !(toEdit.isSelected())){
					word.addSquare(toEdit);
					model.setCurrentWord(word);
					toEdit.toggleSelected();
					squareView.repaintSquare();
				}
				else{}
			}
			else if(word != null && word.getWordLength()==0){
				word.addSquare(toEdit);
				model.setCurrentWord(word);
				toEdit.toggleSelected(); 
				squareView.repaintSquare();
			}
			else{
				word = new Word(toEdit);
				model.setCurrentWord(word);
				toEdit.toggleSelected();
				squareView.repaintSquare();
			}

			//toggle whether the square is active
			System.out.println(word.getWordString()); 
			System.out.println("Selected: " + toEdit.isSelected() + " Active: " + toEdit.isActive());
		}
	}



}
