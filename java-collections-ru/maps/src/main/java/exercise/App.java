package exercise;

import java.util.HashMap;
import java.util.Map;

// BEGIN
public class App {

    public static void main(String[] args) {
    Map<String, Integer> map2 =  getWordCount("java is the best programming language java" +
            " java java java");
        System.out.println(map2);
        System.out.println(toString(map2));
    }

    public static Map<String, Integer> getWordCount(String string) {
        Map<String, Integer> map = new HashMap<>();
        if (string.isEmpty()) {
            return map;
        }
        String[] split = string.split(" ");
        int value;
        for (String element : split) {
            if (map.containsKey(element)) {
                value = map.get(element) + 1;
                map.remove(element);
                map.put(element, value);
            }
            else map.put(element, 1);
        }
        return map;
    }

    public static String toString(Map<String, Integer> map) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        if (!map.isEmpty()) {
            for (String key : map.keySet()) {
                stringBuilder.append("\n  " + key + ": " + map.get(key));
            }
            stringBuilder.append("\n");
        }
        stringBuilder.append("}");
        return String.valueOf(stringBuilder);
    }
}
//END
