package lettercraze.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lettercraze.model.Letter;
import net.miginfocom.swing.MigLayout;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LetterView extends JLabel{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -4249162213703886638L;

	private Letter letter;

	public LetterView(Letter letter){
		setHorizontalAlignment(SwingConstants.CENTER);
		this.letter = letter;
		initialize();
	}

	private void initialize(){
		if(letter != null){
			this.setText(letter.getLetter());
			this.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		} 
		else{
			this.setText("");
		}
	}
	
	public String numToSubscript(){
		int value = letter.getValue();
		//String subscript = "\u2082" + Integer.toString(value);
		String subscript = "\u2082";
		return subscript;
	}
	
	/**
	 * repaints the letterView, updating the text to match the letter it references
	 */
	public void repaintLetterView(){
		//update the text to display
		if(letter != null){
			System.out.println("updating LetterView text to: " + letter.getLetter());
			this.setText(letter.getLetter());
			this.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		} 
		else{
			this.setText("");
			System.out.println("updating LetterView to empty string");
		}
		
		//repaint the label
		//this.repaint();
	}
	
	public Letter getLetter(){
		return letter;
	}


	public void setLetter(Letter letter){
		this.letter = letter;
	}

}
