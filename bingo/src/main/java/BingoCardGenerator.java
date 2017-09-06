public class BingoCardGenerator {
    private static BingoCardGenerator instance = new BingoCardGenerator();

    private BingoCardGenerator(){

    }

    public static BingoCardGenerator getInstance() {
        return instance;
    }

    public BingoCard generateCard() {
        return new BingoCard();
    }
}
