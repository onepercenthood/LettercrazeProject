package lettercraze.view;

import javax.swing.JLabel;

import lettercraze.model.Letter;
import java.awt.Font;
import javax.swing.SwingConstants;

/**
 * Main letterView class which holds the letter as a JLabel
 * 
 * @author ddeisadze
 *
 */
public class LetterView extends JLabel{

	/**
	 * Serial ID
	 */
	private static final long serialVersionUID = -4249162213703886638L;

	/**
	 * The encapsulated letter data structure
	 */
	private Letter letter;

	/**
	 * Main constructor for this class.
	 * 
	 * @param letter as the letter class which to hold
	 */
	public LetterView(Letter letter){
		setFont(new Font("Tahoma", Font.PLAIN, 16));
		setHorizontalAlignment(SwingConstants.CENTER);
		this.letter = letter;
		initialize();
	}

	/**
	 * Initialize the letterView with the data structure. Basically displays the data.
	 */
	private void initialize(){
		if(letter != null){
			this.setText(letter.getLetter());
			this.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 30));
		} 
		else{
			this.setText("");
		}
	}
	

	@Deprecated
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
	
	/**
	 * Getter for the letter.
	 * @return the Letter data structure
	 */
	public Letter getLetter(){
		return letter;
	}


	/**
	 * Setter for the letter.
	 * @param letter Letter class to set
	 */
	public void setLetter(Letter letter){
		this.letter = letter;
	}

}
