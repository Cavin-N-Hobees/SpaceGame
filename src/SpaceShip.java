import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;

public class SpaceShip extends ImageView{
	float speed = 1;
	private boolean moveForward;
	private boolean moveRight;
	private boolean moveLeft;
	public SpaceShip(Image shipSprite,float x, float y) {
		super(shipSprite);
		setX(x);
		setY(y);
	}
	public SpaceShip(Image shipSprite,float x, float y,float speed) {
		super(shipSprite);
		setX(x);
		setY(y);
		this.speed = speed;
	}
	
	public void handleKeyUp(KeyEvent e) {
		System.out.println("handleKeyEvent was called");
        switch (e.getCode()) {
        case UP:     
        moveForward = true;
        break;
        case LEFT: moveLeft = true; break;
        case RIGHT: moveRight = true; break;
        default: break;
      }
    }
	
	
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
	public void moveShip() {
//		System.out.println("Move ship was called");
		if (moveForward) {
			double disX;
	    	double disY;
			 disX = Math.cos(((getRotate() - 90) * Math.PI) / 180); // changes disX to be used for the calculations on line 20
		        disY = Math.sin(((getRotate() - 90) * Math.PI) / 180); // changes disY to be used for the calculations on line 21
		        setX(getX() + disX); // calculates how far the boat should move on the x-axis
		        setY(getY() + disY);
		}
		if (moveRight) {
			setRotate(getRotate() + 1.5);
		}
		if (moveLeft) {
			setRotate(getRotate() - 1.5);
		}
	}
	}
