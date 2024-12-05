package task1;

import java.util.Scanner;
import java.util.InputMismatchException; // InputMismatchException to handle invalid input

public class Task1 {

    public static void main(String[] args) {
        // populate collection with data form txt file
        SuperbowlCollection collection = new SuperbowlCollection();
        collection.loadSuperbowls("src/task1/superbowls.txt");

        Scanner scanner = new Scanner(System.in);
        int choice;
        
        // main loop for chooseing the actions
        do {
            System.out.println("-----------------------");
            System.out.println("NFL Superbowls menu");
            System.out.println("-----------------------");
            System.out.println("list..................1");
            System.out.println("select................2");
            System.out.println("Search................3");
            System.out.println("Exit..................0");
            System.out.println("-----------------------");
            System.out.print("Enter choice: > ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                   // List Superbowls within a year range
                   collection.printSuperbowlsTable();
                   break;
                case 2:
                    // Select a Superbowl by year
                    System.out.print("Enter championship year > ");
                    int year = scanner.nextInt();
                    Superbowl superbowl = collection.getSuperbowlByYear(year);
                    if (superbowl != null) {
                        System.out.println(superbowl.toString());
                    } else {
                        System.out.println("No Superbowl found for the year " + year + ". Please try again.");
                    }
                    break;
                case 3:
                    // Search for a Superbowl
                    searchSuperbowls(collection, scanner);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }

    // Search for a Superbowl by team or state used in case 3
    private static void searchSuperbowls(SuperbowlCollection collection, Scanner scanner) {
        int searchChoice;
        do {
            System.out.println("-----------------------");
            System.out.println("Search superbowls by:");
            System.out.println("-----------------------");
            System.out.println("Team .................1");
            System.out.println("State.................2");
            System.out.println("Main menu.............0");
            System.out.println("-----------------------");
            System.out.print("Enter choice: > ");

            try {
                searchChoice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (searchChoice) {
                    case 1:
                        // Search by team
                        System.out.print("Enter search term for NFL team (e.g., Giants) > ");
                        String team = scanner.nextLine();
                        collection.searchByTeam(team);
                        break;
                    case 2:
                        // Search by state
                        System.out.print("Enter search term for U.S. state (e.g., Florida) > ");
                        String state = scanner.nextLine();
                        collection.searchByState(state);
                        break;
                    case 0:
                        // Return to main menu
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume the invalid input
                searchChoice = -1; // set to an invalid choice to continue the loop
            }
        } while (searchChoice != 0);
    }
}
