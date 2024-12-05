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

    public void addExcursion(Excursion excursion) {
        excursions.add(excursion);
    }

    public void addPassenger(Passenger passenger) {
        passengers.add(passenger);
    }

    public Ship getShip() {
        return ship;
    }

    public List<Excursion> getExcursions() {
        return excursions;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
}