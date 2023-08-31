package exercise;

import java.util.ArrayList;
import java.util.List;

// BEGIN
public class App {

    public static void main(String[] args) {
    }

    public static boolean scrabble(String symbols, String word) {
        char[] wordchar = word.toLowerCase().toCharArray();
        char[] symbolschar = symbols.toLowerCase().toCharArray();
        List<Character> wordlist = new ArrayList<>();
        List<Character> symbollist = new ArrayList<>();
        for (char element : wordchar) {
            wordlist.add(element);
        }
        for (char element: symbolschar) {
            symbollist.add(element);
        }
        int sizelist = wordlist.size();
        for (Character element : wordlist) {
            if (symbollist.contains(element)) {
                symbollist.remove(element);
                sizelist--;
            }
        }
        return sizelist == 0;
    }
}
//END
