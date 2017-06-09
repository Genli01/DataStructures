/**
 * Created by Gen on 6/8/17.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.paint.*;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


public class ShowCircleCentered extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle circle = new Circle();
        circle .centerXProperty().bind(pane.widthProperty().divide(2));
        circle .centerYProperty().bind(pane.heightProperty().divide(2));
        circle.setRadius(50);
        circle.setFill(Color.RED);
        pane.getChildren().add(circle);
        Scene scene = new Scene(pane, 200, 200);
        primaryStage.setTitle("Centered");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
