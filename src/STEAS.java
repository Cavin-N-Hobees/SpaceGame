import java.util.ArrayList;
import java.util.Random;

import javafx.scene.image.Image;

public class STEAS extends SpaceShip {
	private SpaceShip player;
	private ArrayList<Turrent> turrentList = new ArrayList();
	private float speed;

	public STEAS(Image shipSprite, float x, float y, PlayerSpaceship player) {
		super(shipSprite, x, y, 3.1f);
		super.setMoveForward(true);
		this.player = player;
		this.setHitPoints(100);
		Random random = new Random();
		speed = random.nextInt(10);
	}

	@Override
	public void move() {
		if (getDist() > 400) {
			this.setRotate(
					((360 / (2 * Math.PI)) * Math.atan2(((player.getY() - this.getY())), (player.getX() - this.getX())))
							+ 90);
			this.setXForce(this.getXForce() * 0.99f);
			this.setYForce(this.getXForce() * 0.99f);
		} else {
			this.setRotate(
					((360 / (2 * Math.PI)) * Math.atan2(((player.getY() - this.getY())), (player.getX() - this.getX())))
							+ 180);
			double xMovement = Math.cos(((getRotate() - 90) * Math.PI) / 180) * speed;
			double yMovement = Math.sin(((getRotate() - 90) * Math.PI) / 180) * speed;
			this.setXForce(xMovement);
			this.setYForce(yMovement);
		}
		super.move();
	}
	
	@Override
	public void getHit() {
		this.setHitPoints(this.getHitPoints() - 1);
		if (this.getHitPoints() < 0)
			this.setNeedsDestroyed(true);
		if(this.needsDestroyed()) {
		for (Turrent t : turrentList) {
			t.setNeedsDestroyed(true);
		}
		}
		
	}
	public Turrent getTurrent() {
		return new Turrent(new Image("Turrent.png"), (float) this.getRotationAxis().getX(),
				(float) this.getRotationAxis().getY(), this);
	}

	public void addTurrent(Turrent t) {
		turrentList.add(t);
	}

	public ArrayList<Turrent> getTurrents() {
		return this.turrentList;
	}

	private double getDist() {
		double x1 = this.getX();
		double y1 = this.getY();

		double x2 = player.getX();
		double y2 = player.getY();

		float a = (float) Math.pow((x1 - x2), 2);
		float b = (float) Math.pow((y1 - y2), 2);
		double distance = (float) Math.sqrt(a + b);
		return distance;

	}
}
