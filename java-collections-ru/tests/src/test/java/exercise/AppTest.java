package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AppTest {
    ArrayList<Integer> numbers;

    @BeforeEach
    void createList() {
        this.numbers = new ArrayList<>();
        this.numbers.add(3);
        this.numbers.add(4);
        this.numbers.add(5);
        this.numbers.add(6);
    }

    @Test
    void testTake() {
        // BEGIN
        int count = 3;
        List<Integer> excpectedlist = new ArrayList<>(this.numbers);
        excpectedlist.remove(3);
        Assertions.assertEquals(excpectedlist, App.take(this.numbers, count));
        // END
    }

    @Test
    void testTake2() {
        // BEGIN
        int count = 3;
        List<Integer> excpectedlist = new ArrayList<>();
        this.numbers.clear();
        Assertions.assertEquals(excpectedlist, App.take(this.numbers, count));
        // END
    }

    @Test
    void testTake3() {
        // BEGIN
        int count = 6;
        List<Integer> excpectedlist = new ArrayList<>(this.numbers);
        Assertions.assertEquals(excpectedlist, App.take(this.numbers, count));
        // END
    }
}
