// Need to isCompleted method

package lettercraze.model;

import com.fasterxml.jackson.annotation.JsonTypeName;

/**
 * Lightning specific level class 
 * 
 * Creation Date (11/25/16 4:04PM)
 * @author Hoodie
 *
 */
@JsonTypeName("Lightning")
public class Lightning extends Level{
	

	
	
	/*Default constructor necessary for Jackson deserialization*/
	public Lightning(){};
	
	/** seconds at which the timer is initialized **/
	int seconds;
	
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
		this.seconds = seconds;
		this.starThreshold[0] = starThreshold[0];
		this.starThreshold[1] = starThreshold[1];
		this.starThreshold[2] = starThreshold[2];
		
//		this.roundTimer = new CountdownTimer(seconds);
				
	}

	/**
	 * Start timer at the beginning of the round
	 */
	public void startTime(){
//		this.roundTimer.startTimer();
	}
	
	@Override
	public String debugString(){
		String s = levelType + ", ";
		s = s + "Level Number: " + Integer.toString(levelNum) +",\n";
		s = s + "First Threshold: " + Integer.toString(starThreshold[0]) + ",";
		s = s + "Second Threshold: " + Integer.toString(starThreshold[1]) + ", ";
		s = s + "Third Threshold: " + Integer.toString(starThreshold[2]) + ", \n";
//		s = s + "TimerStart: " + Integer.toString(roundTimer.counter) + ", \n";
		s = s + "Board Shape: \n";
		for(int row = 0; row < 6; row++){
			for(int col = 0; col < 6; col ++){
				if(boardShape[row][col]){
					s = s + "[X]";
				} else {
					s = s + "[ ]";
				}
			}
			s = s + "\n";
		}
		return s;
	}

//	public CountdownTimer getRoundTimer() {
//		return roundTimer;
//	}

	public int getSeconds() {
		return seconds;
	}
	
//	@Override
//	public boolean isCompleted(int score) {
//		// TODO Auto-generated method stub
//		return false;
//	}

}
