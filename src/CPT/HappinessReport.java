package CPT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HappinessReport {
 
    private int intRanking;
    private String strCountry;
    private double dblScore;
    private double dblGDP;
    private double dblSocial;
    private double dblLifeExpectancy;
    private double dblFreedom;
    private double dblGenerosity;
    private double dblCorruption;
    //Summary Variable
    private ObservableList<Double> sortingarray;
 
    public HappinessReport(int givenRanking, String givenCountry, double givenScore, double givenGDP, double givenSocial, double givenExpectancy,
    double givenFreedom, double givenGenerosity, double givenCorruption) {
        this.intRanking = givenRanking;
        this.strCountry = givenCountry;
        this.dblScore = givenScore;
        this.dblGDP = givenGDP;
        this.dblSocial = givenSocial;
        this.dblLifeExpectancy = givenExpectancy;
        this.dblFreedom = givenFreedom;
        this.dblGenerosity = givenGenerosity;
        this.dblCorruption = givenCorruption;
    }
    //All Get Methods for Constructor
    public int getRanking() {
        return intRanking;
    }

    public String getCountry() {
        return strCountry;
    }

    public double getScore() {
        return dblScore;
    }

    public double getSocial() {
        return dblSocial;
    }

    public double getExpectancy() {
        return dblLifeExpectancy;
    }

    public double getFreedom() {
        return dblFreedom;
    }

    public double getGenerosity() {
        return dblGenerosity;
    }

    public double getCorruption() {
        return dblCorruption;
    }

    //All Property Get Methods for Constructor
    public IntegerProperty intRankingProperty() {
        return new SimpleIntegerProperty(intRanking);
    }

    public StringProperty strCountryProperty() {
        return new SimpleStringProperty(strCountry);
    }

    public DoubleProperty dblScoreProperty(){
        return new SimpleDoubleProperty(dblScore);
    }

    public DoubleProperty dblGDPProperty() {
        return new SimpleDoubleProperty(dblGDP);
    }

    public DoubleProperty dblSocialProperty() {
        return new SimpleDoubleProperty(dblSocial);
    }

    public DoubleProperty dblLifeExpectancyProperty() {
        return new SimpleDoubleProperty(dblLifeExpectancy);
    }

    public DoubleProperty dblFreedomProperty() {
        return new SimpleDoubleProperty(dblFreedom);
    }

    public DoubleProperty dblGenerosityProperty() {
        return new SimpleDoubleProperty(dblGenerosity);
    }

    public DoubleProperty dblCorruptionProperty() {
        return new SimpleDoubleProperty(dblCorruption);
    }

    //All Setter Methods for Constructor
    public void setRanking(int change) {
        this.intRanking = (change);
    }

    public void setCountry(String change) {
        this.strCountry = change;
    }

    public void setScore(Double change) {
        this.dblScore = change;
    }

    public void setGDP(Double change) {
        this.dblGDP = change;
    }

    public void setSocial(Double change) {
        this.dblSocial = change;
    }

    public void setExpectancy(Double change) {
        this.dblLifeExpectancy = change;
    }

    public void setFreedom(Double change) {
        this.dblFreedom = change;
    }

    public void setGenerosity(Double change) {
        this.dblGenerosity = change;
    }

    public void setCorruption(Double change) {
        this.dblCorruption = change;
    }

    public String toString() {
        return "\n " + intRanking + "\n " + strCountry + "\n" + dblScore + "\n" + dblGDP + "\n" + dblSocial + "\n" + dblLifeExpectancy + "\n" + dblFreedom + "\n" + dblGenerosity;
    }

    public static ObservableList<HappinessReport> loadEntries(String filename) {
        ObservableList<HappinessReport> HappinessList = FXCollections.observableArrayList();
        String strread;
        try {
            BufferedReader fr = new BufferedReader(new FileReader("src/CPT/" + filename + ".csv"));
            while ((strread = fr.readLine()) != null) {
                String[] FileSplit = strread.split(",");
            
                HappinessReport loader = new HappinessReport(0,strread, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

                loader.setRanking(Integer.parseInt(FileSplit[0]));
                loader.setCountry(FileSplit[1]);
                loader.setScore(Double.parseDouble(FileSplit[2]));
                loader.setGDP(Double.parseDouble(FileSplit[3]));
                loader.setSocial(Double.parseDouble(FileSplit[4]));
                loader.setExpectancy(Double.parseDouble(FileSplit[5]));
                loader.setFreedom(Double.parseDouble(FileSplit[6]));
                loader.setGenerosity(Double.parseDouble(FileSplit[7]));
                loader.setCorruption(Double.parseDouble(FileSplit[8]));
                HappinessList.add(loader);
            }
                fr.close();
        } catch (IOException e) {
            //Catch Statement
            e.printStackTrace();
            System.out.println("Error at Entry.loadEntries");
        }
    return HappinessList;
    }
    public static ObservableList<HappinessReport> search(String searchitem) {
        // Declare variables
        ObservableList<HappinessReport> searchedList = FXCollections.observableArrayList();
        String filename = "2019";
        final ObservableList<HappinessReport> data = FXCollections.observableArrayList(HappinessReport.loadEntries(filename));

        // Linear search
        for (HappinessReport test: data) {
            if (test.getCountry().contains(searchitem)) {
                searchedList.add(test);
            }
        }
        // Return the list
        return searchedList;
    }

    public static ObservableList<Double> grabAllScores(ObservableList<HappinessReport> data) {
        ObservableList<Double> temp = FXCollections.observableArrayList();
        for (HappinessReport test : data) {
            temp.add(test.getScore());
        }
        return temp;
    }
//Data Summary Methods

    public static String[] getDataSummary(ObservableList<HappinessReport> data) {
        ObservableList<Double> temp = grabAllScores(data);
        mergesort(temp);
        String[] SummaryData = new String[6];
        int intcount = 0;
        double dblmax = 0.0;
        double dblmin = 0.0;
        double dblaverageScore = 0.0;
        double dblmedianScore = 0.0;
        double dbldeviationScore = 0.0;
        double dbltotal = 0;
        // Get Count
        intcount = temp.size();
        //System.out.println(intcount);
        // Get Total
        for (int intx = 0; intx < intcount; intx++) {
            dbltotal = dbltotal + temp.get(intx);
        }
        //Get Min & Max
        dblmin = temp.get(intcount - 1);
        dblmax = temp.get(0);
        // Get Average
        dblaverageScore = dbltotal / intcount;
        dblaverageScore = Math.round(dblaverageScore * 100.0) / 100.0;
        // Get Median
        // Odd & Even Case
        if (intcount % 2 != 0) {
            dblmedianScore = temp.get((intcount - 1) / 2);
        } else {
            dblmedianScore = temp.get((intcount - 1) / 2) + temp.get(((intcount - 1) / 2) - 1);
            dblmedianScore = dblmedianScore / 2;
        }
        dblmedianScore = Math.round(dblmedianScore * 100.0) / 100.0;
        // Get Standard Deviation
        for (int intx = 0; intx < intcount; intx++) {
            dbldeviationScore = dbldeviationScore + Math.pow(temp.get(intx) - dblaverageScore, 2);
        }
        dbldeviationScore = dbldeviationScore / intcount;
        dbldeviationScore = Math.sqrt(dbldeviationScore);
        dbldeviationScore = Math.round(dbldeviationScore * 100.0) / 100.0;

        SummaryData[0] = String.valueOf(intcount);
        SummaryData[1] = String.valueOf(dblmax);
        SummaryData[2] = String.valueOf(dblmin);
        SummaryData[3] = String.valueOf(dblaverageScore);
        SummaryData[4] = String.valueOf(dblmedianScore);
        SummaryData[5] = String.valueOf(dbldeviationScore);
        return SummaryData;
    }

    // Mergesort Method (Using CodeHS method)
    private static ObservableList<Double> mergesort(ObservableList<Double> temp) {
        ObservableList<Double> sortingarray = FXCollections.observableArrayList(temp);
        mergeSortHelper(sortingarray, 0, temp.size() - 1);
        return sortingarray;
    }

    private static void mergeSortHelper(ObservableList<Double> sortingarray, int from, int to) {
        if (to - from >= 1)
        {
            int mid = (from + to) / 2;
            mergeSortHelper(sortingarray, from, mid);
            mergeSortHelper(sortingarray, mid + 1, to);
            merge(sortingarray, from, mid, to);
        }
    }

    private static void merge(ObservableList<Double> sortingarray, int from, int mid, int to) {
        int lefttracker = from;
        int righttracker = mid + 1;
        int temptracker = from;

        while (lefttracker <= mid && righttracker <= to) {
            if (sortingarray.get(temptracker) > sortingarray.get(righttracker)) {
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
