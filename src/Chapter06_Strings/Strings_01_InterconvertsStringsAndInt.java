package Chapter06_Strings;

public class Strings_01_InterconvertsStringsAndInt {
    public static int stringToInt(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            res = (res * 10) + (c - '0');
        }
        return res;
    }

    public static String intToString(Integer n) {
        StringBuilder sb = new StringBuilder();
        boolean isNegative = false;
        if (n < 0) {
            isNegative = true;
            n *= -1;
        }
        while (n > 0) {
            int d = n % 10;
            sb.insert(0, (char) (d + '0'));
            n = n / 10;
        }
        if (isNegative) {
            sb.insert(0, '-');
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("string to int 348 = " + stringToInt("348"));
        System.out.println("int to string 348 = " + intToString(348));
        System.out.println("int to string -348 = " + intToString(-348));
    }
}
