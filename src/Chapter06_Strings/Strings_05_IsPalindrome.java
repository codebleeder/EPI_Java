package Chapter06_Strings;

import java.util.ArrayList;
import java.util.List;

public class Strings_05_IsPalindrome {
    public static boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            // get next valid char1:
            while (!Character.isLetterOrDigit(s.charAt(i))) {
                ++i;
            }
            while (!Character.isLetterOrDigit(s.charAt(j))) {
                --j;
            }
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) {
                return false;
            }
            ++i;
            --j;
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> tests = new ArrayList<>();
        tests.add("A man, a plan, a canal, Panama."); // true
        tests.add("Able was I, ere I saw Elba!"); //true
        tests.add("Ray a Ray"); // false
        for (int i = 0; i < tests.size(); ++i) {
            System.out.println(isPalindrome(tests.get(i)));
        }
    }
}
