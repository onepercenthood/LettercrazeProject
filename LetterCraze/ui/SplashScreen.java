package ui;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class SplashScreen extends DefaultJFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLettercraze = new JLabel("LetterCraze");
		lblLettercraze.setBounds(182, 65, 105, 16);
		contentPane.add(lblLettercraze);
		
		JLabel lblGroupManganese = new JLabel("Group Manganese");
		lblGroupManganese.setBounds(163, 90, 144, 16);
		contentPane.add(lblGroupManganese);
		
		JLabel lblDavidDeisadze = new JLabel("David Deisadze");
		lblDavidDeisadze.setBounds(163, 113, 144, 16);
		contentPane.add(lblDavidDeisadze);
		
		JLabel lblDerekFeehrer = new JLabel("Derek Feehrer");
		lblDerekFeehrer.setBounds(163, 136, 144, 16);
		contentPane.add(lblDerekFeehrer);
		
		JLabel lblJackHarding = new JLabel("Jack Harding");
		lblJackHarding.setBounds(163, 155, 144, 16);
		contentPane.add(lblJackHarding);
		
		JLabel lblZackHood = new JLabel("Zack Hood");
		lblZackHood.setBounds(163, 176, 144, 16);
		contentPane.add(lblZackHood);
		
		JLabel lblDeanSchifilliti = new JLabel("Dean Schifilliti");
		lblDeanSchifilliti.setBounds(163, 197, 144, 16);
		contentPane.add(lblDeanSchifilliti);
	}
}
