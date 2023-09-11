package exercise;

import java.util.Comparator;
import java.util.Map;
import java.util.List;
import java.time.LocalDate;
import java.util.stream.Collectors;

// BEGIN
public class Sorter {


    public static List<String> takeOldestMans(List<Map<String, String>> names) {
        return names.stream()
                .filter(x -> x.get("gender").equals("male"))
                .sorted(Comparator.comparing(n -> LocalDate.parse(n.get("birthday"))))
                .map(m -> m.get("name"))
                .collect(Collectors.toList());
    }
}
// END
