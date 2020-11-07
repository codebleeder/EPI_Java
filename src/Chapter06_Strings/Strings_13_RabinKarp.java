package Chapter06_Strings;

public class Strings_13_RabinKarp {
    // book sol:
    public static int rabinKarp(String s, String t) {
        if (s.length() > t.length()) {
            return -1;
        }
        final int BASE = 26;
        int tHash = 0, sHash = 0;
        int powerS = 1;
        for (int i = 0; i < s.length(); ++i) {
            powerS = i > 0 ? powerS * BASE : 1;
            tHash = tHash * BASE + t.charAt(i);
            sHash = sHash * BASE + s.charAt(i);
        }

        for (int i = s.length(); i < t.length(); ++i) {
            if (sHash == tHash && t.substring(i - s.length(), i).equals(s)) {
                return i - s.length();
            }
            tHash = tHash - (t.charAt(i - s.length()) * powerS);
            tHash = tHash * BASE + t.charAt(i);
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(rabinKarp("abc", "adabcda"));
        System.out.println("expected = 2");
    }
}
