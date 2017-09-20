import java.util.Arrays;

public class DigitalTimeToBerlinTimeConverter {

    private final int FIVE_HOUR_LAMP_VALUE = 5;
    private final int FIVE_MINUTE_LAMP_VALUE = 5;

    public String getBottomMinutes(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return switchOnOneMinuteLampsWithRespectTo(digitalTime.getMinutes());
    }

    private String switchOnOneMinuteLampsWithRespectTo(int minutes) {
        int NUMBER_OF_ONE_MINUTE_LAMPS = 4;
        int ONE_MINUTE_LAMP_VALUE = 1;
        BerlinTimeSymbol[] resultingBerlinTime = initializeZeroTime(NUMBER_OF_ONE_MINUTE_LAMPS);
        for(int lampIndex = 0; lampIndex < NUMBER_OF_ONE_MINUTE_LAMPS && minutes % FIVE_MINUTE_LAMP_VALUE != 0; lampIndex++){
            minutes -= ONE_MINUTE_LAMP_VALUE;
            resultingBerlinTime[lampIndex] = BerlinTimeSymbol.ONE_MINUTE_ON;
        }
        return getStringValue(resultingBerlinTime);
    }

    private String getStringValue(BerlinTimeSymbol[] resultingBerlinTime) {
        StringBuilder sb = new StringBuilder();
        for(BerlinTimeSymbol symbol : resultingBerlinTime){
            sb.append(symbol);
        }
        return sb.toString();
    }

    private BerlinTimeSymbol[] initializeZeroTime(int NUMBER_OF_LAMPS) {
        BerlinTimeSymbol[] zeroMinutes = new BerlinTimeSymbol[NUMBER_OF_LAMPS];
        Arrays.fill(zeroMinutes, BerlinTimeSymbol.LAMP_OFF);
        return zeroMinutes;
    }

    public String getTopMinutes(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return switchOnFiveMinuteLampsWithRespectTo(digitalTime.getMinutes());
    }

    private String switchOnFiveMinuteLampsWithRespectTo(int minutes) {
        int NUMBER_OF_FIVE_MINUTE_LAMPS = 11;
        BerlinTimeSymbol[] resultingBerlinTime = initializeZeroTime(NUMBER_OF_FIVE_MINUTE_LAMPS);
        for(int lampIndex = 0; lampIndex < NUMBER_OF_FIVE_MINUTE_LAMPS && minutes >= FIVE_MINUTE_LAMP_VALUE; lampIndex++){
            minutes -= FIVE_MINUTE_LAMP_VALUE;
            BerlinTimeSymbol lampValueToPlace =
                    (lampIndex + 1) % 3 == 0 ? BerlinTimeSymbol.FIVE_MINUTES_ON_THIRD : BerlinTimeSymbol.FIVE_MINUTES_ON;
            resultingBerlinTime[lampIndex] = lampValueToPlace;
        }
        return getStringValue(resultingBerlinTime);
    }

    public String getBottomHours(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return switchOnOneHourLampsWithRespectTo(digitalTime.getHours());
    }

    private String switchOnOneHourLampsWithRespectTo(int hours) {
        int NUMBER_OF_ONE_HOUR_LAMPS = 4;
        int ONE_HOUR_LAMP_VALUE = 1;
        BerlinTimeSymbol[] resultingBerlinTime = initializeZeroTime(NUMBER_OF_ONE_HOUR_LAMPS);
        for(int lampIndex = 0; lampIndex < NUMBER_OF_ONE_HOUR_LAMPS && hours % FIVE_HOUR_LAMP_VALUE != 0; lampIndex++){
            hours -= ONE_HOUR_LAMP_VALUE;
            resultingBerlinTime[lampIndex] = BerlinTimeSymbol.ONE_HOUR_ON;
        }
        return getStringValue(resultingBerlinTime);
    }

    public String getTopHours(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return switchOnFiveHourLampsWithRespectTo(digitalTime.getHours());
    }

    private String switchOnFiveHourLampsWithRespectTo(int hours) {
        int NUMBER_OF_FIVE_HOUR_LAMPS = 4;
        BerlinTimeSymbol[] resultingBerlinTime = initializeZeroTime(NUMBER_OF_FIVE_HOUR_LAMPS);
        for(int lampIndex = 0; lampIndex < NUMBER_OF_FIVE_HOUR_LAMPS && hours >= FIVE_HOUR_LAMP_VALUE; lampIndex++){
            hours -= FIVE_HOUR_LAMP_VALUE;
            resultingBerlinTime[lampIndex] = BerlinTimeSymbol.FIVE_HOUR_ON;
        }
        return getStringValue(resultingBerlinTime);
    }

    public String getSeconds(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return switchOnSecondsLampWithRespectTo(digitalTime.getSeconds());
    }

    private String switchOnSecondsLampWithRespectTo(int seconds) {
        return String.valueOf(seconds % 2 != 0 ? BerlinTimeSymbol.LAMP_OFF : BerlinTimeSymbol.SECONDS_ON);
    }

    public String getBerlinTime(String strDigitalTime) {
        DigitalTime digitalTime = new DigitalTime(strDigitalTime);
        return switchOnSecondsLampWithRespectTo(digitalTime.getSeconds())
                + getBerlinHours(digitalTime)
                + getBerlinMinutes(digitalTime);
    }

    private String getBerlinMinutes(DigitalTime digitalTime) {
        return switchOnFiveMinuteLampsWithRespectTo(digitalTime.getMinutes())
                + switchOnOneMinuteLampsWithRespectTo(digitalTime.getMinutes());
    }

    private String getBerlinHours(DigitalTime digitalTime) {
        return switchOnFiveHourLampsWithRespectTo(digitalTime.getHours())
                + switchOnOneHourLampsWithRespectTo(digitalTime.getHours());
    }
}
