import java.util.*;

public class SnakesAndLaddersGame {
    private Map<Player, Token> playerTokenMap;
    private Player winner;
    private final int lastSquareLocation = 101;
    private Space[] spaces;
    private final Player computer = new Player("COMPUTER");
    private LinkedList<Player> turnOrder;
    private int turnNumber;

    public SnakesAndLaddersGame(SpecialEnds specialEnds) {
        playerTokenMap = new HashMap<Player, Token>();
        turnOrder = new LinkedList<Player>();
        spaces = new Space[lastSquareLocation];
        for(int squareLocation = 1; squareLocation < lastSquareLocation; squareLocation++){
            Space space = new Space();
            if(specialEnds.leadsToAnotherSquareLocation(squareLocation))
                space.setDestination(specialEnds.getDestination(squareLocation));
            spaces[squareLocation] = space;
        }
        this.winner = Player.NO_ONE;
    }

    public void addPlayer(Player player) {
        turnOrder.clear();
        playerTokenMap.put(player, new Token());
    }

    public int getPositionOfTokenOf(Player tokenOwner) {
        return playerTokenMap.get(tokenOwner).getLocation();
    }

    public void turnPlayerMove(int spaces) {
        Player turnPlayer = getTurnPlayer();
        Token token = playerTokenMap.get(turnPlayer);
        if(tokenWillGoPastTheLastSquare(token, spaces))
            return;
        token.move(spaces);
        int tokenLocation = token.getLocation();
        if(hasSpecialEnd(tokenLocation))
            token.move(this.spaces[tokenLocation].getDestination() - tokenLocation);
        if(hasWonTheGame(token))
            this.winner = turnPlayer;
        turnNumber++;
    }

    private boolean hasSpecialEnd(int squareLocationOfToken) {
        return spaces[squareLocationOfToken].isYieldingToAnotherDestination();
    }

    private boolean hasWonTheGame(Token token) {
        return token.getLocation() == lastSquareLocation - 1;
    }

    private boolean tokenWillGoPastTheLastSquare(Token token, int numberOfSpacesToMove) {
        return token.getLocation() + numberOfSpacesToMove >  lastSquareLocation - 1;
    }

    public Player getWinner() {
        return winner;
    }

    public Player getTurnPlayer() {
        if(turnOrder.isEmpty())
            return Player.NO_ONE;
        return turnOrder.get(turnNumber % playerTokenMap.size());
    }

    public void determinePlayOrder() {
        SortedMap<Integer, Player> playOrderPlayerMap = new TreeMap<Integer, Player>();
        for(Player player : playerTokenMap.keySet()){
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
