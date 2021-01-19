package CPT.Class;

public class Entry {
    private String strCountry;
    private double dblScore;
    private double dblSocial;
    private double dblLifeExpectancy;
    private double dblFreedom;
    private double dblGenerosity;
    private double dblCorruption;

    public Entry(String givenCountry, double givenScore, double givenSocial, double givenExpectancy, double givenFreedom, double givenGenerosity, double givenCorruption){
        this.strCountry = givenCountry;
        this.dblScore = givenScore;
        this.dblSocial = givenSocial;
        this.dblLifeExpectancy = givenExpectancy;
        this.dblFreedom = givenFreedom;
        this.dblGenerosity = givenGenerosity;
        this.dblCorruption = givenCorruption;

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
}
