package Chapter06_Strings;

import java.util.HashMap;
import java.util.Map;

public class Strings_09_romanToInteger {
    private static Map<Character, Integer> map = new HashMap<>() {
        {
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }
    };

    public static int romanToInteger(String s) {

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            if (i < s.length() - 1 && s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                sum += (map.get(s.charAt(i + 1)) - 1);
                i += 2;
            } else if (i < s.length() - 1 && s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                sum += (map.get(s.charAt(i + 1)) - 10);
                i += 2;
            } else if (i < s.length() - 1 && s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                sum += (map.get(s.charAt(i + 1)) - 100);
                i += 2;
            } else {
                sum += map.get(s.charAt(i));
                ++i;
            }

        }
        return sum;
    }

    // book solution (better): start from right. If current value less the right value
    public static int romanToInteger2(String s) {
        int sum = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if ((i < s.length() - 1) && (map.get(s.charAt(i)) < map.get(s.charAt(i + 1)))) {
                --sum;
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(romanToInteger2("LIX")); // 59
        System.out.println(romanToInteger2("MMMDCCXXIV")); // 3724
        System.out.println(romanToInteger2("LVIIII")); // 59
    }
}
