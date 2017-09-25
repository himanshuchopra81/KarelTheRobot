import stanford.karel.*;
public class Steeplechase extends Karel {
	public void run() {
		for(int i=0; i<8; i++) {
			if(frontIsClear()) {
				move();
			}
			else {
				jump();
			}
			
		}
	}
	public void jump() {
		if(leftIsClear())
			turnLeft();
		while(rightIsBlocked())
			move();
//		turnRight();
		//going down
//		if(frontIsClear())
//			move();
		//
		turnRight();
		while(frontIsClear())
			move();
		/* end of jump -- reached the ground
		//turnLeft();
			*/
	}
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
	}
}
