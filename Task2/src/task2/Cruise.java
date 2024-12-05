package task2;

import java.util.ArrayList;
import java.util.List;

public class Cruise {
    private Ship ship;
    private List<Excursion> excursions;
    private List<Passenger> passengers;

    public Cruise(Ship ship) {
        this.ship = ship;
        this.excursions = new ArrayList<>(); // Initialize the excursions list
        this.passengers = new ArrayList<>(); // Initialize the passengers list
    }

    // add excursion
    public void addExcursion(Excursion excursion) {
        if (excursion != null && excursion instanceof Excursion) {
            excursions.add(excursion);
        } else {
            System.out.println("Invalid excursion. It must be a non-null instance of the Excursion class.");
        }
    }

    // add passenger
    public void addPassenger(Passenger passenger) {
        if (passenger != null && passenger instanceof Passenger) {
            passengers.add(passenger);
        } else {
            System.out.println("Invalid excursion. It must be a non-null instance of the Excursion class.");
        }
    }

    // get ship
    public Ship getShip() {
        return ship;
    }

    // get excursions
    public List<Excursion> getExcursions() {
        return excursions;
    }

    // get passengers
    public List<Passenger> getPassengers() {
        return passengers;
    }

    // check if ship has excursion
    public boolean hasExcursion(Excursion excursion) {
        return excursions.contains(excursion);
    }

    // new toString to show meaningful data
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cruise on ship: ").append(ship.getName()).append("\n");
        sb.append("Cabins: \n");
        for (Cabin cabin : ship.getCabins()){
             sb.append(" - ").append(cabin).append("\n");
        }
        sb.append("Passengers:\n");
        for (Passenger passenger : passengers) {
            sb.append(" - ").append(passenger.getName()).append(" in cabin ").append(passenger.getCabin().getCabinNumber()).append("\n");
        }
        sb.append("Excursions:\n");
        for (Excursion excursion : excursions) {
            sb.append(" - ").append(excursion.getPort().getName()).append(" on ").append(excursion.getDayOfWeek()).append("\n");
        }
        return sb.toString();
    }
}
