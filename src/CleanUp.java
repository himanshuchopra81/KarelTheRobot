import stanford.karel.Karel;
import stanford.karel.KarelProgram;

public class CleanUp extends Karel {
	/*Declared variable is used as a flag for Climb and Drop methods 
	 *As the drop method is different for right turn at the top
	*/
	boolean flag;
	//run() method is the initial method that is invoked when the program is executed
	public void run() {
		//this method will initialize the number of beepers to zero in the beginning, so that we can have a count of picke beepers
		setBeepersInBag(0);
		climb();
	}
	//This method is used to make karel climb the column
	public void climb() {
		flag = true;
		turnLeft();
		while(frontIsClear()) {
			checkBeeper();
			move();
		}		
		if(facingNorth() && rightIsClear()) {
		
			turnRight();
			checkBeeper();
			move();
			if(leftIsClear()) {
				turnLeft();
			}
			while(frontIsClear()) {	
				checkBeeper();
				move();
			}
				drop();
			
			flag=true;
		}
		
		else if(facingNorth() && rightIsBlocked()){
			turnLeft();
			turnLeft();			
			while(rightIsBlocked()) {
				checkBeeper();
				move();
			}
			turnLeft();
			while(frontIsClear()) {
				checkBeeper();
				move();
			}
			flag = false;
				drop();			
		}			
	}	
	//This method is used to make karel come towards south from top or north
	public void drop() {
		if(flag) {
			turnLeft();
			turnLeft();
		}
		else {
			turnRight();
		}
		while(frontIsClear()) {
			checkBeeper();
			move();
		}
		if(facingSouth() && leftIsClear()) {
			turnLeft();
			checkBeeper();
			move();
			climb();
		}
		//to put beepers at the end which are present in the bag
		else {
			while(beepersInBag())
				putBeeper();
			turnRight();
			move();
			turnRight();
			turnRight();
		}

		
	}
	//to make a right turn 
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
		
	}
	//this method is invoked on every single move made by karel
	public void checkBeeper() {
		if(beepersPresent()) {
			pickBeeper();
		}
	
	}
	
}
