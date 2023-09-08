package exercise;

import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Map.Entry;

// BEGIN
public class App {

    public static List<Map<String, String>> findWhere(List<Map<String, String>> list,
                                                      Map<String, String> map) {
        List<Map<String, String>> result = new ArrayList<>();
        if (map.isEmpty()) {
            return result;
        }
        for (int i = 0; i < list.size(); i++) {
            int count = 0;
            for (Entry<String, String> entry: map.entrySet()) {
                if (list.get(i).containsKey(entry.getKey())
                    && list.get(i).containsValue(entry.getValue())) {
                    count++;
                }
            }
            if (count == map.size()) {
                result.add(list.get(i));
            }
        }
        return  result;
    }

}
//END
