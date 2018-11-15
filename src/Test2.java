import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;

public class Test2 extends Application {
  @Override
  public void start(Stage primaryStage) {     
    Pane pane = new Pane();
    ArrayList<MoveableObject> moveableObjects = new ArrayList<>();
    SpaceShip spaceship = new SpaceShip(new Image("Spaceship.png"),(pane.widthProperty().floatValue() / 2),pane.heightProperty().floatValue() / 2);
    //circle.xProperty().bind(pane.widthProperty().divide(2));
    moveableObjects.add(spaceship);
    //circle.yProperty().bind(pane.heightProperty().divide(2));
    pane.getChildren().add(spaceship);
    spaceship.setScaleX(spaceship.getScaleX() * 2);
    spaceship.setScaleY(spaceship.getScaleY() * 2);
    
    Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(50), (e -> {
            	for(MoveableObject obj:moveableObjects) {
            		obj.move();
            	}
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
        	Bullet bullet = spaceship.fireBullet();
        	pane.getChildren().add(bullet);
        	moveableObjects.add(bullet);
        	
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
  public static void main(String[] args) {
    launch(args);
  }}