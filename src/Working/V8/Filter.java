package CPT;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Filter {
    public static  ObservableList<HappinessReport> filter(ObservableList<HappinessReport> load, int intamount) {
        ObservableList<HappinessReport> sortedarray = FXCollections.observableArrayList(load);
        ObservableList<HappinessReport> returnarray = FXCollections.observableArrayList();
        sortedarray = Sorting.sort(load, "LG");
        int intx = 0;
		while (intx < intamount) {
            returnarray.add(sortedarray.get(intx));
            intx++;
        }
        return returnarray;

    }
}
