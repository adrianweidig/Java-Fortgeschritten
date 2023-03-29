package KIT_Einheiten.JavaFX.Apps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * since: 29.03.2023
 * author: ML Dozent Armenti
 */
public class FXApp_2_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
// Label zur Anzeige eines Textes
        Label lbl = new Label("Hallo Welt!");
        lbl.setLayoutX(100);
        lbl.setLayoutY(100);

        // Container in dem die Controls gespeichert werden
        AnchorPane root = new AnchorPane();

        root.getChildren().add(lbl);

        // Aufbau der Scene, Bereich für alle Container
        Scene scene = new Scene(root, 500, 300);


        // Aufbau der Stage
        primaryStage.setTitle("Erste Application");        // Titel
        primaryStage.setScene(scene);                    // Zuordnung der Scene zu dem Fenster
        primaryStage.show();
    }
}
