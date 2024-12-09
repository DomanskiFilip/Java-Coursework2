package task2;

import java.util.List;
import java.util.ArrayList;

public class Passenger {
    private String name;
    private Cabin cabin;
    private Cruise cruise;
    private List<Excursion> excursions;

    public Passenger(String name, Cabin cabin, Cruise cruise) {
        this.name = name;
        this.cabin = cabin;
        this.cruise = cruise;
        this.excursions = new ArrayList<>();
    }

    // get name of the passenger
    public String getName() {
        return name;
    }

    // get cabin of the passenger
    public Cabin getCabin() {
        return cabin;
    }

    // set cabin of the passenger
    public void setCabin(Cabin cabin) {
        this.cabin = cabin;
    }

    // get cruise of the passenger
    public Cruise getCruise() {
        return cruise;
    }

    // get all the excursions of the passenger
    public List<Excursion> getExcursions() {
        return excursions;
    }

    // join excursion if available
    public void joinExcursion(Excursion excursion) {
        if (cruise.hasExcursion(excursion)) {
            excursions.add(excursion);
        } else {
            System.out.println("Excursion not available in the cruise.");
        }
    }
}