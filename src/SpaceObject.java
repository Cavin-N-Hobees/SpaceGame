import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Circle;

public abstract class SpaceObject extends ImageView{
	private boolean needsDestroyed = false;
	private int hitPoints = 0;
	
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
	
	public void adjustPosition(double xForce, double yForce) {
		this.setX(this.getX() - xForce);
		this.setY(this.getY() - yForce);
	}
	

}
