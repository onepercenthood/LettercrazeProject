package lettercraze.controller.player;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.Timer;

import lettercraze.PlayerApplication;
import lettercraze.model.Model;
import lettercraze.view.GameView;

/**
 * TimeController to handle the lightning type level in our player application.
 * 
 * @author ddeisadze
 *
 */
public class TimeController implements ActionListener {
	

	/** the main player application **/
	private PlayerApplication application;
	
	/** the main model from the application **/
	private Model model;
	
	/** the main gameView panel**/
	private GameView gameView;
	
	/** the number of seconds to countdown **/
	private int seconds;
	
	/** Counter to set the number of seconds for the Timer */
	private int counter;
	
	/** Create Timer Instance */
    private static Timer timer;
   	
	/** Delay for the time between each tick, default to 1000 mS to represent a second tick period */
    protected int delay = 1000; 	
    
	/**
	 * 
	 * Controls the timer functionality in the lighting type level.
	 * 
	 * @param application Main application level
	 * @param model Model that stores application wide data
	 * @param gameView GameView Boundary class access to views
	 * @param seconds seconds is the number of seconds to start the count down timer at 
	 */
	public TimeController(PlayerApplication application, Model model, GameView gameView, int seconds) {
		
		this.application = application;
		this.model = model;
		this.gameView = gameView;
		this.seconds = seconds;
		
		this.delay = seconds * 1000;
		this.counter = seconds;
		
	}

	/**
	 * ActionPerformed as the main actionable method.
	 */
	public void actionPerformed(ActionEvent event)
    {
		
		System.out.println("counter" + counter);
		counter -= 1;

		
        if(counter == 0){
        	
        	System.out.println("Time is up");
            gameView.getTypeSpecific().setText("The time is up!");
            
            JOptionPane.showMessageDialog(null, "Time is up!");
            
            gameView.remove(gameView.getAddWordBtn());
            gameView.remove(gameView.getBtnUndoMove());


            
            timer.stop();

            // save the data
        	
        }else{
        	gameView.getTypeSpecific().setText("TimeLeft " + counter);
        }
        
        gameView.getTypeSpecific().repaint();

        gameView.repaint();
        
    }
	
	/**
	 * Starts the timer with the given delay between ticks
	 * @param delay1 as int
	 * @param action as ActionListener
	 */
    public static void startTimer(int delay1, ActionListener action ){
    	
    	System.out.println("Timeer initilalized");
    	System.out.println("Timer delay:" + delay1);

    	
    	timer = new Timer(1000, action);
        timer.start();
    }
	
    /**
     * Stops the timer thread.
     */
    public static void stopTimer(){
    	timer.stop();
    }

}
