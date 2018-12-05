import javafx.scene.image.Image;
public class MoveableObject extends SpaceObject{
	float speed = 1;
	private boolean moveForward;
	private boolean moveRight;
	private boolean moveLeft;
	private boolean moveBackward;
	private double xForce;
	private double yForce;
	public MoveableObject(Image shipSprite,float x, float y) {
		super(shipSprite, x,y);
	}
	public MoveableObject(Image shipSprite,float x, float y,float speed) {
		super(shipSprite, x,y);
		this.speed = speed;
	}
	public boolean isMoveForward() {
		return moveForward;
	}
	
	public void setSpeed(float speed) {
		this.speed = speed;
	}
	
	public float getSpeed() {
		return speed;
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
	
	public void setXForce(double xforce) {
		this.xForce = xforce;
	}
	
	public double getXForce() {
		return xForce;
	}
	
	public void setYForce(double yforce) {
		this.yForce = yforce;
	}
	
	public double getYForce() {
		return yForce;
	}
	
	public void move() {
		if (moveBackward) {
			xForce = Math.cos(((getRotate() - 90) * Math.PI) / 180) * 0.99;
		    yForce = Math.sin(((getRotate() - 90) * Math.PI) / 180) * 0.99;
		     //speed -= 0.1;
		}


	     setX(getX() + xForce); // calculates how far the boat should move on the x-axis
	     setY(getY() + yForce);

		if (moveForward) {
			xForce += Math.cos(((getRotate() - 90) * Math.PI) / 180); 
		    yForce += Math.sin(((getRotate() - 90) * Math.PI) / 180); 

		}
		if (moveRight) {
			setRotate(getRotate() + 3.5);
		}
		if (moveLeft) {
			setRotate(getRotate() - 3.5);
		}
		
	}
	}
