package exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// BEGIN
public class ReversedSequence implements CharSequence {
    private CharSequence charSequence;

    public ReversedSequence(String text) {
        this.charSequence = reverseSequence(text);

    }

    public static CharSequence reverseSequence(String text) {
        List<String> list = new ArrayList<>(Arrays.stream(text.split("")).toList());
        Collections.reverse(list);
        String reverseText = String.join("", list);
        return reverseText.subSequence(0, reverseText.length());
    }

    @Override
    public int length() {
        return charSequence.length();
    }

    @Override
    public char charAt(int index) {
        return charSequence.charAt(index);
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return charSequence.subSequence(start, end);
    }

    @Override
    public String toString() {
        return charSequence.toString();
    }
}
// END
