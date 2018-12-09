import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public abstract class SpaceObject extends ImageView{
	private boolean needsDestroyed = false;
	private int hitPoints = 1;
	
	public SpaceObject(Image shipSprite,float x, float y) {
		super(shipSprite);
		setX(x);
		setY(y);
	}
	public void setHitPoints(int hitPoints) {
		this.hitPoints = hitPoints;
	}
	public int getHitPoints() {
		return hitPoints;
	}
	public boolean needsDestroyed() {
		return needsDestroyed;
	}
	
	public void setNeedsDestroyed(boolean needsDestroyed) {
		this.needsDestroyed = needsDestroyed;
	}
	public void getHit() {
		hitPoints--;
		if(this.hitPoints < 0)
			this.needsDestroyed = true;
	}
}
