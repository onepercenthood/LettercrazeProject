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
	Color defaultColor;
	
	public SquareView(Square square, Color defaultColor){
		this.square = square;
		this.defaultColor = defaultColor;
		setLayout(null);
	}

	public Letter getLetter(){
		return square.getLetter();
	}
	
	public Square getSquare(){
		return square;
	}

	@Override
	public String getPanelName() {
		return "SquareView";
	}
	
	
	public void repaintSquare(){
		super.repaint();
		if(square.isActive()){
			if(square.isSelected()){
				this.setBackground(Color.YELLOW);
			} else {
				this.setBackground(defaultColor);
			}
		} else {
				this.setBackground(Color.GRAY);
		}
	}
}
