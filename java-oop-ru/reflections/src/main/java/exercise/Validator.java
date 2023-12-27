package exercise;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// BEGIN
public class Validator {

    public static List<String> validate(Address aClass) {
        List<String> result = new ArrayList<>();
        try {
            Class<?> newclass = aClass.getClass();
            Field[] fields = newclass.getDeclaredFields();
            for (Field x: fields) {
                x.setAccessible(true);
                if (x.isAnnotationPresent(NotNull.class)
                        && String.valueOf(x.get(aClass)).equals("null")) {
                    result.add(x.getName());
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public static Map<String, List<String>> advancedValidate(Address aClass) {
        Map<String, List<String>> result = new HashMap<>();
        try {
            Class<?> newclass = aClass.getClass();
            Field[] fields = newclass.getDeclaredFields();
            for (Field x: fields) {
                x.setAccessible(true);
                MinLength annotation = x.getAnnotation(MinLength.class);
                if (x.isAnnotationPresent(NotNull.class)
                        && String.valueOf(x.get(aClass)).equals("null")) {
                    result.put(x.getName(), List.of("can not be null"));
                } else if (x.isAnnotationPresent(MinLength.class)
                    && annotation.minLength() > String.valueOf(x.get(aClass)).length()) {
                    result.put(x.getName(), List.of("length less than " + annotation.minLength()));
                }
            }
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
// END
