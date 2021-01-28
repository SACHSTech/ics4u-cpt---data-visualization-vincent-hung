package CPT;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class tabUI extends Application {
    private Stage tabStage;
    private TabPane tabPane;
    private Tab TableTab;
    private Tab BarChartTab;
    private Tab LineGraphTab;

    private ObservableList<HappinessReport> loaddata;
    String[] summarylist = new String[6];
    
    public Parent createContent(String searchitem, ObservableList<HappinessReport> data, Stage primaryStage) {
        //Main Menu/Tabs
        tabPane = new TabPane();
        tabPane.setPrefSize(1000,800);
        TableTab = new Tab();
        BarChartTab = new Tab();
        LineGraphTab = new Tab();

//TableTab
        //TableTab Setup
        TableTab.setText("TableTab");
        TableTab.setTooltip(new Tooltip("Page with a Table"));
        //Setup borderPane for TableTab
        final BorderPane tableborderPane = new BorderPane();
        //Center Pane
        loaddata = HappinessReport.search(searchitem);
        tableborderPane.setCenter(Main.createTable((loaddata)));

        //Top Section
        //hbox controls
        Label tablelabel = new Label("Search Country");
        TextField searchbox = new TextField();
        Button searchbutton = new Button("Search");

        searchbutton.setOnAction((ActionEvent actionEvent) -> {
                loaddata = HappinessReport.search(searchbox.getText());
                tableborderPane.setCenter(Main.createTable((loaddata)));
                primaryStage.setHeight(1000);
        });

        //Hbox
        HBox tablehbox = new HBox();
        tablehbox.getChildren().addAll(tablelabel, searchbox, searchbutton);
        tablehbox.setPrefHeight(60);
        HBox.setMargin(tablelabel, new Insets(20,0,0,10));
        HBox.setMargin(searchbox, new Insets(18,0,0,10));
        HBox.setMargin(searchbutton, new Insets(18,0,0,10));
        //Add hbox to borderPane
        tableborderPane.setTop(tablehbox);
        //Grabbing Summary Data String
        summarylist = HappinessReport.getDataSummary(data);
        //Vbox
        VBox summarybox = new VBox();
        Label summarrytitlelabel = new Label("Entire Data Summary");
        summarrytitlelabel.setAlignment(Pos.CENTER);
        Label summaryrow1label = new Label("Total: " + summarylist[0] + " | Max: " + summarylist[1] + " | Min: " + summarylist[2]);
        Label summaryrow2label = new Label("Average: " + summarylist[3] + " | Median: " + summarylist[4] + " | Deviation: " + summarylist[5]);
        summarybox.getChildren().addAll(summarrytitlelabel, summaryrow1label, summaryrow2label);
        //Add vbox to hbox
        tablehbox.getChildren().add(summarybox);
        HBox.setMargin(summarybox, new Insets(5,0,0,40));
//Bar Graph Tab
        BarChartTab.setText("Bar Chart Tab");
        BarChartTab.setTooltip(new Tooltip("Page with a Barchart"));

//Finished Tabs
        //Add tableTab
        tabPane.getTabs().add(0, TableTab);
        TableTab.setContent(tableborderPane);
        //Add Bar Graph Tab
        tabPane.getTabs().add(1, BarChartTab);
        BarChartTab.setContent(Main.createBarGraph(data));
        //Show Tab Scene - Looking for primaryStage.setScene(new Scene(tabUI.createContent));
        return tabPane;
    }

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub

    }
}
