public enum BerlinLampColor {
    LAMP_OFF("O"), ONE_MINUTE_ON("Y"), FIVE_MINUTES_ON("Y"),
    FIVE_MINUTES_ON_THIRD("R"), ONE_HOUR_ON("R"), FIVE_HOUR_ON("R"), SECONDS_ON("Y");

    private final String value;

    BerlinLampColor(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
