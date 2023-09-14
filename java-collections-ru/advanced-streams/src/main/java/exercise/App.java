package exercise;

import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.stream.Stream;

// BEGIN
public class App {

    public static String getForwardedVariables(String config) {
        String[] configarray = config.split("\n");
        return  Arrays.stream(configarray)
                .filter(x -> x.startsWith("environment"))
                .flatMap(words -> Stream.of(words.split("\"")))
                .flatMap(words -> Stream.of(words.split(",")))
                .filter(x -> x.startsWith("X_FORWARDED"))
                .map(x -> x.replaceAll("X_FORWARDED_", ""))
                .collect(Collectors.joining(","));
    }
}
//END
