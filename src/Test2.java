import javafx.application.Application;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Test2 extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {    
    // Create a pane to hold the circle 
    Pane pane = new Pane();
    
    // Create a circle and set its properties
    SpaceShip spaceship = new SpaceShip(new Image("Spaceship.png"),(pane.widthProperty().floatValue() / 2),pane.heightProperty().floatValue() / 2);
    //circle.xProperty().bind(pane.widthProperty().divide(2));
    //circle.yProperty().bind(pane.heightProperty().divide(2));
    pane.getChildren().add(spaceship); // Add circle to the pane
    
    Timeline animation = new Timeline(
            new KeyFrame(Duration.millis(50), (e -> {
            	spaceship.moveShip();
            })));
    
    spaceship.setOnKeyPressed(e -> {
        switch (e.getCode()) {
        case DOWN:
        	break;
        case UP:
        	spaceship.setMoveForward(true); break;
        case LEFT: 
        	spaceship.setMoveLeft(true);break;
        case RIGHT: 
        	spaceship.setMoveRight(true);break;
        default: 
        	System.out.println("Something else was pressed");
      }
    });

    spaceship.setOnKeyReleased((e -> {
        switch (e.getCode()) {
        case DOWN:
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