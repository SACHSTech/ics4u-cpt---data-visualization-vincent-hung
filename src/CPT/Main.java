package CPT;

import java.util.ArrayList;

import javax.swing.table.TableColumnModel;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    private static Tab hometab;


    private static DataSummary summary;

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
        ArrayList<Entry> EntireList = Entry.loadEntries(filename);
        System.out.println(EntireList);
        //CentralHub(primaryStage, EntireList);

    }

    public static void CentralHub(Stage primaryStage, ArrayList<Entry> EntireList) {
        primaryStage.setWidth(700);
        primaryStage.setHeight(700);

        //Creation of All Tabs
        TabPane tabPane = new TabPane();
        final ObservableList<Entry> obslist = FXCollections.observableArrayList(EntireList);
        hometab = new Tab("table", (tablecreate(EntireList, obslist)));
        tabPane.getTabs().add(hometab);
        hometab.setTooltip(new Tooltip("Tab 1 Tooltip"));
        // Show Menu
        primaryStage.setScene(new Scene(tabPane));
        primaryStage.show();
        //summary = new DataSummary(EntryList.grabAllScores(EntireList));
        
    }

    public static TableView<Entry> tablecreate(ArrayList<Entry> EntireList, ObservableList<Entry> obslist) {
        TableColumn<Entry, Integer> rankingCol = new TableColumn<>();
        rankingCol.setText("Ranking");
        rankingCol.setCellValueFactory(new PropertyValueFactory<Entry, Integer>("intRanking"));

        TableColumn<Entry, String> countryCol = new TableColumn<>();
        countryCol.setText("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory<Entry, String>("strCountry"));

        TableColumn<Entry, Double> scoreCol = new TableColumn<>();
        scoreCol.setText("Score");
        scoreCol.setCellValueFactory(new PropertyValueFactory<Entry, Double>("dblScore"));

        final TableView tableView = new TableView();
        tableView.setEditable(false);
        tableView.setItems(obslist);
        tableView.getColumns().addAll(rankingCol, countryCol, scoreCol);
        //tableView.setItems((ObservableList) EntireList);
        return tableView;
    }   

    
}