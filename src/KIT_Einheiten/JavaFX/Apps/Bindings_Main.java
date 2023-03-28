package KIT_Einheiten.JavaFX.Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Bindings_Main extends Application
{
	public static void main(String[] args) 
	{
		launch();
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
		Parent root = FXMLLoader.load(getClass().getResource("..\\FXML\\Binding.fxml"));
		
		primaryStage.setTitle("Binding");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}
