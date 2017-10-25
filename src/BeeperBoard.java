import stanford.karel.Karel;

public class BeeperBoard extends Karel {
	int i;
	//run() method is the initial method that is invoked when the program is executed
	public void run(){
		//this for loop indicates the number of moves per number of rows- as we have 8 rows
		for(i = 1; i<=8; i++) {
			runToEnd();
		}
	}
	//this method will make Karel move till the end of the map or world 
	public void runToEnd() {
		int count=0;
		while(!frontIsBlocked()) {
			count++;
			// this condition will check if the value of count is odd, if yes then it will place a beeper 
			if(count%2!=0) {
				putBeeper();
			}
			move();
		}
		//this condition will not let karel take a U turn when it is on the last row
		if(i!=8) {
			takeATurn();
		}
	}
	// will make karel take a U turn after moving to the end of one row
	public void takeATurn() {
		if(facingEast()) {
			turnLeft();
			move();
			turnLeft();
		}
		else if(facingWest()) {
			turnRight();
			move();
			turnRight();
		}
	}
	//a method to make Karel turn right
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
}
