/**
 * Created by Gen on 6/8/17.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class NodeStyleRotateDemo extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        Button btOK = new Button("OK");
        btOK.setStyle("-fx-border-color: blue;");
        pane.getChildren().add(btOK);
        pane.setRotate(45);
        pane.setStyle("-fx-bother-color: red; -fx-border-color: lightgray;");

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("Rotate");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
