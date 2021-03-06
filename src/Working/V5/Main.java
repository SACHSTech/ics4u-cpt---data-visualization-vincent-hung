package CPT;

import java.util.ArrayList;

import javax.swing.JTable.PrintMode;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Main extends Application {

    //Chart Variables
    private BarChart barchart;
    private LineChart<String, Number> linechart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;

    //Main Menu Variables
    private TabPane tabPane;
    private Tab TableTab;
    private Tab BarChartTab;
    private Tab LineGraphTab;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String filename = "2019";
        final ObservableList<HappinessReport> data = FXCollections.observableArrayList(HappinessReport.loadEntries(filename));
        //primaryStage.setScene(new Scene(createTable(data)));
        //ObservableList<String> CountryList = (ObservableList<String>) data.get(1);
        //System.out.println(data.get(0).strCountryProperty().getValue());

        //Main Menu/Tabs
        tabPane = new TabPane();
        tabPane.setPrefSize(1000,800);
        TableTab = new Tab();
        BarChartTab = new Tab();
        LineGraphTab = new Tab();

        //TableTab Setup
        TableTab.setText("TableTab");
        TableTab.setTooltip(new Tooltip("Page with a Table"));
        //Setup borderPane for TableTab
        final BorderPane tableborderPane = new BorderPane();
        //Center Pane
        String searchitem = "";
        tableborderPane.setCenter(createTable((search(searchitem, data))));

        //Top Section
        //hbox controls
        Label tablelabel = new Label("Search Country");
        TextField searchbox = new TextField();
        Button searchbutton = new Button("Search");
        //Hbox
        HBox tablehbox = new HBox(5);
        tablehbox.getChildren().addAll(tablelabel, searchbox, searchbutton);
        tablehbox.setPrefHeight(60);
        HBox.setMargin(tablelabel, new Insets(20,0,0,10));
        HBox.setMargin(searchbox, new Insets(18,0,0,10));
        HBox.setMargin(searchbutton, new Insets(18,0,0,10));
        //Add hbox to borderPane
        tableborderPane.setTop(tablehbox);
        //Add tableTab
        tabPane.getTabs().add(TableTab);
        TableTab.setContent(tableborderPane);
        primaryStage.setScene(new Scene(tabPane));
        primaryStage.show();
    }

    public Parent createTable(ObservableList<HappinessReport> data) { 
        
        //Table Coloumn Creation
        TableColumn rankingCol = new TableColumn();
        rankingCol.setText("Rank");
        rankingCol.setCellValueFactory(new PropertyValueFactory("intRanking"));

        TableColumn countryCol = new TableColumn();
        countryCol.setText("Country");
        countryCol.setCellValueFactory(new PropertyValueFactory("strCountry"));

        TableColumn scoreCol = new TableColumn();
        scoreCol.setText("Score");
        scoreCol.setMinWidth(75);
        scoreCol.setCellValueFactory(new PropertyValueFactory("dblScore"));

        TableColumn GDPCol = new TableColumn();
        GDPCol.setText("GDP");
        GDPCol.setMinWidth(75);
        GDPCol.setCellValueFactory(new PropertyValueFactory("dblGDP"));

        TableColumn socialCol = new TableColumn();
        socialCol.setText("Social");
        socialCol.setMinWidth(100);
        socialCol.setCellValueFactory(new PropertyValueFactory("dblSocial"));

        TableColumn lifeexpectancyCol = new TableColumn();
        lifeexpectancyCol.setText("Life Expectancy");
        lifeexpectancyCol.setMinWidth(175);
        lifeexpectancyCol.setCellValueFactory(new PropertyValueFactory("dblLifeExpectancy"));

        TableColumn freedomCol = new TableColumn();
        freedomCol.setText("Freedom");
        freedomCol.setMinWidth(100);
        freedomCol.setCellValueFactory(new PropertyValueFactory("dblFreedom"));

        TableColumn generosityCol = new TableColumn();
        generosityCol.setText("Generosity");
        generosityCol.setMinWidth(100);
        generosityCol.setCellValueFactory(new PropertyValueFactory("dblGenerosity"));

        TableColumn corruptionCol = new TableColumn();
        corruptionCol.setText("Corruption");
        corruptionCol.setMinWidth(125);
        corruptionCol.setCellValueFactory(new PropertyValueFactory("dblCorruption"));

        final TableView tableView = new TableView();
        tableView.setItems(data);
        tableView.getColumns().addAll(rankingCol, countryCol, scoreCol, GDPCol, socialCol, lifeexpectancyCol, freedomCol, generosityCol, corruptionCol);
        //tableView.getColumns().addAll(rankingCol, countryCol);
        return tableView;
    }
 
    public Parent createBarGraph(ObservableList<HappinessReport> data) {
        //Create Bar Chart for Countries
        //Xaxis Creation
        xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        //Yaxis Creation
        yAxis = new NumberAxis();
        yAxis.setLabel("Score");
        //Chart Creation
        barchart = new BarChart<>(xAxis, yAxis);
        barchart.setTitle("Horizontal Bar Chart Example");
        //Country and Score Data load into chart
        for (int intx = 0; intx < data.size(); intx++) {
            XYChart.Series barChartSeries = new XYChart.Series<>();
            barChartSeries.getData().add(new XYChart.Data(String.valueOf(data.get(intx).getCountry()), data.get(intx).getScore()));
            barchart.getData().add(barChartSeries);
        }
        barchart.setTitle("Horizontal Bar Chart Example");
        barchart.setLegendVisible(false);
        return barchart;
    }

    public Parent createLineGraph(ObservableList<HappinessReport> data) {
        //Create Bar Chart for Countries
        //Xaxis Creation
        xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        //Yaxis Creation
        yAxis = new NumberAxis();
        yAxis.setLabel("Life Expectancy (Years)");
        //Chart Creation
        linechart = new LineChart<>(xAxis, yAxis);
        linechart.setTitle("Linechart");
        //Country and Score Data load into chart
        for (int intx = 0; intx < data.size(); intx++) {
            XYChart.Series LineChartSeries = new XYChart.Series<>();
            LineChartSeries.getData().add(new XYChart.Data(String.valueOf(data.get(intx).getCountry()), data.get(intx).getExpectancy()));
            linechart.getData().add(LineChartSeries);
        }
        linechart.setTitle("Horizontal Bar Chart Example");
        linechart.setVerticalGridLinesVisible(false);
        linechart.setLegendVisible(false);
        return linechart;
    }

    public ObservableList<HappinessReport> search(String searchitem, ObservableList<HappinessReport> data) {
        // Declare variables
        ObservableList<HappinessReport> searchedList = FXCollections.observableArrayList();

        // Linear search
        for (HappinessReport test: data) {
            if (test.getCountry().contains(searchitem)) {
                searchedList.add(test);
            }
        }
        // Return the list
        return searchedList;
    }
}
