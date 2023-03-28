package KIT_Einheiten.JavaFX.Apps;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Layouts_Main extends Application
{
	public static void main(String[] args) 
	{
		launch();
	}
	@Override
	public void start(Stage primaryStage) throws Exception 
	{
//		Parent root = FXMLLoader.load(getClass().getResource("..\FXML\HBoxLayout.fxml"));
//		Parent root = FXMLLoader.load(getClass().getResource("..\FXML\FlowLayout.fxml"));
//		Parent root = FXMLLoader.load(getClass().getResource("..\FXML\GridLayout.fxml"));
		Parent root = FXMLLoader.load(getClass().getResource("..\\FXML\\BorderLayout.fxml"));
		
		primaryStage.setTitle("Layouts");
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}

}
