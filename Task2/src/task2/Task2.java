package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException; // InputMismatchException to handle invalid input


public class Task2 {

    public static void main(String[] args) {
        // "pre-loaded" data section

        //Create Ports
        Port Barcelona = new Port("Barcelona");
        Port Rome = new Port("Rome");
        Port Athens = new Port("Athens");
        
        // Create ships
        Ship ship1 = new Ship("Mediterranean Explorer");
        Ship ship2 = new Ship("Adriatic Adventure");
        Ship ship3 = new Ship("Blue Ocean");
        Ship ship4 = new Ship("Markus Aurelius");
        Ship ship5 = new Ship("Alexander the Great");
        Ship ship6 = new Ship("Manta Ray");

        // Create 32 cabins
        Cabin suite1 = new Suite(101, true);
        Cabin suite2 = new Suite(102, false);
        Cabin standardCabin1 = new StandardCabin(201, true);
        Cabin standardCabin2 = new StandardCabin(202, false);
        Cabin suite3 = new Suite(103, true);
        Cabin suite4 = new Suite(104, false);
        Cabin standardCabin3 = new StandardCabin(203, true);
        Cabin standardCabin4 = new StandardCabin(204, false);

        // Add cabins to ships
        for (Cabin cabin : Arrays.asList(suite1, suite2, standardCabin1, standardCabin2, suite3, suite4, standardCabin3, standardCabin4)) {
            ship1.addCabin(cabin);
        }
        for (Cabin cabin : Arrays.asList(suite1, suite2, standardCabin1, standardCabin2, suite3, suite4, standardCabin3, standardCabin4)) {
            ship2.addCabin(cabin);
        }
        for (Cabin cabin : Arrays.asList(suite1, suite2, standardCabin1, standardCabin2, suite3, suite4, standardCabin3, standardCabin4)) {
            ship3.addCabin(cabin);
        }
        for (Cabin cabin : Arrays.asList(suite1, suite2, standardCabin1, standardCabin2, suite3, suite4, standardCabin3, standardCabin4)) {
            ship4.addCabin(cabin);
        }
        for (Cabin cabin : Arrays.asList(suite1, suite2, standardCabin1, standardCabin2, suite3, suite4, standardCabin3, standardCabin4)) {
            ship5.addCabin(cabin);
        }
        for (Cabin cabin : Arrays.asList(suite1, suite2, standardCabin1, standardCabin2, suite3, suite4, standardCabin3, standardCabin4)) {
            ship6.addCabin(cabin);
        }

        // Create excursions
        Excursion excursion1 = new Excursion(Barcelona, "Monday", 10);
        Excursion excursion2 = new Excursion(Rome, "Wednesday", 6);
        Excursion excursion3 = new Excursion(Athens, "Friday", 8);
        Excursion excursion4 = new Excursion(Barcelona, "Tuesday", 12);
        Excursion excursion5 = new Excursion(Barcelona, "Thursday", 12);
        

        // Create cruises
        Cruise cruise1 = new Cruise(ship1);
        Cruise cruise2 = new Cruise(ship2);
        Cruise cruise3 = new Cruise(ship3);
        Cruise cruise4 = new Cruise(ship4);
        Cruise cruise5 = new Cruise(ship5);
        Cruise cruise6 = new Cruise(ship6);

        // Create passengers and assign them to cruses and cabins
        List<Passenger> passengers = new ArrayList<>();
        int passengerCount = 1;

        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Brown", "Williams", "Jones", "Garcia", "Miller", "Davis", "Rodriguez"};

        Random random = new Random();

        Cruise[] cruises = {cruise1, cruise2, cruise3, cruise4, cruise5, cruise6};
        Cabin[] cabins = {suite1, suite2, standardCabin1, standardCabin2, suite3, suite4, standardCabin3, standardCabin4};

        int cruiseIndex = 0;
        for (Cabin cabin : cabins) {
            int maxPassengers = cabin instanceof Suite ? 4 : 6;
            for (int i = 0; i < maxPassengers && passengerCount <= 100; i++) {
                String firstName = firstNames[random.nextInt(firstNames.length)];
                String lastName = lastNames[random.nextInt(lastNames.length)];
                String fullName = firstName + " " + lastName;
                Cruise cruise = cruises[cruiseIndex];
                Passenger passenger = new Passenger(fullName, cabin, cruise);
                cruise.addPassenger(passenger);
                passengers.add(passenger);
                passengerCount++;
                cruiseIndex = (cruiseIndex + 1) % cruises.length; // Move to the next cruise
            }
        }

        // Add excursions to cruises
        cruise1.addExcursion(excursion1);
        cruise1.addExcursion(excursion2);
        cruise2.addExcursion(excursion3);
        cruise3.addExcursion(excursion4);
        cruise3.addExcursion(excursion1);
        cruise4.addExcursion(excursion2);
        cruise4.addExcursion(excursion5);
        cruise5.addExcursion(excursion3);
        cruise6.addExcursion(excursion2);
       
        Scanner scanner = new Scanner(System.in);
        int choice;
        // main loop for chooseing the actions
        do {
            
            System.out.println("--------------------------");
            System.out.println("Cruises:");
            System.out.println("--------------------------");
            System.out.println("Mediterranean Explorer...1");
            System.out.println("Adriatic Adventure.......2");
            System.out.println("Blue Ocean...............3");
            System.out.println("Markus Aurelius..........4");
            System.out.println("Alexander the Great......5");
            System.out.println("Manta Ray................6");
            System.out.println("Exit.....................0");
            System.out.println("--------------------------");
            System.out.print("Enter choice: > ");

           try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline
                switch (choice) {
                    case 1:
                     
                       break;
                    case 2:
                        
                        break;
                    case 3:
                       
                        break;
                    case 4:

                        break;
                    case 5:

                        break;
                    case 6:

                        break;
                    case 0:
                        System.out.println("Exiting...");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // consume the invalid input
                choice = -1; // set to an invalid choice to continue the loop
            }
        } while (choice != 0);

        scanner.close();
    }
}