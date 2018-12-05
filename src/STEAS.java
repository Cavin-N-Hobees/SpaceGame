import javafx.scene.image.Image;

public class STEAS extends SpaceShip{
	private SpaceShip player;
	public STEAS(Image shipSprite,float x, float y, PlayerSpaceship player) {
		super(shipSprite, x,y,3.1f);
		super.setMoveForward(true);
		this.player = player;
	}
	@Override
	public void move() {
		this.setRotate(((360 / (2 * Math.PI)) * Math.atan2(((player.getY() - this.getY())), (player.getX() - this.getX()))) + 180);
		double xMovement = Math.cos(((getRotate() - 90) * Math.PI) / 180); 
	    double yMovement = Math.sin(((getRotate() - 90) * Math.PI) / 180); 
		this.setXForce(xMovement);
		this.setYForce(yMovement);
		
	}
}
