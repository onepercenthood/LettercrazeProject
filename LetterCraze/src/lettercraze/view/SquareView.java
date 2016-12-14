package lettercraze.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;

import lettercraze.model.Letter;
import lettercraze.model.Square;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class SquareView extends DefaultViewPanel{

	private Square square;
	LetterView letterView;
	Color defaultColor;
	
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
	

	public Letter getLetter(){
		return square.getLetter();
	}
	
	public Square getSquare(){
		return square;
	}
	
	public void setSquare(Square square){
		this.square = square;
		Letter newLetter = square.getLetter().copyLetter();
		setLetterView(new LetterView(newLetter));
	}

	@Override
	public String getPanelName() {
		return "SquareView";
	}
	
	
	public LetterView getLetterView() {
		return letterView;
	}

	public void setLetterView(LetterView letterView) {
		this.letterView = letterView;
	}
	
	public void showLetterView(){
		getComponent(0).show();
	}
	
	public void hideLetterView(){
		remove(letterView);
	}

	public void repaintSquare(){
		if(square.isActive()){
			if(square.isSelected()){
				this.setBackground(Color.YELLOW);
			} else {
				this.setBackground(defaultColor);
			}
		} else {
				this.setBackground(Color.GRAY);
		}
		//letterView.repaintLetterView();
	}
}
