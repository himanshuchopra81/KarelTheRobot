import stanford.karel.Karel;
import stanford.karel.KarelProgram;

public class CleanUp extends Karel {
	int i;
	
	boolean flag;
	public void run() {
		B b = new B();
	    Thread t = new Thread(b);
	    t.start();
		climb();
	}
	public void climb() {
		flag = true;
		turnLeft();
		while(frontIsClear()) {
			
			move();
		}
		if(facingNorth() && rightIsClear()) {
			
			turnRight();
			move();
			if(leftIsClear()) {
				turnLeft();
			}
			while(frontIsClear())	move();
			drop();
			flag=true;
		}
		//1
		else if(facingNorth() && rightIsBlocked()){
			turnLeft();
			turnLeft();
			
			while(rightIsBlocked()	)move();
			System.out.println("after while 1");
			turnLeft();
			while(frontIsClear())	move();
			flag = false;
			drop();
			
			
		}
		
	}
	
	public void drop() {
		if(flag) {
			turnLeft();
			turnLeft();
		}
		else {
			turnRight();
		}
		while(frontIsClear()) {
			move();
		}
		if(facingSouth() && leftIsClear()) {
			turnLeft();
			move();
		}
		climb();
	}
	
	
	public void turnRight() {
		turnLeft();
		turnLeft();
		turnLeft();
		
	}
	public void checkBeeper() {
		if(beepersPresent())
			Info.count++;
	}
}
 class B extends Karel implements Runnable{
    public void run()
    {
    	if(beepersPresent())
			Info.count++;
    	System.out.println(Info.count);
    }
}
 class Info{
	 public static int count=0;
	 
 }

