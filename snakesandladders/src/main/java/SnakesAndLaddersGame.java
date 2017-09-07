import java.util.*;

public class SnakesAndLaddersGame {
    private Map<Player, GameToken> playerGameTokenMap;
    private Player winner;
    private final int lastSquareLocation = 101;
    private Square[] squares;
    private final Player computer = new Player("COMPUTER");
    private LinkedList<Player> turnOrder;
    private int turnPlayerIndex;

    public SnakesAndLaddersGame(SpecialEnds specialEnds) {
        playerGameTokenMap = new HashMap<Player, GameToken>();
        turnOrder = new LinkedList<Player>();
        squares = new Square[lastSquareLocation];
        for(int squareLocation = 1; squareLocation < lastSquareLocation; squareLocation++){
            Square square = new Square();
            if(specialEnds.hasSpecialEndFor(squareLocation))
                square.setDestination(specialEnds.getSpecialEndFor(squareLocation));
            squares[squareLocation] = square;
        }
        this.winner = Player.DUMMY_INSTANCE;
    }

    public void addPlayer(Player player) {
        turnOrder.clear();
        playerGameTokenMap.put(player, new GameToken());
    }

    public int getPositionOfTokenOf(Player tokenOwner) {
        return playerGameTokenMap.get(tokenOwner).getSquareLocation();
    }

    public void turnPlayerMoveTokenBy(int numberOfSpacesToMove) {
        Player turnPlayer = getTurnPlayer();
        GameToken gameToken = playerGameTokenMap.get(turnPlayer);
        if(tokenWillGoPastTheLastSquare(gameToken, numberOfSpacesToMove))
            return;
        gameToken.move(numberOfSpacesToMove);
        int squareLocationOfToken = gameToken.getSquareLocation();
        if(squareLocationOfTokenHasASpecialEnd(squareLocationOfToken))
            gameToken.move(squares[squareLocationOfToken].getDestination() - squareLocationOfToken);
        if(tokenIsInTheLastSquare(gameToken))
            this.winner = turnPlayer;
        turnPlayerIndex++;
    }

    private boolean squareLocationOfTokenHasASpecialEnd(int squareLocationOfToken) {
        return squares[squareLocationOfToken].isYieldingToAnotherDestination();
    }

    private boolean tokenIsInTheLastSquare(GameToken gameToken) {
        return gameToken.getSquareLocation() == lastSquareLocation - 1;
    }

    private boolean tokenWillGoPastTheLastSquare(GameToken gameToken, int numberOfSpacesToMove) {
        return gameToken.getSquareLocation() + numberOfSpacesToMove >  lastSquareLocation - 1;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getTurnPlayer() {
        if(turnOrder.isEmpty())
            return Player.DUMMY_INSTANCE;
        return turnOrder.get(turnPlayerIndex % playerGameTokenMap.size());
    }

    public void determinePlayOrder() {
        SortedMap<Integer, Player> playOrderPlayerMap = new TreeMap<Integer, Player>();
        for(Player player : playerGameTokenMap.keySet()){
            int dieRollResult = player.rollDice();
            if(!playOrderPlayerMap.containsKey(dieRollResult))
                playOrderPlayerMap.put(dieRollResult, player);
            else{
                while(playOrderPlayerMap.containsKey(dieRollResult)){
                    dieRollResult = player.rollDice();
                }
                playOrderPlayerMap.put(dieRollResult, player);
            }
        }
        turnOrder.addAll(playOrderPlayerMap.values());
        Collections.reverse(turnOrder);
    }

    public void addComputerToGame() {
        addPlayer(computer);
    }
}
