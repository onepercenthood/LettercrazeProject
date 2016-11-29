package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class Player extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Player frame = new Player();
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
	public Player() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		this.getContentPane().setPreferredSize(new Dimension(800, 600));
	    this.pack();
	    contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLettercraze = new JLabel("LetterCraze");
		lblLettercraze.setBounds(6, 6, 94, 26);
		contentPane.add(lblLettercraze);
		
		JLabel lblScore = new JLabel("Score:");
		lblScore.setBounds(6, 30, 94, 26);
		contentPane.add(lblScore);
		
		JLabel label = new JLabel("400");
		label.setBounds(56, 30, 94, 26);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(16, 82, 383, 414);
		contentPane.add(panel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(439, 82, 338, 414);
		contentPane.add(scrollPane);
		
		JLabel lblWords = new JLabel("Words");
		lblWords.setBounds(439, 49, 61, 16);
		contentPane.add(lblWords);
		
		JButton btnExitLevel = new JButton("Exit Level");
		btnExitLevel.setBounds(660, 6, 117, 29);
		contentPane.add(btnExitLevel);
		
		JPanel panel_stars = new JPanel();
		panel_stars.setBounds(6, 56, 94, 26);
		StarRater starRater21 = new StarRater(3, 3 );
		starRater21.setBounds(0, 6, 48, 16);
		starRater21.addStarListener(new StarRater.StarListener() {

			@Override
			public void handleSelection(int selection) {
				// TODO Auto-generated method stub
				
			}
		
		});
		panel_stars.setLayout(null);
		//		
		panel_stars.add(starRater21);
		contentPane.add(panel_stars);
	}

}
