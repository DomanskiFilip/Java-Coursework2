package task2;

public class Excursion {
    private final Port port;
    private final String dayOfWeek;
    private final int space;

    public Excursion(Port port, String dayOfWeek, int space) {
        this.port = port;
        this.dayOfWeek = dayOfWeek;
        this.space = space;
    }

    // get port
    public Port getPort() {
        return port;
    }

    // get day of the week
    public String getDayOfWeek() {
        return dayOfWeek;
    }
}