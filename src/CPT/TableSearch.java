package CPT;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TableSearch extends Application {
    private String filename = "2019";
    private ObservableList<HappinessReport> data = FXCollections.observableArrayList(HappinessReport.loadEntries(filename));
    public static void main(String[] args) {
        launch(args);
    }

    public Parent searchedTable(String searchitem) throws IOException {
        ObservableList<HappinessReport> searchedlist = search(searchitem);

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
        tableView.setItems(searchedlist);
        tableView.getColumns().addAll(rankingCol, countryCol, scoreCol, GDPCol, socialCol, lifeexpectancyCol, freedomCol, generosityCol, corruptionCol);
        //tableView.getColumns().addAll(rankingCol, countryCol);
        return tableView;
    }   

    @Override
    public void start(Stage primaryStage) throws Exception {

    }
}
