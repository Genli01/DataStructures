/**
 * Created by Gen on 6/12/17.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.scene.text.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;


public class FontDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new StackPane();

        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(new Color(0.5, 0.5, 0.5, 0.1));
        pane.getChildren().add(circle);

        Label label = new Label("JavaFX");
        label.setFont(Font.font("Courier",
                FontWeight.BOLD, FontPosture.ITALIC, 20));
        pane.getChildren().add(label);

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("FontDemo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
