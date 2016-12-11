// Done 
/*
 * Move timer to model.selectLevelController
 * Start it with lightning max seconds
 * Add two action listeners:
 * 	-onTick (updates gui)
 *  -finished (ends level, provides pop-up notification that level is over)
 */
package lettercraze.model;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
/**
 * Lightning specific level class
 * 
 * Creation Date
 * @author Hoodie
 *
 */
public class CountdownTimer extends JFrame{

	/** JLabel for Timer in GUI */ 
	private JLabel label;
	
	/** Create Timer Instance */
    private Timer timer;
   
	/** Counter to set the number of seconds for the Timer */
	protected int counter;
	
	/** Delay for the time between each tick, default to 1000 mS to represent a second tick period */
    protected int delay = 1000; 
    
    /** Some ID tag */
    protected static final long serialVersionUID = 1L;
    
    /** ActionListener event to initialize upon completion of the Timer */ 
    protected ActionListener action;
    
    /**
     * Constructor for ThemeTimer class
     * 
     * @param seconds is the number of seconds to start the count down timer at 
     */
    public CountdownTimer(int seconds){
    	super("Countdown Timer");
    	this.counter = seconds;
    	setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	this.action = new ActionListener(){   
            @Override
            public void actionPerformed(ActionEvent event)
            {
                if(counter == 0)
                {
                    timer.stop();
                    label.setText("The time is up!");
                }
                else
                {
                    label.setText("TimeLeft " + counter);
                    counter--;
                }
            }
        };
    }
    
    /**
     * Starts the Timer 
     */
    public void startTimer(){
    	
    	timer = new Timer(delay, action);
        timer.setInitialDelay(0);
        timer.start();

        setVisible(true);
    }
	

}
