import java.util.Random;

public class Player {
    private final String playerName;

    public static final Player NO_ONE = new Player("NO ONE");

    public Player(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        return playerName.equals(player.playerName);
    }

    @Override
    public int hashCode() {
        return playerName.hashCode();
    }

    public int rollDice() {
        Random random = new Random();
        int max = 6;
        int min = 1;
        return random.nextInt(max - min + 1) + 1;
    }

    @Override
    public String toString() {
        return playerName;
    }
}
