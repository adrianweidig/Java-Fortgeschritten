package KIT_Einheiten.JavaFX.Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXApp_5_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        // 1. Möglichkeit
        Parent root = FXMLLoader.load(this.getClass().getResource("..\\FXML\\FXController_2.fxml"));

        // 2. Möglichkeit
        // FXMLLoader loader = new FXMLLoader(getClass().getResource("HalloWelt.fxml"));
        // Parent root = loader.load();

        primaryStage.setTitle("Hallo Welt");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
}
