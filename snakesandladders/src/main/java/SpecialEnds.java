import java.util.HashMap;
import java.util.Map;

public class SpecialEnds {
    private Map<Integer, Integer> mapOfSpecialEnds;

    public SpecialEnds() {
        mapOfSpecialEnds = new HashMap<Integer, Integer>();
    }

    public void addSqureLocationLeadingTo(int source, int destination){
        mapOfSpecialEnds.put(source, destination);
    }

    public boolean leadsToAnotherSquareLocation(int squareLocation) {
        return mapOfSpecialEnds.containsKey(squareLocation);
    }

    public int getWhereTheSquareLocationLeadsTo(int squareLocation) {
        return mapOfSpecialEnds.get(squareLocation);
    }
}
