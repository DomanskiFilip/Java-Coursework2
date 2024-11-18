package task1;

public class Superbowl {
    // data
    private final int year;
    private final String date;
    private final String superbowlNumber; // roman numerals
    private final String winningTeam;
    private final int winningPoints;
    private final String losingTeam;
    private final int losingPoints;
    private final String mvp;
    private final String stadium;
    private final String city;
    private final String state;

    public Superbowl(int year, String date, String superbowlNumber, String winningTeam, int winningPoints, String losingTeam, int losingPoints, String mvp, String stadium, String city, String state) {
        this.year = year;
        this.date = date;
        this.superbowlNumber = superbowlNumber;
        this.winningTeam = winningTeam;
        this.winningPoints = winningPoints;
        this.losingTeam = losingTeam;
        this.losingPoints = losingPoints;
        this.mvp = mvp;
        this.stadium = stadium;
        this.city = city;
        this.state = state;
    }
    
    
    
}
