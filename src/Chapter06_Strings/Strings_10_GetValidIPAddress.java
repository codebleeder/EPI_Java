package Chapter06_Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Strings_10_GetValidIPAddress {
    // using recursion:
    public static List<String> getValidIPAddress(String s) {
        List<String> res = new ArrayList<>();
        helper(s, 0, new ArrayList<Integer>(), res);
        return res;
    }

    private static void helper(String s, int index, List<Integer> currentValidIP, List<String> res) {
        // basic case
        if (index == s.length() && currentValidIP.size() == 4) {
            res.add(constructIP(currentValidIP));
            return;
        } else if (currentValidIP.size() == 4 && index < s.length()) {
            return;
        } else if (index >= s.length()) {
            return;
        }
        // recursive case
        String current = Character.toString(s.charAt(index));
        while (Integer.parseInt(current) <= 255 && currentValidIP.size() < 4 && index < s.length()) {
            currentValidIP.add(Integer.parseInt(current));
            helper(s, ++index, currentValidIP, res);
            currentValidIP.remove(currentValidIP.size() - 1);
            if (index < s.length()) {
                current += s.charAt(index);
            }

        }

    }

    private static String constructIP(List<Integer> list) {
        StringBuilder sb = new StringBuilder();
        for (int n : list) {
            sb.append(n + ".");
        }
        return sb.substring(0, sb.length() - 1);
    }

    // book solution:

    public static List<String> getValidIPAddress2(String s) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i < 4 && i < s.length(); ++i) {
            String first = s.substring(0, i);
            if (isValid(first)) {
                for (int j = 1; i + j < s.length() && j < 4; ++j) {
                    String second = s.substring(i, i + j);
                    if (isValid(second)) {
                        for (int k = 1; i + j + k < s.length() && k < 4; ++k) {
                            String third = s.substring(i + j, i + j + k);
                            String fourth = s.substring(i + j + k);
                            if (isValid(third) && isValid(fourth)) {
                                res.add(first + "." + second + "." + third + "." + fourth);
                            }
                        }
                    }
                }
            }
        }
        return res;
    }

    private static boolean isValid(String s) {
        if (s.length() > 3) return false;
        if (s.startsWith("0") && s.length() > 1) return false;
        int val = Integer.parseInt(s);
        return val <= 255 && val >= 0;
    }

    public static void main(String[] args) {
        List<String> res = getValidIPAddress2("19216811");
        // System.out.println(constructIP(new ArrayList<>(Arrays.asList(1, 2, 3, 4))));
        for (String s : res) {
            System.out.println(s);
        }
    }
}
