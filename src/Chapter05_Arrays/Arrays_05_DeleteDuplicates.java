package Chapter05_Arrays;

import Util.Util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Arrays_05_DeleteDuplicates {
    public static void deleteDuplicates(List<Integer> list) {
        int writeIndex = 1;
        for (int i = 1; i < list.size(); ++i) {
            if (list.get(i) != list.get(i - 1)) {
                list.set(writeIndex, list.get(i));
                ++writeIndex;
            }
        }
        while (writeIndex < list.size()) {
            list.set(writeIndex++, 0);
        }
    }

    public static void test() {
        List<Integer> testList1 = new ArrayList<>(Arrays.asList(2, 3, 5, 5, 7, 11, 11, 11, 13));
        System.out.println("input:");
        Util.printCollection(testList1);
        System.out.println("result:");
        deleteDuplicates(testList1);
        Util.printCollection(testList1);
    }

    public static void main(String[] args) {
        test();
    }
}
