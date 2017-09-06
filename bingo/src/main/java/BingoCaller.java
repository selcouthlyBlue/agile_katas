import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BingoCaller {
    private List<Integer> bagOfBingoBalls = new ArrayList<Integer>();

    public BingoCaller() {
        refill();
    }

    public void refill() {
        bagOfBingoBalls.clear();
        for(int i = 1; i < 75; i++){
            bagOfBingoBalls.add(i);
        }
    }

    public int getNumber() throws EmptyBingoCallerException {
        if(bagOfBingoBalls.size() == 0)
            throw new EmptyBingoCallerException("Bingo caller is empty");
        return removeNumber();
    }

    private int removeNumber() {
        Random rand = new Random();
        return bagOfBingoBalls.remove(rand.nextInt(bagOfBingoBalls.size()));
    }

    public int getRemainingNumberOfBingoBalls() {
        return bagOfBingoBalls.size();
    }
}
