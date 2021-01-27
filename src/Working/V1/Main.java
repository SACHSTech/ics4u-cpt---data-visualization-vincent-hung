/* ....Show License.... */
package CPT;
 
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
 
/**
 * A simple table with a header row.
 */
public class Main extends Application {
 
    public Parent createContent() {
        final ObservableList<Person> data = FXCollections.observableArrayList(
                new Person("Jacob", "Smith", "jacob.smith@example.com"),
                new Person("Sue", "Jones", "sue@example.com"),
                new Person("Ethan", "Fox", "ethan.fox@example.com"),
                new Person("Emma", "Jones", "emma.jones@example.com"),
                new Person("Mike", "Brown", "mike.brown@example.com"));
 
        TableColumn firstNameCol = new TableColumn();
        firstNameCol.setText("First");
        firstNameCol.setCellValueFactory(new PropertyValueFactory("firstName"));
        
        TableColumn lastNameCol = new TableColumn();
        lastNameCol.setText("Last");
        lastNameCol.setCellValueFactory(new PropertyValueFactory("lastName"));

        TableColumn emailCol = new TableColumn();
        emailCol.setText("Email");
        emailCol.setMinWidth(200);
        emailCol.setCellValueFactory(new PropertyValueFactory("emailxx"));

        final TableView tableView = new TableView();
        tableView.setItems(data);
        tableView.getColumns().addAll(firstNameCol, lastNameCol, emailCol);
        return tableView;
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.show();
    }
 
    /**
     * Java main for when running without JavaFX launcher
     */
    public static void main(String[] args) {
        launch(args);
    }
}