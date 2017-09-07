import java.util.HashMap;
import java.util.Map;

public class SpecialEnds {
    private Map<Integer, Integer> mapOfSpecialEnds;

    public SpecialEnds() {
        mapOfSpecialEnds = new HashMap<Integer, Integer>();
    }

    public void addSpecialEnds(int source, int destination){
        mapOfSpecialEnds.put(source, destination);
    }

    public boolean hasSpecialEndFor(int squareLocation) {
        return mapOfSpecialEnds.containsKey(squareLocation);
    }

    public int getSpecialEndFor(int squareLocation) {
        return mapOfSpecialEnds.get(squareLocation);
    }
}
