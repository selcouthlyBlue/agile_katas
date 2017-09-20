public class DigitalTime {
    private final int hours;
    private final int minutes;
    private final int seconds;

    public DigitalTime(String strDigitalTime) {
        String[] splitDigitalTime = strDigitalTime.split(":");
        this.hours = Integer.parseInt(splitDigitalTime[0]);
        this.minutes = Integer.parseInt(splitDigitalTime[1]);
        this.seconds = Integer.parseInt(splitDigitalTime[2]);
    }

    public int getMinutes() {
        return minutes;
    }

    public int getHours() {
        return hours;
    }

    public int getSeconds() {
        return seconds;
    }
}
