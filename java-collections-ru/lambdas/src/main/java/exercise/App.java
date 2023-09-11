package exercise;

import java.util.Arrays;

// BEGIN
public class App {

    public static String[][] enlargeArrayImage(String[][] strings) {
        int size = strings.length;
        if (size == 0) {
            return new String[0][];
        }
        return Arrays.stream(strings)
                .mapMulti((y, z) -> {
                    String[] arr = Arrays.copyOf(y, size * 2);
                    int count = 0;
                    for (int i = 0; i < arr.length; i += 2) {
                        arr[i] = y[count];
                        arr[i + 1] = y[count];
                        count++;
                    }
                    z.accept(arr);
                    z.accept(arr);
                }
                )
                .toArray(String[][]::new);
    }
}
// END
