import javafx.scene.image.Image;

public class Bullet extends MoveableObject{
	private int range = 100;
	private float originX;
	private float originY;
	
	public Bullet(Image sprite,float x, float y) {
		super(sprite, x,y);
		this.setMoveForward(true);
		this.originX = x;
		this.originY = y;
	}
	@Override
	public void move() {
		super.move();
	}
	
	private float getDistance() {
		float x1 = this.originX;
		float y1 = this.originY;
		float x2 = this.originX;
		float y2 = this.originY;
		
		float a = (float) Math.pow((x1 - x2),2);
		float b = (float) Math.pow((y1 - y2),2);
		float distance = (float) Math.sqrt(a + b);
		return distance;
	}
}
