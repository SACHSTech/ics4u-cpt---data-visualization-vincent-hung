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
    /**
     * The HappinessReport class file
     * 
     * @author V.Hung
     * 
     * 
     */
public class HappinessReport {
    //Instance Variables
    private int intRanking;
    private String strCountry;
    private double dblScore;
    private double dblGDP;
    private double dblSocial;
    private double dblLifeExpectancy;
    private double dblFreedom;
    private double dblGenerosity;
    private double dblCorruption;

    /**
     * Constructor - Create a Happiness Report instance
     * 
     * @param intRanking - Ranking
     * @param strCountry - Country
     * @param dblScore - Score
     * @param dblGDP - GDP
     * @param dblSocial - Social Score
     * @param dblExpectancy - Healthy Life Expectancy Score
     * @param dblFreedom - Freedom Score
     * @param dblGenerosity - Generosity Score
     * @param dblCorruption = Government Corruption Score
     * 
     */
    public HappinessReport(int givenRanking, String givenCountry, double givenScore, double givenGDP, double givenSocial, double givenExpectancy, double givenFreedom, double givenGenerosity, double givenCorruption) {
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
    /**
     * Getter method for Ranking
     * 
     * @return Ranking
     */
    //All Get Methods for Constructor
    public int getRanking() {
        return intRanking;
    }

    /**
     * Getter method for Country
     * 
     * @return Country
     */
    public String getCountry() {
        return strCountry;
    }

    /**
     * Getter method for Score
     * 
     * @return Score
     */
    public double getScore() {
        return dblScore;
    }

    /**
     * Getter method for GDP
     * 
     * @return GDP
     */
    public double getGDP() {
        return dblGDP;
    }

    /**
     * Getter method for Social
     * 
     * @return Social
     */
    public double getSocial() {
        return dblSocial;
    }

    /**
     * Getter method for Expectancy
     * 
     * @return Expectancy
     */
    public double getExpectancy() {
        return dblLifeExpectancy;
    }

    /**
     * Getter method for Freedom
     * 
     * @return Freedom
     */
    public double getFreedom() {
        return dblFreedom;
    }

    /**
     * Getter method for Generosity
     * 
     * @return Generosity
     */
    public double getGenerosity() {
        return dblGenerosity;
    }

    /**
     * Getter method for Corruption
     * 
     * @return Corruption
     */
    public double getCorruption() {
        return dblCorruption;
    }

    //All Property Get Methods for Constructor
    /**
     * Getter method for RankingProperty
     * 
     * @return Ranking IntergerProperty
     */
    public IntegerProperty intRankingProperty() {
        return new SimpleIntegerProperty(intRanking);
    }

    /**
     * Getter method for CountryProperty
     * 
     * @return Country StringProperty
     */
    public StringProperty strCountryProperty() {
        return new SimpleStringProperty(strCountry);
    }

    /**
     * Getter method for ScoreProperty
     * 
     * @return Score DoubleProperty
     */
    public DoubleProperty dblScoreProperty() {
        return new SimpleDoubleProperty(dblScore);
    }

    /**
     * Getter method for GDP Property
     * 
     * @return GDP DoubleProperty
     */
    public DoubleProperty dblGDPProperty() {
        return new SimpleDoubleProperty(dblGDP);
    }

    /**
     * Getter method for Social Property
     * 
     * @return Social DoubleProperty
     */
    public DoubleProperty dblSocialProperty() {
        return new SimpleDoubleProperty(dblSocial);
    }

    /**
     * Getter method for Expectancy Property
     * 
     * @return Expectancy DoubleProperty
     */
    public DoubleProperty dblLifeExpectancyProperty() {
        return new SimpleDoubleProperty(dblLifeExpectancy);
    }

    /**
     * Getter method for Freedom Property
     * 
     * @return Freedom DoubleProperty
     */
    public DoubleProperty dblFreedomProperty() {
        return new SimpleDoubleProperty(dblFreedom);
    }

    /**
     * Getter method for Generosity Proprty
     * 
     * @return Generosity DoubleProperty
     */
    public DoubleProperty dblGenerosityProperty() {
        return new SimpleDoubleProperty(dblGenerosity);
    }

    /**
     * Getter method for Corruption Properety
     * 
     * @return Corruption DoubleProperty
     */
    public DoubleProperty dblCorruptionProperty() {
        return new SimpleDoubleProperty(dblCorruption);
    }

    //All Setter Methods for Constructor
    /**
     * Setter method for Ranking
     * 
     * @param change - the change desired
     */
    public void setRanking(int change) {
        this.intRanking = (change);
    }

    /**
     * Setter method for County
     * 
     * @param change - the change desired
     */
    public void setCountry(String change) {
        this.strCountry = change;
    }

    /**
     * Setter method for Score
     * 
     * @param change - the change desired
     */
    public void setScore(Double change) {
        this.dblScore = change;
    }

    /**
     * Setter method for GDP
     * 
     * @param change - the change desired
     */
    public void setGDP(Double change) {
        this.dblGDP = change;
    }

    /**
     * Setter method for Social
     * 
     * @param change - the change desired
     */
    public void setSocial(Double change) {
        this.dblSocial = change;
    }

    /**
     * Setter method for Expectancy
     * 
     * @param change - the change desired
     */
    public void setExpectancy(Double change) {
        this.dblLifeExpectancy = change;
    }

    /**
     * Setter method for Freedom
     * 
     * @param change - the change desired
     */
    public void setFreedom(Double change) {
        this.dblFreedom = change;
    }

    /**
     * Setter method for Generosity
     * 
     * @param change - the change desired
     */
    public void setGenerosity(Double change) {
        this.dblGenerosity = change;
    }

    /**
     * Setter method for Corruption
     * 
     * @param change - the change desired
     */
    public void setCorruption(Double change) {
        this.dblCorruption = change;
    }

    /**
     * toString method for HappinessReport
     * 
     * @return - All object variables seperated on each line
     */
    public String toString() {
        return "\n " + intRanking + "\n " + strCountry + "\n" + dblScore + "\n" + dblGDP + "\n" + dblSocial + "\n" + dblLifeExpectancy + "\n" + dblFreedom + "\n" + dblGenerosity;
    }

    /**
     * loadEntries from csv to ObservableList method for Ranking
     * 
     * @param filename - the filename of the csv file
     * @return - the HappinessReport list 
     * 
     */
    public static ObservableList < HappinessReport > loadEntries(String filename) {
        ObservableList < HappinessReport > HappinessList = FXCollections.observableArrayList();
        String strread;
        try {
            BufferedReader fr = new BufferedReader(new FileReader("src/CPT/" + filename + ".csv"));
            while ((strread = fr.readLine()) != null) {
                String[] FileSplit = strread.split(",");

                HappinessReport loader = new HappinessReport(0, strread, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);

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

    /**
     * search method for HappinessReport lists, employs linear search to find qualifying entries in list
     * 
     * @param searchitem - the string to check whether items contain in Country
     * @return - returns a HappinessReport list that has been searched (Will be smaller than master list)
     */
    public static ObservableList < HappinessReport > search(String searchitem) {
        // Declare variables
        ObservableList < HappinessReport > searchedList = FXCollections.observableArrayList();
        String filename = "2019";
        //load csv to newly created list
        final ObservableList < HappinessReport > data = FXCollections.observableArrayList(HappinessReport.loadEntries(filename));
        searchitem = searchitem.toLowerCase();
        // Linear search
        for (HappinessReport test: data) {
            if (test.getCountry().toLowerCase().contains(searchitem)) {
                searchedList.add(test);
            }
        }
        // Return the list
        return searchedList;
    }

    /**
     * method to load all scores from HappinessReport list into a Double ObservableList
     * 
     * @param data - the given HappinessReport list
     * @return - a Double ObservableList
     */
    public static ObservableList < Double > grabAllScores(ObservableList < HappinessReport > data) {
        ObservableList < Double > temp = FXCollections.observableArrayList();
        for (HappinessReport test: data) {
            temp.add(test.getScore());
        }
        return temp;
    }
    //Data Summary Methods

    /**
     * method to compute data summary of HappinessReport
     * 
     * @param data - the given HappinessReport list
     * @return - a String array that holds the summary data entries in each index
     */
    public static String[] getDataSummary(ObservableList < HappinessReport > data) {
        ObservableList < Double > temp = grabAllScores(data);
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

    // Mergesort Method 
    /**
     * private method that sorts a Double List
     * 
     * @param temp - the Double List to be sorted
     * @return - returns the sorted array
     */
    private static ObservableList < Double > mergesort(ObservableList < Double > temp) {
        ObservableList < Double > sortingarray = FXCollections.observableArrayList(temp);
        mergeSortHelper(sortingarray, 0, temp.size() - 1);
        return sortingarray;
    }

    /**
     * private method to help with mergesort (recursive helper function)
     * 
     * @param sortingarray - the list that is being sorted
     * @param from - the "leftmost" number in the list when sortng
     * @param to - the "rightmost" number in the list when sorting
     */
    private static void mergeSortHelper(ObservableList < Double > sortingarray, int from, int to) {
        if (to - from >= 1) {
            int mid = (from + to) / 2;
            mergeSortHelper(sortingarray, from, mid);
            mergeSortHelper(sortingarray, mid + 1, to);
            merge(sortingarray, from, mid, to);
        }
    }

    /**
     * method to merge to sorted lists back together (where the real sorting happens)
     * 
     * @param sortingarray - the list that is being sorted
     * @param from - staring index of sort algorithim
     * @param to - ending index of sort algorithim
     */
    private static void merge(ObservableList < Double > sortingarray, int from, int mid, int to) {
        //Create Temp Variables
        int lefttracker = from;
        int righttracker = mid + 1;
        int temptracker = from;
        
        // While the left tracker is less than or equal to mid and the right tracker is less than or equal to to,
        while (lefttracker <= mid && righttracker <= to) {
            // If the element in the left subarray is less
            // than the element in the right subarray it 
            // is next in the merged list
            if (sortingarray.get(temptracker) > sortingarray.get(righttracker)) {
                sortingarray.set(temptracker, sortingarray.get(lefttracker));
                lefttracker++;
            } else {
                sortingarray.set(temptracker, sortingarray.get(righttracker));
                righttracker++;
            }
            temptracker++;
        }

        // We may have missed elements from either list adding remaining values
        while (righttracker <= to) {
            sortingarray.set(temptracker, sortingarray.get(righttracker));
            righttracker++;
            temptracker++;
        }


        //for (int intx = from; intx <= to; intx++) {
            //sortingarray.set(intx, sortingarray.get(intx));
        //}
    }
}