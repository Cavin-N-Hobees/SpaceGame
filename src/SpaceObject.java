import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public abstract class SpaceObject extends ImageView{

	public SpaceObject(Image shipSprite,float x, float y) {
		super(shipSprite);
		setX(x);
		setY(y);
	}
	
}
