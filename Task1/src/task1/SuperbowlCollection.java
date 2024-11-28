package task1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException; // InputMismatchException to handle invalid input

public class SuperbowlCollection {
    private List<Superbowl> superbowls;

    public SuperbowlCollection() {
        superbowls = new ArrayList<>();
    }

    // read the Superbowl data from the file and store it in the list
    public void loadSuperbowls(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                int year = Integer.parseInt(parts[0].substring(0, 4));
                String date = parts[0].substring(5);
                String superbowlNumber = parts[1];
                String winningTeam = parts[2];
                int winningPoints = Integer.parseInt(parts[3]);
                String losingTeam = parts[4];
                int losingPoints = Integer.parseInt(parts[5]);
                String mvp = parts[6];
                String stadium = parts[7];
                String city = parts[8];
                String state = parts[9];
                Superbowl superbowl = new Superbowl(year, date, superbowlNumber, winningTeam, winningPoints, losingTeam, losingPoints, mvp, stadium, city, state);
                superbowls.add(superbowl);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // get the list of Superbowls
    public List<Superbowl> getSuperbowls() {
        return superbowls;
    }

    // get a Superbowl by year (Select functionality)
    public Superbowl getSuperbowlByYear(int year) {
        for (Superbowl superbowl : superbowls) {
            if (superbowl.getYear() == year) {
                return superbowl;
            }
        }
        return null; // Return null if no Superbowl is found for the given year
    }

     // get a list of Superbowls within a specified year range (Search functionality)
     public List<Superbowl> getSuperbowlsByYearRange(int startYear, int endYear) {
        List<Superbowl> filteredSuperbowls = new ArrayList<>();
        int minYear = superbowls.get(0).getYear();
        int maxYear = superbowls.get(superbowls.size() - 1).getYear();

        if (startYear < minYear || endYear > maxYear) {
            System.out.println("Please enter years within the range " + minYear + " to " + maxYear + ".");
            return filteredSuperbowls;
        }

        for (Superbowl superbowl : superbowls) {
            if (superbowl.getYear() >= startYear && superbowl.getYear() <= endYear) {
                filteredSuperbowls.add(superbowl);
            }
        }
        return filteredSuperbowls;
    }

    // print the table of Superbowls within a specified year range
    public void printSuperbowlsTable() {
        Scanner scanner = new Scanner(System.in);
        int startYear = 0, endYear = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Enter start year > ");
                startYear = scanner.nextInt();
                System.out.print("Enter end year > ");
                endYear = scanner.nextInt();

                List<Superbowl> superbowlsInRange = getSuperbowlsByYearRange(startYear, endYear);
                if (superbowlsInRange.isEmpty()) {
                    // The message is already printed in getSuperbowlsByYearRange
                } else {
                    validInput = true;
                    System.out.println("----------------------------------------------------------------------");
                    System.out.println("| Year | Superbowl No. | Champions            | Runners-up           |");
                    System.out.println("----------------------------------------------------------------------");
                    for (Superbowl superbowl : superbowlsInRange) {
                        System.out.println(superbowl);
                    }
                    System.out.println("----------------------------------------------------------------------");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid year.");
                scanner.next(); // Clear the invalid input
            }
        }
    }
}    