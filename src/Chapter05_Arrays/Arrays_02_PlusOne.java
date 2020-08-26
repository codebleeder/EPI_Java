package Chapter05_Arrays;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_02_PlusOne {
    public static List<Integer> plusOne(List<Integer> list) {
        int n = list.size() - 1;
        int carry = 1;
        for (int i = n; i >= 0; --i) {
            int d = list.get(i);
            if (carry == 1) {
                if (d == 9) {
                    list.set(i, 0);
                } else {
                    list.set(i, d + 1);
                    carry = 0;
                }
            } else {
                break;
            }
        }
        if (carry == 1) {
            list.set(0, 1);
            list.add(0);
        }
        return list;
    }

    public static void test() {
        List<List<Integer>> tests = new ArrayList<>();
        tests.add(new ArrayList<>(Arrays.asList(9, 9, 9)));
        tests.add(new ArrayList<>(Arrays.asList(1, 2, 9)));
        for (List<Integer> test : tests) {
            System.out.println("--------------------------------");
            System.out.println("input: ");
            Util.printCollection(test);
            System.out.println("result: ");
            Util.printCollection(plusOne(test));
        }
    }

    public static void main(String[] args) {
        test();
    }
}
