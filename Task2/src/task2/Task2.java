package task2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.InputMismatchException; // InputMismatchException to handle invalid input
import java.util.Map;
import java.util.stream.Collectors;


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
       

        // create and assign passengers with random names to cruises with hash map allowing to later call individual objects and random
        int cruiseIndex = 0;
        Map<String, Passenger> passengerMap = new HashMap<>();
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
                passengerMap.put("passenger" + passengerCount, passenger);

                // Randomly assign excursions to passengers
                List<Excursion> excursions = cruise.getExcursions();
                for (Excursion excursion : excursions) {
                    if (random.nextBoolean()) { // 50% chance to join each excursion
                        passenger.joinExcursion(excursion);
                    }
                }
                passengerCount++;
            }
            cruiseIndex = (cruiseIndex + 1) % cruises.length; // Move to the next cruise
        }
        
        Scanner scanner = new Scanner(System.in);
        int choice;

         // main loop for choosing the actions
        do {
            System.out.println("--------------------------");
            System.out.println("Main Menu:");
            System.out.println("--------------------------");
            System.out.println("Cruise Information.......1");
            System.out.println("Excursion Information....2");
            System.out.println("Passenger Information....3");
            System.out.println("Booking Excursion........4");
            System.out.println("Change Passenger Cabin...5");
            System.out.println("Exit.....................0");
            System.out.println("--------------------------");
            System.out.print("Enter choice: > ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // consume newline

                switch (choice) {
                    case 1:
                        int cruiseChoice;
                        do {
                            // Display the list of cruises and their detailed info
                            System.out.println("--------------------------");
                            System.out.println("Cruises:");
                            System.out.println("--------------------------");
                            System.out.println("Mediterranean Explorer...1");
                            System.out.println("Adriatic Adventure.......2");
                            System.out.println("Blue Ocean...............3");
                            System.out.println("Markus Aurelius..........4");
                            System.out.println("Alexander the Great......5");
                            System.out.println("Manta Ray................6");
                            System.out.println("Back to Main Menu........0");
                            System.out.println("--------------------------");
                            System.out.print("Enter choice: > ");

                            cruiseChoice = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            switch (cruiseChoice) {
                                case 1:
                                    System.out.println(cruise1.toString());
                                    break;
                                case 2:
                                    System.out.println(cruise2.toString());
                                    break;
                                case 3:
                                    System.out.println(cruise3.toString());
                                    break;
                                case 4:
                                    System.out.println(cruise4.toString());
                                    break;
                                case 5:
                                    System.out.println(cruise5.toString());
                                    break;
                                case 6:
                                    System.out.println(cruise6.toString());
                                    break;
                                case 0:
                                    System.out.println("Returning to Main Menu...");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                        } while (cruiseChoice != 0);
                        break;
                    case 2:
                        // display the list of cruises
                        int selectedCruise;
                        do {
                            System.out.println("--------------------------");
                            System.out.println("Select a Cruise:");
                            System.out.println("--------------------------");
                            System.out.println("Mediterranean Explorer...1");
                            System.out.println("Adriatic Adventure.......2");
                            System.out.println("Blue Ocean...............3");
                            System.out.println("Markus Aurelius..........4");
                            System.out.println("Alexander the Great......5");
                            System.out.println("Manta Ray................6");
                            System.out.println("Back to Main Menu........0");
                            System.out.println("--------------------------");
                            System.out.print("Enter choice: > ");

                            selectedCruise = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            Cruise cruise = null;
                            switch (selectedCruise) {
                                case 1:
                                    cruise = cruise1;
                                    break;
                                case 2:
                                    cruise = cruise2;
                                    break;
                                case 3:
                                    cruise = cruise3;
                                    break;
                                case 4:
                                    cruise = cruise4;
                                    break;
                                case 5:
                                    cruise = cruise5;
                                    break;
                                case 6:
                                    cruise = cruise6;
                                    break;
                                case 0:
                                    System.out.println("Returning to Main Menu...");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                            
                            // display excursions on a selected cruise
                            if (cruise != null) {
                                int selectedExcursion;
                                do {
                                    System.out.println("--------------------------");
                                    System.out.println("Select an Excursion:");
                                    System.out.println("--------------------------");
                                    List<Excursion> excursions = cruise.getExcursions();
                                    for (int i = 0; i < excursions.size(); i++) {
                                        System.out.println(excursions.get(i).getPort().getName() + "..." + (i + 1));
                                    }
                                    System.out.println("Back to Cruise Menu.......0");
                                    System.out.println("--------------------------");
                                    System.out.print("Enter choice: > ");

                                    selectedExcursion = scanner.nextInt();
                                    scanner.nextLine(); // consume newline
                                    
                                    // display informaion about selected excursion useing methods
                                    if (selectedExcursion > 0 && selectedExcursion <= excursions.size()) {
                                        Excursion excursion = excursions.get(selectedExcursion - 1);
                                        System.out.println("Excursion to " + excursion.getPort().getName() + " on " + excursion.getDayOfWeek());
                                        List<Passenger> passengersOnExcursion = cruise.getPassengers().stream()
                                                .filter(p -> p.getExcursions().contains(excursion))
                                                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                                                .collect(Collectors.toList());
                                        System.out.println("Passengers:");
                                        for (Passenger passenger : passengersOnExcursion) {
                                            System.out.println(" - " + passenger.getName());
                                        }
                                    } else if (selectedExcursion != 0) {
                                        System.out.println("Invalid choice. Please try again.");
                                    }
                                } while (selectedExcursion != 0);
                            }
                        } while (selectedCruise != 0);
                        break;
                    case 3:
                        //display list of cruises
                        int selectedCruiseForPassenger;
                        do {
                            System.out.println("--------------------------");
                            System.out.println("Select a Cruise:");
                            System.out.println("--------------------------");
                            System.out.println("Mediterranean Explorer...1");
                            System.out.println("Adriatic Adventure.......2");
                            System.out.println("Blue Ocean...............3");
                            System.out.println("Markus Aurelius..........4");
                            System.out.println("Alexander the Great......5");
                            System.out.println("Manta Ray................6");
                            System.out.println("Back to Main Menu........0");
                            System.out.println("--------------------------");
                            System.out.print("Enter choice: > ");

                            selectedCruiseForPassenger = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            Cruise selectedCruiseObj = null;
                            switch (selectedCruiseForPassenger) {
                                case 1:
                                    selectedCruiseObj = cruise1;
                                    break;
                                case 2:
                                    selectedCruiseObj = cruise2;
                                    break;
                                case 3:
                                    selectedCruiseObj = cruise3;
                                    break;
                                case 4:
                                    selectedCruiseObj = cruise4;
                                    break;
                                case 5:
                                    selectedCruiseObj = cruise5;
                                    break;
                                case 6:
                                    selectedCruiseObj = cruise6;
                                    break;
                                case 0:
                                    System.out.println("Returning to Main Menu...");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }
                            
                            // display list of passengers in selected cruise
                            if (selectedCruiseObj != null) {
                                List<Passenger> passengersOfCruse = selectedCruiseObj.getPassengers().stream()
                                        .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                                        .collect(Collectors.toList());

                                int selectedPassenger;
                                do {
                                    System.out.println("--------------------------");
                                    System.out.println("Select a Passenger:");
                                    System.out.println("--------------------------");
                                    for (int i = 0; i < passengersOfCruse.size(); i++) {
                                        System.out.println(passengersOfCruse.get(i).getName() + "..." + (i + 1));
                                    }
                                    System.out.println("Back to Cruise Menu.......0");
                                    System.out.println("--------------------------");
                                    System.out.print("Enter choice: > ");

                                    selectedPassenger = scanner.nextInt();
                                    scanner.nextLine(); // consume newline
                                    
                                    // display information about selected passenger
                                    if (selectedPassenger > 0 && selectedPassenger <= passengersOfCruse.size()) {
                                        Passenger passenger = passengersOfCruse.get(selectedPassenger - 1);
                                        System.out.println("Passenger Name: " + passenger.getName());
                                        System.out.println("Cabin Number: " + passenger.getCabin().getCabinNumber());
                                        System.out.println("Cabin Type: " + passenger.getCabin().isSuite());

                                        List<Passenger> cabinMates = selectedCruiseObj.getPassengers().stream()
                                                .filter(p -> p.getCabin().equals(passenger.getCabin()) && !p.equals(passenger))
                                                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                                                .collect(Collectors.toList());

                                        if (cabinMates.isEmpty()) {
                                            System.out.println("Not sharing the cabin with anyone.");
                                        } else {
                                            System.out.println("Sharing cabin with:");
                                            for (Passenger cabinMate : cabinMates) {
                                                System.out.println(" - " + cabinMate.getName());
                                            }
                                        }

                                        List<Excursion> passengerExcursions = passenger.getExcursions();
                                        if (passengerExcursions.isEmpty()) {
                                            System.out.println("No excursions booked.");
                                        } else {
                                            System.out.println("Excursions booked:");
                                            for (Excursion excursion : passengerExcursions) {
                                                System.out.println(" - " + excursion.getPort().getName() + " on " + excursion.getDayOfWeek());
                                            }
                                        }
                                    } else if (selectedPassenger != 0) {
                                        System.out.println("Invalid choice. Please try again.");
                                    }
                                } while (selectedPassenger != 0);
                            }
                        } while (selectedCruiseForPassenger != 0);
                        break;
                    case 4:
                        // display a list of cruises
                        int selectedCruiseIndex;
                        do {
                            System.out.println("--------------------------");
                            System.out.println("Select a Cruise:");
                            System.out.println("--------------------------");
                            System.out.println("Mediterranean Explorer...1");
                            System.out.println("Adriatic Adventure.......2");
                            System.out.println("Blue Ocean...............3");
                            System.out.println("Markus Aurelius..........4");
                            System.out.println("Alexander the Great......5");
                            System.out.println("Manta Ray................6");
                            System.out.println("Back to Main Menu........0");
                            System.out.println("--------------------------");
                            System.out.print("Enter choice: > ");

                            selectedCruiseIndex = scanner.nextInt();
                            scanner.nextLine(); // consume newline

                            Cruise selectedCruiseForBooking = null;
                            switch (selectedCruiseIndex) {
                                case 1:
                                    selectedCruiseForBooking = cruise1;
                                    break;
                                case 2:
                                    selectedCruiseForBooking = cruise2;
                                    break;
                                case 3:
                                    selectedCruiseForBooking = cruise3;
                                    break;
                                case 4:
                                    selectedCruiseForBooking = cruise4;
                                    break;
                                case 5:
                                    selectedCruiseForBooking = cruise5;
                                    break;
                                case 6:
                                    selectedCruiseForBooking = cruise6;
                                    break;
                                case 0:
                                    System.out.println("Returning to Main Menu...");
                                    break;
                                default:
                                    System.out.println("Invalid choice. Please try again.");
                            }

                            // display a list of passengers on selected cruise
                            if (selectedCruiseForBooking != null) {
                                List<Passenger> passengersForBooking = selectedCruiseForBooking.getPassengers().stream()
                                        .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                                        .collect(Collectors.toList());

                                int selectedPassengerIndex;
                                do {
                                    System.out.println("--------------------------");
                                    System.out.println("Select a Passenger:");
                                    System.out.println("--------------------------");
                                    for (int i = 0; i < passengersForBooking.size(); i++) {
                                        System.out.println(passengersForBooking.get(i).getName() + "..." + (i + 1));
                                    }
                                    System.out.println("Back to Cruise Menu.......0");
                                    System.out.println("--------------------------");
                                    System.out.print("Enter choice: > ");

                                    selectedPassengerIndex = scanner.nextInt();
                                    scanner.nextLine(); // consume newline

                                    // display what excursions if any are avaliable for this passenger and allow to book it
                                    if (selectedPassengerIndex > 0 && selectedPassengerIndex <= passengersForBooking.size()) {
                                        Passenger passenger = passengersForBooking.get(selectedPassengerIndex - 1);
                                        List<Excursion> availableExcursions = selectedCruiseForBooking.getExcursions().stream()
                                                .filter(excursion -> !passenger.getExcursions().contains(excursion))
                                                .collect(Collectors.toList());

                                        if (availableExcursions.isEmpty()) {
                                            System.out.println("No available excursions for this passenger.");
                                        } else {
                                            int selectedExcursionIndex;
                                            do {
                                                System.out.println("--------------------------");
                                                System.out.println("Select an Excursion:");
                                                System.out.println("--------------------------");
                                                for (int i = 0; i < availableExcursions.size(); i++) {
                                                    Excursion excursion = availableExcursions.get(i);
                                                    System.out.println(excursion.getPort().getName() + " on " + excursion.getDayOfWeek() + " (" + excursion.getSpace() + " spaces available)..." + (i + 1));
                                                }
                                                System.out.println("Cancel....................0");
                                                System.out.println("--------------------------");
                                                System.out.print("Enter choice: > ");

                                                selectedExcursionIndex = scanner.nextInt();
                                                scanner.nextLine(); // consume newline

                                                if (selectedExcursionIndex > 0 && selectedExcursionIndex <= availableExcursions.size()) {
                                                    Excursion excursion = availableExcursions.get(selectedExcursionIndex - 1);
                                                    passenger.joinExcursion(excursion);
                                                    System.out.println("Booking confirmed for " + excursion.getPort().getName() + " on " + excursion.getDayOfWeek() + ".");
                                                    // go back after booking is confirmed
                                                    selectedExcursionIndex = 0;
                                                } else if (selectedExcursionIndex != 0) {
                                                    System.out.println("Invalid choice. Please try again.");
                                                }
                                            } while (selectedExcursionIndex != 0);
                                        }
                                    } else if (selectedPassengerIndex != 0) {
                                        System.out.println("Invalid choice. Please try again.");
                                    }
                                } while (selectedPassengerIndex != 0);
                            }
                        } while (selectedCruiseIndex != 0);
                        break;
                    case 5:
                    // display list of cruises
                    int selectedCruiseIndexForCabinChange;
                    do {
                        System.out.println("--------------------------");
                        System.out.println("Select a Cruise:");
                        System.out.println("--------------------------");
                        System.out.println("Mediterranean Explorer...1");
                        System.out.println("Adriatic Adventure.......2");
                        System.out.println("Blue Ocean...............3");
                        System.out.println("Markus Aurelius..........4");
                        System.out.println("Alexander the Great......5");
                        System.out.println("Manta Ray................6");
                        System.out.println("Back to Main Menu........0");
                        System.out.println("--------------------------");
                        System.out.print("Enter choice: > ");
                
                        selectedCruiseIndexForCabinChange = scanner.nextInt();
                        scanner.nextLine(); // consume newline
                
                        Cruise selectedCruiseForCabinChange = null;
                        switch (selectedCruiseIndexForCabinChange) {
                            case 1:
                                selectedCruiseForCabinChange = cruise1;
                                break;
                            case 2:
                                selectedCruiseForCabinChange = cruise2;
                                break;
                            case 3:
                                selectedCruiseForCabinChange = cruise3;
                                break;
                            case 4:
                                selectedCruiseForCabinChange = cruise4;
                                break;
                            case 5:
                                selectedCruiseForCabinChange = cruise5;
                                break;
                            case 6:
                                selectedCruiseForCabinChange = cruise6;
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                
                        if (selectedCruiseForCabinChange != null) {
                            final List<Passenger> passengersForCabinChange= selectedCruiseForCabinChange.getPassengers();
                            List<Cabin> vacantCabins = selectedCruiseForCabinChange.getShip().getCabins().stream()
                                    .filter(cabin -> passengersForCabinChange.stream().noneMatch(p -> p.getCabin().equals(cabin)))
                                    .collect(Collectors.toList());
                        
                            if (vacantCabins.isEmpty()) {
                                System.out.println("No vacant cabins available.");
                            } else {
                                int continueChoice;
                                do {
                                    System.out.println("--------------------------");
                                    System.out.println("Vacant Cabins:");
                                    System.out.println("--------------------------");
                                    for (int i = 0; i < vacantCabins.size(); i++) {
                                        System.out.println(vacantCabins.get(i).getCabinNumber() + "..." + (i + 1));
                                    }
                                    System.out.println("Cancel....................0");
                                    System.out.println("--------------------------");
                                    System.out.print("Enter choice: > ");
                        
                                    continueChoice = scanner.nextInt();
                                    scanner.nextLine(); // consume newline
                        
                                    if (continueChoice > 0 && continueChoice <= vacantCabins.size()) {
                                        Cabin selectedCabin = vacantCabins.get(continueChoice - 1);
                        
                                        List<Passenger> passengersOfCruise = passengersForCabinChange.stream()
                                                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                                                .collect(Collectors.toList());
                        
                                        int selectedPassenger;
                                        do {
                                            System.out.println("--------------------------");
                                            System.out.println("Select a Passenger:");
                                            System.out.println("--------------------------");
                                            for (int i = 0; i < passengersOfCruise.size(); i++) {
                                                System.out.println(passengersOfCruise.get(i).getName() + "..." + (i + 1));
                                            }
                                            System.out.println("Back to Cruise Menu.......0");
                                            System.out.println("--------------------------");
                                            System.out.print("Enter choice: > ");
                        
                                            selectedPassenger = scanner.nextInt();
                                            scanner.nextLine(); // consume newline
                        
                                            if (selectedPassenger > 0 && selectedPassenger <= passengersOfCruise.size()) {
                                                Passenger passenger = passengersOfCruise.get(selectedPassenger - 1);
                                                List<Passenger> cabinMates = passengersForCabinChange.stream()
                                                        .filter(p -> p.getCabin().equals(passenger.getCabin()))
                                                        .collect(Collectors.toList());
                        
                                                for (Passenger cabinMate : cabinMates) {
                                                    cabinMate.setCabin(selectedCabin);
                                                }
                        
                                                System.out.println("Cabin change confirmed for " + passenger.getName() + " and cabin mates.");
                                                selectedPassenger = 0; // exit loop after successful change
                                            } else if (selectedPassenger != 0) {
                                                System.out.println("Invalid choice. Please try again.");
                                            }
                                        } while (selectedPassenger != 0);
                                    } else if (continueChoice != 0) {
                                        System.out.println("Invalid choice. Please try again.");
                                    }
                                } while (continueChoice != 0);
                            }
                        }
                    } while (selectedCruiseIndexForCabinChange != 0);
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