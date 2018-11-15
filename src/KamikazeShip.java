import javafx.scene.image.Image;

public class KamikazeShip extends SpaceShip{
	private PlayerSpaceship player;
	public KamikazeShip(Image shipSprite,float x, float y, PlayerSpaceship player) {
		super(shipSprite, x,y,0.5f);
		this.player = player;
		super.setMoveForward(true);
	}
	@Override
	public void move() {
		//shark.rotation = ((360 / (2 * Math.PI)) * Math.atan2(((BoatY - shark.y)), (BoatX - shark.x))) + 90;
		this.setRotate(((360 / (2 * Math.PI)) * Math.atan2(((player.getY() - this.getY())), (player.getX() - this.getX()))) + 90);
		super.move();
	}
}
