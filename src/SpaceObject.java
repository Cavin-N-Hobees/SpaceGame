import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public abstract class SpaceObject extends ImageView{
	private boolean needsDestroyed = false;
	
	public SpaceObject(Image shipSprite,float x, float y) {
		super(shipSprite);
		setX(x);
		setY(y);
	}
	
	public boolean needsDestroyed() {
		return needsDestroyed;
	}
	
	public void setNeedsDestroyed(boolean needsDestroyed) {
		this.needsDestroyed = needsDestroyed;
	}
}
