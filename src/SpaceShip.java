import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class SpaceShip extends MoveableObject{
	public SpaceShip(Image shipSprite,float x, float y) {
		super(shipSprite, x,y);
	}
	
	public SpaceShip(Image shipSprite,float x, float y,float speed) {
		super(shipSprite, x,y,speed);
	}
	
	public void fireBullet(Pane pane) {
		System.out.println("Fire bullet called");
		pane.getChildren().add(new Bullet(new Image("PlayerBullet.png"), (float) this.getX(), (float) this.getY()));
	}
}
