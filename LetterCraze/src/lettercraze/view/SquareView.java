package lettercraze.view;

import java.awt.Color;

import lettercraze.model.Letter;
import lettercraze.model.Square;

/**
 * SquareVeiw shows the state of the square its linked to
 * @author Everett
 *
 */
public class SquareView extends DefaultViewPanel{

	private Square square;
	LetterView letterView;
	Color defaultColor;
	
	/**
	 * Constructor for the squareView 
	 * @param square as Square
	 * @param defaultColor as Color
	 * @param showLetter as showLetter
	 */
	public SquareView(Square square, Color defaultColor, boolean showLetter){
		this.square = square;
		this.defaultColor = defaultColor;
		//Set up the letterView to appear in the middle of the sqaure
		this.letterView = new LetterView(square.getLetter());
		int halfWidth = this.getWidth() / 2;
		int halfHeight = this.getHeight() / 2;
		letterView.setBounds(0, 0,72,72);
		add(letterView);
		//if we're supposed to show the letter, add it to the panel
		if(!showLetter) 
			getComponent(0).hide();
		setLayout(null);
	}
	

	/**
	 * returns the letter contained in the square
	 * @return Letter
	 */
	public Letter getLetter(){
		return square.getLetter();
	}
	
	/**
	 * returns the Square associated with this SquareView
	 * @return Square
	 */
	public Square getSquare(){
		return square;
	}
	
	/**
	 * sets this square to contain the same letter as the given square
	 * @param square
	 */
	public void setSquare(Square square){
		this.square = square;
		Letter newLetter = square.getLetter().copyLetter();
		setLetterView(new LetterView(newLetter));
	}

	@Override
	public String getPanelName() {
		return "SquareView";
	}
	
	/**
	 * returns the letterView associated with this squareView
	 * @return LetterView
	 */
	public LetterView getLetterView() {
		return letterView;
	}

	/**
	 * sets the letterVeiw object to the given letterView
	 * @param letterView
	 */
	public void setLetterView(LetterView letterView) {
		this.letterView = letterView;
	}
	
	/**
	 * repaints this squareView
	 */
	public void repaintSquare(){
		if(square.isActive()){
			if(square.isSelected()){
				this.setBackground(Color.YELLOW);
			} else {
				this.setBackground(new Color(204,255,255));
			}
		} else {
				this.setBackground(Color.GRAY);
		}
		//letterView.repaintLetterView();
	}
}
