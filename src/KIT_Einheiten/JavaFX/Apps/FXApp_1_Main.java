package KIT_Einheiten.JavaFX.Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FXApp_1_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        //Zuorden der FXML Klasse an die Application
        // 1. Möglichkeit
//		Parent root = FXMLLoader.load(getClass().getResource("/views/HelloWorld.fxml"));

        // 2. Möglichkeit
        // Das Object loader steht zur Verfügung
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("..\\FXML\\FXController_1.fxml"));
        Parent root = loader.load();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();

    }
}
