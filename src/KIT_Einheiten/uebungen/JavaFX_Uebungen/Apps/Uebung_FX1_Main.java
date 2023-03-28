package KIT_Einheiten.uebungen.JavaFX_Uebungen.Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;


/**
 * JavaFX Übung 1 Mainklasse
 *
 * @author Adrian Weidig
 * @since 28.03.2023
 */
public class Uebung_FX1_Main extends Application {

    public static void main(String[] args) {
        // Auskommentieren und gem. Dokumentation zwischen eigenen oder verschiedenen Stylesheets wechseln
        setUserAgentStylesheet(STYLESHEET_MODENA);
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Adressausgabe");

        // Größer veränderbar? Grundsätzlich nicht außer es ist responsiv.
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("..\\FXML\\Uebung_FX1.fxml"));
        Parent fxmlScene = loader.load();

        // Scene und Stage getrennt, falls man spezielle Anpassungen vornehmen will.
        Scene scene = new Scene(fxmlScene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
