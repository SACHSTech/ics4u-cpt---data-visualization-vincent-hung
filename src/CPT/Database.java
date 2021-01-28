package CPT;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Database {
    public static  ObservableList<HappinessReport> filter(ObservableList<HappinessReport> load, int intamount) {
        ObservableList<HappinessReport> sortedarray = FXCollections.observableArrayList();
        ObservableList<HappinessReport> returnarray = FXCollections.observableArrayList();
        sortedarray = Sorting.sort(load, "LG");
        int intx = 0;
		while (intx < intamount && intx < sortedarray.size()) {
            returnarray.add(sortedarray.get(intx));
        }
        return returnarray;

    }
}
