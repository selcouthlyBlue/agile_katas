public class BottomBerlinLamps extends AbstractBerlinLamps {
    private BottomBerlinLamps(BerlinLampBuilder builder) {
        super(builder);
    }

    static BerlinLamps generateLamps(BerlinLampBuilder builder) {
        return new BottomBerlinLamps(builder);
    }

    @Override
    public String switchOnLamps(int timeElement) {
        for(int lampIndex = 0; lampIndex < berlinLamps.length && timeElement % bound != 0; lampIndex++){
            timeElement -= lampValue;
            switchOnLampAtIndex(lampIndex);
        }
        return getBerlinTime();
    }
}
