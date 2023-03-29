package KIT_Einheiten.JavaFX.Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * since: 29.03.2023
 * author: ML Dozent Armenti
 */
public class TreeView_Main extends Application {

    public static void main(String[] args) {
        launch();
    }

    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("..\\FXML\\TreeView.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Tree View");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}

