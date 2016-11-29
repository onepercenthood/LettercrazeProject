package lettercraze.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;

public class PuzzleLevel extends DefaultJFrame {


	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PuzzleLevel frame = new PuzzleLevel();
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
	public PuzzleLevel() {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.getContentPane().setPreferredSize(new Dimension(800, 600));
	    this.pack();
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 17, 410, 399);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(493, 29, 124, 27);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel = new JLabel("Difficulty");
		lblNewLabel.setBounds(503, 79, 61, 16);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Reset");
		btnNewButton.setBounds(493, 397, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Save Level");
		btnNewButton_1.setBounds(632, 397, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("100 points");
		lblNewLabel_1.setBounds(632, 130, 79, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("200 points");
		lblNewLabel_2.setBounds(632, 193, 79, 16);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("300 points");
		lblNewLabel_3.setBounds(632, 258, 79, 16);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("120 max moves");
		lblNewLabel_4.setBounds(503, 321, 129, 16);
		contentPane.add(lblNewLabel_4);
		
		JPanel panel_star_1 = new JPanel();
		panel_star_1.setBounds(524, 119, 34, 27);
		StarRater starRater1 = new StarRater(1, 1 );
		starRater1.setBounds(0, 6, 48, 16);
		starRater1.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		panel_star_1.add(starRater1);
		contentPane.add(panel_star_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(524, 182, 53, 27);
		StarRater starRater2 = new StarRater(2, 2 );
		starRater2.setBounds(0, 6, 48, 16);
		starRater2.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		panel_2.add(starRater2);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(524, 247, 69, 27);
		StarRater starRater3 = new StarRater(3, 3 );
		starRater3.setBounds(0, 6, 48, 16);
		starRater3.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		
		panel_3.add(starRater3);
		
		contentPane.add(panel_3);
		
		contentPane.add(new DrawStarShapePanel());
		
		JLabel lblLevelType = new JLabel("Level Type");
		lblLevelType.setBounds(503, 17, 90, 16);
		contentPane.add(lblLevelType);
//        f.setSize(600, 600);
//        f.setLocationRelativeTo(null);
//        f.setVisible(true);
	}
}
