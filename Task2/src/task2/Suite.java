package task2;

public class Suite extends Cabin {
    private boolean balcony;

    public Suite(int cabinNumber, boolean balcony) {
        super(cabinNumber);
        this.balcony = balcony;
    }

    // Overriding abstract methods from Cabin
    @Override
    public String isSuite() {
        return "This is a suite";
    }

    @Override
    public String hasBalcony() {
        if(balcony) {
            return "this suite has a balcony";
        } else {
            return "this suite does not have a balcony";
        }
    }

    @Override
    public String hasSeaView() {
        if(balcony) {
            return "this suite has a sea view through balcony";
        } else {
            return "this suite does not have a sea view";
        }
    }
}