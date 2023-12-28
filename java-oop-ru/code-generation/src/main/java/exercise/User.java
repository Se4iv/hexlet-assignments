package exercise;

import lombok.Value;

// BEGIN
@Value
// END
public class User {
    int id;
    String firstName;
    String lastName;
    int age;
}
