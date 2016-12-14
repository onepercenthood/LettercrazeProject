
package lettercraze.view;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;

public class SplashScreen extends DefaultViewPanel{


	/**
	 * Create the frame.
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
		lblGroupManganese.setBounds(354, 267, 144, 28);
		add(lblGroupManganese);
		
		JLabel lblDavidDeisadze = new JLabel("David Deisadze");
		lblDavidDeisadze.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDavidDeisadze.setHorizontalAlignment(SwingConstants.CENTER);
		lblDavidDeisadze.setBounds(329, 307, 203, 16);
		add(lblDavidDeisadze);
		
		JLabel lblDerekFeehrer = new JLabel("Derek Feehrer");
		lblDerekFeehrer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDerekFeehrer.setHorizontalAlignment(SwingConstants.CENTER);
		lblDerekFeehrer.setBounds(329, 330, 203, 16);
		add(lblDerekFeehrer);
		
		JLabel lblJackHarding = new JLabel("Jack Harding");
		lblJackHarding.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblJackHarding.setHorizontalAlignment(SwingConstants.CENTER);
		lblJackHarding.setBounds(329, 349, 203, 16);
		add(lblJackHarding);
		
		JLabel lblZackHood = new JLabel("Zack Hood");
		lblZackHood.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblZackHood.setHorizontalAlignment(SwingConstants.CENTER);
		lblZackHood.setBounds(329, 370, 203, 16);
		add(lblZackHood);
		
		JLabel lblDeanSchifilliti = new JLabel("Dean Schifilliti");
		lblDeanSchifilliti.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDeanSchifilliti.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeanSchifilliti.setBounds(329, 391, 203, 16);
		add(lblDeanSchifilliti);
		
		
		JLabel JbuilderOrPlayer = new JLabel(builderOrPlayer);
		JbuilderOrPlayer.setForeground(new Color(0, 0, 255));
		JbuilderOrPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		JbuilderOrPlayer.setFont(new Font("Lucida Grande", Font.PLAIN, 19));
		JbuilderOrPlayer.setBounds(344, 217, 167, 45);
		add(JbuilderOrPlayer);
		
		JLabel label = new JLabel("L");
		label.setVerticalAlignment(SwingConstants.TOP);
		label.setForeground(new Color(255, 0, 0));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label.setBounds(202, 118, 208, 88);
		add(label);
		
		JLabel lblLettercraze = new JLabel("e");
		lblLettercraze.setVerticalAlignment(SwingConstants.TOP);
		lblLettercraze.setForeground(new Color(0, 0, 255));
		lblLettercraze.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblLettercraze.setHorizontalAlignment(SwingConstants.CENTER);
		lblLettercraze.setBounds(227, 118, 208, 88);
		add(lblLettercraze);
		
		JLabel lblT = new JLabel("t");
		lblT.setVerticalAlignment(SwingConstants.TOP);
		lblT.setForeground(new Color(255, 140, 0));
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblT.setBounds(247, 118, 208, 88);
		add(lblT);
		
		JLabel label_1 = new JLabel("t");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		label_1.setForeground(new Color(0, 255, 0));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label_1.setBounds(263, 118, 208, 88);
		add(label_1);
		
		JLabel label_2 = new JLabel("e");
		label_2.setVerticalAlignment(SwingConstants.TOP);
		label_2.setForeground(new Color(255, 0, 255));
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label_2.setBounds(285, 118, 208, 88);
		add(label_2);
		
		JLabel lblR = new JLabel("r");
		lblR.setVerticalAlignment(SwingConstants.TOP);
		lblR.setForeground(new Color(255, 255, 0));
		lblR.setHorizontalAlignment(SwingConstants.CENTER);
		lblR.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblR.setBounds(307, 118, 208, 88);
		add(lblR);
		
		JLabel lblC = new JLabel("C");
		lblC.setVerticalAlignment(SwingConstants.TOP);
		lblC.setForeground(new Color(0, 0, 255));
		lblC.setHorizontalAlignment(SwingConstants.CENTER);
		lblC.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblC.setBounds(342, 118, 208, 88);
		add(lblC);
		
		JLabel label_3 = new JLabel("r");
		label_3.setVerticalAlignment(SwingConstants.TOP);
		label_3.setForeground(new Color(138, 43, 226));
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label_3.setBounds(364, 118, 208, 88);
		add(label_3);
		
		JLabel lblA = new JLabel("a");
		lblA.setVerticalAlignment(SwingConstants.TOP);
		lblA.setForeground(new Color(255, 0, 0));
		lblA.setHorizontalAlignment(SwingConstants.CENTER);
		lblA.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblA.setBounds(386, 118, 208, 88);
		add(lblA);
		
		JLabel lblZ = new JLabel("z");
		lblZ.setVerticalAlignment(SwingConstants.TOP);
		lblZ.setForeground(new Color(0, 255, 0));
		lblZ.setHorizontalAlignment(SwingConstants.CENTER);
		lblZ.setFont(new Font("Tahoma", Font.ITALIC, 50));
		lblZ.setBounds(409, 118, 208, 88);
		add(lblZ);
		
		JLabel label_4 = new JLabel("e");
		label_4.setVerticalAlignment(SwingConstants.TOP);
		label_4.setForeground(new Color(255, 140, 0));
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.ITALIC, 50));
		label_4.setBounds(432, 118, 208, 88);
		add(label_4);
	}
	
	
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