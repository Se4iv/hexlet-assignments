package exercise;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

// BEGIN
public class AppTest {

    @Test
    void testEnlargeArrayImage1() {
        String[][] image = {
                {"*", "*", "*", "*"},
                {"*", " ", " ", "*"},
                {"*", " ", " ", "*"},
                {"*", "*", "*", "*"},
        };
        String[][] expected = {
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", " ", " ", " ", " ", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
                {"*", "*", "*", "*", "*", "*", "*", "*"},
        };
        String[][] actual = App.enlargeArrayImage(image);

        Assertions.assertThat(actual).isEqualTo(expected);
    }

    @Test
    void testEnlargeArrayImage2() {
        String[][] image = {};
        String[][] expected = {};
        String[][] actual = App.enlargeArrayImage(image);

        Assertions.assertThat(actual).isEqualTo(expected);
    }
}
// END
