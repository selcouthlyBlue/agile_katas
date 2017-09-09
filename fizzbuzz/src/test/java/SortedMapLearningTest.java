import org.junit.Test;

import java.util.SortedMap;
import java.util.TreeMap;

import static org.junit.Assert.*;

public class SortedMapLearningTest {
    private SortedMap<Integer, String> preferences;

    @Test
    public void addingValuesToTreeMap() throws Exception {
        int firstKeyToInput = 3;
        int secondKeyToInput = 2;
        String firstValueToInput = "bizz";
        String secondValueToInput = "fuzz";
        preferences = new TreeMap<>();
        preferences.put(firstKeyToInput, firstValueToInput);
        preferences.put(secondKeyToInput, secondValueToInput);
        assertTrue(preferences.firstKey() == secondKeyToInput);
    }

    @Test
    public void addingExistingKeyButDifferentValueToTreeMap() throws Exception {
        int key = 3;
        String value = "bizz";
        String differentValue = "fuzz";
        preferences = new TreeMap<>();
        preferences.put(key, value);
        preferences.put(key, differentValue);
        assertTrue(preferences.get(3).equals("fuzz"));
    }
}