import stanford.karel.*;
public class Steeplechase extends Karel {
	public void run() {
		for(int i=0; i<8; i++) {
			moveForward();
			
		}
	
		
	}
	public void moveForward() {
		//&& rightIsBlocked()
		if(frontIsClear() ) {
			move();
			
		}
		else
		jump();
		
	}
	public void moveDown() {
		if(rightIsClear()) {
			turnRight();
			
		}
		
	}
	public void jump() {
		turnLeft();
		while(rightIsBlocked()) {
		move();}
		turnRight();
		while(rightIsClear())
		move();
		//down
		turnRight();
		
	}
	
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
		
	}
	/*
	 
	  
	  
	  
	  
	  
	 * */
}
