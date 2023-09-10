package exercise;

import java.util.List;
import java.util.Arrays;

// BEGIN
public class App {

    public static long getCountOfFreeEmails(List<String> mails) {
        String[]  freedomains = {"gmail.com", "yandex.ru", "hotmail.com"};
        return mails.stream()
                .map(m -> m.substring(m.indexOf("@") + 1))
                .filter(y -> Arrays.asList(freedomains).contains(y))
                .count();
    }
}
// END
