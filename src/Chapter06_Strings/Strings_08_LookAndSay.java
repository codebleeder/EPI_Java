package Chapter06_Strings;

public class Strings_08_LookAndSay {
    public static String lookAndSay(int n) {
        String res = "1";
        for (int i = 1; i < n; ++i) {
            res = calcNext(res);
        }
        return res;
    }

    public static String calcNext(String input) {
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i <= input.length() - 1) {
            int count = 1;
            while (i < input.length() - 1 && input.charAt(i) == input.charAt(i + 1)) {
                ++i;
                ++count;
            }
            sb.append(count);
            sb.append(input.charAt(i));
            ++i;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(lookAndSay(8));
    }
}
