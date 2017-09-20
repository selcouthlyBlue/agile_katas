public class TopBerlinLamps extends GenericBerlinLamps implements BerlinLamps {
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
