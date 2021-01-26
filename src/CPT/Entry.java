package CPT;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Entry {
    private String strCountry;
    private Double dblScore;
    private Double dblSocial;
    private Double dblLifeExpectancy;
    private Double dblFreedom;
    private Double dblGenerosity;
    private Double dblCorruption;

    public Entry(double givenScore, String givenCountry, double givenSocial, double givenExpectancy,
            double givenFreedom, double givenGenerosity, double givenCorruption) {
        this.dblScore = givenScore;
        this.strCountry = givenCountry;
        this.dblSocial = givenSocial;
        this.dblLifeExpectancy = givenExpectancy;
        this.dblFreedom = givenFreedom;
        this.dblGenerosity = givenGenerosity;
        this.dblCorruption = givenCorruption;

    }

    public String getCountry() {
        return strCountry;
    }

    public Double getScore() {
        return dblScore;
    }

    public Double getSocial() {
        return dblSocial;
    }

    public Double getExpectancy() {
        return dblLifeExpectancy;
    }

    public Double getFreedom() {
        return dblFreedom;
    }

    public Double getGenerosity() {
        return dblGenerosity;
    }

    public Double getCorruption() {
        return dblCorruption;
    }

    public void setCountry(String strchange) {
        this.strCountry = strchange;
    }

    public void setScore(Double strchange) {
        this.dblScore = strchange;
    }

    public void setSocial(Double strchange) {
        this.dblSocial = strchange;
    }

    public void setExpectancy(Double strchange) {
        this.dblLifeExpectancy = strchange;
    }

    public void setFreedom(Double strchange) {
        this.dblFreedom = strchange;
    }

    public void setGenerosity(Double strchange) {
        this.dblGenerosity = strchange;
    }

    public void setCorruption(Double strchange) {
        this.dblCorruption = strchange;
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
