import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public abstract class SpaceObject extends SpaceShip{
	
	public SpaceObject(Image shipSprite,float x, float y) {
		super(shipSprite);
		setX(x);
		setY(y);
		super.setMoveForward(true);
	}
	
}
