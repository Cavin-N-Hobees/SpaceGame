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

public class Test2 extends Application {
	private boolean playerShoot = false;
	private int timePassed = 0;
  @Override
  public void start(Stage primaryStage) {     
    Pane pane = new Pane();
    ArrayList<MoveableObject> moveableObjects = new ArrayList<>();
    PlayerSpaceship spaceship = new PlayerSpaceship(new Image("Spaceship.png"),(pane.widthProperty().floatValue() / 2),pane.heightProperty().floatValue() / 2);
    KamikazeShip enemyship = new KamikazeShip(new Image("Alien.png"),(pane.widthProperty().floatValue() / 2),pane.heightProperty().floatValue() / 2, spaceship);
    moveableObjects.add(spaceship);
    ArrayList<SpaceShip> enemyShips = new ArrayList<>();
    ArrayList<Bullet> bulletList = new ArrayList<>();
    
    enemyShips.add(enemyship);
    pane.getChildren().add(spaceship);
    spaceship.setScaleX(spaceship.getScaleX() * 2);
    spaceship.setScaleY(spaceship.getScaleY() * 2);
    moveableObjects.add(enemyship);
    pane.getChildren().add(enemyship);
    enemyship.setScaleX(enemyship.getScaleX() * 2);
    enemyship.setScaleY(enemyship.getScaleY() * 2);
    enemyShips.add(enemyship);
    
    STEAS bigShip = new STEAS(new Image("STEAS(1).png"),10,10,spaceship);
    enemyShips.add(bigShip);
    pane.getChildren().add(bigShip);
    moveableObjects.add(bigShip);
    
    Turrent turrent1 = bigShip.addTurrent();
    turrent1.setPlayer(spaceship);
    enemyShips.add(turrent1);
    pane.getChildren().add(turrent1);
    moveableObjects.add(turrent1);
    
    Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(50), (e -> {
        		Iterator<Bullet> bulletIterator = bulletList.iterator();
            	while( bulletIterator.hasNext()) {
            		Bullet bullet = bulletIterator.next();
	            	if(bullet.getDistance() > 1000) {
	        			pane.getChildren().remove(bullet);
	        			moveableObjects.remove(bullet);
	        			bulletIterator.remove();
	        		}
	            }
            	for(MoveableObject obj:moveableObjects) {
            		obj.move();
            	}
            	
            	checkCollisions(bulletList, enemyShips);
            	
            	if (playerShoot) {
            		Bullet bullet = spaceship.fireBullet();
            		bulletList.add(bullet);
            		moveableObjects.add(bullet);
            		pane.getChildren().add(bullet);
            		//timePassed = 0;
            	}
            	//timePassed++;
            })));
    
    spaceship.setOnKeyPressed(e -> {
        switch (e.getCode()) {
        case DOWN:
        	spaceship.setMoveBackward(true);
        	break;
        case UP:
        	spaceship.setMoveForward(true); break;
        case LEFT: 
        	spaceship.setMoveLeft(true);break;
        case RIGHT: 
        	spaceship.setMoveRight(true);break;
        case SPACE:
        	playerShoot = true;
        	/*
        	if(bulletList.size() < 100) {
        	Bullet bullet = spaceship.fireBullet();
        	pane.getChildren().add(bullet);
        	moveableObjects.add(bullet);
        	bulletList.add(bullet);
        	}*/
        	
        	break;
        default: 
        	System.out.println("Something else was pressed");
      }
    });

    spaceship.setOnKeyReleased((e -> {
        switch (e.getCode()) {
        case DOWN:
        	spaceship.setMoveBackward(false);
        	break;
        case UP:
        	spaceship.setMoveForward(false); break;
        case LEFT: 
        	spaceship.setMoveLeft(false);break;
        case RIGHT: 
        	spaceship.setMoveRight(false);break;
        case SPACE:
        	playerShoot = false; break;
        default: 
        	System.out.println("Something else was pressed");
      }
    }));
    
    spaceship.setFocusTraversable(true);
    
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setTitle("Test2"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play();  
  }
  
  
  protected void checkCollisions(ArrayList<Bullet> playerBullets, ArrayList<SpaceShip> enemyShips) {
      // check other sprite's collisions
      
	  //spriteManager.resetCollisionsToCheck();
      
	  // check each sprite against other sprite objects.
      for (Bullet bullet : playerBullets) {
          for (SpaceShip enemy : enemyShips) {
              if   (handleCollision(bullet, enemy)) {
                  // The break helps optimize the collisions
                  //  The break statement means one object only hits another
                  // object as opposed to one hitting many objects.
                  // To be more accurate comment out the break statement.
                  //break;
            	  System.out.println("Collision occured");
            	  bullet.setNeedsDestroyed(true);
            	  enemy.setNeedsDestroyed(true);
              }
          }
      }
      
     Iterator<Bullet> bulletIterator = playerBullets.iterator();
  	while(bulletIterator.hasNext()) {
  		if(bulletIterator.next().needsDestroyed()) {
  			
  		}
  	}
      
  }
  
  /**
   * How to handle the collision of two sprite objects.
   *
   * @param spriteA Sprite from the first list.
   * @param spriteB Sprite from the second list.
   * @return boolean returns a true if the two sprites have collided otherwise false.
   */

  protected boolean handleCollision(Bullet spriteA, SpaceShip spriteB) {
     // if (spriteA != spriteB) {
          if (spriteA.collide(spriteB)) {
        	  System.out.println("Collison Occured");
          }
      //}
      
      

      return false;
  }
  
 
  
  public static void main(String[] args) {
    launch(args);
  }}