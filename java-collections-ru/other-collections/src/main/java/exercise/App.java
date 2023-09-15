package exercise;

import java.util.LinkedHashMap;
import java.util.Map;

// BEGIN
public class App {

    public static Map<String, String> genDiff(Map<String, Object> map1,
                                              Map<String, Object> map2) {
        Map<String, String> result = new LinkedHashMap<>();
        for (Map.Entry<String, Object> element1 : map1.entrySet()) {
            if (map2.containsKey(element1.getKey())
                && map2.get(element1.getKey()) == element1.getValue()) {
                result.put(element1.getKey(), "unchanged");
            } else if (map2.containsKey(element1.getKey())
                && map2.get(element1.getKey()) != element1.getValue()) {
                result.put(element1.getKey(), "changed");
            } else if (!map2.containsKey(element1.getKey())) {
                result.put(element1.getKey(), "deleted");
            }
        }
        for (Map.Entry<String, Object> element2 : map2.entrySet()) {
            if (!map1.containsKey(element2.getKey())) {
                result.put(element2.getKey(), "added");
            }
        }
        return result;
    }
}
//END
