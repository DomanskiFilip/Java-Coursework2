package task2;

public abstract class Cabin {
    private int cabinNumber;

    public Cabin(int cabinNumber) {
        this.cabinNumber = cabinNumber;
    }

    public int getCabinNumber() {
        return cabinNumber;
    }

    public abstract String isSuite();

    public abstract String hasBalcony();

    public abstract String hasSeaView();
}
