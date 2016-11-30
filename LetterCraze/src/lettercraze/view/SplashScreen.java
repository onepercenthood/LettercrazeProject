
package lettercraze.view;
import java.awt.BorderLayout;
import java.awt.Dimension;
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

public class SplashScreen extends DefaultViewPanel{


	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		super();
		setBounds(100, 100, 450, 300);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		JLabel lblLettercraze = new JLabel("LetterCraze");
		lblLettercraze.setBounds(182, 65, 105, 16);
		add(lblLettercraze);
		
		JLabel lblGroupManganese = new JLabel("Group Manganese");
		lblGroupManganese.setBounds(163, 90, 144, 16);
		add(lblGroupManganese);
		
		JLabel lblDavidDeisadze = new JLabel("David Deisadze");
		lblDavidDeisadze.setBounds(163, 113, 144, 16);
		add(lblDavidDeisadze);
		
		JLabel lblDerekFeehrer = new JLabel("Derek Feehrer");
		lblDerekFeehrer.setBounds(163, 136, 144, 16);
		add(lblDerekFeehrer);
		
		JLabel lblJackHarding = new JLabel("Jack Harding");
		lblJackHarding.setBounds(163, 155, 144, 16);
		add(lblJackHarding);
		
		JLabel lblZackHood = new JLabel("Zack Hood");
		lblZackHood.setBounds(163, 176, 144, 16);
		add(lblZackHood);
		
		JLabel lblDeanSchifilliti = new JLabel("Dean Schifilliti");
		lblDeanSchifilliti.setBounds(163, 197, 144, 16);
		add(lblDeanSchifilliti);
	}
	
	
	public static JFrame createAndShowGUI(Dimension size) {
        //Create and set up the window.
        JFrame frame = new JFrame("SplashScreen");
        frame.setPreferredSize(size);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        SplashScreen splashScreen = new SplashScreen();

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
