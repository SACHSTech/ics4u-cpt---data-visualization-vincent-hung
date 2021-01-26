package CPT;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
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
        ToolBar toolbar = new ToolBar();
        toolbar.getItems().add(new Button("Home"));
        basePane.setTop(toolbar);

        //Left Bar
        TextField searchbar = new TextField();
        Button searchbutton = new Button("Search");
        searchbar.setPromptText("Search");
        VBox leftVbox = new VBox();
        leftVbox.setMinWidth(150);
        leftVbox.getChildren().addAll(searchbar, searchbutton);
        basePane.setLeft(leftVbox);

        //Show Menu

    }

    
}