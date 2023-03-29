package KIT_Einheiten.JavaFX.Apps;

import javafx.animation.RotateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * since: 29.03.2023
 * author: ML Dozent Armenti
 */
public class FXApp_3_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        AnchorPane root = new AnchorPane();

        Rectangle r = new Rectangle(20, 20, 100, 100);
        RotateTransition t = new RotateTransition();
        t.setNode(r);
        t.setFromAngle(0);
        t.setToAngle(60);
        t.setDuration(Duration.seconds(1));
        t.setCycleCount(3);
        t.setAutoReverse(true);
        t.play();
        root.getChildren().add(r);

        Label lbl = new Label("Das ist ein Text");
        lbl.setLayoutX(20);
        lbl.setLayoutY(200);
        RotateTransition t1 = new RotateTransition();
        t1.setNode(lbl);
        t1.setFromAngle(0);
        t1.setToAngle(360);
        t1.setDuration(Duration.seconds(5));
        t1.setCycleCount(3);
        t1.setAutoReverse(true);
        t1.play();
        root.getChildren().add(lbl);

        primaryStage.setTitle("Animation");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }
}
