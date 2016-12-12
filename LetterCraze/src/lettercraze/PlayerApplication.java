<<<<<<< HEAD
package lettercraze;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

import lettercraze.model.FileIO;
import lettercraze.model.Level;
import lettercraze.model.Model;
import lettercraze.view.GameView;
import lettercraze.view.LevelPreviewView;
import lettercraze.view.MenuView;
import lettercraze.view.SplashScreen;


/**
 * 
 * PlayerApplication class which will run the LetterCraze Player
 * 
 * Creation Date: (11/24/16 11:20 AM) 
 * @author ddeisadze
 *
 */
public class PlayerApplication extends JFrame {

	private static final long serialVersionUID = 3544957666427353398L;
	private java.awt.Panel ivjContentsPane = null;
	private java.awt.Panel ivjTopPane = null;

	/** Name of the current user. Needed to include this value within the Container. */
	protected String currentUser = "test";

	/** Initial width for the window. Must never shrink less than this. */
	protected static int initialWidth = 900;

	/** Initial height for the window. Must never shrink less than this. */
	protected static int initialHeight = 635;

	/** Last height for the window. Start with initial height. */
	protected int lastHeight = 635;

	/** Last width for the window. Start with initial width. */
	protected int lastWidth = 769;

	/**
	 * Application wide model for storing application data
	 */
	Model model = new Model();

	/**
	 * SplashScreen view class 
	 */
	SplashScreen splashView;

	/**
	 * Menu view class
	 */
	MenuView menuView;

	GameView gameView;

	/**
	 * 
	 * This is the main Panel which will hold all the other views inside of.
	 * 
	 * The Cardlayout will be hosted in this panel.
	 */
	private JPanel panelMain;

	public JPanel getCardLayoutParent() {
		return panelMain;
	}

	/**
	 * CardLayout will be used for switching views.
	 * 
	 * CardLayout works by storing different JPanels with names, as <Name, JPanel>
	 * 
	 * Whenever cardLayout.show(parent, name) is called, it will switch views and maintain
	 * 
	 * the last parent moved. 
	 * 
	 */
	private CardLayout cardLayout = new CardLayout();




	/**
	 * Will call initialize
	 */
	public PlayerApplication(){
		initialize();
	}

	/**
	 * Initializes all the components of the ApplicationPlayer
	 */
	private void initialize(){

		initializeViewClasses();

		setTitle("LetterCraze | Team Manganese");
		setLayout(null);
		setPreferredSize(new Dimension(initialWidth, initialHeight));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelMain = new JPanel(cardLayout);

		panelMain.setBackground(Color.GRAY);
		panelMain.setBounds(0, 0, initialWidth, initialHeight);
		panelMain.setPreferredSize(new Dimension(initialWidth, initialHeight));
		setContentPane(panelMain);

		initializeViewClasses();

		//		panelMain.add(splashView, splashView.getName());
		gameView = new GameView(model, panelMain, this);
		panelMain.add(menuView, menuView.getPanelName());
		panelMain.add(gameView, gameView.getPanelName());

		loadInLevels();

		pack();

	}

	public void initializeViewClasses(){
		menuView = new MenuView(panelMain, model);

	}

	/**
	 * Load in the levels to the menu object.
	 */
	public void loadInLevels(){
		//FileIO fileReader = new FileIO();
		ArrayList<Level> levels = FileIO.loadDefaultLevelsFromDisk();
		int col = 5;
		int row = 4;

		int totalCount = 0;

		LevelPreviewView level;
		for(Level toLoad: levels){
			totalCount ++;
			Color levelColor = Color.GRAY;
			switch(toLoad.getLevelType()){
			case "Puzzle": levelColor = Color.GREEN; break;
			case "Lightning": levelColor = Color.ORANGE; break;
			case "Theme": levelColor = Color.PINK; break;
			default : levelColor = Color.WHITE;
			}
			level = new LevelPreviewView(toLoad.getLevelType(), levelColor, totalCount, 0, panelMain, this);	
			menuView.addMenuItemToDefault(level);
		}
		panelMain.repaint();
	}

	/**
	 * Invoked whenever model is changed and the application needs to refresh
	 * 
	 * @return Model instance
	 */
	public Model modelChanged(){
		return model;
	}

	/**
	 * Main method to launch our LetterCraze swing application
	 * @param args
	 */
	public static void main(String[] args){
		Dimension size = new Dimension(initialWidth, initialHeight);

		JFrame splashFrame = SplashScreen.createAndShowGUI(size, "Player");
		try {
			// here is wher eit appes
			System.out.println("splash screeb");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		splashFrame.setVisible(false);
		PlayerApplication frame = new PlayerApplication();
		frame.setVisible(true);

	}
=======
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

import lettercraze.model.Model;
import lettercraze.view.GameView;
import lettercraze.view.LevelPreviewView;
import lettercraze.view.MenuView;
import lettercraze.view.SplashScreen;


/**
 * 
 * PlayerApplication class which will run the LetterCraze Player
 * 
 * Creation Date: (11/24/16 11:20 AM) 
 * @author ddeisadze
 *
 */
public class PlayerApplication extends JFrame {
	
	private static final long serialVersionUID = 3544957666427353398L;
	private java.awt.Panel ivjContentsPane = null;
	private java.awt.Panel ivjTopPane = null;
	
	/** Name of the current user. Needed to include this value within the Container. */
	protected String currentUser = "test";

	/** Initial width for the window. Must never shrink less than this. */
	protected static int initialWidth = 900;

	/** Initial height for the window. Must never shrink less than this. */
	protected static int initialHeight = 635;

	/** Last height for the window. Start with initial height. */
	protected int lastHeight = 635;

	/** Last width for the window. Start with initial width. */
	protected int lastWidth = 769;
	
	/**
	 * Application wide model for storing application data
	 */
	Model model = new Model();
	
	/**
	 * SplashScreen view class 
	 */
	SplashScreen splashView;
	
	/**
	 * Menu view class
	 */
	MenuView menuView;

	GameView gameView;
	
	/**
	 * 
	 * This is the main Panel which will hold all the other views inside of.
	 * 
	 * The Cardlayout will be hosted in this panel.
	 */
	private JPanel panelMain;
	
	public JPanel getCardLayoutParent() {
		return panelMain;
	}

	/**
	 * CardLayout will be used for switching views.
	 * 
	 * CardLayout works by storing different JPanels with names, as <Name, JPanel>
	 * 
	 * Whenever cardLayout.show(parent, name) is called, it will switch views and maintain
	 * 
	 * the last parent moved. 
	 * 
	 */
	private CardLayout cardLayout = new CardLayout();
	
	

	
	/**
	 * Will call initialize
	 */
	public PlayerApplication(){
		initialize();
	}
	
	/**
	 * Initializes all the components of the ApplicationPlayer
	 */
	private void initialize(){
	
		initializeViewClasses();
		
        setTitle("LetterCraze | Team Manganese");
		setLayout(null);
        setPreferredSize(new Dimension(initialWidth, initialHeight));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panelMain = new JPanel(cardLayout);
        
        panelMain.setBackground(Color.GRAY);
        panelMain.setBounds(0, 0, initialWidth, initialHeight);
        panelMain.setPreferredSize(new Dimension(initialWidth, initialHeight));
        setContentPane(panelMain);
        
        initializeViewClasses();
		
//		panelMain.add(splashView, splashView.getName());
		gameView = new GameView(model, panelMain, this);
		//panelMain.add(gameView, gameView.getPanelName());
		panelMain.add(menuView, menuView.getPanelName());
		panelMain.add(gameView, gameView.getPanelName());
		
		loadInLevels();
        
        pack();

	}
	
	public void initializeViewClasses(){
		menuView = new MenuView(panelMain, model, this);
		
	}
	
	/**
	 * Load in the levels to the menu object.
	 */
	public void loadInLevels(){
		int col =5;
		int row = 4;

		int total_count = 0;

		String[] levelTypes = {"Puzzle", "Lightning", "Theme"};
		Color[] levelColors = {Color.GREEN, Color.ORANGE, Color.PINK};

		String levelType;
		int levelI;
		for( int rowi = 1; rowi < row; rowi++ ){

			for( int coli=0; coli < col; coli++){
				levelI = total_count % 3;
				levelType = levelTypes[levelI];
				total_count += 1;
				
				LevelPreviewView level = new LevelPreviewView(levelType, levelColors[levelI], total_count, 0, panelMain, this);
				
				if( total_count != 1 && total_count != 2){
					level.setEnabled(false);

				}
				
				menuView.addMenuItemToDefault(level);
				
			}

		}
		
		panelMain.repaint();
	}
	
	/**
	 * Invoked whenever model is changed and the application needs to refresh
	 * 
	 * @return Model instance
	 */
	public Model modelChanged(){
		return model;
	}
	
	/**
	 * Main method to launch our LetterCraze swing application
	 * @param args
	 */
	public static void main(String[] args){
        Dimension size = new Dimension(initialWidth, initialHeight);

		JFrame splashFrame = SplashScreen.createAndShowGUI(size, "Player");
		try {
			// here is wher eit appes
			System.out.println("splash screeb");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		splashFrame.setVisible(false);
		PlayerApplication frame = new PlayerApplication();
        frame.setVisible(true);
		
	}

	public GameView getGameView() {
		// TODO Auto-generated method stub
		return this.gameView;
	}
	
	public Model getModel() {
		return model;
	}

>>>>>>> refs/heads/development
}