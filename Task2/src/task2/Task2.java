package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


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
        Cabin suite5 = new Suite(105, true);
        Cabin suite6 = new Suite(106, false);
        Cabin standardCabin5 = new StandardCabin(205, true);
        Cabin standardCabin6 = new StandardCabin(206, false);

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
        Excursion excursion1 = new Excursion(Barcelona, "Monday");
        Excursion excursion2 = new Excursion(Rome, "Wednesday");
        Excursion excursion3 = new Excursion(Athens, "Friday");

        // Create cruises
        Cruise cruise1 = new Cruise(ship1);
        Cruise cruise2 = new Cruise(ship2);
        Cruise cruise3 = new Cruise(ship3);
        Cruise cruise4 = new Cruise(ship4);
        Cruise cruise5 = new Cruise(ship5);
        Cruise cruise6 = new Cruise(ship6);

        // Create passengers
        List<Passenger> passengers = new ArrayList<>();
        int passengerCount = 1;

        String[] firstNames = {"John", "Jane", "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Hank"};
        String[] lastNames = {"Doe", "Smith", "Johnson", "Brown", "Williams", "Jones", "Garcia", "Miller", "Davis", "Rodriguez"};

        Random random = new Random();

        Cruise[] cruises = {cruise1, cruise2, cruise3, cruise4, cruise5, cruise6};
        Cabin[] cabins = {suite1, suite2, standardCabin1, standardCabin2, suite3, suite4, standardCabin3, standardCabin4};

        for (Cruise cruise : cruises) {
            for (Cabin cabin : cabins) {
                int maxPassengers = cabin instanceof Suite ? 4 : 6;
                for (int i = 0; i < maxPassengers && passengerCount <= 100; i++) {
                    String firstName = firstNames[random.nextInt(firstNames.length)];
                    String lastName = lastNames[random.nextInt(lastNames.length)];
                    String fullName = firstName + " " + lastName;
                    Passenger passenger = new Passenger(fullName, cabin, cruise);
                    cruise.addPassenger(passenger);
                    passengers.add(passenger);
                    passengerCount++;
                }
            }
        }



        // Add excursions to cruises
        cruise1.addExcursion(excursion1);
        cruise1.addExcursion(excursion2);
        cruise2.addExcursion(excursion3);


        // Print out the data
        System.out.println("Cruise 1:");
        System.out.println(cruise1);
        System.out.println("Cruise 2:");
        System.out.println(cruise2);
        
        
    }   
}