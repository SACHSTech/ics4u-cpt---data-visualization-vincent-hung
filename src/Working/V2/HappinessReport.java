package CPT;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

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
}
