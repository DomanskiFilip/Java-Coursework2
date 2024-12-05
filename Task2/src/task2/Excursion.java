package task2;

public class Excursion {
    private Port port;
    private String dayOfWeek;

    public Excursion(Port port, String dayOfWeek) {
        this.port = port;
        this.dayOfWeek = dayOfWeek;
    }

    public Port getPort() {
        return port;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }
}