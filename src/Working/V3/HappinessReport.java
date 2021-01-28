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
 
    private IntegerProperty intRanking;
    private StringProperty strCountry;
    private DoubleProperty dblScore;
    private DoubleProperty dblGDP;
    private DoubleProperty dblSocial;
    private DoubleProperty dblLifeExpectancy;
    private DoubleProperty dblFreedom;
    private DoubleProperty dblGenerosity;
    private DoubleProperty dblCorruption;
 
    public HappinessReport(int givenRanking, String givenCountry, double givenScore, double givenGDP, double givenSocial, double givenExpectancy,
    double givenFreedom, double givenGenerosity, double givenCorruption) {
        this.intRanking = new SimpleIntegerProperty(givenRanking);
        this.strCountry = new SimpleStringProperty(givenCountry);
        this.dblScore = new SimpleDoubleProperty(givenScore);
        this.dblGDP = new SimpleDoubleProperty(givenGDP);
        this.dblSocial = new SimpleDoubleProperty(givenSocial);
        this.dblLifeExpectancy = new SimpleDoubleProperty(givenExpectancy);
        this.dblFreedom = new SimpleDoubleProperty(givenFreedom);
        this.dblGenerosity = new SimpleDoubleProperty(givenGenerosity);
        this.dblCorruption = new SimpleDoubleProperty(givenCorruption);
    }
    
    //All Getter Methods for Constructor
    public IntegerProperty intRankingProperty() {
        return intRanking;
    }

    public StringProperty strCountryProperty() {
        return strCountry;
    }

    public DoubleProperty dblScoreProperty(){
        return dblScore;
    }

    public DoubleProperty dblGDPProperty() {
        return dblGDP;
    }

    public DoubleProperty dblSocialProperty() {
        return dblSocial;
    }

    public DoubleProperty dblLifeExpectancyProperty() {
        return dblLifeExpectancy;
    }

    public DoubleProperty dblFreedomProperty() {
        return dblFreedom;
    }

    public DoubleProperty dblGenerosityProperty() {
        return dblGenerosity;
    }

    public DoubleProperty dblCorruptionProperty() {
        return dblCorruption;
    }

    //All Setter Methods for Constructor
    public void setRanking(int change) {
        this.intRanking = new SimpleIntegerProperty(change);
    }

    public void setCountry(String change) {
        this.strCountry = new SimpleStringProperty(change);
    }

    public void setScore(Double change) {
        this.dblScore = new SimpleDoubleProperty(change);
    }

    public void setGDP(Double change) {
        this.dblGDP = new SimpleDoubleProperty(change);
    }

    public void setSocial(Double change) {
        this.dblSocial = new SimpleDoubleProperty(change);
    }

    public void setExpectancy(Double change) {
        this.dblLifeExpectancy = new SimpleDoubleProperty(change);
    }

    public void setFreedom(Double change) {
        this.dblFreedom = new SimpleDoubleProperty(change);
    }

    public void setGenerosity(Double change) {
        this.dblGenerosity = new SimpleDoubleProperty(change);
    }

    public void setCorruption(Double change) {
        this.dblCorruption = new SimpleDoubleProperty(change);
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
}
