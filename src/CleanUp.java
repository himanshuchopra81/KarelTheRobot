import stanford.karel.Karel;

public class CleanUp extends Karel {
	int i;
	public void run() {
		turnLeft();
		for(i=1; i<=20; i++) {
			runToEnd();
		}
	}
	public void runToEnd() {
		int count=0;
		while(!frontIsBlocked()) {
			move();
		}
		if(i!=20)
			takeATurn();
	}
	public void takeATurn() {
		if(facingNorth() && rightIsClear()) {
			turnRight();
			move();
			turnRight();
		}
		
		else if(facingSouth() && leftIsClear()) {
			turnLeft();
			move();
			turnLeft();
		}
		else if(facingNorth() && rightIsBlocked()){
			turnRight();
			turnRight();
		}
		
		
	}
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
}


