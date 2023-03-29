package KIT_Einheiten.uebungen.JavaFX_Uebungen.Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX Startklasse
 *
 * @author
 * @since
 */
public class Uebung_FX3_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Verzeichnis anzeigen");

        // Größer veränderbar? Grundsätzlich nicht außer es ist responsiv.
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("..\\FXML\\Uebung_FX3.fxml"));
        Parent fxmlScene = loader.load();

        // Auskommentieren und Objekt des benannten Controllers erzeugen
        // MainController controller = loader.getController();

        // Scene und Stage getrennt, falls man spezielle Anpassungen vornehmen will.
        Scene scene = new Scene(fxmlScene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

