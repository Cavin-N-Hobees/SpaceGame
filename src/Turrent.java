import javafx.scene.image.Image;

public class Turrent extends SpaceShip {//implements Shooter{
	private PlayerSpaceship player;
	private STEAS parentShip;
	public Turrent(Image shipSprite,float x, float y, STEAS parentShip) {
		super(shipSprite, x,y);
		this.setX(x);
		this.setY(y);
		this.parentShip = parentShip;
	}
	@Override
	public void move() {
		this.setRotate(((360 / (2 * Math.PI)) * Math.atan2(((player.getY() - this.getY())), (player.getX() - this.getX()))) + 90);
		this.setX(parentShip.getX());
		this.setY(parentShip.getY());
	}
	public void setPlayer(PlayerSpaceship player) {
		this.player = player;
	}
	
	public void checkForShoot() {
		
	}
}
