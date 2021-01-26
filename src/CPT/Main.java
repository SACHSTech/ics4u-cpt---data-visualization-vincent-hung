package CPT;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    private static Tab hometab;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Startup Loading
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

        // Top Bar
        TabPane tabPane = new TabPane();
        hometab = new Tab();
        tabPane.getTabs().add(hometab);
        final VBox vbox = new VBox();
        vbox.setSpacing(10);
        vbox.setTranslateX(10);
        vbox.setTranslateY(10);
        hometab.setText("Home");
        hometab.setTooltip(new Tooltip("Tab 1 Tooltip"));
        //Show Menu
        primaryStage.setScene(new Scene(tabPane));
        primaryStage.show();
    }

    
}