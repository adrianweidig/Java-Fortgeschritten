package KIT_Einheiten.JavaFX.Apps;

import KIT_Einheiten.JavaFX.Klassen.MDIHauptfensterController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Modal_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\MDIHauptfenster.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("MDIHauptfenster");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

        MDIHauptfensterController ctrl = loader.getController();
        ctrl.setHauptfenster(primaryStage);
    }
}
