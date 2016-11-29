// Need to isCompleted method

package lettercraze.model;


/**
 * Lightning specific level class 
 * 
 * Creation Date (11/25/16 4:04PM)
 * @author Hoodie
 *
 */
public class Lightning extends Level{
	
	/** Timer to keep track of time left (Using Swing Timer) */ 
	CountdownTimer roundTimer;
	
	/**
	 * Constructor for the Lightning Level 
	 * 
	 * @param levelNum is the level number 
	 * @param starThreshold starThreshold is a int[] of the threshold values to earn the 3 stars. Based on number of words
	 * @param seconds is the time limit for the level in seconds 
	 */
	public Lightning(int levelNum, int[] starThreshold, int seconds){
		super();
		this.levelNum = levelNum;
		this.levelType = "Lightning";
		this.starThreshold[0] = starThreshold[0];
		this.starThreshold[1] = starThreshold[1];
		this.starThreshold[2] = starThreshold[2];
		this.roundTimer = new CountdownTimer(seconds);
				
	}

	/**
	 * Start timer at the beginning of the round
	 */
	public void startTime(){
		this.roundTimer.startTimer();
	}
	
	@Override
	public boolean isCompleted(int score) {
		// TODO Auto-generated method stub
		return false;
	}

}
