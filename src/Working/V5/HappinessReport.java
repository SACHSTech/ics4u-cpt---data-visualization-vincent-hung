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
    public ObservableList<HappinessReport> search(String searchitem, ObservableList<HappinessReport> data) {
        // Declare variables
        ObservableList<HappinessReport> searchedList = FXCollections.observableArrayList();

        // Linear search
        for (HappinessReport test: data) {
            if (test.getCountry().contains(searchitem)) {
                searchedList.add(test);
            }
        }
        // Return the list
        return searchedList;
    }
}
