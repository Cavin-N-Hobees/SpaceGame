import java.util.Random;

import javafx.scene.image.Image;

public class Turrent extends SpaceShip implements Shooter{
	private PlayerSpaceship player;
	private STEAS parentShip;
	private int framesPassed = 0;
	private int cooldown = 100;
	private Random random;
	public Turrent(Image shipSprite,float x, float y, STEAS parentShip) {
		super(shipSprite, x,y);
		this.setX(x + 5);
		this.setY(y + 10);
		this.setCollisionBoundSize(10);
		this.parentShip = parentShip;
		random = new Random();
	}
	
	@Override
	public void move() {
		this.setRotate(((360 / (2 * Math.PI)) * Math.atan2(((player.getY() - this.getY())), (player.getX() - this.getX()))) + 90);
		this.setX(parentShip.getX() + (20 * Math.cos(((parentShip.getRotate() - 90) * Math.PI) / 180) * 0.99));
		this.setY(parentShip.getY() + (60 * Math.sin(((getRotate() - 90) * Math.PI) / 180) * 0.99));
		this.setCollisionBounds((float) this.getX(), (float) this.getY());
	}
	public void setPlayer(PlayerSpaceship player) {
		this.player = player;
	}
	@Override
	public void getHit() {
		parentShip.getHit();
	}
	
	public boolean checkForShoot() {
		framesPassed++;
		if (framesPassed > cooldown) {
			framesPassed = 0;
			cooldown = random.nextInt(150);
			return true;
		}
		else {
			return false;
		}
	}
	
	
}
