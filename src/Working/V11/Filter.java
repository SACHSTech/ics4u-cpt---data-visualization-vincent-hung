package CPT;

//Java Imports
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

    /**
     * The Filter file
     * 
     * @author V.Hung
     * 
     * 
     */
public class Filter {
    /**
     * The filter method used to filter HappinessReport lists
     * 
     * @param load - The given list to filter
     * @param intamount - the amount to entries left after filtering
     * @return - returns list with filtered results
     */
    public static ObservableList < HappinessReport > filter(ObservableList < HappinessReport > load, int intamount) {
        //Load list to be sorted from given list
        ObservableList < HappinessReport > sortedarray = FXCollections.observableArrayList(load);
        //Create List to be returned
        ObservableList < HappinessReport > returnarray = FXCollections.observableArrayList();
        //Accessing sort method
        sortedarray = Sorting.sort(load, "LG");
        int intx = 0;
        //loop to add given amount of entries
        while (intx < intamount) {
            returnarray.add(sortedarray.get(intx));
            intx++;
        }
        return returnarray;

    }
}