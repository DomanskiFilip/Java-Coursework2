package task2;

public class StandardCabin extends Cabin {
    private boolean seaView;

    public StandardCabin(int cabinNumber, boolean seaView) {
        super(cabinNumber);
        this.seaView = seaView;
    }

    @Override
    public String isSuite() {
        return "This is a cabin";
    }

    @Override
    public String hasBalcony() {
        return "Cabins do not have balconies";
    }

    @Override
    public String hasSeaView() {
        if(seaView) {
            return "this suite has a sea view";
        } else {
            return "this suite does not have a sea view";
        }
    }
}