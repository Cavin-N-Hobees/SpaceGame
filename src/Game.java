import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Iterator;

public class Game extends Application {
	private boolean playerShoot = false;
	private int timePassed = 0;
	private Pane pane = new Pane();
	private ArrayList<MoveableObject> moveableObjects = new ArrayList<>();
	private PlayerSpaceship spaceship = new PlayerSpaceship(new Image("Spaceship.png"), 1000, 700);
	private ArrayList<MoveableObject> enemyShips = new ArrayList<>();
	private ArrayList<MoveableObject> bulletList = new ArrayList<>(); 

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setFullScreen(true);
		// adds in the players spaceship and doubles its scale.
		pane.getChildren().add(spaceship);
		spaceship.setScaleX(spaceship.getScaleX() * 2);
		spaceship.setScaleY(spaceship.getScaleY() * 2);
		moveableObjects.add(spaceship);

		// loop that creates the enemy ships
		for (int i = 0; i < 10; i++) {
			KamikazeShip enemyship = new KamikazeShip(new Image("Alien.png"), 100 * (i + 1),
					pane.heightProperty().floatValue() / 2, spaceship);
			enemyShips.add(enemyship);
			moveableObjects.add(enemyship);
			pane.getChildren().add(enemyship);
			enemyship.setScaleX(enemyship.getScaleX() * 2);
			enemyship.setScaleY(enemyship.getScaleY() * 2);
			enemyShips.add(enemyship);

			STEAS bigShip = new STEAS(new Image("STEAS(1).png"), 100 * (i + 1), 10, spaceship);
			enemyShips.add(bigShip);
			pane.getChildren().add(bigShip);
			moveableObjects.add(bigShip);

			Turrent turrent1 = bigShip.getTurrent();
			turrent1.setPlayer(spaceship);
			enemyShips.add(turrent1);
			pane.getChildren().add(turrent1);
			moveableObjects.add(turrent1);
			bigShip.addTurrent(turrent1);
		}

		Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), (e -> {
			// the loop that calls adjust position, adjust position is a method in space object
			// that moves the all the object relative to the spaceship so that it seems like the
			// camera is following the player
			for (SpaceObject spaceObject : moveableObjects) {
				spaceObject.adjustPosition(spaceship.getXForce(), spaceship.getYForce());
			}
			
			// sets the players x and y coordinates to the middle of the screen, I had
			// problems with the player going offscreen before I added this.
			spaceship.setX(pane.getWidth() / 2);
			spaceship.setY(pane.getHeight() / 2);

			
			Iterator<MoveableObject> bulletIterator = bulletList.iterator();
			// loops through and removes any bullets that have exceeded their range
			while (bulletIterator.hasNext()) {
				Bullet bullet = (Bullet) bulletIterator.next();
				if (bullet.getDistance() > 1000) {
					pane.getChildren().remove(bullet);
					moveableObjects.remove(bullet);
					bulletIterator.remove();
				}
			}
			
			ArrayList<Bullet> bulletsToAdd = new ArrayList();
			// Loops through and fires any turrents that are ready to fire
			for (MoveableObject obj : moveableObjects) {
				obj.move();
				if (obj instanceof Shooter) {
					if (((Shooter) obj).checkForShoot()) {
						Bullet b = new Bullet(new Image("EnemyBullet.png"), (float) obj.getX(), (float) obj.getY());
						b.setRotate(obj.getRotate());
						pane.getChildren().add(b);
						// moveableObjects.add(b);
						bulletsToAdd.add(b);
						enemyShips.add(b);
					}
				}
			}
			// Adds any bullets that were added in the last loop into movable objects
			// adding the bullet while still looping through the list give an error
			for (Bullet b : bulletsToAdd) {
				moveableObjects.add(b);
			}

			// checks for and handles collisions between the players bullets
			// and the enemy ships.
			checkCollisions(bulletList, enemyShips);
			
			ArrayList<MoveableObject> playersList = new ArrayList();
			playersList.add(spaceship);
			// Handles collisions between the player and enemy ships, note that enemy
			// bullets are also in the enemy ships list because we want to damage the
			// player whether he gets hit by an enemy ship or an enemy bullet
			checkCollisions(playersList, enemyShips);

			// if the player is holding spacebar, fire a friendly bullet from the players
			// spaceship
			if (playerShoot) {
				Bullet bullet = spaceship.fireBullet();
				bulletList.add(bullet);
				moveableObjects.add(bullet);
				pane.getChildren().add(bullet);
			}

			Iterator<MoveableObject> objectIterator = moveableObjects.iterator();
			// Loops through and removes any objects that need to be destroyed
			while (objectIterator.hasNext()) {
				MoveableObject temp = objectIterator.next();
				if (temp.needsDestroyed()) {
					pane.getChildren().remove(temp);
					objectIterator.remove();
					if (bulletList.contains(temp))
						bulletList.remove(temp);
					if (enemyShips.contains(temp))
						enemyShips.remove(temp);
				}
			}

		})));

		// Handles keys being pressed
		spaceship.setOnKeyPressed(e -> {
			switch (e.getCode()) {
			case DOWN:
				spaceship.setMoveBackward(true);
				break;
			case UP:
				spaceship.setMoveForward(true);
				break;
			case LEFT:
				spaceship.setMoveLeft(true);
				break;
			case RIGHT:
				spaceship.setMoveRight(true);
				break;
			case SPACE:
				playerShoot = true;
				break;
			default:
				System.out.println("Something else was pressed");
			}
		});

		// Handles keys being released
		spaceship.setOnKeyReleased((e -> {
			switch (e.getCode()) {
			case DOWN:
				spaceship.setMoveBackward(false);
				break;
			case UP:
				spaceship.setMoveForward(false);
				break;
			case LEFT:
				spaceship.setMoveLeft(false);
				break;
			case RIGHT:
				spaceship.setMoveRight(false);
				break;
			case SPACE:
				playerShoot = false;
				break;
			default:
				System.out.println("Something else was pressed");
			}
		}));
		
		spaceship.setFocusTraversable(true);

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane, 5000, 5000);
		primaryStage.setTitle("Test2"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

		animation.setCycleCount(Timeline.INDEFINITE);
		animation.play();
	}
	
	protected void checkCollisions(ArrayList<MoveableObject> playerBullets, ArrayList<MoveableObject> enemyShips) {
		for (MoveableObject bullet : playerBullets) {
			for (MoveableObject enemy : enemyShips) {
				if (handleCollision(bullet, enemy)) {
					break;
				}
			}
		}

	}


	protected boolean handleCollision(MoveableObject bullet, MoveableObject enemy) {
		if (bullet.collide(enemy)) {
			bullet.getHit();
			enemy.getHit();
		}

		return false;
	}

	public static void main(String[] args) {
		launch(args);
	}
}