package CPT;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Main extends Application {

    //BarChartVariables
    private BarChart barchart;
    private LineChart<String, Number> linechart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String filename = "2019";
        final ObservableList<HappinessReport> data = FXCollections.observableArrayList(HappinessReport.loadEntries(filename));
        //primaryStage.setScene(new Scene(createContent(data)));
        //ObservableList<String> CountryList = (ObservableList<String>) data.get(1);
        //System.out.println(data.get(0).strCountryProperty().getValue());
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
        scoreCol.setMinWidth(200);
        scoreCol.setCellValueFactory(new PropertyValueFactory("dblScore"));

        TableColumn GDPCol = new TableColumn();
        GDPCol.setText("GDP");
        GDPCol.setMinWidth(200);
        GDPCol.setCellValueFactory(new PropertyValueFactory("dblGDP"));

        TableColumn socialCol = new TableColumn();
        socialCol.setText("Social");
        socialCol.setMinWidth(200);
        socialCol.setCellValueFactory(new PropertyValueFactory("dblSocial"));

        TableColumn lifeexpectancyCol = new TableColumn();
        lifeexpectancyCol.setText("Life Expectancy");
        lifeexpectancyCol.setMinWidth(200);
        lifeexpectancyCol.setCellValueFactory(new PropertyValueFactory("dblLifeExpectancy"));

        TableColumn freedomCol = new TableColumn();
        freedomCol.setText("Freedom");
        freedomCol.setMinWidth(200);
        freedomCol.setCellValueFactory(new PropertyValueFactory("dblFreedom"));

        TableColumn generosityCol = new TableColumn();
        generosityCol.setText("Generosity");
        generosityCol.setMinWidth(200);
        generosityCol.setCellValueFactory(new PropertyValueFactory("dblGenerosity"));

        TableColumn corruptionCol = new TableColumn();
        corruptionCol.setText("Corruption");
        corruptionCol.setMinWidth(200);
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
        linechart.setLegendVisible(false);
        return linechart;
    }
}
