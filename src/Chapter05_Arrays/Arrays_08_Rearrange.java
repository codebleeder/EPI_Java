package Chapter05_Arrays;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Arrays_08_Rearrange {
    public static void rearrange(List<Integer> list) {
        for (int i = 1; i < list.size(); ++i) {
            if (((i % 2 == 0) && list.get(i) > list.get(i - 1)) ||
                    (i % 2 != 0 && list.get(i) < list.get(i - 1))) {
                Collections.swap(list, i, i - 1);
            }
        }
    }

    public static void test() {
        List<Integer> testList = new ArrayList<>(
                Arrays.asList(33, 36, 56, 34, 33, 32, 55, 57, 58, 59, 2)
        );
        System.out.println("input: ");
        Util.printCollection(testList);
        rearrange(testList);
        System.out.println("result: ");
        Util.printCollection(testList);
    }

    public static void main(String[] args) {
        test();
    }
}
