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
import lettercraze.view.BuilderLevelSelecterView;
import lettercraze.view.BuilderMenuView;
import lettercraze.view.BuilderView;
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
public class BuilderApplication extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6930841076581584591L;
	private java.awt.Panel ivjContentsPane = null;
	private java.awt.Panel ivjTopPane = null;
	
	/** Name of the current user. Needed to include this value within the Container. */
	protected String currentUser = "test";

	/** Initial width for the window. Must never shrink less than this. */
	protected static int initialWidth = 1088;

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
	BuilderMenuView menuView;

	BuilderView builderView;
	
	BuilderLevelSelecterView loadLevelMenuView;
	
	public BuilderView getBuilderView() {
		return builderView;
	}

	/**
	 * 
	 * This is the main Panel which will hold all the other views inside of.
	 * 
	 * The Cardlayout will be hosted in this panel.
	 */
	private JPanel panelMain;
	
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
	public BuilderApplication(){
		initialize();
	}
	
	/**
	 * Initializes all the components of the ApplicationPlayer
	 */
	private void initialize(){
		
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
                
		
//		panelMain.add(splashView, splashView.getName());
        initializeViewClasses();
        
        pack();

	}
	
	public void initializeViewClasses(){
		menuView = new BuilderMenuView(panelMain, model, this );
		builderView = new BuilderView(model, panelMain, this);
		//loadLevelMenuView = new BuilderLevelSelecterView(panelMain);
		panelMain.add(menuView, menuView.getPanelName());
		panelMain.add(builderView, builderView.getPanelName()); 
		//panelMain.add(loadLevelMenuView, loadLevelMenuView.getPanelName());
		
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

		JFrame splashFrame = SplashScreen.createAndShowGUI(size, "Builder");
		try {
			// here is where it appears
			System.out.println("splash screen");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		splashFrame.setVisible(false);
		BuilderApplication frame = new BuilderApplication();
        frame.setVisible(true);
		
	}

}