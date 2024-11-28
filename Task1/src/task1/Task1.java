package task1;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        SuperbowlCollection collection = new SuperbowlCollection();
        collection.loadSuperbowls("src/task1/superbowls.txt");

        Scanner scanner = new Scanner(System.in);
        int choice;

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
                        System.out.println(superbowl.toDetailedString());
                    } else {
                        System.out.println("No Superbowl found for the year " + year + ". Please try again.");
                    }
                    break;
                case 3:
                    // Search for a Superbowl (implementation needed)
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
}