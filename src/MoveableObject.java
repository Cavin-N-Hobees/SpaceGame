import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.scene.input.KeyEvent;

public class MoveableObject extends SpaceObject{
	float speed = 1;
	private boolean moveForward;
	private boolean moveRight;
	private boolean moveLeft;
	private boolean moveBackward;
	private double xForce;
	private double yForce;
	// Comment so I can commit again
	public MoveableObject(Image shipSprite,float x, float y) {
		super(shipSprite, x,y);
	}
	public MoveableObject(Image shipSprite,float x, float y,float speed) {
		super(shipSprite, x,y);
		this.speed = speed;
	}
	
	/*public void handleKeyUp(KeyEvent e) {
		System.out.println("handleKeyEvent was called");
        switch (e.getCode()) {
        case DOWN:
        	moveBackward = true;
        	break;
        case UP:     
        moveForward = true;
        break;
        case LEFT: moveLeft = true; break;
        case RIGHT: moveRight = true; break;
        default: break;
      }
    }
	
	public void handleKeyDown(KeyEvent e) {
		System.out.println("handleKeyEvent was called");
        switch (e.getCode()) {
        case DOWN:
        	moveBackward = false;
        	break;
        case UP:     
        moveForward = false;
        break;
        case LEFT: moveLeft = false; break;
        case RIGHT: moveRight = false; break;
        default: break;
      }
    }*/
	
	
	public boolean isMoveForward() {
		return moveForward;
	}
	public void setMoveForward(boolean moveForward) {
		this.moveForward = moveForward;
	}
	public boolean isMoveRight() {
		return moveRight;
	}
	public void setMoveRight(boolean moveRight) {
		this.moveRight = moveRight;
	}
	public boolean isMoveLeft() {
		return moveLeft;
	}
	public void setMoveLeft(boolean moveLeft) {
		this.moveLeft = moveLeft;
	}
	
	public void setMoveBackward(boolean moveBack) {
		this.moveBackward = moveBack;
	}
	public boolean isMoveBackward() {
		return moveBackward;
	}
	
	public void moveShip() {
		if (moveBackward) {
			xForce = Math.cos(((getRotate() - 90) * Math.PI) / 180) * 0.99; // changes disX to be used for the calculations on line 20
		    yForce = Math.sin(((getRotate() - 90) * Math.PI) / 180) * 0.99; // changes disY to be used for the calculations on line 21
		     //speed -= 0.1;
		}


	     setX(getX() + xForce); // calculates how far the boat should move on the x-axis
	     setY(getY() + yForce);

		if (moveForward) {
//			double disX;
//	    	double disY;
//			 disX = Math.cos(((getRotate() - 90) * Math.PI) / 180);
//		     disY = Math.sin(((getRotate() - 90) * Math.PI) / 180); 
			 xForce += Math.cos(((getRotate() - 90) * Math.PI) / 180); 
		     yForce += Math.sin(((getRotate() - 90) * Math.PI) / 180); 
		     

			//if(xForce < 40)
			//	xForce += disX;
		    //if(yForce < 40) 
		    //	yForce += disY;
		    
//		     setX(getX() + xForce); // calculates how far the boat should move on the x-axis
//		     setY(getY() + yForce);
		}
		if (moveRight) {
			setRotate(getRotate() + 3.5);
		}
		if (moveLeft) {
			setRotate(getRotate() - 3.5);
		}
		
	}
	}
