package Chapter06_Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Strings_07_PhoneMnemonic {
    public static List<String> phoneMnemonic(String phoneNumber) {
        List<String> res = new ArrayList<>();
        helper(phoneNumber, res, 0, "");
        return res;
    }

    private static final String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public static void helper(String phoneNumber, List<String> res, int index, String comb) {
        if (index == phoneNumber.length()) {
            res.add(comb);
            return;
        }

        String alphabets = map[phoneNumber.charAt(index) - '0'];

        for (char c : alphabets.toCharArray()) {
            helper(phoneNumber, res, index + 1, comb + c);
        }
    }

    public static void main(String[] args) {
        System.out.println(phoneMnemonic("2276696"));
        System.out.println(phoneMnemonic("23"));
    }
}
