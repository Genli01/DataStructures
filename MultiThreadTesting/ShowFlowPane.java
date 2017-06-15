/**
 * Created by Gen on 6/14/17.
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;


public class ShowFlowPane extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        FlowPane pane = new FlowPane(5, 5);
        pane.setPadding(new Insets(11, 12, 13, 14));

        pane.getChildren().addAll(new Label("First Name:"),
                new TextField(), new Label("MI:"));
        TextField tfMI = new TextField();
        tfMI.setPrefColumnCount(1);
        pane.getChildren().addAll(tfMI, new Label("Last Name:"),
                new TextField());

        Scene scene = new Scene(pane, 200, 250);
        primaryStage.setTitle("Show Flow Pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
