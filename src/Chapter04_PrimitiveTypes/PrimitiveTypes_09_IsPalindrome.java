package Chapter04_PrimitiveTypes;

public class PrimitiveTypes_09_IsPalindrome {
    public static boolean isPalindromeNumber(int x) {
        if (x <= 0) {
            return x == 0;
        }
        final int numDigits = (int) (Math.floor(Math.log10(x))) + 1;
        int msdMask = (int) Math.pow(10, numDigits - 1);
        for (int i = 0; i < (numDigits / 2); ++i) {
            if (x / msdMask != x % 10) {
                return false;
            }
            x %= msdMask;
            x /= 10;
            msdMask /= 100;
        }
        return true;
    }

    public static boolean isPalindromeNumber2(int x) {
        int reversed = (int) PrimitiveTypes_08_Reverse.reverse(x);
        return reversed == x;
    }

    public static void test() {
        System.out.println(String.format("isPalindrome(%d) = %b", 5175, isPalindromeNumber(5175)));
        System.out.println(String.format("isPalindrome(%d) = %b", 517715, isPalindromeNumber(517715)));
        System.out.println(String.format("isPalindrome2(%d) = %b", 5175, isPalindromeNumber2(5175)));
        System.out.println(String.format("isPalindrome2(%d) = %b", 517715, isPalindromeNumber2(517715)));
    }

    public static void main(String[] args) {
        test();
    }
}
