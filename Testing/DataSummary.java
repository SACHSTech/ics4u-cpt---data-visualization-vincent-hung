package CPT;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class DataSummary {
    private int intcount;
    private double dblmax;
    private double dblmin;
    private double dblaverageScore;
    private double dblmedianScore;
    private double dbldeviationScore;
    private ObservableList<Double> SummaryList;

    public DataSummary(ObservableList<Double> SummaryList) {
        this.SummaryList = SummaryList;
        getSummary();
    }
    public void getSummary() {
        //Math Variables
        double dbltotal = 0;
        

        intcount = SummaryList.size();
        mergesort();
        dblmin = SummaryList.get(0);
        dblmax = SummaryList.get(intcount-1);
        //Get Total
        for(int intx = 0 ; intx < intcount ; intx++) {
            dbltotal = dbltotal + SummaryList.get(intx);
        }
        //Get Average
        dblaverageScore = dbltotal/intcount;
        dblaverageScore = Math.round(dblaverageScore * 100.0) / 100.0;
        //Get Median
        //Odd & Even Case
        if (intcount % 2 != 0) {
            dblmedianScore = SummaryList.get((intcount - 1) / 2);
        } else {
            dblmedianScore = SummaryList.get((intcount - 1) / 2) + SummaryList.get(((intcount - 1) / 2) - 1);
            dblmedianScore = dblmedianScore / 2;
        }
        dblmedianScore = Math.round(dblmedianScore * 100.0) / 100.0;
        //Get Standard Deviation
        for (int intx = 0 ; intx < intcount ; intx++) {
            dbldeviationScore = dbldeviationScore + Math.pow(SummaryList.get(intx) - dblaverageScore, 2);
        }
        dbldeviationScore = dbldeviationScore/intcount;
        dbldeviationScore = Math.sqrt(dbldeviationScore);
        dbldeviationScore = Math.round(dbldeviationScore * 100.0) / 100.0;
    }

    //All Property Getter Methods
    public IntegerProperty intcountProperty() {
        return new SimpleIntegerProperty(intcount);
    }

    public DoubleProperty dblminProperty(){
        return new SimpleDoubleProperty(dblmin);
    }

    public DoubleProperty dblmaxProperty(){
        return new SimpleDoubleProperty(dblmax);
    }

    public DoubleProperty dblaverageScoreProperty(){
        return new SimpleDoubleProperty(dblaverageScore);
    }

    public DoubleProperty dblmedianScoreProperty(){
        return new SimpleDoubleProperty(dblmedianScore);
    }

    public DoubleProperty dbldeviationScoreProperty(){
        return new SimpleDoubleProperty(dbldeviationScore);
    }

    //Mergesort Method (Using CodeHS method)
    private void mergesort() {
        ObservableList<Double> sortingarray = FXCollections.observableArrayList(SummaryList);
        mergeSortHelper(sortingarray, 0, intcount - 1);
    }

    private void mergeSortHelper(ObservableList<Double> sortingarray, int from, int to) {
        if (to - from >= 1)
        {
            int mid = (from + to) / 2;
            mergeSortHelper(sortingarray, from, mid);
            mergeSortHelper(sortingarray, mid + 1, to);
            merge(sortingarray, from, mid, to);
        }
    }
    private void merge(ObservableList<Double> sortingarray, int from, int mid, int to) {
        int lefttracker = from;
        int righttracker = mid + 1;
        int temptracker = from;

        while (lefttracker <= mid && righttracker <= to) {
            if (sortingarray.get(temptracker) <sortingarray.get(righttracker)) {
                sortingarray.set(temptracker,sortingarray.get(lefttracker));
                lefttracker++;
            } else {
                sortingarray.set(temptracker,sortingarray.get(righttracker));
                righttracker++;
            }
            temptracker++;
        }

        while (righttracker <= to) {
            sortingarray.set(temptracker,sortingarray.get(righttracker));
            righttracker++;
            temptracker++;
        }

        for (int intx = from ; intx <= to ; intx++) {
           sortingarray.set(intx, sortingarray.get(intx));
        }
    }

}
