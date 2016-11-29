package lettercraze;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import lettercraze.view.MainMenu;
import lettercraze.view.SplashScreen;


/**
 * 
 * Creation Date: (11/24/16 11:20 AM) 
 * @author ddeisadze
 *
 */
public class LetterCrazePlayer extends JFrame {
	
	SplashScreen splashscreen = new SplashScreen();
	MainMenu mainMenu = new MainMenu();
	
	private static final long serialVersionUID = 3544957666427353398L;
	private java.awt.Panel ivjContentsPane = null;
	private java.awt.Panel ivjTopPane = null;
	
	/** Name of the current user. Needed to include this value within the Container. */
	protected String currentUser = "test";

	/** Initial width for the window. Must never shrink less than this. */
	protected int initialWidth = 769;

	/** Initial height for the window. Must never shrink less than this. */
	protected int initialHeight = 635;

	/** Last height for the window. Start with initial height. */
	protected int lastHeight = 635;

	/** Last width for the window. Start with initial width. */
	protected int lastWidth = 769;

	
	/** Enable tester to try out new games. */
	private Button newGameButton = null;
	
	private Button solveButton = null;

	boolean includeSolver = false;
	private JPanel panelMain;
	private CardLayout cardLayout = new CardLayout();



	/**
	 * Main method to launch our LetterCraze swing application
	 * @param args
	 */
	public static void main(String[] args){
		LetterCrazePlayer frame = new LetterCrazePlayer();
        frame.setVisible(true);
		
	}
	
	public LetterCrazePlayer(){
		initialize();
	}
	
	public void initialize(){
		setTitle("LetterCraze | Team Manganese");
		setLayout(null);
        setPreferredSize(new Dimension(initialWidth, initialHeight));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelMain = new JPanel(cardLayout);
        panelMain.setBackground(Color.GRAY);
        panelMain.setBounds(0, 0, initialWidth, initialHeight);
        panelMain.setPreferredSize(new Dimension(initialWidth, initialHeight));
        add(panelMain);
        
        initializeViews();
        
        pack();
        
        ActionListener taskPerformer = new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                //...Perform a task...

                System.out.println("Reading SMTP Info.");
            }
        };
        
        Timer timer = new Timer(100 ,taskPerformer);
        timer.setRepeats(false);
        timer.start();

        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void initializeViews(){
		panelMain.add(splashscreen, splashscreen.getName());
		panelMain.add(mainMenu, mainMenu.getName());
		
		
	}
}