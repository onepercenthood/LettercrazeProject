package lettercraze.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.JLabel;

import lettercraze.model.Letter;
import lettercraze.model.Square;
import javax.swing.JPanel;
import java.awt.SystemColor;

public class SquareView extends DefaultViewPanel{

	private Square square;
	private JLabel lblA;
	private JLabel label;
	
	public SquareView(Square square){
		this.square = square;
		setLayout(null);
		
		initialize();
	}

	private void initialize(){
		
		if(square.getLetter() != null){
			lblA = new JLabel(square.getLetter().getLetter());
//			lblA.setBounds(41, 11, 59, 120);
			lblA.setFont(new Font("Tahoma", Font.PLAIN, 10));
			add(lblA);
			
			label = new JLabel(Integer.toString(square.getLetter().getValue()));
			label.setFont(new Font("Tahoma", Font.PLAIN, 10));
//			label.setBounds(112, 59, 59, 120);
			add(label);
		}
		
		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.LIGHT_GRAY);
//		panel.setBounds(0, 0, 150, 150);
//		add(panel);
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
	
	public JLabel getLetterLabel(){
		return this.lblA;
	}

}
