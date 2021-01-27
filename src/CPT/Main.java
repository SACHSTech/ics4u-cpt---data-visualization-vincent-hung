package CPT;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class Main extends Application {

    //BarChartVariables
    private BarChart chart;
    private CategoryAxis xAxis;
    private NumberAxis yAxis;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String filename = "2019";
        final ObservableList<HappinessReport> data = FXCollections.observableArrayList(HappinessReport.loadEntries(filename));
        primaryStage.setScene(new Scene(createContent()));
        
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
 
    public Parent createContent(ObservableList<HappinessReport> data) {
        //Grab List of Countries
        ObservableList<String> years;
        for (HappinessReport country : data) {
            years = (country.strCountryProperty().get());
        }
        xAxis = new CategoryAxis();
        xAxis.setCategories(FXCollections.<String>observableArrayList(years));
        yAxis = new NumberAxis("Units Sold", 0.0d, 3000.0, 1000.0);
        //Grab any for Yaxis
        ObservableList<BarChart.Series> barChartData = FXCollections.observableArrayList(
                new BarChart.Series("Apples", FXCollections.observableArrayList(
                    new BarChart.Data(years.get(0), 567),
                    new BarChart.Data(years[1], 1292),
                    new BarChart.Data(years[2], 1292))));
        chart = new BarChart(xAxis, yAxis, barChartData, 25.0);
        return chart;
    }
}
