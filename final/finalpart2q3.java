<<<<<<< HEAD
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class finalpart2q3 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create an image
        ImageView image = new ImageView(new Image("file:C:/Users/desai/Desktop/CSCI2020/final/flag0.gif"));

        // Create a line
        Line line = new Line(250, 600, 250, -70);

        // Create a pane
        Pane pane = new Pane(image);

        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(70000));
        pt.setPath(line);
        pt.setNode(image);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("finalpart2q3"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
=======
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class finalpart2q3 extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create an image
        ImageView image = new ImageView(new Image("file:C:/Users/desai/Desktop/CSCI2020/final/flag0.gif"));

        // Create a line
        Line line = new Line(250, 600, 250, -70);

        // Create a pane
        Pane pane = new Pane(image);

        // Create a path transition
        PathTransition pt = new PathTransition();
        pt.setDuration(Duration.millis(70000));
        pt.setPath(line);
        pt.setNode(image);
        pt.setCycleCount(Timeline.INDEFINITE);
        pt.play();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("finalpart2q3"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }
>>>>>>> 6e22061cf32aaedcc0260e23f23e85e766b18a94
}