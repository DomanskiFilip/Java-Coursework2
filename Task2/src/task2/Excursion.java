package task2;

public class Excursion {
    private final Port port;
    private final String dayOfWeek;

    public Excursion(Port port, String dayOfWeek) {
        this.port = port;
        this.dayOfWeek = dayOfWeek;
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