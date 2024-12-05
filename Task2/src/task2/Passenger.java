package task2;

import java.util.List;
import java.util.ArrayList;

public class Passenger {
    private String name;
    private Cabin cabin;
    private Cruise cruise;
    private List<Excursion> excursions;

    public Passenger(String name, Cabin cabin, Cruise cruise, Excursion excursions) {
        this.name = name;
        this.cabin = cabin;
        this.cruise = cruise;
        this.excursions = new ArrayList<>();
    }

    public void joinExcursion(Excursion excursion) {
        excursions.add(excursion);
    }

    public String getName() {
        return name;
    }

    public Cabin getCabin() {
        return cabin;
    }

    public Cruise getCruise() {
        return cruise;
    }

    public List<Excursion> getExcursions() {
        return excursions;
    }
}