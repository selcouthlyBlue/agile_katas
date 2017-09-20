public class BerlinLampBuilder {
    private final int numberOfLamps;
    private final BerlinLampColor lampColorForOn;
    private final int lampValue;
    private final int bound;

    private BerlinLampColor specialLampColorForOn = BerlinLampColor.LAMP_OFF;

    // This is set to highest index possible in the case of not having a special lamp color at a special index
    private int specialLampIndex = 61;

    public BerlinLampBuilder(int numberOfLamps, BerlinLampColor lampColorForOn, int lampValue, int bound) {
        this.numberOfLamps = numberOfLamps;
        this.lampColorForOn = lampColorForOn;
        this.lampValue = lampValue;
        this.bound = bound;
    }

    public BerlinLampBuilder specialLampColorForOnAndSpecialLampIndex(BerlinLampColor specialLampColorForOn, int specialLampIndex){
        this.specialLampColorForOn = specialLampColorForOn;
        this.specialLampIndex = specialLampIndex;
        return this;
    }

    public int getNumberOfLamps() {
        return numberOfLamps;
    }

    public BerlinLampColor getLampColorForOn() {
        return lampColorForOn;
    }

    public int getLampValue() {
        return lampValue;
    }

    public int getBound() {
        return bound;
    }

    public BerlinLampColor getSpecialLampColorForOn() {
        return specialLampColorForOn;
    }

    public int getSpecialLampIndex() {
        return specialLampIndex;
    }
}
