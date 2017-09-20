public class TopBerlinLamps extends AbstractBerlinLamps {
    public TopBerlinLamps(BerlinLampBuilder builder) {
        super(builder);
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
