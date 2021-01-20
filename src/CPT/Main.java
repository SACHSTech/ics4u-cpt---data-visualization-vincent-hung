package CPT;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage startstage = new Stage(StageStyle.TRANSPARENT);
        Parent root = FXMLLoader.load(getClass().getResource("fxml/Startup.fxml"));
        primaryStage.setTitle("World Happiness Ranking");
        startstage.centerOnScreen();
        startstage.setScene(new Scene(root));
        startstage.show();

    }
}