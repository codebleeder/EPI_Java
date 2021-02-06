package Chapter12_HashTables;

import java.util.*;

public class HashTables_01_CanFormPalindrome {
    public static boolean canFormPalindrome(String s) {
        char[] chars = s.toCharArray();
        Set<Character> set = new HashSet<>();
        for (Character c : chars) {
            if (set.contains(c)) {
                set.remove(c);
            } else {
                set.add(c);
            }
        }
        return set.size() <= 1;
    }

    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>(Arrays.asList(
                "sharad", // false
                "edified" // true
        ));
        for (String s : stringList) {
            System.out.println("input: " + s + " result: " + canFormPalindrome(s));
        }
    }
}
