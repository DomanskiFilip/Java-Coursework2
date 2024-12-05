package task2;

import java.util.List;

public class Ship {
    private List<Cabin> cabins;

    public Ship(List<Cabin> cabins) {
        this.cabins = cabins;
    }

    public List<Cabin> getCabins() {
        return cabins;
    }
}