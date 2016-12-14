
package lettercraze.view;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * Panel to hold the splashScreen
 * @author ddeisadze
 *
 */
public class SplashScreen extends DefaultViewPanel{
	
	/**
	 * Constructor for the splashScreen
	 * @param builderOrPlayer
	 */
	public SplashScreen(String builderOrPlayer) {
		super();
		setBackground(new Color(204, 255, 255));
		setBounds(100, 100, 876, 564);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblGroupManganese = new JLabel("Group Manganese");
		lblGroupManganese.setForeground(new Color(255, 69, 0));
		lblGroupManganese.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblGroupManganese.setHorizontalAlignment(SwingConstants.CENTER);
		lblGroupManganese.setBounds(357, 280, 144, 16);
		add(lblGroupManganese);
		
		JLabel lblDavidDeisadze = new JLabel("David \"Where's David\" Deisadze");
		lblDavidDeisadze.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDavidDeisadze.setHorizontalAlignment(SwingConstants.LEFT);
		lblDavidDeisadze.setBounds(357, 307, 250, 16);
		add(lblDavidDeisadze);
		
		JLabel lblDerekFeehrer = new JLabel("Derek \"Golden Hair\" Feehrer");
		lblDerekFeehrer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDerekFeehrer.setHorizontalAlignment(SwingConstants.LEFT);
		lblDerekFeehrer.setBounds(357, 330, 200, 16);
		add(lblDerekFeehrer);
		
		JLabel lblJackHarding = new JLabel("Jack \"What's Git?\" Harding");
		lblJackHarding.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJackHarding.setHorizontalAlignment(SwingConstants.LEFT);
		lblJackHarding.setBounds(357, 349, 200, 16);
		add(lblJackHarding);
		
		JLabel lblZackHood = new JLabel("Zack \"Lit\" Hood");
		lblZackHood.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblZackHood.setHorizontalAlignment(SwingConstants.LEFT);
		lblZackHood.setBounds(357, 370, 200, 16);
		add(lblZackHood);
		
		JLabel lblDeanSchifilliti = new JLabel("Dean \"Dammit Dean\" Schifilliti");
		lblDeanSchifilliti.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeanSchifilliti.setHorizontalAlignment(SwingConstants.LEFT);
		lblDeanSchifilliti.setBounds(357, 391, 200, 16);
		add(lblDeanSchifilliti);
		
		
		JLabel JbuilderOrPlayer = new JLabel(builderOrPlayer);
		JbuilderOrPlayer.setForeground(new Color(0, 0, 255));
		JbuilderOrPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		JbuilderOrPlayer.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		JbuilderOrPlayer.setBounds(344, 228, 167, 28);
		add(JbuilderOrPlayer);
		
		JLabel label = new JLabel("L");
		label.setForeground(new Color(255, 0, 0));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label.setBounds(202, 118, 208, 40);
		add(label);
		
		JLabel lblLettercraze = new JLabel("e");
		lblLettercraze.setForeground(new Color(0, 0, 255));
		lblLettercraze.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblLettercraze.setHorizontalAlignment(SwingConstants.CENTER);
		lblLettercraze.setBounds(227, 118, 208, 40);
		add(lblLettercraze);
		
		JLabel lblT = new JLabel("t");
		lblT.setForeground(new Color(255, 140, 0));
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblT.setBounds(247, 118, 208, 40);
		add(lblT);
		
		JLabel label_1 = new JLabel("t");
		label_1.setForeground(new Color(0, 255, 0));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label_1.setBounds(263, 118, 208, 40);
		add(label_1);
		
		JLabel label_2 = new JLabel("e");
		label_2.setForeground(new Color(255, 0, 255));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label_2.setBounds(285, 118, 208, 40);
		add(label_2);
		
		JLabel lblR = new JLabel("r");
		lblR.setForeground(new Color(255, 255, 0));
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblR.setBounds(307, 118, 208, 40);
		add(lblR);
		
		JLabel lblC = new JLabel("C");
		lblC.setForeground(new Color(0, 0, 255));
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblC.setBounds(342, 118, 208, 40);
		add(lblC);
		
		JLabel label_3 = new JLabel("r");
		label_3.setForeground(new Color(138, 43, 226));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label_3.setBounds(364, 118, 208, 40);
		add(label_3);
		
		JLabel lblA = new JLabel("a");
		lblA.setForeground(new Color(255, 0, 0));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblA.setBounds(386, 118, 208, 40);
		add(lblA);
		
		JLabel lblZ = new JLabel("z");
		lblZ.setForeground(new Color(0, 255, 0));
		lblZ.setHorizontalAlignment(SwingConstants.CENTER);
		lblZ.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblZ.setBounds(409, 118, 208, 40);
		add(lblZ);
		
		JLabel label_4 = new JLabel("e");
		label_4.setForeground(new Color(255, 140, 0));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label_4.setBounds(432, 118, 208, 40);
		add(label_4);
	}
	
	/**
	 * Sets up the JFrame based on the size and string and displays the splash-screen.
	 * 
	 * @param size Size of the JFrame window
	 * @param builderOrPlayer Text to differentiate the title of the splash-screen
	 * @return JFrame instance
	 */
	public static JFrame createAndShowGUI(Dimension size, String builderOrPlayer) {
        //Create and set up the window.
        JFrame frame = new JFrame("SplashScreen");
        frame.setPreferredSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SplashScreen splashScreen = new SplashScreen(builderOrPlayer);

        //Add the ubiquitous "Hello World" label.
        frame.getContentPane().add(splashScreen);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
        
        return frame;
    }


	@Override
	public String getPanelName() {
		// TODO Auto-generated method stub
		return "SplashView";
	}
}