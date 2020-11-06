package Chapter06_Strings;

import java.util.ArrayList;
import java.util.List;

public class Strings_11_SnakeString {
    public static String snakeString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i += 4) {
            sb.append(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i += 2) {
            sb.append(s.charAt(i));
        }
        for (int i = 3; i < s.length(); i += 4) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("result: " + snakeString("hello world")); //e lhlowrdlo
        System.out.println("expected: e lhlowrdlo");
    }
}
