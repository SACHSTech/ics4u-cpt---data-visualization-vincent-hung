package CPT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Entry {
    private StringProperty strCountry;
    private DoubleProperty dblScore;
    private DoubleProperty dblSocial;
    private DoubleProperty dblLifeExpectancy;
    private DoubleProperty dblFreedom;
    private DoubleProperty dblGenerosity;
    private DoubleProperty dblCorruption;

    public Entry(double givenScore, String givenCountry, double givenSocial, double givenExpectancy,
            double givenFreedom, double givenGenerosity, double givenCorruption) {
        this.dblScore = new SimpleDoubleProperty(givenScore);
        this.strCountry = new SimpleStringProperty(givenCountry);
        this.dblSocial = new SimpleDoubleProperty(givenSocial);
        this.dblLifeExpectancy = new SimpleDoubleProperty(givenExpectancy);
        this.dblFreedom = new SimpleDoubleProperty(givenFreedom);
        this.dblGenerosity = new SimpleDoubleProperty(givenGenerosity);
        this.dblCorruption = new SimpleDoubleProperty(givenCorruption);

    }

    public StringProperty getCountry() {
        return strCountry;
    }

    public DoubleProperty getScore() {
        return dblScore;
    }

    public DoubleProperty getSocial() {
        return dblSocial;
    }

    public DoubleProperty getExpectancy() {
        return dblLifeExpectancy;
    }

    public DoubleProperty getFreedom() {
        return dblFreedom;
    }

    public DoubleProperty getGenerosity() {
        return dblGenerosity;
    }

    public DoubleProperty getCorruption() {
        return dblCorruption;
    }

    public void setCountry(String strchange) {
        this.strCountry = new SimpleStringProperty(strchange);
    }

    public void setScore(Double strchange) {
        this.dblScore = new SimpleDoubleProperty(strchange);
    }

    public void setSocial(Double strchange) {
        this.dblSocial = new SimpleDoubleProperty(strchange);
    }

    public void setExpectancy(Double strchange) {
        this.dblLifeExpectancy = new SimpleDoubleProperty(strchange);
    }

    public void setFreedom(Double strchange) {
        this.dblFreedom = new SimpleDoubleProperty(strchange);
    }

    public void setGenerosity(Double strchange) {
        this.dblGenerosity = new SimpleDoubleProperty(strchange);
    }

    public void setCorruption(Double strchange) {
        this.dblCorruption = new SimpleDoubleProperty(strchange);
    }

    public static ArrayList<Entry> loadEntries(String filename) {
            ArrayList<Entry> EntryList = new ArrayList<>();
            String strread;
        try {
            BufferedReader fr = new BufferedReader(new FileReader("src/CPT/" + filename + ".csv"));
            while ((strread = fr.readLine()) != null) {
                String[] EntrySplit = strread.split(",");
                
                Entry loader = new Entry(0.0,strread, 0.0, 0.0, 0.0, 0.0, 0.0);

                loader.setScore(Double.parseDouble(EntrySplit[0]));
                loader.setCountry(EntrySplit[1]);
                loader.setSocial(Double.parseDouble(EntrySplit[2]));
                loader.setExpectancy(Double.parseDouble(EntrySplit[3]));
                loader.setFreedom(Double.parseDouble(EntrySplit[4]));
                loader.setGenerosity(Double.parseDouble(EntrySplit[5]));
                loader.setCorruption(Double.parseDouble(EntrySplit[6]));

                EntryList.add(loader);
            }
                fr.close();
        } catch (IOException e) {
            //Catch Statement
            e.printStackTrace();
            System.out.println("Error at Entry.loadEntries");
        }
    return EntryList;
    }
}
