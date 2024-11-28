package task1;

public class Superbowl {
    private final int year;
    private final String date;
    private final String superbowlNumber;
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

    public int getYear() {
        return year;
    }

    public String getSuperbowlNumber() {
        return superbowlNumber;
    }

    public String getWinningTeam() {
        return winningTeam;
    }

    public int getWinningPoints() {
        return winningPoints;
    }

    public String getLosingTeam() {
        return losingTeam;
    }

    public int getLosingPoints() {
        return losingPoints;
    }

    public String getMvp() {
        return mvp;
    }

    public String getStadium() {
        return stadium;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return String.format("| %-4d | %-13s | %-20s | %-20s |", year, superbowlNumber, winningTeam, losingTeam);
    }

    public String toDetailedString() {
        StringBuilder sb = new StringBuilder();
        sb.append("------------------------------------------------------------------------------------------\n");
        sb.append("|                                                                                        |\n");
        sb.append(String.format("|                                          Superbowl %-4s                                |\n", superbowlNumber));
        sb.append(String.format("|                           Venue: %-1s in %-1s, %-28s |\n", stadium, city, state));
        sb.append(String.format("|          The %-1s beat the %-1s by %-1d points to %-3d points      |\n", winningTeam, losingTeam, winningPoints, losingPoints));
        sb.append(String.format("|                     The most valuable player award went to %-27s |\n", mvp));
        sb.append("|                                                                                        |\n");
        sb.append("------------------------------------------------------------------------------------------");
        return sb.toString();
    }

    public static void printSuperbowlTableHeader() {
        System.out.println("----------------------------------------------------------------------");
        System.out.println("| Year | Superbowl No. | Champions            | Runners-up           |");
        System.out.println("----------------------------------------------------------------------");
    }

    public static void printSuperbowlTableFooter() {
        System.out.println("----------------------------------------------------------------------");
    }
}
