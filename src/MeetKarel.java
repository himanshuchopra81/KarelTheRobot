import stanford.karel.*;

public class MeetKarel extends Karel{
		public void run() {
			for(int i=0; i<2; i++) {
				move();
			}
			pickBeeper();
			turnLeft();
			move();
			turnRight();
			move();
			move();
			putBeeper();
			move();
			
		}
		public void turnRight() {
			turnLeft();
			turnLeft();
			turnLeft();
		}
}
