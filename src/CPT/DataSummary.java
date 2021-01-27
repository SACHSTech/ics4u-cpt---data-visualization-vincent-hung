package CPT;

import java.util.ArrayList;

import javafx.stage.Stage;

public class DataSummary {

    private int intcount;
    private double dblmaxscore;
    private double dblminscore;
    private double dblaverageScore;
    private double dblmedianScore;
    private double dbldeviationScore;
    private ArrayList<Double> EntryList;


    public DataSummary(ArrayList<Double> EntryList) {
        this.EntryList = EntryList;
        getSummary();
    }

    private void getSummary() {
        //Math Variables
        double dbltempsum = 0;
        

        intcount = EntryList.size();
        mergesort();
        dblminscore = EntryList.get(0);
        dblmaxscore = EntryList.get(intcount-1);
        //Get Average
        for(int intx = 0 ; intx < intcount ; intx++) {
            dbltempsum = dbltempsum + EntryList.get(intx);
        }
        dblaverageScore = dbltempsum/intcount;
    }

    //Mergesort Method (Using CodeHS method)
    private void mergesort() {
        ArrayList<Double> sortingarray = new ArrayList<Double>();
        mergeSortHelper(sortingarray, 0, intcount - 1);
    }

    private void mergeSortHelper(ArrayList<Double> sortingarray, int from, int to) {
        if (to - from >= 1)
        {
            int mid = (from + to) / 2;
            mergeSortHelper(sortingarray, from, mid);
            mergeSortHelper(sortingarray, mid + 1, to);
            merge(sortingarray, from, mid, to);
        }
    }
    private void merge(ArrayList<Double> sortingarray, int from, int mid, int to) {
        int lefttracker = from;
        int righttracker = mid + 1;
        int temptracker = from;

        while (lefttracker <= mid && righttracker <= to) {
            if (EntryList.get(temptracker) < EntryList.get(righttracker)) {
                sortingarray.set(temptracker, EntryList.get(lefttracker));
                lefttracker++;
            } else {
                sortingarray.set(temptracker, EntryList.get(righttracker));
                righttracker++;
            }
            temptracker++;
        }

        while (righttracker <= to) {
            sortingarray.set(temptracker, EntryList.get(righttracker));
            righttracker++;
            temptracker++;
        }

        for (int intx = from ; intx <= to ; intx++) {
            EntryList.set(intx, sortingarray.get(intx));
        }
    }
}
