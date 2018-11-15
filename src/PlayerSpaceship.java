import javafx.scene.image.Image;

public class PlayerSpaceship extends SpaceShip{
	public PlayerSpaceship(Image shipSprite,float x, float y) {
		super(shipSprite,x, y);
	}
	/*@Override
	public void move() {
		if (this.isMoveBackward()) {
			this.setXForce(Math.cos(((getRotate() - 90) * Math.PI) / 180) * 0.99);
		    this.setYForce(Math.sin(((getRotate() - 90) * Math.PI) / 180) * 0.99);
		     //speed -= 0.1;
		}


	     setX(getX() + this.getXForce()); // calculates how far the boat should move on the x-axis
	     setY(getY() + this.getYForce());

		if (this.isMoveForward()) {
			this.setXForce(this.getXForce() + Math.cos(((getRotate() - 90) * Math.PI) / 180)); 
			this.setYForce(this.getYForce() + Math.cos(((getRotate() - 90) * Math.PI) / 180)); 
		}
		
		
	}*/
}
