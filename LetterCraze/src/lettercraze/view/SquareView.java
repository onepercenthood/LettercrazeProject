package lettercraze.view;

import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;

import lettercraze.model.Letter;
import lettercraze.model.Square;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class SquareView extends DefaultViewPanel{

	private Square square;
	private Box squareBox;
	private LetterView letter;

	public SquareView(Square square, Box squareBox, LetterView letter){
		this.square = square;
		this.squareBox = squareBox;
		this.letter = letter;
		setLayout(null);
		
		initialize();
	}
	
	public SquareView(Square square){
		this.square = square;
		setLayout(null);
		
		initialize();
	}

	private void initialize(){
		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.windowBorder);
		panel.setBounds(0, 0, 150, 150);
		add(panel);
	}

	public Letter getLetter(){
		return letter.getLetter();
	}
	
	public LetterView getLetterView(){
		return letter;
	}
	
	public Square getSquare(){
		return square;
	}
	
	public Box getSquareBox(){
		return squareBox;
	}

	@Override
	public String getPanelName() {
		return "SquareView";
	}

}
