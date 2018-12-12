import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
public class MoveableObject extends SpaceObject{
	float speed = 1;
	private boolean moveForward;
	private boolean moveRight;
	private boolean moveLeft;
	private boolean moveBackward;
	private double xForce;
	private double yForce;
	private Circle collisionBounds;
	public MoveableObject(Image shipSprite,float x, float y) {
		this(shipSprite,x,y,1);
		//collisionBounds = new Rectangle(x, y, .1, 1);
		
	}
	public MoveableObject(Image shipSprite,float x, float y,float speed) {
		super(shipSprite, x,y);
		collisionBounds = new Circle(x, x, 10);
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
	public Circle getCollisionBounds() {
		return collisionBounds;
	}
	public void setCollisionBounds(float x,float y) {
		collisionBounds.setCenterX(x);
		collisionBounds.setCenterY(y);
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
		
		//collisionBounds.setX(this.getX());
		collisionBounds.setCenterX(this.getX());
		collisionBounds.setCenterY(this.getY());
		//collisionBounds.setY(this.getY());
		//collisionBounds.setRotate(this.getRotate());
	}
	
	public boolean collide(MoveableObject other) {

        /*if (collisionBounds == null || other.collisionBounds == null) {
            return false;
        }*/

        // determine it's size
        Circle otherSphere = other.getCollisionBounds();
        Circle thisSphere = this.getCollisionBounds();
        Point2D otherCenter = otherSphere.localToScene(otherSphere.getCenterX(), otherSphere.getCenterY());
        Point2D thisCenter = thisSphere.localToScene(thisSphere.getCenterX(), thisSphere.getCenterY());
        double dx = otherCenter.getX() - thisCenter.getX();
        double dy = otherCenter.getY() - thisCenter.getY();
        double distance = Math.sqrt(dx * dx + dy * dy);
        double minDist = otherSphere.getRadius() + thisSphere.getRadius();

        return (distance < minDist);
    }
	}
