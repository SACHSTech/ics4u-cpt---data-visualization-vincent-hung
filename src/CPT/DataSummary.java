package CPT;

import javafx.collections.ObservableList;

public class DataSummary {
    private int intcount;
    private double dblmaxscore;
    private double dblminscore;
    private double dblaverageScore;
    private double dblmedianScore;
    private double dbldeviationScore;
    private ObservableList<Double> SummaryList;

    public DataSummary(ObservableList<Double> SummaryList) {
        this.SummaryList = SummaryList;
        getSummary();
    }
}
