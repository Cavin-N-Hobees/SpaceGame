import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Test3 extends Application {
	public static boolean moveShip = false;
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {    
    // Create a pane to hold the circle 
    Pane pane = new Pane();
    // Create a circle and set its properties
    ImageView circle = new ImageView(new Image("Spaceship.png"));
    //circle.xProperty().bind(pane.widthProperty().divide(2));
    //circle.yProperty().bind(pane.heightProperty().divide(2));
    pane.getChildren().add(circle); // Add circle to the pane
    circle.setX(100);
    circle.setY(100);
    moveShip(circle);
    circle.setOnKeyPressed(e -> {
        switch (e.getCode()) {
        case DOWN:
        ; break;
        case UP:     
        	moveShip = true;
        	break;
        case LEFT: circle.setRotate(circle.getRotate() - 1.5); break;
        case RIGHT: circle.setRotate(circle.getRotate() + 1.5); break;
        default: 
          if (e.getText().length() > 0)
            circle.setX(circle.getX());
      }
        switch (e.getCode()) {
        case LEFT: circle.setRotate(circle.getRotate() - 1.5); break;
        case RIGHT: circle.setRotate(circle.getRotate() + 1.5); break;
        }
    });
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 200, 200);
    primaryStage.setTitle("Test2"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
    
    circle.requestFocus();
  }
  void tick(ImageView ship) {
	  while (moveShip)
		  moveShip(ship);
  }
  void moveShip(ImageView ship) {
  	double disX;
  	double disY;
      disX = Math.cos(((ship.getRotate() - 90) * Math.PI) / 180); // changes disX to be used for the calculations on line 20
      disY = Math.sin(((ship.getRotate() - 90) * Math.PI) / 180); // changes disY to be used for the calculations on line 21
          ship.setX(ship.getX() + disX); // calculates how far the boat should move on the x-axis
          ship.setY(ship.getY() + disY);
  }
  public static void main(String[] args) {
    launch(args);
  }
}
/*
public class Test extends Application {
  @Override // Override the start method in the Application class
  public void start(Stage primaryStage) {
    ImageView spaceship = new ImageView(new Image("Spaceship.png"));
    HBox pane = new HBox(20);
    DoubleProperty spaceshipX = new SimpleDoubleProperty(10.0);
    spaceship.xProperty().bind(spaceshipX);
    pane.getChildren().add(spaceship);
    // Create a scene and place it in the stage
    Scene scene = new Scene(pane, 450, 150);
    primaryStage.setTitle("LabelWithGraphic"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }
  public static void main(String[] args) {
    launch(args);
  }
}
*/