package task2;

public abstract class Cabin {
    private int cabinNumber;

    public Cabin(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    // Abstract methods to get information about cabins overrode in StandardCabin and Suite
    public abstract String isSuite();

    public abstract String hasBalcony();

    public abstract String hasSeaView();
    
    @Override
    public String toString(){
       return this.getCabinNumber()+ " | " +this.isSuite()+ " | " + this.hasBalcony()+ " | " + this.hasSeaView();
    }
}
