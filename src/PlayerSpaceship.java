import javafx.scene.image.Image;

public class PlayerSpaceship extends SpaceShip {
	public PlayerSpaceship(Image shipSprite, float x, float y) {
		super(shipSprite, x, y);
		this.setHitPoints(20);
	}

	@Override
	public void move() {
		super.move();
	}
}
