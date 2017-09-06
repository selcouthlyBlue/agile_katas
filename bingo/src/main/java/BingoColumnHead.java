public enum BingoColumnHead {
    B("B", 1, 15), I("I", 16, 30), N("N", 31, 45), G("G", 46, 60), O("O", 61, 75);

    private final String name;
    private final int upperBound;
    private final int lowerBound;

    BingoColumnHead(String name, int lowerBound, int upperBound) {
        this.name = name;
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public int getUpperBound() {
        return upperBound;
    }

    public int getLowerBound() {
        return lowerBound;
    }

    @Override
    public String toString() {
        return name;
    }
}
