import java.util.HashMap;
import java.util.Map;

public class SpecialEnds {
    private Map<Integer, Integer> mapOfSpecialEnds;

    public SpecialEnds() {
        mapOfSpecialEnds = new HashMap<Integer, Integer>();
    }

    public void add(int source, int destination){
        mapOfSpecialEnds.put(source, destination);
    }

    public boolean leadsToAnotherSquareLocation(int squareLocation) {
        return mapOfSpecialEnds.containsKey(squareLocation);
    }

    public int getDestination(int squareLocation) {
        return mapOfSpecialEnds.get(squareLocation);
    }
}
