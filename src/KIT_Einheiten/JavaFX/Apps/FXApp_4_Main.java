package KIT_Einheiten.JavaFX.Apps;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class FXApp_4_Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        AnchorPane root = new AnchorPane();
        root.getChildren().add(rechteck());
        root.getChildren().add(kreis(100, 100, 70));
        root.getChildren().add(kreis(200, 130, 80));

        primaryStage.setTitle("Graphik");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }

    public Rectangle rechteck() {
        Rectangle rect = new Rectangle(20, 20, 200, 200);

        rect.setFill(Color.BLUE);

        return rect;
    }

    public Circle kreis(int x, int y, int r) {
        Circle c = new Circle(x, y, r, Color.RED);
        return c;
    }
}
