package Chapter12_HashTables;

import java.util.HashMap;
import java.util.Map;

public class HashTables_02_CanFormLetterFromMagazine {
    public static boolean canFormLetterFromMagazine(String letterText, String magazineText) {
        Map<Character, Integer> letterMap = new HashMap<>();
        char[] letterChars = letterText.toCharArray();
        for (char c : letterChars) {
            if (letterMap.containsKey(c)) {
                letterMap.put(c, letterMap.get(c) + 1);
            } else {
                letterMap.put(c, 1);
            }
        }

        char[] magazineChars = magazineText.toCharArray();
        for (char c : magazineChars) {
            if (letterMap.size() == 0) {
                return true;
            }
            if (letterMap.containsKey(c)) {
                if (letterMap.get(c) == 1) {
                    letterMap.remove(c);
                } else {
                    letterMap.put(c, letterMap.get(c) - 1);
                }
            }
        }

        return letterMap.isEmpty();

    }

    public static void main(String[] args) {
        System.out.println(canFormLetterFromMagazine("letter", "loretta likes candies"));
        System.out.println(canFormLetterFromMagazine("letter", "letter"));
        System.out.println(canFormLetterFromMagazine("letter", "monster magazine"));
    }
}
