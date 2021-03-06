import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
public class SpaceShip extends MoveableObject{
	private int timePassed = 0;
	public SpaceShip(Image shipSprite,float x, float y) {
		super(shipSprite, x,y);
	}
	
	public SpaceShip(Image shipSprite,float x, float y,float speed) {
		super(shipSprite, x,y,speed);
	}
	
	public Bullet fireBullet() {
		//System.out.println("Fire bullet called");
		Bullet bullet = new Bullet(new Image("PlayerBullet.png"), (float) this.getX(), (float) this.getY());
		bullet.setRotate(this.getRotate());
		return bullet;
	}
	
	
	public int getTimePassed() {
		return this.timePassed;
	}
	public void setTimePassed(int i) {
		timePassed = i;
	}
}
