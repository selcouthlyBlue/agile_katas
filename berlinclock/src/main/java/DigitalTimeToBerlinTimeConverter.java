public class DigitalTimeToBerlinTimeConverter {
    private final int FIVE_HOUR_LAMP_VALUE = 5;
    private final int FIVE_MINUTE_LAMP_VALUE = 5;

    private BerlinLamps bottomMinuteLamps;
    private BerlinLamps topMinuteLamps;
    private BerlinLamps bottomHourLamps;
    private BerlinLamps topHourLamps;

    public DigitalTimeToBerlinTimeConverter() {
        buildBottomMinutes();
        buildTopMinutes();
        buildBottomHours();
        buildTopHours();
    }

    private void buildTopHours() {
        int FIVE_MINUTE_LAMP_VALUE = 5;
        int NUMBER_OF_TOP_HOURS_LAMPS = 4;
        BerlinLampBuilder builder = new BerlinLampBuilder(NUMBER_OF_TOP_HOURS_LAMPS, BerlinLampColor.FIVE_HOUR_ON, FIVE_MINUTE_LAMP_VALUE, FIVE_HOUR_LAMP_VALUE);
        this.topHourLamps = TopBerlinLamps.generateLamps(builder);
    }

    private void buildBottomHours() {
        int NUMBER_OF_BOTTOM_HOURS_LAMPS = 4;
        int BOTTOM_HOUR_LAMP_VALUE = 1;
        BerlinLampBuilder builder = new BerlinLampBuilder(NUMBER_OF_BOTTOM_HOURS_LAMPS, BerlinLampColor.ONE_HOUR_ON, BOTTOM_HOUR_LAMP_VALUE, FIVE_HOUR_LAMP_VALUE);
        this.bottomHourLamps = BottomBerlinLamps.generateLamps(builder);
    }

    private void buildTopMinutes() {
        int TOP_MINUTE_LAMP_VALUE = 5;
        int NUMBER_OF_TOP_MINUTES_LAMPS = 11;
        BerlinLampBuilder builder = new BerlinLampBuilder(NUMBER_OF_TOP_MINUTES_LAMPS, BerlinLampColor.FIVE_MINUTES_ON, TOP_MINUTE_LAMP_VALUE, FIVE_MINUTE_LAMP_VALUE);
        builder = builder.specialLampColorForOnAndSpecialLampIndex(BerlinLampColor.FIVE_MINUTES_ON_THIRD, 3);
        this.topMinuteLamps = TopBerlinLamps.generateLamps(builder);
    }

    private void buildBottomMinutes() {
        int ONE_MINUTE_LAMP_VALUE = 1;
        int NUMBER_OF_BOTTOM_MINUTES_LAMPS = 4;
        BerlinLampBuilder builder = new BerlinLampBuilder(NUMBER_OF_BOTTOM_MINUTES_LAMPS, BerlinLampColor.ONE_MINUTE_ON, ONE_MINUTE_LAMP_VALUE, FIVE_MINUTE_LAMP_VALUE);
        this.bottomMinuteLamps = BottomBerlinLamps.generateLamps(builder);
    }

    public String getBottomMinutes(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return bottomMinuteLamps.switchOnLamps(digitalTime.getMinutes());
    }

    public String getTopMinutes(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return topMinuteLamps.switchOnLamps(digitalTime.getMinutes());
    }

    public String getBottomHours(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return bottomHourLamps.switchOnLamps(digitalTime.getHours());
    }

    public String getTopHours(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return topHourLamps.switchOnLamps(digitalTime.getHours());
    }

    public String getSeconds(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return getBerlinSeconds(digitalTime.getSeconds());
    }

    private String getBerlinSeconds(int seconds) {
        return String.valueOf(seconds % 2 != 0 ? BerlinLampColor.LAMP_OFF : BerlinLampColor.SECONDS_ON);
    }

    public String getBerlinTime(String strDigitalTime) {
        StringBuilder resultingBerlinTime = appendBerlinLampValues(strDigitalTime);
        return resultingBerlinTime.toString();
    }

    private StringBuilder appendBerlinLampValues(String strDigitalTime) {
        StringBuilder resultingBerlinTime = new StringBuilder();
        resultingBerlinTime.append(getSeconds(strDigitalTime));
        resultingBerlinTime.append(getTopHours(strDigitalTime));
        resultingBerlinTime.append(getBottomHours(strDigitalTime));
        resultingBerlinTime.append(getTopMinutes(strDigitalTime));
        resultingBerlinTime.append(getBottomMinutes(strDigitalTime));
        return resultingBerlinTime;
    }
}
