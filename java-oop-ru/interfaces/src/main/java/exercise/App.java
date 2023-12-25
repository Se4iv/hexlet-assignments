package exercise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

// BEGIN
public class App {

    public static List<String> buildApartmentsList(List<Home> homes, int countElements) {
        List<Home> prepare = new ArrayList<>(homes);
        return prepare.stream()
                .sorted(Home::compareTo)
                .limit(countElements)
                .map(Object::toString)
                .collect(Collectors.toList());
    }
}
// END
