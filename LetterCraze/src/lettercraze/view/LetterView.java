package lettercraze.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import lettercraze.model.Letter;
import net.miginfocom.swing.MigLayout;
import java.awt.Font;
import javax.swing.SwingConstants;

public class LetterView extends DefaultViewPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4249162213703886638L;

	private Letter letter;

	public LetterView(Letter letter){
		this.letter = letter;
		setLayout(null);

		initialize();
	}

	private void initialize(){

		JLabel lblA = new JLabel("A");
		lblA.setBounds(41, 11, 59, 120);
		lblA.setFont(new Font("Tahoma", Font.PLAIN, 99));
		add(lblA);
		
		JLabel label = new JLabel("2");
		label.setFont(new Font("Tahoma", Font.PLAIN, 40));
		label.setBounds(112, 59, 59, 120);
		add(label);

	}

	@Override
	public String getPanelName() {
		return "LetterView";
	}


}
