package Chapter06_Strings;

import java.util.Arrays;

public class Strings_12_RunLengthEncoding {
    public static String encode(String s) {
        int count = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); ++i) {
            if (s.charAt(i - 1) == s.charAt(i)) {
                ++count;
            } else {
                sb.append(count);
                sb.append(s.charAt(i - 1));
                count = 1;
            }
        }
        sb.append(count);
        sb.append(s.charAt(s.length() - 1));
        return sb.toString();
    }

    public static String decode(String s) {
        StringBuilder sb = new StringBuilder();
        if (s.length() % 2 != 0) return "";
        for (int i = 1; i < s.length(); i += 2) {
            char[] charArr = new char[s.charAt(i - 1) - '0'];
            Arrays.fill(charArr, s.charAt(i));
            sb.append(new String(charArr));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("encode aaaabcccaa = " + encode("aaaabcccaa"));
        System.out.println("decode 3e4f2e = " + decode("3e4f2e"));
    }
}
