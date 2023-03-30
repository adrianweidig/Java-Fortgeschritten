package KIT_Einheiten.JavaFX.Apps;

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
public class TableView_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        primaryStage.setTitle("Table View");

        primaryStage.setResizable(false);

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("..\\FXML\\TableView.fxml"));
        Parent fxmlScene = loader.load();

        Scene scene = new Scene(fxmlScene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

