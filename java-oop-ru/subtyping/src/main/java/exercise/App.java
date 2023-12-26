package exercise;

import java.util.Map;


// BEGIN
public class App {

    public static void swapKeyValue(KeyValueStorage storage) {
        Map<String, String> tmp = storage.toMap();
        for (Map.Entry<String, String> element : tmp.entrySet()) {
            storage.unset(element.getKey());
            storage.set(element.getValue(), element.getKey());
        }
    }
}
// END
