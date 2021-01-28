package CPT;

import java.util.ArrayList;

import javax.swing.JTable.PrintMode;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class Main extends Application {
    //Summary Variable
    String[] summarylist = new String[6];
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
    private String searchitem = "";
    private ObservableList<HappinessReport> loaddata;
    private ObservableList<Double> summarydata;
    private TableView<HappinessReport> clickdata;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String filename = "2019";
        final ObservableList<HappinessReport> data = FXCollections.observableArrayList(HappinessReport.loadEntries(filename));
        primaryStage.setTitle("World Happiness Report");
        tabUI(searchitem, data, primaryStage);
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    private void tabUI(String searchitem, ObservableList<HappinessReport> data, Stage primaryStage) {
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
        tableborderPane.setCenter(createTable((loaddata)));
        

        //Top Section
        //hbox controls
        Label tablelabel = new Label("Search Country");
        TextField searchbox = new TextField();
        Button searchbutton = new Button("Search");
        Button resetbutton = new Button("Reset");

        searchbutton.setOnAction((ActionEvent actionEvent) -> {
                loaddata = HappinessReport.search(searchbox.getText());
                tableborderPane.setCenter(createTable((loaddata)));
                primaryStage.setResizable(false);
        });
        resetbutton.setOnAction((ActionEvent actionEvent) -> {
            searchbox.setText("");
            loaddata = data;
            tableborderPane.setCenter(createTable((data)));
            primaryStage.setResizable(false);
    });

        //Hbox
        HBox tablehbox = new HBox();
        tablehbox.getChildren().addAll(tablelabel, searchbox, searchbutton, resetbutton);
        tablehbox.setPrefHeight(60);
        tablehbox.setMaxHeight(60);
        HBox.setMargin(tablelabel, new Insets(20,0,0,10));
        HBox.setMargin(searchbox, new Insets(18,0,0,10));
        HBox.setMargin(searchbutton, new Insets(18,0,0,10));
        HBox.setMargin(resetbutton, new Insets(18,0,0,10));
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
        //Vertical Seperator
        Separator verticalSeparator = new Separator();
        verticalSeparator.setOrientation(Orientation.VERTICAL);
        //Add Separator to hbox
        tablehbox.getChildren().add(verticalSeparator);
        HBox.setMargin(verticalSeparator, new Insets(10,0,0,0));
        //Add Sorting And Filtering Buttons
        //Add hbox and vbox
        HBox buttonHBox = new HBox();
        VBox buttonrightVBox = new VBox();
        VBox buttonleftVBox = new VBox();
        //Left Buttons
        Button sortrankDescendingbutton = new Button("Sort Descending Rank");
        sortrankDescendingbutton.setOnAction((ActionEvent actionEvent) -> {
            loaddata = Sorting.sort(loaddata, "GL");
            tableborderPane.setCenter(createTable((loaddata)));
            primaryStage.setResizable(false);
        });
        Button sortrankAscendingbutton = new Button("Sort Ascending Rank  ");
        sortrankAscendingbutton.setOnAction((ActionEvent actionEvent) -> {
            loaddata = Sorting.sort(loaddata, "LG");
            tableborderPane.setCenter(createTable((loaddata)));
            primaryStage.setResizable(false);
        });
        buttonleftVBox.getChildren().addAll(sortrankDescendingbutton, sortrankAscendingbutton);
        VBox.setMargin(sortrankDescendingbutton, new Insets(5,0,5,0));
        VBox.setMargin(sortrankAscendingbutton, new Insets(5,0,5,0));
        //Right Buttons
        Button filtertop10button = new Button("Filter Top 10 Current");
        Button filtertop5button = new Button("Filter Top 5 Current ");
        filtertop5button.setOnAction((ActionEvent actionEvent) -> {
            loaddata = Filter.filter(loaddata, 5);
            tableborderPane.setCenter(createTable((loaddata)));
            primaryStage.setResizable(false);
        });
        filtertop10button.setOnAction((ActionEvent actionEvent) -> {
            loaddata = Filter.filter(loaddata, 10);
            tableborderPane.setCenter(createTable((loaddata)));
            primaryStage.setResizable(false);
        });
        buttonrightVBox.getChildren().addAll(filtertop5button, filtertop10button);
        VBox.setMargin(filtertop5button, new Insets(5,0,5,10));
        VBox.setMargin(filtertop10button, new Insets(5,0,5,10));
        //Adding to main Hbox
        buttonHBox.getChildren().addAll(buttonleftVBox, buttonrightVBox);
        tablehbox.getChildren().add(buttonHBox);
//Bar Graph Tab
        BarChartTab.setText("Bar Chart Tab");
        BarChartTab.setTooltip(new Tooltip("Page with a Barchart"));
//Line Chart Tab
        LineGraphTab.setText("Scatter Plot Tab");
        LineGraphTab.setTooltip(new Tooltip("Page with a Scatterplot"));
//Finished Tabs
        //Add tableTab
        tabPane.getTabs().add(0, TableTab);
        TableTab.setContent(tableborderPane);
        //Add Bar Graph Tab
        tabPane.getTabs().add(1, BarChartTab);
        BarChartTab.setContent(createBarGraph(data));
        //Add Line Graph Tab
        tabPane.getTabs().add(2, LineGraphTab);
        LineGraphTab.setContent(createScatterPlot(data));
        //Show Tab Scene
        primaryStage.setScene(new Scene(tabPane));
        primaryStage.show();
    }

    public Parent createTable(ObservableList<HappinessReport> data) {
        
        //Table Coloumn Creation
        TableColumn rankingCol = new TableColumn();
        rankingCol.setText("Rank");
        rankingCol.setMinWidth(40);
        rankingCol.setCellValueFactory(new PropertyValueFactory("intRanking"));

        TableColumn countryCol = new TableColumn();
        countryCol.setText("Country");
        countryCol.setMinWidth(150);
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
        lifeexpectancyCol.setMinWidth(100);
        lifeexpectancyCol.setCellValueFactory(new PropertyValueFactory("dblLifeExpectancy"));

        TableColumn freedomCol = new TableColumn();
        freedomCol.setText("Freedom");
        freedomCol.setMinWidth(60);
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
        tableView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        tableView.getColumns().addAll(rankingCol, countryCol, scoreCol, GDPCol, socialCol, lifeexpectancyCol, freedomCol, generosityCol, corruptionCol);
        tableView.setOnMousePressed(e -> {
            if (e.getClickCount() == 2 && !tableView.getSelectionModel().isEmpty()) {
                //clickdata.getItems().clear();
                 popupdetails((HappinessReport) tableView.getSelectionModel().getSelectedItem());
            }
        });
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
        barchart.setTitle("Score Vs Country");
        //Country and Score Data load into chart
        for (int intx = 0; intx < data.size(); intx++) {
            XYChart.Series barChartSeries = new XYChart.Series<>();
            barChartSeries.getData().add(new XYChart.Data(String.valueOf(data.get(intx).getCountry()), data.get(intx).getScore()));
            barchart.getData().add(barChartSeries);
        }
        barchart.setLegendVisible(false);
        return barchart;
    }

    public Parent createScatterPlot(ObservableList<HappinessReport> data) {
        //Create Bar Chart for Countries
        //Xaxis Creation
        xAxis = new CategoryAxis();
        xAxis.setLabel("Country");
        //Yaxis Creation
        yAxis = new NumberAxis();
        yAxis.setLabel("Life Expectancy Score");
        //Chart Creation
        linechart = new LineChart<>(xAxis, yAxis);
        linechart.setTitle("Life Expectancy Score Vs. Country");
        //Country and Score Data load into chart
        for (int intx = 0; intx < data.size(); intx++) {
            XYChart.Series LineChartSeries = new XYChart.Series<>();
            LineChartSeries.getData().add(new XYChart.Data(String.valueOf(data.get(intx).getCountry()), data.get(intx).getExpectancy()));
            linechart.getData().add(LineChartSeries);
        }
        linechart.setVerticalGridLinesVisible(false);
        linechart.setLegendVisible(false);
        return linechart;
    }
    private PieChart piechart;

    public static ObservableList<Data> createPieGraphData(ObservableList<HappinessReport> singleReport) {
        return FXCollections.observableArrayList(
                new PieChart.Data("Happiness Score", singleReport.get(0).getScore()),
                new PieChart.Data("GDP", singleReport.get(0).getGDP()),
                new PieChart.Data("Social Score", singleReport.get(0).getSocial()),
                new PieChart.Data("Healthy Life Expectancy Score", singleReport.get(0).getExpectancy()),
                new PieChart.Data("Freedom Score", singleReport.get(0).getFreedom()),
                new PieChart.Data("Generosity Score", singleReport.get(0).getGenerosity()),
                new PieChart.Data("Corruption Level", singleReport.get(0).getCorruption()));
    }

    public Parent createPieGraph(ObservableList<HappinessReport> recordlist) {
        piechart = new PieChart(createPieGraphData(recordlist));
        piechart.setClockwise(false);
        piechart.setTitle(recordlist.get(0).getCountry());
        piechart.setMinSize(100, 100);
        return piechart;
    }

    public void popupdetails(HappinessReport record) {
        ObservableList<HappinessReport> recordlist = FXCollections.observableArrayList(record);
        //Create popupstage
        Stage popup = new Stage();
        //Create popup contaner
        VBox popupvbox = new VBox();
        VBox popuppiechartvbox = new VBox(createPieGraph(recordlist));
        HBox popupmastercontainer = new HBox();
        //Create popupscene
        Scene popupscene = new Scene(popupmastercontainer,750,450);
        //Add Text To Popupvbox
        Label ranklabel = new Label("Rank: " + record.getRanking());
        Label countrylabel = new Label("Country: " + record.getCountry());
        Label scorelabel = new Label("Happiness Score " + record.getScore());
        Label GDPlabel = new Label("GDP:  " + record.getGDP());
        Label sociallabel = new Label("Social Score: " + record.getSocial());
        Label expectancylabel = new Label("Healthy Life Expectancy Score: " + record.getExpectancy());
        Label freedomlabel = new Label("Freedom Score: " + record.getFreedom());
        Label generostylabel = new Label("Generosity Score: " + record.getGenerosity());
        Label corruptionlabel = new Label("Corruption Level: " + record.getCorruption());
        popupvbox.getChildren().addAll(ranklabel, countrylabel, scorelabel, GDPlabel, sociallabel, expectancylabel, freedomlabel, generostylabel, corruptionlabel);
        popupvbox.setPadding(new Insets(5, 5, 5, 5));
        //popupvbox into mastercontainer
        popupmastercontainer.getChildren().addAll(popupvbox, popuppiechartvbox);
        //Show Scene
        popup.setTitle("View an Individual Record");
        popup.setScene(popupscene);
        popup.centerOnScreen();
        popup.requestFocus();
        popup.show();
        //
    }
}
