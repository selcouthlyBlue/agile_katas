public class TopBerlinLamps extends AbstractBerlinLamps {
    private TopBerlinLamps(BerlinLampBuilder builder) {
        super(builder);
    }

    public static BerlinLamps generateLamps(BerlinLampBuilder builder) {
        return new TopBerlinLamps(builder);
    }

    @Override
    public String switchOnLamps(int timeElement) {
        for(int lampIndex = 0; lampIndex < berlinLamps.length && timeElement >= bound; lampIndex++){
            timeElement -= lampValue;
            switchOnLampAtIndex(lampIndex);
        }
        return getBerlinTime();
    }
}
