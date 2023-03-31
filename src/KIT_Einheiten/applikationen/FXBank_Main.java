package KIT_Einheiten.applikationen;

import KIT_Einheiten.bank.klassen.FXBank_Controller;
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
 * @author Adrian Weidig
 * @since 30.03.2023
 */
public class FXBank_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Bankverwaltung");
        primaryStage.getIcons().add(new Image(String.valueOf(this.getClass().getResource("..\\bank\\resources\\bank-flat.png"))));

        // Größer veränderbar? Grundsätzlich nicht außer es ist responsiv.
        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("..\\bank\\FXML\\Bank.fxml"));
        Parent fxmlScene = loader.load();

        // Auskommentieren und Objekt des benannten Controllers erzeugen
        FXBank_Controller controller = loader.getController();

        // Scene und Stage getrennt, falls man spezielle Anpassungen vornehmen will.
        Scene scene = new Scene(fxmlScene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

