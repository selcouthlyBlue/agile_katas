public enum TennisScores {
    LOVE("0"), FIFTEEN("15"), THIRTY("30"), FORTY("40"), ADVANTAGE("A"), WINNER("WIN");

    private final String value;

    TennisScores(String value) {
        this.value = value;
    }

    public String getTennisScoreValue(){
        return value;
    }

    public static TennisScores getTennisScoreEquivalent(int number){
        switch (number){
            case 0: return LOVE;
            case 1: return FIFTEEN;
            case 2: return THIRTY;
            case 3: return FORTY;
            case 4: return ADVANTAGE;
            case 5: return WINNER;
            default: throw new InvalidTennisScoreException(number + " is an invalid tennis score value.");
        }
    }
}
