package Chapter06_Strings;

public class Strings_00_IsPalindrome {
    public static boolean isPalindrome(String s) {
        for (int i = 0, j = s.length() - 1; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("sharahs is palindrome: " + isPalindrome("sharahs"));
        System.out.println("ten is palindrome: " + isPalindrome("ten"));
    }
}
