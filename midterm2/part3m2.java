<<<<<<< HEAD
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class part3m3 extends Application {
    private String text = "";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();
        Label lblText = new Label("Midterm 2");
        pane.getChildren().add(lblText);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (lblText.getText().trim().length() == 0)
                            text = "Somebody you will miss today!";
                        else
                            text = "";

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                lblText.setText(text);
                            }
                        });
                        Thread.sleep(200);
                    }
                }
                catch (InterruptedException ex) {
                }
            }
        }).start();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("FlashText"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}

=======
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class part3m3 extends Application {
    private String text = "";

    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {

        StackPane pane = new StackPane();
        Label lblText = new Label("Midterm 2");
        pane.getChildren().add(lblText);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        if (lblText.getText().trim().length() == 0)
                            text = "Somebody you will miss today!";
                        else
                            text = "";

                        Platform.runLater(new Runnable() {
                            @Override
                            public void run() {
                                lblText.setText(text);
                            }
                        });
                        Thread.sleep(200);
                    }
                }
                catch (InterruptedException ex) {
                }
            }
        }).start();

        // Create a scene and place it in the stage
        Scene scene = new Scene(pane, 200, 50);
        primaryStage.setTitle("FlashText"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage
    }

    public static void main(String[] args) {
        launch(args);
    }
}

>>>>>>> 6e22061cf32aaedcc0260e23f23e85e766b18a94
