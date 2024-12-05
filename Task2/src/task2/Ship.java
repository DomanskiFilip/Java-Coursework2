package task2;

import java.util.ArrayList;
import java.util.List;

public class Ship {
    private String name;
    private List<Cabin> cabins;

    public Ship(String name) {
        this.name = name;
        this.cabins = new ArrayList<>();
    }

    // add cabins
    public void addCabin(Cabin cabin) {
        cabins.add(cabin);
    }
    
    // get name of the ship
    public String getName(){
        return name;
    }
    
    //get all the cabins in the ship
    public List<Cabin> getCabins() {
        return cabins;
    }
}