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
		this.letter = letter;
		initialize();
	}

	private void initialize(){
		this.setText(letter.getLetter());
		this.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 20));
	}
	

	public Letter getLetter(){
		return letter;
	}

	public void setLetter(Letter letter){
		this.letter = letter;
	}

}
