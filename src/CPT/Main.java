package CPT;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application{
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        //Startup Loading
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        primaryStage.setResizable(false);
        primaryStage.setTitle("World Happiness Rankings");
        String filename = "2019";
        ArrayList<Entry> EntryList = Entry.loadEntries(filename);
        CentralHub(primaryStage, EntryList);

    }

    public static void CentralHub(Stage primaryStage, ArrayList<Entry> EntryList) {
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);
        BorderPane basePane = new BorderPane();
        basePane.setPadding(new Insets(10,10,10,10));

        //Top Bar
        TabPane tabPane = new TabPane();
        Button homebutton = new Button("Home");
        Button searchbutton = new Button("Search");
        Button graphsbutton = new Button("Graphs");
        Button summarybutton = new Button("Summary");
        tophBox.getChildren().addAll(homebutton, searchbutton, graphsbutton, summarybutton);
        HBox.setMargin(homebutton, new Insets(10, 10, 10, 10));
        HBox.setMargin(searchbutton, new Insets(10, 10, 10, 10));
        HBox.setMargin(graphsbutton, new Insets(10, 10, 10, 10));
        HBox.setMargin(summarybutton, new Insets(10, 10, 10, 10));
        basePane.setTop(tophBox);

        //Left Bar
        //Center
        ImageView cover = new ImageView(new Image("src/CPT.cover.jpg"));
        basePane.setCenter(cover);
        //Show Menu
        primaryStage.setScene(new Scene(basePane));
        primaryStage.show();
    }

    
}