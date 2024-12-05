package task2;

import java.util.Arrays;

public class Task2 {

    public static void main(String[] args) {
        Cabin suite = new Suite(101, true);
        Cabin standardCabin = new StandardCabin(102, false);
        Ship ship = new Ship(Arrays.asList(suite, standardCabin));
        Cruise cruiseToBahamas = new Cruise(ship);

        Port port = new Port("Bahamas");
        Excursion excursionTobahamas = new Excursion(port, "Monday");
        cruiseToBahamas.addExcursion(excursionTobahamas);

        Passenger passenger1 = new Passenger("John Doe", suite, cruiseToBahamas, excursionTobahamas);
        cruiseToBahamas.addPassenger(passenger1);
        passenger1.joinExcursion(excursionTobahamas);

        Passenger passenger2 = new Passenger("Jane Smith", standardCabin, cruiseToBahamas, excursionTobahamas);
        cruiseToBahamas.addPassenger(passenger2);
        passenger2.joinExcursion(excursionTobahamas);

        System.out.println("List of passengers on the cruise:");
        for (Passenger passenger : cruiseToBahamas.getPassengers()) {
            System.out.println("Passenger name: " + passenger.getName());
            Cabin cabin = passenger.getCabin();
            System.out.println(cabin.isSuite());
            System.out.println("Has balcony?: " + cabin.hasBalcony());
            System.out.println("Has sea view?: " + cabin.hasSeaView());
        }
    }
}