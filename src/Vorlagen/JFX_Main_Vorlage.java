package Vorlagen;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX Startklasse
 *
 * @author
 * @since
 */
public class JFX_Main_Vorlage extends Application {

    public static void main(String[] args) {
        // Auskommentieren und gem. Dokumentation zwischen eigenen oder verschiedenen Stylesheets wechseln
        // setUserAgentStylesheet(STYLESHEET_CASPIAN);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("FENSTER TITEL");
        primaryStage.getIcons().add(new Image("PFAD ZUM FENSTER ICON"));

        // Größer veränderbar? Grundsätzlich nicht außer es ist responsiv.
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("PFAD ZUR FXML DATEI.fxml"));
        Parent fxmlScene = loader.load();

        // Auskommentieren und Objekt des benannten Controllers erzeugen
        // MainController controller = loader.getController();

        // Scene und Stage getrennt, falls man spezielle Anpassungen vornehmen will.
        Scene scene = new Scene(fxmlScene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
