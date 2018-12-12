import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;


public class Bullet extends MoveableObject{
	private int range = 100;
	private float originX;
	private float originY;;
	
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
	

	
	public double getDistance() {
		
		double x1 = this.getX();
		double y1 = this.getY();
		
		float x2 = this.originX;
		float y2 = this.originY;
		
		float a = (float) Math.pow((x1 - x2),2);
		float b = (float) Math.pow((y1 - y2),2);
		double distance = (float) Math.sqrt(a + b);
		//double distance = Math.hypot(x1-x2, y1-y2);
		//System.out.println(distance);
		return distance;
	}
}
