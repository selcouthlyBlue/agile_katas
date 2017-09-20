import java.util.Arrays;

class GenericBerlinLamps {
    BerlinLampColor[] berlinLamps;

    private final BerlinLampColor lampColorForOn;
    final int lampValue;
    final int bound;

    private final BerlinLampColor specialLampColorForOn;
    private final int specialLampIndex;

    GenericBerlinLamps(BerlinLampBuilder builder) {
        this.berlinLamps = initializeBerlinLamps(builder.getNumberOfLamps());
        this.lampColorForOn = builder.getLampColorForOn();
        this.lampValue = builder.getLampValue();
        this.bound = builder.getBound();
        this.specialLampColorForOn = builder.getSpecialLampColorForOn();
        this.specialLampIndex = builder.getSpecialLampIndex();
    }

    private BerlinLampColor[] initializeBerlinLamps(int numberOfLamps) {
        BerlinLampColor[] berlinLamps = new BerlinLampColor[numberOfLamps];
        Arrays.fill(berlinLamps, BerlinLampColor.LAMP_OFF);
        return berlinLamps;
    }

    void switchOnLampAtIndex(int lampIndex){
        berlinLamps[lampIndex] = (lampIndex + 1) % specialLampIndex != 0 ? lampColorForOn : specialLampColorForOn;
    }

    String getBerlinTime(){
        StringBuilder sb  = new StringBuilder();
        for(BerlinLampColor lampColor : berlinLamps){
            sb.append(lampColor);
        }
        return sb.toString();
    }
}
